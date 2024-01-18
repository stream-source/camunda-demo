package com.example.camuda.servicetask;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

/**
 * 上门维修服务节点
 * 定义bean的名字，用于流程图中的serviceTask的delegateExpression属性
 */
@Service("doRepair")
public class DoRepairService implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String currentActivityName = delegateExecution.getCurrentActivityName();
        System.out.println("当前服务节点：【" + currentActivityName + "】");
        String processDefinitionId = delegateExecution.getProcessDefinitionId();
        System.out.println("currentActivityName: " + currentActivityName + ", processDefinitionId: " + processDefinitionId);
        delegateExecution.setVariable("repairManName", "张三");
    }
}
