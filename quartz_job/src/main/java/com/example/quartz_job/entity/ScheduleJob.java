package com.example.quartz_job.entity;

import com.alibaba.fastjson.JSON;
import com.example.entity.BaseUUIDEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * @ProjectName: quartz
 * @Package: com.example.quartz_job.entity
 * @ClassName: ScheduleJob
 * @Author: wxy
 * @Description: 定时任务类
 * @Date: 2020/4/12 12:00
 * @Version: 1.0
 */
@Entity
@Table(name = "task_schedule_job")
@EntityListeners(AuditingEntityListener.class)
public class ScheduleJob extends BaseUUIDEntity {

    /**
     * 任务名称
     */
    @Column
    private String jobName;

    /**
     * 任务所属服务
     */
    @Column
    private String jobGroup;

    /**
     * 是否开启
     */
    @Column
    private String jobStatus;

    /**
     * corn表达式
     */
    @Column
    private String cronExpression;

    /**
     * 描述 0:集群全部执行 1:单节点执行
     */
    @Column
    private String description;

    /**
     * 类路径
     */
    @Column
    private String beanClass;

    /**
     * 是否需要顺序执行
     */
    @Column
    private String isConcurrent;


    /**
     * springId
     */
    @Column
    private String springId;


    /**
     * 方法名
     */
    @Column
    private String methodName;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(String beanClass) {
        this.beanClass = beanClass;
    }

    public String getIsConcurrent() {
        return isConcurrent;
    }

    public void setIsConcurrent(String isConcurrent) {
        this.isConcurrent = isConcurrent;
    }

    public String getSpringId() {
        return springId;
    }

    public void setSpringId(String springId) {
        this.springId = springId;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return JSON.toJSONString(this);
    }
}
