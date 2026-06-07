package io.github.estudosSpringBoot.arquiteturaSpring.todos;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/toDo/")
public class ToDoController {
    private ToDoServices services;

    public ToDoController(ToDoServices services) {
        this.services = services;
    }

    @PostMapping
    public ToDoEntity create(@RequestBody  ToDoEntity newToDo){
        return services.create(newToDo);
    }

    @PutMapping("/{id}/")
    public void update(@PathVariable("id") Integer id ,@RequestBody ToDoEntity toDo){
        services.update(id , toDo) ;
    }

    @GetMapping("/{id}/")
    public ToDoEntity detail(@PathVariable("id") Integer id){
        return services.toDoDetail(id);
    }
    
}
