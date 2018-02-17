package com.spring.data.elastic.search.load;

import com.spring.data.elastic.search.repository.UserRepository;
import com.spring.data.elastic.search.repository.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Loaders {

    @Autowired
    ElasticsearchOperations operations;

    @Autowired
    UserRepository userRepository;

    @PostConstruct // Load data into elastic search data, while starting server.
    @Transactional
    public void loadAll(){

        operations.putMapping(User.class);
        System.out.println("Loading Data");
        userRepository.save(getData()); // It should be fetched from SQL/NO SQL Databases.
        System.out.printf("Loading Completed");

    }

    private List<User> getData() {
        List<User> userses = new ArrayList<>();
        userses.add(new User("Ajay",123L, "Accounting", 12000L));
        userses.add(new User("Jaga",1234L, "Finance", 22000L));
        userses.add(new User("Thiru",1235L, "Accounting", 12000L));
        userses.add(new User("Ritesh",1236L, "Development", 16000L));
        userses.add(new User("Triyanka",1237L, "Architect", 18000L));
        userses.add(new User("Pinki",1238L, "Health", 10000L));
        userses.add(new User("Rajat",1239L, "Sales", 11000L));
        userses.add(new User("Heer",1230L, "Architect", 19000L));
        return userses;
    }
}
