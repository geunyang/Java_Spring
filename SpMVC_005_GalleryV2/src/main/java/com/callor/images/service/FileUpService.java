package com.callor.images.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.images.model.FilesVO;

public interface FileUpService {
	
	// 한개 업로드
	public String fileUp(MultipartFile file) throws Exception;
	// 여러개업로드
	public List<FilesVO> filesUP(MultipartHttpServletRequest files) throws Exception;
	public boolean fileDelete(String filename) throws Exception;

}
