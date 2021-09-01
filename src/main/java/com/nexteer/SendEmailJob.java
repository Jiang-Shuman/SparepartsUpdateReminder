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
        
		//ʹ��JavaMail�����ʼ���5������
		//1������session
		Session session = Session.getInstance(prop);
		//2��ͨ��session�õ�transport����
        Transport trs = session.getTransport();
        //3��ʹ��������û��������������ʼ�������
        //���������䷢���ʼ�ʱ����������Ҫ�ύ������û����������smtp������
        trs.connect(host, username, passwd);
        //4�������ʼ�
        Message message = createSimpleMail(from, to, session);
         //5�������ʼ�
        trs.sendMessage(message, message.getAllRecipients());
        trs.close();
	}
	
	public static MimeMessage createSimpleMail(String from, String to, Session session) throws Exception {
		//�����ʼ�����
		MimeMessage msg = new MimeMessage(session);
        //���÷�����
         msg.setFrom(new InternetAddress(from));
         //�����ռ���
         msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
         //�ʼ�����
         Date date = new Date();
         msg.setSubject("�������� -- " + date );
         //�ʼ�����
         msg.setContent(HttpClientUtil.httpClientUtil().toString(), "text/html;charset=UTF-8");
         //���ش����õ��ʼ�����
         return msg;
     }

	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		try {
			this.sendEmail("smtp.163.com", "jiang_shuman@163.com", "LVUYBOSQFPJEOHYL", "jiang_shuman@163.com", "jiang_shuman@163.com");
			System.out.println("���������ѿ�������鿴��������\n");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
