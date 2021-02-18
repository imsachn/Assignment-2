package com.hashedin.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service")
@Data
@EqualsAndHashCode(callSuper = true)
public class Service extends BaseEntity {
		@Id
	 	@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "serviceid", updatable =false ,nullable = false)
	    private Integer serviceId;

		@OneToMany(mappedBy="service")
		List<Deployment> Deployments;
    }
