package com.example;
import java.util.ArrayList;

public class LBlock extends TetrisBlock {
    public LBlock(int rotation) {
        super(rotation, initialize());
    }
    public static ArrayList<Tile> initialize() {
        ArrayList<Tile> block = new ArrayList<Tile>();
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("🟧", 7, false));
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("🟧", 7, false));
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("🟧", 7, true));
        block.add(new Tile("🟧", 7, true));
        return block;
    }
}
