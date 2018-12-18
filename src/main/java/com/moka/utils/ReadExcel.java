package com.moka.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;



public class ReadExcel {
	private Logger log = LoggerFactory.getLogger(ReadExcel.class);
	//总行数
	private  int totalRows = 0;
	//总条数
	private  int totalCells=0;
	//错误信息接收器
	private String errorMsg;
	//构造方法
	public ReadExcel() {};
	//获取总行数
	public int getTotalRows() {return totalRows;}
	//获取总列数
	public int getTotalCells() {return totalCells;}
	//获取错误信息
	public String getErrorInfo() {return errorMsg;}
	
	/**
	 * 获取订单管理信息文件及相关文件验证
	 * @param path
	 * @param fileName
	 * @param Mfile
	 * @param startRow
	 * @return
	 */
	public List<Map<String, Object>> getExcelOrderManagement(String path, String fileName, MultipartFile Mfile, int startRow) {
		//把spring文件上传的MultipartFile转换成CommonMultipartFile类型
		//CommonsMultipartFile cf=(CommonsMultipartFile)Mfile;
		String newName=fileName.substring(0,fileName.lastIndexOf("."));
		//检查文件是否存在，不存在创建并返回文件对象
		String filePath=path+System.getProperty("file.separator")+newName+"_"+new Date().getTime()+".xlsx";
		File dir =new File(path);
		if(!dir.exists()) dir.mkdir();
		//新建一个文件
		File file = new File(filePath);
		try {
			//将上传的文件写入新建的文件中
			FileUtil.writeFile(Mfile.getInputStream(),file);
		}catch(Exception e) {
			e.printStackTrace();
			log.error("保存文件失败:path="+filePath);
			log.error("error="+e.getMessage());
		}
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		//初始化输入流
		InputStream is=null;
		try {
		     //验证文件是否合格
			if(!validateExcel(fileName)) {
				log.error("文件验证失败"+fileName);
				
			}
			// 根据文件名判断是2003还是2007版本
			boolean isExcel2003 =true;
			if(FileUtil.isExcel2007(fileName)) {
				isExcel2003=false;
			}
			//根据新建的文件实例化输入流
			is=new FileInputStream(file);
			//根据excel里面的内容读取订单信息
			list =getExcelInfoOrderManagement(is,isExcel2003,startRow);		
		}catch(Exception e) {
			e.printStackTrace();
			log.error("parse excel error:"+e.getMessage());
		}finally {
			if(is!=null){
				try {
				   is.close();
				}catch(IOException e){
				   is=null;
				   e.printStackTrace();
				}
			}
			
		}
		return list;
	}
	
	/*
	 * 验证excel文件
	 * @param filePath
	 * @return
	 */
	public boolean validateExcel(String filePath) {
		if(filePath==null||!(FileUtil.isExcel2003(filePath)||FileUtil.isExcel2007(filePath))) {
			errorMsg="文件名不是excel格式";
			return false;
		}
		return true;
	}
	
	/** 根据excel版本创建workbook对象*/
	public List<Map<String, Object>> getExcelInfoOrderManagement(InputStream is, boolean isExcel2003, int startRow) throws IOException {
		List<Map<String,Object>> list=null;
		/** 根据版本选择创建workbook的方式*/
	    Workbook wb = null;
		if(isExcel2003) {
			wb = new HSSFWorkbook(is);
		}else {
			wb = new XSSFWorkbook(is);
		}
		list = readExcelValue(wb,startRow);
		return list;
	}
	
	/**读取excel列表值*/
	private List<Map<String, Object>> readExcelValue(Workbook wb, int startRow) {
		//得到第一个sheet
		Sheet sheet = wb.getSheetAt(0);
		//得到Excel的行数
		this.totalRows =sheet.getPhysicalNumberOfRows();
		//得到excel的列数(前提要有行数)
		if(totalRows>1&&null!=sheet.getRow(1)) {
			this.totalCells = sheet.getRow(1).getPhysicalNumberOfCells();
		}
		List<Map<String,Object>> records = Lists.newArrayList();
		Map<String,Object> record ;
		//循环行数
		for(int r=startRow;r<totalRows;r++) {
			Row row =sheet.getRow(r);
			if(row==null) {
				continue;
			}
			record = Maps.newLinkedHashMap();
			//循环列数
			for(int c=0;c<totalCells;c++) {
				Cell cell= row.getCell(c);
				Object cellValue = getCellValue(cell);
				record.put("key"+c, cellValue);
			}
			records.add(record);
		}		
		return records;
	}
	
	
	/** 对单元格值不同格式做处理*/
	public Object getCellValue(Cell cell) {
		Object cellvalue="";
		if(null!=cell) {
			//判断当前的cell的Type
			switch(cell.getCellType()) {
			case NUMERIC:{ //当前类型为NUMERIC
				if(HSSFDateUtil.isCellDateFormatted(cell)) {
					cellvalue=DateUtil.getStringShortDate(cell.getDateCellValue());
				}else if(cell.getCellStyle().getDataFormat()==58) {
					Date date =org.apache.poi.ss.usermodel.DateUtil.getJavaDate(cell.getNumericCellValue());
					cellvalue = DateUtil.getStringShortDate(date);
				}else {
					//返回数值类型的值
					Long longval = Math.round(cell.getNumericCellValue());
					cellvalue = longval;
					Double doubleVal =cell.getNumericCellValue();
					if(Double.parseDouble(longval + ".0")==doubleVal) {
						//判断是否含有小数.0
						cellvalue=longval;
					}else {
						cellvalue=doubleVal;
					}
				}
				break;
			}
			case FORMULA:{ 
				//判断当前的cell是否为格式
				try {
					cellvalue=String.valueOf(new BigDecimal(cell.getNumericCellValue()).setScale(4,BigDecimal.ROUND_HALF_UP));
				}catch(IllegalStateException e) {
					try {
						cellvalue = String.valueOf(cell.getRichStringCellValue());
					}catch(Exception ee) {
						cellvalue="";	
					}
				}catch(Exception e) {
					cellvalue="";
				 }
					break;
				}
				case STRING://当前cell的type为string
					cellvalue=cell.getRichStringCellValue().getString();
					break;
					default: //默认的cell值
				    cellvalue="";
		        }
			}
			return cellvalue;
		}
		
}
