package com.amin.course.repository;

import com.amin.course.entity.Cat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepo extends CrudRepository<Cat, Integer> {
}
