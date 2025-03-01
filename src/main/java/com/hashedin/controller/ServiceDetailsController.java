/*
 *
 *  Copyright (c) 2018-2020 Givantha Kalansuriya, This source is a part of
 *   Staxrt - sample application source code.
 *   http://staxrt.com
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package com.hashedin.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hashedin.service.ServiceDetailService;
import com.hashedin.web.APIResponseModel;
import com.hashedin.web.model.ServiceWM;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/service-details")
public class ServiceDetailsController {

  @Autowired
  private ServiceDetailService serviceDeatilsService;
  
  @PostMapping("/")
  public APIResponseModel updateService(@Valid @RequestBody ServiceWM serviceWM) {
	  
	  return serviceDeatilsService.updateService(serviceWM);
		   
   };

  @GetMapping("/")
  public APIResponseModel getService() {

    return serviceDeatilsService.getService();

  };
/*
  @GetMapping("/{serviceId}")
  public List<ServiceWM> getHistory(@PathVariable Integer serviceId) {

       return serviceDeatilsService.getHistory(serviceId);
  };

  @GetMapping("/{serviceId}")
  public List<ServiceWM> getHistory(@PathVariable Integer serviceId,@RequestParam("env") String enviornment) {

   return serviceDeatilsService.getHistory(serviceId,enviornment);
  };*/
  }


