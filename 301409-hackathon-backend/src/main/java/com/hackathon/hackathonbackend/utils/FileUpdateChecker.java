package com.hackathon.hackathonbackend.utils;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUpdateChecker {

	public void checkLastModifiedFile() {

	}

	private long getLastModifiedDateInLong(String fileName) throws ParseException {

		File file = new File(fileName);

		System.out.println(fileName + " Current Modified Date & Time : " + file.lastModified());

		return file.lastModified();
	}

	private String getLastModifiedDateInDateFormat(String fileName) throws ParseException {

		File file = new File(fileName);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		String dateStr = sdf.format(file.lastModified());

		System.out.println("Date Format in dd/MM/yyyy HH:mm:ss: " + dateStr);

		return dateStr;
	}

	public static void main(String args[]) throws ParseException {
		new FileUpdateChecker().getLastModifiedDateInLong("AssociateDetails.xlsx");
		new FileUpdateChecker().getLastModifiedDateInDateFormat("AssociateDetails.xlsx");
	}

}
