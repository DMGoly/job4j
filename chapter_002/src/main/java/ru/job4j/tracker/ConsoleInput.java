package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
    public String askID() {
        System.out.println("Введите ID заявки: ");
        return scanner.nextLine();
    }
}
