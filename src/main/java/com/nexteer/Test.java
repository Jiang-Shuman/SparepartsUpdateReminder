package com.nexteer;

import java.io.IOException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("* * * * * * ��ӭʹ�û���RESTful API�ı�����������ϵͳ * * * * * *\n");
		System.out.println("��ѡ����Ҫʹ�õĹ��ܣ�\n");
		System.out.println("[1] ������SpareParts������");
		System.out.println("[2] ɾ����SpareParts������");
		System.out.println("[3] �޸ı�SpareParts������");
		System.out.println("[4] ��ѯ��SpareParts������");
		System.out.println("[5] ������������\n");
		
		Scanner inn = new Scanner(System.in);
		int i = inn.nextInt();
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * \n");
		switch(i){
	    case 1 : //��������
	    {
	    	Scanner in = new Scanner(System.in);	
	    	System.out.println("���������������ı��룬���ƣ������������ȫ��棬��λ�����ۣ�״̬��");
	    	String sp_code = in.nextLine();
	    	String sp_name = in.nextLine();
			String sp_classification_code = in.nextLine();
			int sp_current_quantity = in.nextInt();
			int sp_minimum_quantity  = in.nextInt();
			String sp_unit = in.nextLine();
			String sp_unit_price = in.nextLine();
			int sp_status = in.nextInt();
			
			SqlOperation sqlOperation = new SqlOperation();
	    	sqlOperation.insertData(sp_code, sp_name, sp_classification_code, sp_current_quantity, 
	    			sp_minimum_quantity, sp_unit, sp_unit_price, sp_status);
	    	break;
	    }
	    case 2 : //ɾ������
	    {
	    	Scanner in = new Scanner(System.in);	
	    	System.out.println("������ɾ�������ı��룺");
	    	String sp_code = in.nextLine();
	    	
	    	SqlOperation sqlOperation = new SqlOperation();
	    	sqlOperation.deleteData(sp_code);
	    	break;
	    }
	    case 3: //�޸�����
	    {
	    	Scanner in = new Scanner(System.in);	
	    	System.out.println("�������޸ı����ı��룬���޸ĺ����������ۣ�״̬��");
	    	String sp_code = in.nextLine();
			int sp_current_quantity = in.nextInt();
			String sp_unit_price = in.nextLine();
			int sp_status = in.nextInt();
			
			SqlOperation sqlOperation = new SqlOperation();
	    	sqlOperation.updateData(sp_code, sp_current_quantity, sp_unit_price, sp_status);
	    	break;
	    }
	    case 4: //��ѯ����
	    {
	    	Scanner in = new Scanner(System.in);	
	    	System.out.println("�������ѯ�����ı��룺");
	    	String sp_code = in.nextLine();
	    	
	    	SqlOperation sqlOperation = new SqlOperation();
	    	sqlOperation.queryData(sp_code);
	    	break;
	    }
	    case 5: //����������������
	    {
	    	CronTrigger cron = new CronTrigger();
	    	cron.main(args);
	    	
	    }
	    default : 
	       System.out.println("�������룡\n");
	}
	}

}
