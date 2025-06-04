package com.example;
import java.util.ArrayList;

public class OBlock extends TetrisBlock {
    public OBlock(int rotation) {
        super(rotation, initialize());
    }
    public static ArrayList<Tile> initialize() {
        ArrayList<Tile> block = new ArrayList<Tile>();
        block.add(new Tile("🟨", 2, false));
        block.add(new Tile("🟨", 2, false));
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("🟨", 2, true));
        block.add(new Tile("🟨", 2, true));
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("⬜", 0, false));
        return block;
    }
    @Override
    public ArrayList<Tile> getBlockTileList() {
        return initialize();   
    }
}
