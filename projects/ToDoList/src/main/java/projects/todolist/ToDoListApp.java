package projects.todolist;

import projects.todolist.config.DbUtil;
import projects.todolist.model.Task;
import projects.todolist.option.TodoListOption;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TodoListApp {

    public static void main(String[] args) {
        DbUtil.getSession();

        Task task1 = new Task("Bieganie", LocalDateTime.of(2021,3,3,8,00).plusMinutes(30), LocalDateTime.now());
        Task task2 = new Task("Kurs", LocalDateTime.of(2021,3,2,16,30).plusMinutes(00), LocalDateTime.now());
        List<Task> tasks = new ArrayList<>();

        TodoListOption todoListOption = new TodoListOption();
        todoListOption.run();



//        logger.debug("Zadanie na dzis 1: {}", task1);
//        logger.debug("Zadanie na dzis 2: {}", task2);
//        logger.debug(String.format("Oba taski, 1: %s, 2: %s", task1, task2));

//        TodoListOption todoListOption = new TodoListOption();
//        todoListOption.run();

    }

}