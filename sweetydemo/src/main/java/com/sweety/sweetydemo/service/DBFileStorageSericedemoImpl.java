package com.sweety.sweetydemo.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sweety.sweetydemo.Repository.DBFileRepository;
import com.sweety.sweetydemo.bo.DBFile;

@Service
public class DBFileStorageSericedemoImpl implements DBFileStorageService{
	
	@Autowired
    private DBFileRepository dbFileRepository;

	   public DBFile storeFile(MultipartFile file, Long id) throws IOException {
	        // Normalize file name
	        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

	        DBFile dbFile = new DBFile(id,fileName, file.getContentType(), file.getBytes());

	       return dbFileRepository.save(dbFile);
	        
	    }

	   @Override
	   public Optional<DBFile> getFile(Long fileId) {
	        return dbFileRepository.findById(fileId);
	   }

}
