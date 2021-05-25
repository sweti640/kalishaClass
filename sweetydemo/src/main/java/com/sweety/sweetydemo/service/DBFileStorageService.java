package com.sweety.sweetydemo.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sweety.sweetydemo.bo.DBFile;

@Service
public interface DBFileStorageService {

	public DBFile storeFile(MultipartFile file, Long id) throws IOException;

	public Optional<DBFile> getFile(Long fileId);
	

}
