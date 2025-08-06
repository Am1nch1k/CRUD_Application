package com.amin.course.repository;

import com.amin.course.entity.Cat;
import org.springframework.data.repository.CrudRepository;

public interface CatRepo extends CrudRepository<Cat, Integer> {

}
