package com.karthigaspringboot.spring.controller;

import com.karthigaspringboot.spring.models.Todo;
import com.karthigaspringboot.spring.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/todoapi")
public class TodoController {


    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/getitems/all")
    public List<Todo> getallTodos()
    {
        return todoRepository.getallTodos();
    }


    @GetMapping("/getitem/{id}")
    public Todo getTodo(@PathVariable int id)
    {
        return  todoRepository.getTodo(id);
    }

    @PostMapping("/additem")
    public List<Todo> addTodo(@RequestBody Todo todo)
    {
        return todoRepository.addTodo(todo);
    }

    @PutMapping("/updateitem")
    public List<Todo> updateItem(@RequestBody Todo todo)
    {
        return todoRepository.updateTodo(todo);
    }

    @DeleteMapping("/deleteitem/{id}")
    public List<Todo> deleteItem(@PathVariable int id)
    {
        return todoRepository.deleteTodo(id);
    }
}
