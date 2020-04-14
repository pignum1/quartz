package com.example.quartz_job.quartz;

import com.example.quartz_job.entity.ScheduleJob;
import com.example.quartz_job.entity.ScheduleTime;
import com.example.quartz_job.service.ScheduleTimeService;
import com.example.quartz_job.utils.SpringContextHolder;
import io.micrometer.core.instrument.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @ProjectName: quartz
 * @Package: com.example.quartz_job.utils
 * @ClassName: TaskUtils
 * @Author: wxy
 * @Description: 任务工具
 * @Date: 2020/4/13 13:29
 * @Version: 1.0
 */
public class TaskUtils {
    public final static Logger log = LoggerFactory.getLogger(TaskUtils.class);

    /**
     * 通过反射调用scheduleJob中定义的方法
     *
     * @param scheduleJob
     */
    public static void invokMethod(ScheduleJob scheduleJob) {
        Object object = null;
        Class clazz = null;
        if (StringUtils.isNotBlank(scheduleJob.getSpringId())) {
            object = SpringContextHolder.getBean(scheduleJob.getSpringId());
        } else if (StringUtils.isNotBlank(scheduleJob.getBeanClass())) {
            try {
                clazz = Class.forName(scheduleJob.getBeanClass());
                object = clazz.newInstance();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        if (object == null) {
            log.error("任务名称 = [" + scheduleJob.getJobName() + "]---------------未启动成功，请检查是否配置正确！！！");
            return;
        }
        clazz = object.getClass();
        Method method = null;
        ScheduleTimeService taskTimeService = SpringContextHolder.getBean(ScheduleTimeService.class);
        try {

            method = clazz.getDeclaredMethod(scheduleJob.getMethodName());

        } catch (NoSuchMethodException e) {
            log.error("任务名称 = [" + scheduleJob.getJobName() + "]---------------未启动成功，方法名设置错误！！！");
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (method != null) {

            if (!taskTimeService.getTaskJobState(scheduleJob.getJobName(), "0") && "1".equals(scheduleJob.getDescription())) {//如果此任务正在执行，则其他集群上服务不再执行此任务
                return;
            }
            ScheduleTime taskScheduleTime = new ScheduleTime();
            try {
                taskScheduleTime.setJobName(scheduleJob.getJobName());
                if ("1".equals(scheduleJob.getDescription())) {
                    taskScheduleTime.setStatus("0");
                }
                try {
                    taskTimeService.addTime(taskScheduleTime);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                method.invoke(object);
                taskScheduleTime.setResult("S");
                taskScheduleTime.setStatus(null);
                taskTimeService.editTime(taskScheduleTime);
            } catch (Exception e) {
                log.error("任务名称 = [" + scheduleJob.getJobName() + "]调用过程中出现异常:", e);
                taskScheduleTime.setResult("F");
                taskScheduleTime.setStatus(null);
                taskTimeService.editTime(taskScheduleTime);
                //jobExectErrorEmailNotice(scheduleJob, e.getMessage());

            }
        }
        System.out.println("任务名称 = [" + scheduleJob.getJobName() + "]----------启动成功");
    }

}
