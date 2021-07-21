package com.kardibus.spring.repository;

import com.kardibus.spring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT c FROM User c")
    Stream<User> streamAll();
}
