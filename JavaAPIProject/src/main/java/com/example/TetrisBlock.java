package com.example;
import java.util.ArrayList;

public class TetrisBlock {
    private int rotation;
    private boolean rotated;
    private int ID;
    private ArrayList<Tile> block;
    public TetrisBlock() {
        rotation = 0;
        block = initialize();
        rotated = false;
    }
    public TetrisBlock(int rotation, ArrayList<Tile> block, int ID) {
        this.rotation = rotation;
        this.block = block;
        this.ID = ID;
        rotated = false;
    }
    public static ArrayList<Tile> initialize() {return new ArrayList<Tile>();} //overridden 
    public ArrayList<Tile> getBlockTileList() {
        ArrayList<Tile> result = block;
        ArrayList<Tile> temp = new ArrayList<Tile>();
        for (int i = 0; i < result.size(); i++) {
            temp.add(result.get(i));
        }
        int count = 0;
        if (!rotated) {
            if (getRotation() == 0) {
                for (int i = 0; i < result.size(); i++) {
                }
            } else if (getRotation() == 1) {
                result.set(0, temp.get(2));
                result.set(1, temp.get(5));
                result.set(2, temp.get(8));
                result.set(3, temp.get(1));
                result.set(4, temp.get(4));
                result.set(5, temp.get(7));
                result.set(6, temp.get(0));
                result.set(7, temp.get(3));
                result.set(8, temp.get(6));
            } else if (getRotation() == 2) {
                for (int i = temp.size() - 1; i >= 0; i--) {
                    result.set(count, temp.get(i));
                    count++;
                }
            } else if (getRotation() == 3) {
                int layer = 2;
                for (int i = 2; i >= 0; i--) {
                    for (int j = 8 - layer; j >= 0; j -= 3) {
                        result.set(count, temp.get(j));
                        count++;
                    }
                    layer--;
                }
            }
        }
        if (rotation != 0) {
            for (int i = 0; i < result.size(); i++) {
                boolean emptyBelow = false;
                for (int j = 0; j < 6; j++) {
                    if (!result.get(j).getVal().equals("⬜")) {
                        if (result.get(j + 3).getVal().equals("⬜")) {
                            emptyBelow = true;
                        }
                    }
                }
               if ((i >= 6 && !result.get(i).getVal().equals("⬜")) || emptyBelow) {
                   result.get(i).setBottomTile(true);
               } else {
                   result.get(i).setBottomTile(false);
               }
            }
        }
        setRotated(true);
        return result;
    }
    public void placeBlock(int row, int col, TetrisGrid grid) {
        ArrayList<Tile> blockList = new ArrayList<Tile>();
        for (int i = 0; i < getBlockTileList().size(); i++) {
            blockList.add(getBlockTileList().get(i));
        }
        ArrayList<Integer> notContain = new ArrayList<Integer>();
        int count = 0;
        if (col > 10 - (int) Math.sqrt(blockList.size())) {
            if ((blockList.get(2).getVal().equals("⬜")) && (blockList.get(5).getVal().equals("⬜"))) {
                if ((blockList.get(8).getVal().equals("⬜"))) {
                    for (int i = blockList.size() - 1; i >= 0; i -= (int) Math.sqrt(blockList.size())) {
                        notContain.add(i);
                    }
                    col = 5 + (int) Math.sqrt(blockList.size());
                } else {
                    col = 10 - (int) Math.sqrt(blockList.size());
                }
            } else  {
                col = 10 - (int) Math.sqrt(blockList.size());
            }
        }
        for (int k = row + 4; k < row + 4 + Math.sqrt(blockList.size()); k++) {
            for (int y = col; y < col + Math.sqrt(blockList.size()); y++) {
                if (!notContain.contains(count)) {
                    if (grid.getGrid()[k][y].getVal().equals("⬜")) {
                        grid.updateGrid(k, y, blockList.get(count));
                        if (y == 9 && col > 10 - (int) Math.sqrt(blockList.size())) {
                            k--;
                        }
                    }
                } else if (count < blockList.size() && col > 10 - (int) Math.sqrt(blockList.size())) {
                    k++;
                }
                count++;
            }
        }
    }
    public int getRotation() {
        return rotation;
    }
    public void setRotation(int newRotation) {
        rotation = newRotation;
    }
    public boolean getRotated() {
        return rotated;
    }
    public void setRotated(boolean isRotated) {
        rotated = isRotated;
    }
    public ArrayList<Tile> getBlock() {
        return block;
    }
    public int getID() {
        return ID;
    }
    public void setID(int newID) {
        ID = newID;
    }
}
