package com.ridvan.daily2.repository;

import com.ridvan.daily2.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Integer> {

    public Optional<User> findByUsername(String username);
}
