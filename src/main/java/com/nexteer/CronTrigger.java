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
		
        JobDetail job = JobBuilder.newJob(SendEmailJob.class)// ���� jobDetail ʵ������ Job ʵ����
                .withIdentity("job1", "group1")//job���ơ�����������
                .build();
        
        //�������
         Trigger trigger = TriggerBuilder
         .newTrigger()
         .withIdentity("trigger1", "group1")//trigger���ơ���
         .withSchedule(CronScheduleBuilder.cronSchedule("0/30 * * * * ?"))//ÿ30�뷢�ʼ�
         .build();
         
        Scheduler scheduler = null;
        
        try {
            scheduler = new StdSchedulerFactory().getScheduler();
            System.out.println("�����������ѿ����С������Ժ�\n");
            //����ҵ�ʹ�����ע�ᵽ���������
            scheduler.scheduleJob(job, trigger);
            
            //����
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
	}

}
