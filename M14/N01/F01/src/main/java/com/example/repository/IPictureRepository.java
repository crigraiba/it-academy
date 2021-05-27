package com.example.repository;

import com.example.entity.Picture;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface IPictureRepository extends CrudRepository<Picture, Integer> {
	
	Iterable<Picture> findAllByShopId(Integer id);
	
	void deleteAllByShopId(Integer id);
	
}
