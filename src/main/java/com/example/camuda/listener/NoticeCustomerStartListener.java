package com.example.camuda.listener;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service("noticeCustomer")
public class NoticeCustomerStartListener implements ExecutionListener {
    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {
        String currentActivityName = delegateExecution.getCurrentActivityName();
        System.out.println("当前服务节点：【" + currentActivityName + "】");

        String homeAddress = String.valueOf(delegateExecution.getVariable("homeAddress"));
        TimeUnit.SECONDS.sleep(1);

        System.out.println("维修师傅正在赶往：" + homeAddress + "，请您耐心等待！");
    }
}
