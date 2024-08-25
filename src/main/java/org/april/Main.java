package org.april;

import org.april.controller.MainController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MainController controller = new MainController();

        while(true)
            controller.processInput(getInput());
    }

    private static String getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(">>>> ");
        return scanner.nextLine();
    }

}