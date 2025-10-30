package com.bkap.qlks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bkap.qlks.entity.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

	List<News> findAll();



}
