package com.example.repository;

import com.example.entity.Shop;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface IShopRepository extends CrudRepository<Shop, Integer> {
}
