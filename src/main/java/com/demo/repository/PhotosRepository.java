package com.demo.repository;

import com.demo.entity.Photos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotosRepository extends JpaRepository<Photos,Integer> {
//
//    @Query(value="select id,images from photos where images=:images",nativeQuery = true)
//    Optional<Photos> findByPhoto(@Param("images") byte[] images);

}
