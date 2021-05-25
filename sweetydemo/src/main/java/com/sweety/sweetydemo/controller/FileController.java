package com.sweety.sweetydemo.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sweety.sweetydemo.bo.DBFile;
import com.sweety.sweetydemo.bo.UploadFileResponse;
import com.sweety.sweetydemo.service.DBFileStorageService;



@RestController
public class FileController {
	
	@Autowired
	private DBFileStorageService dbserice;
	
	@RequestMapping(value=("/uploadFile"),headers=("content-type=multipart/*"),method=RequestMethod.POST)
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("id") Long id) throws IOException {

    	//Saveing multipart file
    	DBFile dbFile = dbserice.storeFile(file,id);
    	//URL of saved multipart file
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/sweety_download/")
                .path(String.valueOf(dbFile.getId()))
                .toUriString();

        return new UploadFileResponse(dbFile.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }
	
	@GetMapping("/sweety_download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long fileId) {
        // Load file from database
		Optional<DBFile> dbFile = dbserice.getFile(fileId);

    	//Multipart file
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.get().getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.get().getFileName() + "\"")
                .body(new ByteArrayResource(dbFile.get().getData()));
    }

}
