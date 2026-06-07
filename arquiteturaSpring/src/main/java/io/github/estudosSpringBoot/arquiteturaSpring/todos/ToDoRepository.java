package io.github.estudosSpringBoot.arquiteturaSpring.todos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDoEntity , Integer> {}
