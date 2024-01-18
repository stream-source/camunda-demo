package com.example.camuda.servicetask;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Service;

/**
 * 回访节点以及查看分数节点
 * 定义bean的名字
 */
@Service("telCall")
public class TelCallService {


    public Long doCall(DelegateExecution execution) {
        String currentActivityName = execution.getCurrentActivityName();
        System.out.println("当前服务节点：【" + currentActivityName + "】");
        String repairManName = String.valueOf(execution.getVariable("repairManName"));
        System.out.println("您对：" + repairManName + "，服务打几分？");
        return 10L;
    }

    public void getScore(DelegateExecution execution) {
        String currentActivityName = execution.getCurrentActivityName();
        System.out.println("当前服务节点：【" + currentActivityName + "】");
        Long score = (Long) execution.getVariable("score");
        System.out.println("您的评分是：" + score);
    }


}
