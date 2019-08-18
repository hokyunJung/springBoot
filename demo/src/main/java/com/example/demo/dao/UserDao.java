package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entitiys.AdsUser;

public interface UserDao extends JpaRepository<AdsUser, String> {
	@Query("SELECT u FROM AdsUser u WHERE u.id = :id")
	public AdsUser findOneById(@Param("id") String id);
}
