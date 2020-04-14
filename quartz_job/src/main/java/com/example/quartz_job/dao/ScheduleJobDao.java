package com.example.quartz_job.dao;

import com.example.dao.BaseRepository;
import com.example.quartz_job.entity.ScheduleJob;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ProjectName: quartz
 * @Package: com.example.quartz_job.dao
 * @ClassName: ScheduleJobDao
 * @Author: wxy
 * @Description: 定时任务dao
 * @Date: 2020/4/13 10:48
 * @Version: 1.0
 */
@Repository
public interface ScheduleJobDao extends BaseRepository<ScheduleJob,String>{

    List<ScheduleJob> findByJobGroup(String group);

}
