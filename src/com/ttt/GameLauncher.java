package com.ttt;

import java.io.IOException;
import java.util.Scanner;

public class GameLauncher{
    public static void main (String [] args) throws NumberFormatException, IOException{
    	Scanner scanner = new Scanner(System.in);
        CommandLine commandLine = new CommandLine(scanner, System.out);
        Game game = new Game(commandLine);
        game.playGame();
    }
}
