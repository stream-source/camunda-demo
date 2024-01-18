# camunda-demo

# sql脚本

# 流程

1、绘制bpmn,导出xml,放入resources/bpmn

2、流程部署，将定义的流程模型部署到流程引擎中；

    部署方式：
        1、直接将bpmn文件放入resources/bpmn目录下，启动项目，流程引擎会自动部署；
    
        2、手动部署，使用Camunda Modeler进行部署；
            
            发布地址：即项目集成camunda部署的地址，http://localhost:19091/engine-rest

![img.png](images/img0.png)

部署完之后，即可看到流程定义
![img.png](images/img1.png)

3、启动流程实例，启动流程实例，流程实例启动后，流程引擎会根据流程定义的信息创建相应的流程实例；


# 名词

processKey: 流程定义的key,即bpmn文件中的id

![img.png](images/img2.png)

processInstanceId: 流程实例id

![img.png](images/img3.png)


# api

## 1、启动流程实例

/start/{processKey}

