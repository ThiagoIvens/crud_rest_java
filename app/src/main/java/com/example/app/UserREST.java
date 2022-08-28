package com.example.app;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Where;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.database.UserRepository;
import com.example.app.entity.User;

@RestController
@RequestMapping("/user")
public class UserREST {
    @Autowired
    private UserRepository repositoryUser;

    @GetMapping
    public List<User> listAll() {
        return repositoryUser.findAll();
    }

    @PostMapping("/boss")
    public List<User> listByBoss(@RequestBody User user) {
        List<User> listAll = repositoryUser.findAll();
        List<User> listBosses = new ArrayList<User>();
        for(int i=0;i<listAll.size();i++){
            if(listAll.get(i).getBoss().equals(user.getId())){
                listBosses.add(listAll.get(i));
            }
        }
        return listBosses;
    }

    @PostMapping
    public void create(@RequestBody User user) {
        repositoryUser.save(user);
    }

    @PutMapping
    public void update(@RequestBody User user) {
        if (user.getId() > 0)
            repositoryUser.save(user);
    }

    @DeleteMapping
    public void delete(@RequestBody User user) {
        repositoryUser.delete(user);
    }
}
