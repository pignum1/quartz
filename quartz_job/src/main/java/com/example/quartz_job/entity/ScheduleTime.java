package com.example.quartz_job.entity;

import com.example.entity.BaseUUIDEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * @ProjectName: quartz
 * @Package: com.example.quartz_job.entity
 * @ClassName: ScheduleTime
 * @Author: wxy
 * @Description: 定时任务执行记录表
 * @Date: 2020/4/13 11:01
 * @Version: 1.0
 */
@Entity
@Table(name = "task_schedule_time")
@EntityListeners(AuditingEntityListener.class)
public class ScheduleTime extends BaseUUIDEntity {

    /**
     * 任务名称
     */
    @Column
    private String jobName;

    /**
     * 开始时间
     */
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String beginTime;


    /**
     * 结束时间
     */
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String endTime;

    /**
     * 执行结果
     */
    @Column
    private String result;

    /**
     * 执行状态
     */
    @Column
    private String status;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
