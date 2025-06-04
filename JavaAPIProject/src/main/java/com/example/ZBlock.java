package com.example;
import java.util.ArrayList;

public class ZBlock extends TetrisBlock {
    public ZBlock(int rotation) {
        super(rotation, initialize());
    }
    public static ArrayList<Tile> initialize() {
        ArrayList<Tile> block = new ArrayList<Tile>();
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("🟩", 5, true));
        block.add(new Tile("🟩", 5, false));
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("🟩", 5, true));
        block.add(new Tile("🟩", 5, true));
        return block;
    }
}
