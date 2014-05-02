package com.ttt;

import java.io.IOException;
import java.util.Scanner;

public class GameLauncher{
    public static void main (String [] args) throws NumberFormatException, IOException{
    	Scanner scanner = new Scanner(System.in);
        UserInterface userInterface = new CommandLine(scanner, System.out);
        Game game = new Game(userInterface);
        game.playGame();
    }
}
