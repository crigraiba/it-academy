package com.example.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.example.domain.Shop;

@Repository
public interface IShopRepository extends CrudRepository<Shop, Integer> {
}
