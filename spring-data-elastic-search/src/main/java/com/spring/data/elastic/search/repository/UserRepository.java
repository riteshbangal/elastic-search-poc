package com.spring.data.elastic.search.repository;

import com.spring.data.elastic.search.repository.entities.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface UserRepository extends ElasticsearchRepository<User, Long> {
    List<User> findByName(String text);

    List<User> findBySalary(Long salary);
}