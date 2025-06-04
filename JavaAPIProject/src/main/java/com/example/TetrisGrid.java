package com.example;
import java.util.ArrayList;

public class TetrisGrid {
    private Tile[][] tetris;
    public TetrisGrid() {
        tetris = new Tile[24][10];
        for (int i = 0; i < tetris.length; i++) {
            for (int j = 0; j < tetris[0].length; j++) {
                tetris[i][j] = new Tile("⬜", 0, false);
            }
        }
    }
    public void display() {
        for (int i = 4; i < tetris.length; i++) {
            for (int j = 0; j < tetris[0].length; j++) {
                System.out.print(tetris[i][j].getVal());
            }
            System.out.println();
        }
    }
    
    public static TetrisBlock randBlock() {
        int rand = (int) (Math.random() * 6) + 1;
        int rotation = (int) (Math.random() * 3) + 1;
        TetrisBlock block;
        if (rand == 1) {
            block = new IBlock(rotation);
        } else if (rand == 2) {
            block = new OBlock(rotation);
        } else if (rand == 3) {
            block = new TBlock(rotation);
        } else if (rand == 4) {
            block = new SBlock(rotation);
        } else if (rand == 5) {
            block = new ZBlock(rotation);
        } else if (rand == 6) {
            block = new JBlock(rotation);
        } else {
            block = new LBlock(rotation);
        }
        return block;
    }
    public void updateGrid(int i, int j, Tile val) {
        tetris[i][j] = val;
    }
    public void tick() {
        ArrayList<Integer> IDs = new ArrayList<Integer>();
        for (int i = tetris.length - 1; i >= 0; i--) {
            for (int j = 0; j < tetris[0].length; j++) {
                Tile tile = tetris[i][j];
                if (IDs.contains(tile.getID())) {
                    //tile.setCanMoveDown(true);
                } else if (tile.getID() != 0) {
                    ArrayList<Tile> block = new ArrayList<Tile>();
                    for (int k = 0; k < tetris.length; k++) {
                        for (int y = 0; y < tetris[0].length; y++) {
                            if (tetris[k][y].getID() == tile.getID()) {
                                block.add(tetris[k][y]);
                                tetris[k][y].setK(k);
                                tetris[k][y].setY(y);
                            }
                        }
                    }
                    boolean blockCanMoveDown = true;
                    for (int u = 0; u < block.size(); u++) {
                        if (block.get(u).getK() == tetris.length - 1 || (tetris[block.get(u).getK() + 1][block.get(u).getY()].getID() != 0 && 
                        tetris[block.get(u).getK() + 1][block.get(u).getY()].getID() != tile.getID())) {
                            blockCanMoveDown = false;
                        }
                    }
                    for (int o = 0; o < block.size(); o++) {
                        block.get(o).setCanMoveDown(blockCanMoveDown);
                    }
                }
            }
        }
        Tile[][] newTetris = new Tile[tetris.length][tetris[0].length];
        for (int i = 0; i < tetris.length; i++) {
            for (int j = 0; j < tetris[0].length; j++) {
                newTetris[i][j] = new Tile("⬜", 0, false);
            }
        }
        for (int i = tetris.length - 1; i >= 0; i--) {
            for (int j = 0; j < tetris[0].length; j++) {
                Tile tile = tetris[i][j];
                if (tile.getID() != 0 && tile.canMoveDown()) {
                    newTetris[i + 1][j] = tile;
                } else if (tile.getID() != 0) {
                    newTetris[i][j] = tile;
                }
            }
        }
        tetris = newTetris;
    }
    public Tile[][] getGrid() {
        return tetris;
    }
}


