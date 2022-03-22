package com.portfolio.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.portfolio.Model.Competences;

@Repository
public interface Competencesrepository  extends JpaRepository<Competences,Long>{

}
