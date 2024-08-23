package org.april;

import org.april.controller.MainController;
import org.april.repository.SessionFactoryMaker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MainController controller = new MainController();

        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            System.out.print(">>>> ");
            String line = scanner.nextLine();
            controller.processInput(line);
        }

    }
}