package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Admin;


@Repository
public interface AdminRepo extends CrudRepository<Admin, Long> {
	
	@Query("from Admin where username=?1 and password=?2")
	List<Admin> login(String username, String password);
}
