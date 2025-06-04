package com.example;
import java.util.ArrayList;

public class TBlock extends TetrisBlock {
    public TBlock(int rotation) {
        super(rotation, initialize());
    }
    public static ArrayList<Tile> initialize() {
        ArrayList<Tile> block = new ArrayList<Tile>();
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("🟪", 3, true));
        block.add(new Tile("🟪", 3, false));
        block.add(new Tile("🟪", 3, true));
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("🟪", 3, true));
        block.add(new Tile("⬜", 0, false));
        return block;
    }
}
