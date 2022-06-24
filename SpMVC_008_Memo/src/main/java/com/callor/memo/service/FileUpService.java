package com.callor.memo.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUpService{
	
	public String fileUp(MultipartFile file) throws Exception;
	public boolean fileDelete(String filename) throws Exception;

}
