package projects.todolist.option;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import projects.todolist.ToDoListApp;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Set;



public interface Option {
    static final Logger logger = LoggerFactory.getLogger(ToDoListApp.class);


    default void run(Object... args) {
        TodoListOption.logger.info("Rozpoczęcie pracy z aplikacją");
        showWelcomeMessage();
        while (true) {
            showOptions();
            String option = getUserOption();
            boolean isValidOption = validateOption(option);
            if (isValidOption) {
                executeOption(option);
                boolean isExitOption = checkIsExitOption(option);
                if (isExitOption) {
                    break;
                }
            } else {
                executeInvalidOption(option);
            }
        }
        showExitMessage();
        TodoListOption.logger.info("Zakończono pracę z aplikacją");
    }

    default void showWelcomeMessage() {
        System.out.println("Welcome in the To Do List!(" + LocalDateTime.now() + ")");
    }

    default void showOptions() {
        System.out.println("\nMenu: ");
        System.out.println("\t1. Listy zadan");
        System.out.println("\t2. Zadania");
        System.out.println("\t3. Pokaz najblizsze zadania do realizacji");
        System.out.println("\t0. Zakończ");
    }

    default String getUserOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nTwój wybór: ");
        return scanner.nextLine();
    }

    default boolean validateOption(String option) {
        return Set.of("1", "2", "3", "0").contains(option);
    }

    default void executeOption(String option) {
        TodoListOption.logger.debug("Wykonywana opcja: {}", option);
        switch (option) {
            case "1":
                new ManageTodosOption().run();
                break;
            case "2":
            case "3":
        }
    }

    default boolean checkIsExitOption(String option) {
//        return userInput.equals("0");
        return "0".equals(option);
    }

    default void executeInvalidOption(String option) {
        System.out.println("\nNiestety`" + option + "'jest niepoprawna");
    }

    default void showExitMessage() { }
}
