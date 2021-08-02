package com.gateway.task.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.gateway.task.entity.Gateway;


@Repository
public interface GatewayRepository extends PagingAndSortingRepository<Gateway, Long>{
	
}
