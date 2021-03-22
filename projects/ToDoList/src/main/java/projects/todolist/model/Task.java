package projects.todolist.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "tasks", uniqueConstraints = @UniqueConstraint(name = "unigue_tasks", columnNames = {"name"}))
public class Task {

    @ManyToOne()
    private Todos todos;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDateTime createdOn;
    private LocalDateTime expectedCompletedOn;
    private LocalDateTime completedOn;

    public Task() {
    }
    @PrePersist
    public void setCreatedOn() {
        this.createdOn = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Task(String name, LocalDateTime createdOn, LocalDateTime expectedCompletedOn) {
        this.name = name;
        this.createdOn = createdOn;
        this.expectedCompletedOn = expectedCompletedOn;
    }

    public Task(String name, LocalDateTime createdOn, LocalDateTime expectedCompletedOn, LocalDateTime completedOn) {
        this.name = name;
        this.createdOn = createdOn;
        this.expectedCompletedOn = expectedCompletedOn;
        this.completedOn = completedOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (name != null ? !name.equals(task.name) : task.name != null) return false;
        if (createdOn != null ? !createdOn.equals(task.createdOn) : task.createdOn != null)
            return false;
        return expectedCompletedOn != null ? expectedCompletedOn.equals(task.expectedCompletedOn) : task.expectedCompletedOn == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (createdOn != null ? createdOn.hashCode() : 0);
        result = 31 * result + (expectedCompletedOn != null ? expectedCompletedOn.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdOn=" + createdOn +
                ", expectedCompletedOn=" + expectedCompletedOn +
                ", completedOn=" + completedOn +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getExpectedCompletedOn() {
        return expectedCompletedOn;
    }

    public void setExpectedCompletedOn(LocalDateTime expectedCompletedOn) {
        this.expectedCompletedOn = expectedCompletedOn;
    }

    public LocalDateTime getCompletedOn() {
        return completedOn;
    }

    public void setCompletedOn(LocalDateTime completedOn) {
        this.completedOn = completedOn;
    }

    public Todos getTodos() {
        return todos;
    }

    public void setTodos(Todos todos) {
        this.todos = todos;
    }
}