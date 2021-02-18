
package com.hashedin.service;


import javax.validation.Valid;

import com.hashedin.model.Deployment;
import com.hashedin.model.Service;
import com.hashedin.repository.DeploymentRepo;
import com.hashedin.repository.ServiceRepo;
import com.hashedin.web.APIResponseModel;
import com.hashedin.web.model.ServiceWM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;


public class ServiceDetailService {

	@Autowired
	private ServiceRepo serviceRepo;

	@Autowired
	private DeploymentRepo deploymentRepo;


	public APIResponseModel updateService( ServiceWM serviceWM) {
		APIResponseModel apiResponseModel = new APIResponseModel();
		if(serviceWM!=null){
		Optional <Service>  service=serviceRepo.findByServiceName(serviceWM.getServiceName());
		if(service.isPresent()){
			service.get().getDeployments().stream().filter();
			Deployment deployment=service.getDeployments();
			deployment.setVersion(serviceWM.getVersion());
			deployment.setEnviornment(serviceWM.getEnv());
			deployment.setGitbranch(serviceWM.getGitbrach());
			deployment.setTechnology(serviceWM.getTechnology());
			service.setDeployments(deployment);
			serviceRepo.save(service);
			apiResponseModel.setMessage("Service updated");

		}
		else {
			Service s = new Service();
			Deployment deployment = new Deployment();
			deployment.setVersion(serviceWM.getVersion());
			deployment.setEnviornment(serviceWM.getEnv());
			deployment.setGitbranch(serviceWM.getGitbrach());
			deployment.setTechnology(serviceWM.getTechnology());
			s.setDeployments(deployment);
			serviceRepo.save(s);
			apiResponseModel.setMessage("New service created");

		}
	}
		apiResponseModel.setSuccess(true);
	return apiResponseModel;

	}
	public APIResponseModel getService() {
		APIResponseModel apiResponseModel = new APIResponseModel();

		List<Service> serviceList=serviceRepo.findAll(orderBy());
		apiResponseModel.setBody(serviceList);
		apiResponseModel.setSuccess(true);
		return apiResponseModel;
	}

	private Sort orderBy() {
		return new Sort(Sort.Direction.ASC, "serviceName");
	}


/*
	public List<ServiceWM> getHistory(Integer serviceId) {
		List<Deployment> deploymentList=	deploymentRepo.findAllByServiceId(serviceId);

	}

	public List<ServiceWM> getHistory(Integer serviceId,String choice) {
		List<Deployment> deploymentList=deploymentRepo.findAllByServiceId(serviceId);

		return new List<ServiceWM>();
;
	}*/
}
