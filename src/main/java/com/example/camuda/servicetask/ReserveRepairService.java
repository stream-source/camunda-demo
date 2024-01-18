package com.example.camuda.servicetask;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * 预约维修节点
 */
public class ReserveRepairService implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String currentActivityName = delegateExecution.getCurrentActivityName();
        System.out.println("当前服务节点：【" + currentActivityName + "】");
        String processDefinitionId = delegateExecution.getProcessDefinitionId();
        System.out.println("currentActivityName: " + currentActivityName + ", processDefinitionId: " + processDefinitionId);
    }
}
