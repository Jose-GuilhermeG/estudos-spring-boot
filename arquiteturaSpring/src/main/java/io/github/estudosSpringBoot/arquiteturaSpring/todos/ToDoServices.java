package io.github.estudosSpringBoot.arquiteturaSpring.todos;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
//@Scope("singleton")
//@Scope("request")
//@Scope("session")
//@Scope("application")
public class ToDoServices {

    private ToDoRepository repository;

    public ToDoServices(ToDoRepository repository) {
        this.repository = repository;
    }

    public ToDoEntity create(ToDoEntity newToDo){
        return repository.save(newToDo);
    }

    public void update(Integer id , ToDoEntity toDo){
        toDo.setId(id);
        repository.save(toDo);
    }

    public ToDoEntity toDoDetail(Integer id){
        return repository.findById(id).orElse(null);
    }
}
