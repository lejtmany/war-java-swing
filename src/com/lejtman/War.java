//yosef shalom lejtman
package com.lejtman;

import java.util.Scanner;

public class War {

    public static void main(String[] args) {
        WarGameModel model = new WarGameModel();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press enter to move. Enter q to quit.");
        System.out.println(String.format("%s %20s %20s %20s %20s %20s", "Player 1", "Player 2", "Winner", "P1 Card Count", "P2 Card Count", "Pot Card Count"));
        String input = "";
        String moveString;
        do {
            input = scanner.nextLine();
            moveString = model.move();
            System.out.println(moveString);
        } while (!input.equalsIgnoreCase("q"));

    }

}
