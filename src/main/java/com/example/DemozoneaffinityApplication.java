package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class DemozoneaffinityApplication {

	@Autowired
	LoadBalancerClient lb;

	@RequestMapping("/")
	public ServiceInstance home() {
		return lb.choose("testzoneaffinity");
	}

    public static void main(String[] args) {
        SpringApplication.run(DemozoneaffinityApplication.class, args);
    }
}
