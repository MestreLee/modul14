package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.Quadre;

public interface QuadresDAO extends JpaRepository<Quadre,Integer>{

	List<Quadre> findBybotigaid(int botigaID);

	@Transactional
	void deleteAllBybotigaid(int botigaID);
	

}
