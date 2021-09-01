package com.nexteer;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class CronTrigger {

	public  void main(String[] args) {
		// TODO Auto-generated method stub
		
        JobDetail job = JobBuilder.newJob(SendEmailJob.class)// 创建 jobDetail 实例，绑定 Job 实现类
                .withIdentity("job1", "group1")//job名称、所在组名称
                .build();
        
        //定义规则
         Trigger trigger = TriggerBuilder
         .newTrigger()
         .withIdentity("trigger1", "group1")//trigger名称、组
         .withSchedule(CronScheduleBuilder.cronSchedule("0/30 * * * * ?"))//每30秒发邮件
         .build();
         
        Scheduler scheduler = null;
        
        try {
            scheduler = new StdSchedulerFactory().getScheduler();
            System.out.println("备件更新提醒开启中……请稍候\n");
            //把作业和触发器注册到任务调度中
            scheduler.scheduleJob(job, trigger);
            
            //启动
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
	}

}
