package com.susant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.susant.entity.BusDetails;

public interface BusRepository extends JpaRepository<BusDetails,Long>{

}
