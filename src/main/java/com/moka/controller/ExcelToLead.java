package com.moka.controller;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
* @author    created by lbq
* @date	     2018年9月11日 下午5:22:01
**/
public class ExcelToLead {
	
	public static void main(String[] args) {
		
		//引入需要解析的文件
		File file =new File("C:/Users/admin/Desktop/交行订单.xlsx");
		//创建workbook
		try {
			//创建Execl
			XSSFWorkbook workbook=new XSSFWorkbook(FileUtils.openInputStream(file));
			//读取sheet页
			//HSSFSheet sheet=workbook.getSheet("Sheet0");
			//读取默认第一个工作表sheet
			XSSFSheet sheet=workbook.getSheetAt(0);
			int oneNum=0;
			//获取sheet中最后一行
			int lastNum=sheet.getLastRowNum();
			for (int i = 0; i <= lastNum; i++) {
				XSSFRow row=sheet.getRow(i);
				//获取当前行最后单元格列号
				int lastCellNum=row.getLastCellNum();
				for (int j = 0; j < lastCellNum; j++) {
					XSSFCell cell=row.getCell(j);
					String value=cell.getStringCellValue();
					System.out.print(value+"");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
