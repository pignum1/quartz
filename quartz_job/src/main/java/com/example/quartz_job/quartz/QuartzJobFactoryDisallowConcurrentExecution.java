package com.example.quartz_job.quartz;

import com.example.quartz_job.entity.ScheduleJob;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ProjectName: quartz
 * @Package: com.example.quartz_job.quartz
 * @ClassName: QuartzJobFactoryDisallowConcurrentExecution
 * @Author: wxy
 * @Description: 定时任务
 * @Date: 2020/4/13 13:25
 * @Version: 1.0
 */
@DisallowConcurrentExecution
public class QuartzJobFactoryDisallowConcurrentExecution implements Job {
    public final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
        TaskUtils.invokMethod(scheduleJob);

    }
}
