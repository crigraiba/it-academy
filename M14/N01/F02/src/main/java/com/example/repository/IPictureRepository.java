package com.example.repository;

import org.springframework.stereotype.Repository;

import com.example.domain.Picture;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface IPictureRepository extends CrudRepository<Picture, Integer> {
	
	Iterable<Picture> findAllByShopId(Integer id);
	
	void deleteAllByShopId(Integer id);
	
}
