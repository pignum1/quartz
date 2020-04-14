package com.example.quartz_job.quartz;

import com.example.quartz_job.entity.ScheduleJob;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ProjectName: quartz
 * @Package: com.example.quartz_job.quartz
 * @ClassName: QuartzJobFactory
 * @Author: wxy
 * @Description: 定时任务工厂类
 * @Date: 2020/4/13 13:24
 * @Version: 1.0
 */
public class QuartzJobFactory implements Job {
    public final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
        TaskUtils.invokMethod(scheduleJob);
    }
}
