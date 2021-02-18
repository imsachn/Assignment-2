package com.hashedin.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hashedin.model.Deployment;


@Repository
public interface DeploymentRepo extends JpaRepository<Deployment, Integer> {
	
	List<Deployment> findAllByServiceId(Integer serviceId);

	List<Deployment> findAllByServiceIdAnsEnviornment(Integer serviceId, String enviornment);


}
