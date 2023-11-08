package com.karthigaspringboot.spring.repository;

import com.karthigaspringboot.spring.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class TodoRepository {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Todo> getallTodos() {
        return jdbcTemplate.query("SELECT id, item FROM todos;",new BeanPropertyRowMapper<>(Todo.class));
    }

    public List<Todo> addTodo(Todo todo) {
        jdbcTemplate.update("INSERT INTO todos(item) VALUES(?);", new Object[]{todo.getItem()});
        return getallTodos();
    }

    public List<Todo> updateTodo(Todo todo) {
        jdbcTemplate.update("UPDATE todos SET item=? WHERE id=?;",new Object[]{todo.getItem(),todo.getId()});
        return getallTodos();
    }


    public List<Todo> deleteTodo(int id) {
        jdbcTemplate.update("DELETE FROM todos WHERE id=?;",new Object[]{id });
        return getallTodos();
    }

    public Todo getTodo(int id) {
       return jdbcTemplate.queryForObject("SELECT id,item FROM todos WHERE id=?",new Object[]{id}, new BeanPropertyRowMapper<>(Todo.class));
    }
}
