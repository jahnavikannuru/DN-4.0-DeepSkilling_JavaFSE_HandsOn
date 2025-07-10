package com.cognizant.orm_learn.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.orm_learn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
	@Query("SELECT c FROM Country c WHERE c.name LIKE CONCAT('%', ?1, '%')")
	List<Country> findByNameContaining(String namePart);
	@Query("SELECT c FROM Country c WHERE c.name LIKE CONCAT('%', ?1, '%') ORDER BY c.name ASC")
	List<Country> findByNameContainingSorted(String namePart);
	@Query("SELECT c FROM Country c WHERE c.name LIKE CONCAT(?1, '%')")
	List<Country> findByNameStartingWith(String prefix);

}

