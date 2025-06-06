package com.example;
import java.util.ArrayList;

public class TetrisGrid {
    private static int IDBase = 0;
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
        for (int i = 0; i < tetris.length; i++) {
            for (int j = 0; j < tetris[0].length; j++) {
                System.out.print(tetris[i][j].getVal());
            }
            System.out.println();
        }
    }
    
    public static TetrisBlock randBlock() {
        int rand = (int) (Math.random() * 6) + 1;
        int rotation = (int) (Math.random() * 4);
        TetrisBlock block;
        if (rand == 1) {
            block = new IBlock(rotation, IDBase + 1);
        } else if (rand == 2) {
            block = new OBlock(rotation, IDBase + 2);
        } else if (rand == 3) {
            block = new TBlock(rotation, IDBase + 3);
        } else if (rand == 4) {
            block = new SBlock(rotation, IDBase + 4);
        } else if (rand == 5) {
            block = new ZBlock(rotation, IDBase + 5);
        } else if (rand == 6) {
            block = new JBlock(rotation, IDBase + 6);
        } else {
            block = new LBlock(rotation, IDBase + 7);
        }
        IDBase += 10;
        return block;
    }
    public void updateGrid(int i, int j, Tile val) {
        tetris[i][j] = val;
    }
    public boolean tick() {
        boolean returnVal = true;
        for (int i = tetris.length - 1; i >= 0; i--) {
            for (int j = 0; j < tetris[0].length; j++) {
                Tile tile = tetris[i][j];
                if (tile.getID() != 0) {
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
                    returnVal = blockCanMoveDown;
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
        for (int i = 0; i < tetris.length; i++) {
            int count = 0;
            for (int j = 0; j < tetris[0].length; j++) {
                if (tetris[i][j].getID() == 0) {
                    count++;
                }
            }
            if (count == 0) {
                TetrisGame.addScore(100);
                for (int y = 0; y < tetris[0].length; y++) {
                    tetris[i][y] = new Tile("⬜", 0, false);
                }
                for (int k = i; k > 0; k--) {
                    for (int u = 0; u < tetris[0].length; u++) {
                        tetris[k][u] = tetris[k - 1][u];
                    }
                }
            }
        }
        return returnVal;
    }
    public Tile[][] getGrid() {
        return tetris;
    }
    public void rotateOnGrid(int row, int col, TetrisBlock block) {
        for (int i = 0; i < tetris.length; i++) {
            for (int j = 0; j < tetris[0].length; j++) {
                if (tetris[i][j].canMoveDown()) {
                    tetris[i][j] = new Tile("⬜", 0, false);
                }
            }
        }
        int rotation = block.getRotation();
        rotation++;
        if (rotation == 4) {
            rotation = 0;
        }
        block.setRotation(rotation);
        block.setRotated(false);
        block.placeBlock(row, col, this);
    }
    public void moveRight(int row, int col, TetrisBlock block) {
        for (int i = 0; i < tetris.length; i++) {
            for (int j = 0; j < tetris[0].length; j++) {
                if (tetris[i][j].canMoveDown()) {
                    tetris[i][j] = new Tile("⬜", 0, false);
                }
            }
        }
        if (row >= 23) {
            block.placeBlock(23, col + 1, this);
            tick();
        } else {
            block.placeBlock(row, col + 1, this);
        }
    }
    public void moveLeft(int row, int col, TetrisBlock block) {
        for (int i = 0; i < tetris.length; i++) {
            for (int j = 0; j < tetris[0].length; j++) {
                if (tetris[i][j].canMoveDown()) {
                    tetris[i][j] = new Tile("⬜", 0, false);
                }
            }
        }
        if (row >= 23) {
            block.placeBlock(23, col - 1, this);
            tick();
        } else {
            block.placeBlock(row, col - 1, this);
        }
    }
}