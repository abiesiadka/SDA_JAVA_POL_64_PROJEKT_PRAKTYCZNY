package projects.todolist.option;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import projects.todolist.ToDoListApp;

import java.util.Scanner;
import java.util.Set;

public class ManageTodosOption {
    private static final Logger logger = LoggerFactory.getLogger(ToDoListApp.class);


    public void run(Object... args) {
        logger.info("Rozpoczęcie pracy z aplikacją");
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
        logger.info("Zakończono pracę z aplikacją");
    }


    private void showWelcomeMessage() {
        System.out.println("\nZarzadzanie lista zadan");
    }

    private void showOptions() {
        System.out.println("\nMenu: ");
        System.out.println("\t1. Dodaj liste zadan");
        System.out.println("\t2. Pokaz listy zadan");
        System.out.println("\t3. Usun liste zadan");
        System.out.println("\t0. Wroc");
    }
    private String getUserOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nTwój wybór: ");
        return scanner.nextLine();
    }
    private boolean validateOption(String option) {
        return Set.of("1","2","3","0").contains(option);
    }



    private void executeOption(String option) {
        logger.debug("Wykonywana opcja: {}", option);
        switch (option) {
            case "1":
            case "2":
            case "3":
        }
    }


    private boolean checkIsExitOption(String option) {
//        return userInput.equals("0");
        return "0".equals(option);
    }
    private void executeInvalidOption(String option) {
        System.out.println("\nNiestety`" + option + "'jest niepoprawna");
    }

    private void showExitMessage() {
        System.out.println();
    }

}
