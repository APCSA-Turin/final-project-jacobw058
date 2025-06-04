package com.example;
import java.util.ArrayList;

public class JBlock extends TetrisBlock {
    public JBlock(int rotation) {
        super(rotation, initialize());
    }
    public static ArrayList<Tile> initialize() {
        ArrayList<Tile> block = new ArrayList<Tile>();
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("🟫", 6, false));
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("🟫", 6, false));
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("🟫", 6, true));
        block.add(new Tile("🟫", 6, true));
        block.add(new Tile("⬜", 0, false));
        return block;
    }
}
