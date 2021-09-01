package com.nexteer;

import java.io.IOException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("* * * * * * 欢迎使用基于RESTful API的备件更新提醒系统 * * * * * *\n");
		System.out.println("请选择您要使用的功能：\n");
		System.out.println("[1] 新增表SpareParts中数据");
		System.out.println("[2] 删除表SpareParts中数据");
		System.out.println("[3] 修改表SpareParts中数据");
		System.out.println("[4] 查询表SpareParts中数据");
		System.out.println("[5] 开启备件更新\n");
		
		Scanner inn = new Scanner(System.in);
		int i = inn.nextInt();
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * \n");
		switch(i){
	    case 1 : //新增数据
	    {
	    	Scanner in = new Scanner(System.in);	
	    	System.out.println("请输入新增备件的编码，名称，类别，数量，安全库存，单位，单价，状态：");
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
	    case 2 : //删除数据
	    {
	    	Scanner in = new Scanner(System.in);	
	    	System.out.println("请输入删除备件的编码：");
	    	String sp_code = in.nextLine();
	    	
	    	SqlOperation sqlOperation = new SqlOperation();
	    	sqlOperation.deleteData(sp_code);
	    	break;
	    }
	    case 3: //修改数据
	    {
	    	Scanner in = new Scanner(System.in);	
	    	System.out.println("请输入修改备件的编码，和修改后数量，单价，状态：");
	    	String sp_code = in.nextLine();
			int sp_current_quantity = in.nextInt();
			String sp_unit_price = in.nextLine();
			int sp_status = in.nextInt();
			
			SqlOperation sqlOperation = new SqlOperation();
	    	sqlOperation.updateData(sp_code, sp_current_quantity, sp_unit_price, sp_status);
	    	break;
	    }
	    case 4: //查询数据
	    {
	    	Scanner in = new Scanner(System.in);	
	    	System.out.println("请输入查询备件的编码：");
	    	String sp_code = in.nextLine();
	    	
	    	SqlOperation sqlOperation = new SqlOperation();
	    	sqlOperation.queryData(sp_code);
	    	break;
	    }
	    case 5: //开启备件更新提醒
	    {
	    	CronTrigger cron = new CronTrigger();
	    	cron.main(args);
	    	
	    }
	    default : 
	       System.out.println("错误输入！\n");
	}
	}

}
