package com.example.camuda.listener;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("addLeaders")
public class AddLeadersListener implements ExecutionListener {
    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {
        String currentActivityName = delegateExecution.getCurrentActivityName();
        System.out.println("当前服务节点：【" + currentActivityName + "】");
        Long leaveDay = (Long) delegateExecution.getVariable("leaveDay");
        List<String> leaders = new ArrayList<>();
        if (leaveDay >= 3 && leaveDay < 5) {
            leaders.add("zhangsan");
            leaders.add("wangxuan");
        } else if (leaveDay >= 5) {
            leaders.add("zhangsan");
            leaders.add("wangxuan");
            leaders.add("lisi");
        }
        delegateExecution.setVariable("leaders", leaders);
    }
}
