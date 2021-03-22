package projects.todolist.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name= "todos", uniqueConstraints = @UniqueConstraint(name = "unigue_todos", columnNames = {"name"}))
public class Todos {



    @OneToMany(fetch = FetchType.LAZY, mappedBy = "todos")  //EAGER dla many to one
    private List<Task> tasks = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDateTime createdOn;

    public Todos() {
    }

    public Todos(String name, LocalDateTime createdOn) {
        this.name = name;
        this.createdOn = createdOn;
    }

    @PrePersist
    public void setCreatedOn() {
        this.createdOn = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Todos todos = (Todos) o;

        return name != null ? name.equals(todos.name) : todos.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Todos{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdOn=" + createdOn +
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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}