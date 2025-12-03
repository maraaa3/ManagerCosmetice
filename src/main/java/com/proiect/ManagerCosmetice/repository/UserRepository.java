package com.proiect.ManagerCosmetice.repository;

import com.proiect.ManagerCosmetice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUtilizator(String utilizator);
}