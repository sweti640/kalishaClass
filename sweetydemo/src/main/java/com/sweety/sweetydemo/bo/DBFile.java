package com.sweety.sweetydemo.bo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

	@Entity
	@Table(name = "Sweety_File_Demo")
	public class DBFile {
	    @Id
	    private Long id;

	    private String fileName;

	    private String fileType;

	    @Lob
	    private byte[] data;

	    public DBFile() {

	    }

	  
	    public DBFile(Long id, String fileName, String fileType, byte[] data) {
			super();
			this.id = id;
			this.fileName = fileName;
			this.fileType = fileType;
			this.data = data;
		}


		public Long getId() {
	        return id;
	    }

	    public void setSite(Long id) {
	        this.id = id;
	    }

	    public String getFileName() {
	        return fileName;
	    }

	    public void setFileName(String fileName) {
	        this.fileName = fileName;
	    }

	    public String getFileType() {
	        return fileType;
	    }

	    public void setFileType(String fileType) {
	        this.fileType = fileType;
	    }

	    public byte[] getData() {
	        return data;
	    }

	    public void setData(byte[] data) {
	        this.data = data;
	    }
}

