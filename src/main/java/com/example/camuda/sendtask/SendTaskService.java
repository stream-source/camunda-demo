package com.example.camuda.sendtask;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("sendTask")
public class SendTaskService implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String currentActivityName = delegateExecution.getCurrentActivityName();
        System.out.println("当前服务节点：【" + currentActivityName + "】");
        RuntimeService runtimeService = delegateExecution.getProcessEngine().getRuntimeService();
        //设置消息内容
        runtimeService.createMessageCorrelation("Message_receive-task")
                .processInstanceBusinessKey("businessKey01")//设置业务key
                .setVariable("message", "Hello World!")
                .correlate();
    }
}
