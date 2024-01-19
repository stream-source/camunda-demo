package com.example.camuda.listener;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Service;

/**
 * 定义Bean的名字，与流程BPMN中配置监听器的值保持一致
 */
@Service("checkHomeAddress")
public class CheckHomeAddressEndListener implements ExecutionListener {
    private static final String DEFAULT_ADDRESS = "默认地址：郑州市金水区";

    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {
        System.out.println("检查用户是否存在家庭地址");
        Object homeAddress = delegateExecution.getVariable("homeAddress");
        if (homeAddress == null) {
            System.out.println("用户不存在家庭地址，设置默认地址");
            delegateExecution.setVariable("homeAddress", DEFAULT_ADDRESS);
        } else {
            System.out.println("用户已设置存在家庭地址：【" + homeAddress + "】");
        }
    }
}
