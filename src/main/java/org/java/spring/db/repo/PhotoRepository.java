package org.java.spring.db.repo;

import java.util.List;

import org.java.spring.db.pojo.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Integer> {

    List<Photo> findByNameContainingIgnoreCase(String name);
}