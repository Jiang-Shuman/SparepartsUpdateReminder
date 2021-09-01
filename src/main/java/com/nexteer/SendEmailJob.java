package com.nexteer;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SendEmailJob implements Job{

	public void sendEmail(String host, String username, String passwd, String from, String to) throws Exception
	{
		Properties prop = new Properties();
		prop.setProperty("smtp.163.com", host);
		prop.setProperty("mail.smtp.auth", "true");
        
		//使用JavaMail发送邮件的5个步骤
		//1、创建session
		Session session = Session.getInstance(prop);
		//2、通过session得到transport对象
        Transport trs = session.getTransport();
        //3、使用邮箱的用户名和密码连上邮件服务器
        //用其他邮箱发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器
        trs.connect(host, username, passwd);
        //4、创建邮件
        Message message = createSimpleMail(from, to, session);
         //5、发送邮件
        trs.sendMessage(message, message.getAllRecipients());
        trs.close();
	}
	
	public static MimeMessage createSimpleMail(String from, String to, Session session) throws Exception {
		//创建邮件对象
		MimeMessage msg = new MimeMessage(session);
        //设置发件人
         msg.setFrom(new InternetAddress(from));
         //设置收件人
         msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
         //邮件主题
         Date date = new Date();
         msg.setSubject("备件更新 -- " + date );
         //邮件内容
         msg.setContent(HttpClientUtil.httpClientUtil().toString(), "text/html;charset=UTF-8");
         //返回创建好的邮件对象
         return msg;
     }

	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		try {
			this.sendEmail("smtp.163.com", "jiang_shuman@163.com", "LVUYBOSQFPJEOHYL", "jiang_shuman@163.com", "jiang_shuman@163.com");
			System.out.println("备件更新已开启，请查看您的邮箱\n");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
