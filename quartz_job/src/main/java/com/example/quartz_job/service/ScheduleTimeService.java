package com.example.quartz_job.service;

import com.example.quartz_job.dao.ScheduleTimeDao;
import com.example.quartz_job.entity.ScheduleTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: quartz
 * @Package: com.example.quartz_job.service
 * @ClassName: ScheduleTimeService
 * @Author: wxy
 * @Description: 定时任务记录
 * @Date: 2020/4/13 11:12
 * @Version: 1.0
 */
@Service
public class ScheduleTimeService {
    @Autowired
    private ScheduleTimeDao scheduleTimeDao;

    public void addTime(ScheduleTime scheduleTime) {
        scheduleTimeDao.save(scheduleTime);
    }

    public void editTime(ScheduleTime scheduleTime) {
        scheduleTimeDao.save(scheduleTime);
    }


    /**
     * 判断当前计划任务是否可执行
     * true：可执行，false：不可执行
     *
     * @param name
     * @param state
     * @return
     */
    public Boolean getTaskJobState(String name, String state) {
        Boolean flag = true;
        ScheduleTime taskScheduleTime = scheduleTimeDao.findByJobNameAndAndStatus(name, state);
        if (taskScheduleTime != null) {
            flag = false;
        }
        return flag;
    }

}
