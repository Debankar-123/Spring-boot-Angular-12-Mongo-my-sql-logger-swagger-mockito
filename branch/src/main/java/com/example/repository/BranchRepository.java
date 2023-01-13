package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.model.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch,Integer> {

	@Query("select b from Branch b where b.dist=:d")
	public List<Branch> getBranchByDist(@Param("d")String dist);
	
	@Query("select b from Branch b where b.state=:s")
	public List<Branch> getBranchByState(@Param("s")String state);
	
	@Query("select b from Branch b where b.country=:c")
	public List<Branch> getBranchByCountry(@Param("c")String country);
	
	@Query("select b from Branch b where b.email=:email")
	public Branch getByemail(@Param("email")String email);

}
