package com.example;
import java.util.ArrayList;

public class OBlock extends TetrisBlock {
    public OBlock(int rotation, int ID) {
        super(rotation, initialize(ID), ID);
    }
    public static ArrayList<Tile> initialize(int ID) {
        ArrayList<Tile> block = new ArrayList<Tile>();
        block.add(new Tile("🟨", ID, false));
        block.add(new Tile("🟨", ID, false));
        block.add(new Tile("⬜", 0, false));
        block.add(new Tile("🟨", ID, true));
        block.add(new Tile("🟨", ID, true));
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
