package com.example.quartz_job.controller;
import java.util.Date;

import com.example.quartz_job.dao.ScheduleTimeDao;
import com.example.quartz_job.entity.ScheduleTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: quartz
 * @Package: com.example.quartz_job.controller
 * @ClassName: ScheduleTimeCotroller
 * @Author: wxy
 * @Description: 定时任务执行记录
 * @Date: 2020/4/13 11:13
 * @Version: 1.0
 */
@RestController
public class ScheduleTimeCotroller {
    @Autowired
    private ScheduleTimeDao scheduleTimeDao;

    @PostMapping("/addTest")
    public void addTest(){
        ScheduleTime scheduleTime = new ScheduleTime();
        scheduleTime.setJobName("123");
        scheduleTime.setBeginTime("123");
        scheduleTime.setEndTime("123");
        scheduleTime.setResult("123");
        scheduleTime.setStatus("123");
        scheduleTime.setDeleteFlag(false);
        scheduleTimeDao.save(scheduleTime);

    }
}
