package com.moka.utils;

public class OrderValidateUtils {

	public boolean verifyExcelTypeIsO7(String fileName) {

		return fileName.matches("^.+\\.(?i)(xlsx)$");
	}

	public String mergeFilePath(String filePath, String fileName) {
		String path=filePath+fileName;
		return path;
	}

}
