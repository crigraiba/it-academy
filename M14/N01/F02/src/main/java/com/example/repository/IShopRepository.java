package com.example.repository;

import org.springframework.stereotype.Repository;

import com.example.domain.Shop;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface IShopRepository extends CrudRepository<Shop, Integer> {
}
