package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Player;

public interface IPlayerRepository extends JpaRepository<Player, Integer> {
}
