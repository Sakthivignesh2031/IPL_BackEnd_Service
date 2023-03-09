package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Team;


@Repository
public interface TeamRepository extends JpaRepository<Team, Integer>{
	
	@Query(value = "select * from IPL_Teams where owner_name=? ", nativeQuery = true)
	public  Team getIdByName(String ownerName);
}
