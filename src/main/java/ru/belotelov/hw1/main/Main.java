package ru.belotelov.hw1.main;

import ru.belotelov.hw1.model.Note;
import ru.belotelov.hw1.repo.FileRepo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        FileRepo repo = new FileRepo();

        while(true) {
            System.out.println("Меню: ");
            System.out.println("1. Ввести новую заметку");
            System.out.println("2. Показать сохраненные заметки");
            System.out.println("3. Выход");
            int userChoice = 0;
            try {
                userChoice = scanner.nextInt();
                switch (userChoice) {
                    case 1:
                        System.out.println("Введите заметку: ");
                        Scanner scanner1 = new Scanner(System.in);
                        Note note = new Note(scanner1.nextLine());
                        repo.saveNoteToFile(note);
                        break;
                    case 2:
                        System.out.println("Загрузка заметок...");
                        repo.loadNotesFromFile();
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("Необходимо ввести число от 1 до 3");
                }
            }
            catch (Exception e) {
                System.out.println("Ошибка!" + e.getMessage());
                scanner.next();
            }
        }
    }
}
