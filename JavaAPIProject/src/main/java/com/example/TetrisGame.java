package com.example;
import java.util.Scanner;

public class TetrisGame extends ArcadeGame {
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
        while (!gameEnd) {
            if (invalid) {
                System.out.println("Invalid Input");
                invalid = false;
            }
            System.out.println("Enter 1 to do nothing\nEnter 2 to move right\nEnter 3 to move left\nEnter 4 to rotate\nEnter 5 to quit");
            String answer = scan.nextLine();
            if (answer.equals("1")) {}
            else if (answer.equals("2")) {

            } else if (answer.equals("3")) {

            } else if (answer.equals("4")) {
              //  block.setRotation(block.getRotation() + 1); account for loop around
            } else if (answer.equals("5")) {
                gameEnd = true;
                System.out.println("Game Over");
            } else {
                invalid = true;
            }
                grid.tick();
                grid.display();
        }
    }
}
