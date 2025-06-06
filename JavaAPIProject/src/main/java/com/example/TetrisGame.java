package com.example;
import java.util.Scanner;
import java.util.ArrayList;

public class TetrisGame extends ArcadeGame {
    private static int score;
    public TetrisGame() {
        score = 0;
    }
    @Override
    public void playGame() {
        Scanner scan = new Scanner(System.in);
        boolean gameEnd = false;
        TetrisGrid grid = new TetrisGrid();
        TetrisBlock block = new TetrisBlock();
        block = TetrisGrid.randBlock();
        block.placeBlock(3, 4, grid);
        grid.display();
        boolean invalid = false;
        int currentRow = 3;
        int currentCol = 4;
        while (!gameEnd) {
            if (invalid) {
                System.out.println("Invalid Input");
                invalid = false;
            }
            System.out.println("Enter 1 to do nothing\nEnter 2 to move left\nEnter 3 to move right\nEnter 4 to rotate\nEnter 6 to quit");
            //\nEnter 5 to drop block to bottom
            String answer = scan.nextLine();
            if (answer.equals("1")) {} 
            else if (answer.equals("3")) {
                if (currentCol < 9) {
                    grid.moveRight(currentRow, currentCol, block);
                    currentCol++;
                }
            } else if (answer.equals("2")) {
                if (currentCol > 0) {
                    grid.moveLeft(currentRow, currentCol, block);
                    currentCol--;
                }
            } else if (answer.equals("4")) {
                grid.rotateOnGrid(currentRow, currentCol, block);
            } else if (answer.equals("5")) {

            } else if (answer.equals("6")) {
                gameEnd = true;
                System.out.println("Game Over");
            } else {
                invalid = true;
            }
            if (grid.tick()) {
                currentRow++;
            } else {
                block = TetrisGrid.randBlock();
                currentRow = -2;
                currentCol = 4;
                block.placeBlock(currentRow, currentCol, grid);
                grid.tick();
            }
            grid.display();
            System.out.println("=============================");
            System.out.println("Score: " + score);
            System.out.println("=============================");
        }
    }
    public static void addScore(int plusScore) {
        score += plusScore;
    }
}
