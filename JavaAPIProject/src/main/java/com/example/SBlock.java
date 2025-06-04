package com.example;
import java.util.ArrayList;

public class SBlock extends TetrisBlock {
    public SBlock(int rotation) {
        super(rotation, initialize());
    }
    public static ArrayList<Tile> initialize() {
        ArrayList<Tile> block = new ArrayList<Tile>();
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("🟥", 4, false));
        block.add(new Tile("🟥", 4, true));
        block.add(new Tile("🟥", 4, true));
        block.add(new Tile("🟥", 4, true));
        block.add(new Tile("⬜", 0, false));
        return block;
    }
}
