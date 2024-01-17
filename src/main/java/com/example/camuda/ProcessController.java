package com.example.camuda;

import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.repository.Deployment;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/process")
public class ProcessController {

    @Resource
    private RepositoryService repositoryService;

    @Resource
    private RuntimeService runtimeService;

    @Resource
    private IdentityService identityService;

    @Resource
    private TaskService taskService;


    /**
     * 部署流程
     */
    @GetMapping("/deploy")
    public String deploy() {
        System.out.println("deploy-start");
        Deployment deployment = repositoryService.createDeployment()
                .name("支付流程")
                .addClasspathResource("bpmn/PaymentProcess.bpmn")
                .deploy();
        System.out.println("流程id:"+deployment.getId());
        System.out.println("流程name:"+deployment.getName());
        return deployment.getId();
    }


    /**
     * 启动流程
     */
    @GetMapping("/start")
    public String start() {
        System.out.println("start-start");
        runtimeService.startProcessInstanceByKey("priceApproval");
        return "success";
    }
}