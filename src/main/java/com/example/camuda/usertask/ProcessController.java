package com.example.camuda.usertask;

import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.repository.Deployment;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
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
    @GetMapping("/start/{processKey}")
    public String start(@PathVariable("processKey") String processKey) {
        System.out.println("start-start");
        identityService.setAuthenticatedUserId("demo");
        VariableMap variableMap = Variables.createVariables();
        variableMap.put("isFree", false);
        // 启动流程：通过流程定义的key或者id启动
        runtimeService.startProcessInstanceByKey(processKey,variableMap);
        return "success";
    }
}
