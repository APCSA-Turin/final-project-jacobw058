package com.example;

public class Tile {
    private int k;
    private int y;
    private String val;
    private int ID;
    private boolean bottomTile;
    private boolean canMoveDown;
    public Tile(String val, int ID, boolean bottomTile) {
        this.val = val;
        this.ID = ID;
       this.bottomTile = bottomTile;
        k = 0;
        y = 0;
        canMoveDown = true;
    }
    public String getVal() {
        return val;
    }
    public int getID() {
        return ID;
    }
    public void setID(int newID) {
        ID = newID;
    }
   public boolean isBottomTile() {
       return bottomTile;
   }
   public void setBottomTile(boolean bottom) {
       bottomTile = bottom;
   }
    public int getK() {
        return k;
    }
    public void setK(int newK) {
        k = newK;
    }
    public int getY() {
        return y;
    }
    public void setY(int newY) {
        y = newY;
    }
    public boolean canMoveDown() {
        return canMoveDown;
    }
    public void setCanMoveDown(boolean newCanMoveDown) {
        canMoveDown = newCanMoveDown;
    }
}
