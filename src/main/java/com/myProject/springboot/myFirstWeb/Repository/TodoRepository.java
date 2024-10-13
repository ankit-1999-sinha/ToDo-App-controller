package com.myProject.springboot.myFirstWeb.Repository;

import com.myProject.springboot.myFirstWeb.todo.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<ToDo,Integer> {

    public List<ToDo> findByuserName (String userName);
}
