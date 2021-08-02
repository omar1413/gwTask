package com.gateway.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gateway.task.entity.Peripheral;

public interface PeripheralRepository extends JpaRepository<Peripheral, Long>{

}
