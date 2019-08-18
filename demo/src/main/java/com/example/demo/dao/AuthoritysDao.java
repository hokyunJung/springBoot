package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entitiys.AdsUser;
import com.example.demo.entitiys.Authoritys;

public interface AuthoritysDao extends JpaRepository<Authoritys, String> {
	@Query("SELECT a.authority FROM Authoritys a WHERE a.id = :id")
	public List<String> findListsById(@Param("id") String id);
}
