package com.hackathon.hackathonbackend.vo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fileModificationdetails")
public class FileModificationDetailsVO {

	@Id
	private String fileName;

	private long fileLastModified;
	private String fileLastModifiedDate;

	public FileModificationDetailsVO(String fileName, long fileLastModified, String fileLastModifiedDate) {
		super();
		this.fileName = fileName;
		this.fileLastModified = fileLastModified;
		this.fileLastModifiedDate = fileLastModifiedDate;
	}

}
