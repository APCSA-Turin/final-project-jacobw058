package com.example;

import java.util.ArrayList;

public class IBlock extends TetrisBlock {
    public IBlock(int rotation, int ID) {
        super(rotation, initialize(ID), ID);
    }
    public static ArrayList<Tile> initialize(int ID) {
        ArrayList<Tile> block = new ArrayList<Tile>();
        block.add(new Tile("🟦", ID, false));
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("🟦", ID, false));
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("🟦", ID, false));
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("🟦", ID, true));
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("⬜", 0, false));
        return block;
    }
    @Override
    public ArrayList<Tile> getBlockTileList() {
        ArrayList<Tile> result = getBlock();
        ArrayList<Tile> temp = new ArrayList<Tile>();
        for (int i = 0; i < result.size(); i++) {
            temp.add(result.get(i));
        }
        if (!getRotated()) {
            if (getRotation() % 2 == 0) {
                result.set(0, new Tile("⬜", 0, false));
                result.set(4, new Tile("⬜", 0, false));
                result.set(8, new Tile("⬜", 0, false));
                result.set(13, new Tile("🟦", getID(), true));
                result.set(14, new Tile("🟦", getID(), true));
                result.set(15, new Tile("🟦", getID(), true));
            }
        }
        setRotated(true);
        return result;
    }
    @Override
    public void placeBlock(int row, int col, TetrisGrid grid) {
        if (col <= 6) {
            super.placeBlock(row, col, grid);
        } else {
            if (getRotation() % 2 == 1) {
                for (int i = 0; i < 4; i++) {
                    if (i != 3) {
                        grid.updateGrid(row + i + 4, col, new Tile("🟦", 1, false));
                    } else {
                        grid.updateGrid(row + i + 4, col, new Tile("🟦", 1, true));
                    }
                }
            } else {
                super.placeBlock(row, 6, grid);
            }
        }
    }
}
