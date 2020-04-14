package com.example.quartz_job;
import java.util.Date;

import com.example.quartz_job.dao.ScheduleJobDao;
import com.example.quartz_job.dao.ScheduleTimeDao;
import com.example.quartz_job.entity.ScheduleJob;
import com.example.quartz_job.entity.ScheduleTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QuartzJobApplicationTests {
    @Autowired
    private ScheduleJobDao scheduleTimeDao;

    @Test
    void contextLoads() {
        ScheduleJob scheduleJob = new ScheduleJob();
        scheduleJob.setJobName("test");
        scheduleJob.setJobGroup("test");
        scheduleJob.setJobStatus("Y");
        scheduleJob.setCronExpression("0/5 * * * * ? *");
        scheduleJob.setBeanClass("com.example.quartz_job.service.ScheduleJobService");
        scheduleJob.setIsConcurrent("Y");
        scheduleJob.setSpringId("");
        scheduleJob.setMethodName("test");
        scheduleJob.setDescription("");
        scheduleJob.setId("");
        scheduleJob.setVersion(0L);
        scheduleJob.setCreateTime(new Date());
        scheduleJob.setLastTime(new Date());
        scheduleJob.setDeleteFlag(false);
        scheduleTimeDao.save(scheduleJob);


    }

}
