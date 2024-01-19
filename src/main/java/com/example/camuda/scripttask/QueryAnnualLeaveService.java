package com.example.camuda.scripttask;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service("queryAnnualLeave")
public class QueryAnnualLeaveService implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String currentActivityName = delegateExecution.getCurrentActivityName();
        System.out.println("当前服务节点：【" + currentActivityName + "】");
        double leftAnnualDays = (double) delegateExecution.getVariable("leftAnnualDays");
        Object name = delegateExecution.getVariable("name");
        System.out.println(name + ",您的剩余年假天数为：" + leftAnnualDays);
    }
}
