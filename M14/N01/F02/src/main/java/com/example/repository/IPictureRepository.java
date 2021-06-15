package com.example.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.example.domain.Picture;

@Repository
public interface IPictureRepository extends CrudRepository<Picture, Integer> {
	
	Iterable<Picture> findAllByShopId(Integer id);
	
	void deleteAllByShopId(Integer id);
	
}
