package com.moka.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;



public class FileUtil {
	/**
	 * 检查文件是否存在，不存在则创建
	 * @param filePath 文件对象
	 * @throws IOException
	 */
	
	public static void writeFile(InputStream input,File outfile) throws IOException{
		
		FileOutputStream out =null;
		try {
			out = new FileOutputStream(outfile);
			byte[] byteBuffer =new byte[1024];
			while(input.read(byteBuffer)!=-1) {
				out.write(byteBuffer);
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(null!=input) {
				input.close();
			}
			if(null!=out) {
				out.close();
			}
		}
	}
	
	
	//@ 描述：是否是2003的excel,返回true是2003
	public static boolean isExcel2003(String filePath) {
		return filePath.matches("^.+\\.(?i)(xls)$");
	}
	
	//@ 描述：是否是2007的excel,返回true是2007
	public static boolean isExcel2007(String filePath) {
		return filePath.matches("^.+\\.(?i)(xlsx)$");
	}


}
