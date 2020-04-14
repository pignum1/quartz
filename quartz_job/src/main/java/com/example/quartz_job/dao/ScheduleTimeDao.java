package com.example.quartz_job.dao;

import com.example.dao.BaseRepository;
import com.example.quartz_job.entity.ScheduleTime;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @ProjectName: quartz
 * @Package: com.example.quartz_job.dao
 * @ClassName: ScheduleTimeDao
 * @Author: wxy
 * @Description: 定时任务记录dao
 * @Date: 2020/4/13 11:11
 * @Version: 1.0
 */
@Repository
public interface ScheduleTimeDao extends BaseRepository<ScheduleTime,String> {

    ScheduleTime findByJobNameAndAndStatus(@Param("jobName")String jobName,@Param("status")String status);
}
