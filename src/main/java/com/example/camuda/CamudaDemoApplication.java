package com.example.camuda;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.camunda.bpm.spring.boot.starter.event.PreUndeployEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableProcessApplication("myProcessApplicationName")
public class CamudaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CamudaDemoApplication.class, args);
    }

    @EventListener
    public void onPostDeploy(PostDeployEvent event) {
        System.out.println(event.toString());
    }

    @EventListener
    public void onPreUndeploy(PreUndeployEvent event) {
        System.out.println(event.toString());
    }
}
