package com.sda.sdaspring.repositories;

import com.sda.sdaspring.models.Bird;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BirdRepository extends JpaRepository<Bird, Long> {

    List<Bird> findBirdsByNameContainsIgnoreCase(String s);

    @Query("SELECT b from Bird b WHERE b.canFly = true")
    List<Bird> findAllFlyingBirds();

    @Query(value = "SELECT * from birds WHERE can_fly = true", nativeQuery = true)
    List<Bird> findAllFlyingBirdsNative();

    @Query("SELECT b FROM Bird  b ORDER BY " +
            "CASE WHEN :parameter = 'name' THEN b.name END ASC," +
            "CASE WHEN :parameter = 'weight' THEN b.weight END ASC," +
            "CASE WHEN :parameter = 'canFly' THEN b.canFly END ASC")
    List<Bird> findAllSortByParameter(@Param("parameter") String parameter);
}
