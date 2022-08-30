package com.example.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.database.UserRepository;
import com.example.app.entity.User;
import com.example.app.interfaces.LoginData;
import com.example.app.interfaces.Response;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserREST {
    @Autowired
    private UserRepository repositoryUser;

    // LISTAR TODOS USUARIOS
    @GetMapping
    public List<User> listAll() {
        return repositoryUser.findAll();
    }

    // CRIAR USUARIO
    @PostMapping
    public void create(@RequestBody User user) {
        repositoryUser.save(user);
    }

    // ATUALIZAR USUARIO
    @PutMapping
    public void update(@RequestBody User user) {
        if (user.getId() > 0)
            repositoryUser.save(user);
    }

    // DELETAR USUARIO
    @DeleteMapping
    public void delete(@RequestBody User user) {
        repositoryUser.delete(user);
    }

}
