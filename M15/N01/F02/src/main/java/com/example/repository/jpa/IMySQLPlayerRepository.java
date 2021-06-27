package com.example.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Player;

@Repository
public interface IMySQLPlayerRepository extends JpaRepository<Player, String> {
}
