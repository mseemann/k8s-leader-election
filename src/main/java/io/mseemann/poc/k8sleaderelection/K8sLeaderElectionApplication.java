package io.mseemann.poc.k8sleaderelection;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class K8sLeaderElectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(K8sLeaderElectionApplication.class, args);
	}

}
