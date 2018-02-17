package com.spring.data.elastic.search.controller;

import com.spring.data.elastic.search.repository.UserElasticsearchRepository;
import com.spring.data.elastic.search.repository.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchResource {

    @Autowired
    UserElasticsearchRepository userElasticsearchRepository;

    @GetMapping(value = "/name/{text}")
    public List<User> searchName(@PathVariable final String text) {
        return userElasticsearchRepository.findByName(text);
    }


    @GetMapping(value = "/salary/{salary}")
    public List<User> searchSalary(@PathVariable final Long salary) {
        return userElasticsearchRepository.findBySalary(salary);
    }


    @GetMapping(value = "/all")
    public List<User> searchAll() {
        List<User> userList = new ArrayList<>();
        Iterable<User> users = userElasticsearchRepository.findAll();
        users.forEach(userList::add);
        return userList;
    }
}
