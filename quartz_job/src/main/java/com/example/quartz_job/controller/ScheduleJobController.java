package com.example.quartz_job.controller;

import com.example.quartz_job.entity.ScheduleJob;
import com.example.quartz_job.service.ScheduleJobService;
import io.swagger.annotations.ApiOperation;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ProjectName: quartz
 * @Package: com.example.quartz_job.controller
 * @ClassName: ScheduleJobController
 * @Author: wxy
 * @Description: 定时任务接口
 * @Date: 2020/4/13 10:52
 * @Version: 1.0
 */
@RestController
public class ScheduleJobController {

    @Autowired
    private ScheduleJobService scheduleJobService;

    @PostMapping("/allJob")
    @ApiOperation(value = "获取数据库所有定时任务", notes = "获取数据库所有定时任务")
    public List<ScheduleJob> allJob() {
        return scheduleJobService.getAllTask();
    }

    @PostMapping("/addJob")
    @ApiOperation(value = "添加一个定时任务到数据库", notes = "添加一个定时任务到数据库")
    public void addJob(@RequestBody ScheduleJob scheduleJob) {
        scheduleJobService.addTask(scheduleJob);
    }

    @PostMapping("/startOne")
    @ApiOperation(value = "开启一个定时任务", notes = "开启一个定时任务")
    public void startOne(String id) throws SchedulerException {
        ScheduleJob scheduleJob = scheduleJobService.findById(id);
        scheduleJobService.addJob(scheduleJob);

    }

    @PostMapping("/stopOne")
    @ApiOperation(value = "暂停一个定时任务", notes = "暂停一个定时任务")
    public void stopOne(String id) throws SchedulerException {
        ScheduleJob scheduleJob = scheduleJobService.findById(id);
        scheduleJobService.pauseJob(scheduleJob);
    }

    @PostMapping("/resumeJob")
    @ApiOperation(value = "恢复一个定时任务", notes = "恢复一个定时任务")
    public void resumeJob(String id) throws SchedulerException {
        ScheduleJob scheduleJob = scheduleJobService.findById(id);
        scheduleJobService.resumeJob(scheduleJob);
    }



    @PostMapping("/startAll")
    @ApiOperation(value = "开启所有定时任务", notes = "开启所有定时任务")
    public void startAll() {

    }

    @PostMapping("/stopAll")
    @ApiOperation(value = "关闭所有定时任务", notes = "关闭所有定时任务")
    public void stopAll() {

    }


}
