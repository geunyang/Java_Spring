package com.callor.images.service.impl;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.images.config.QualifierConfig;
import com.callor.images.service.FileUpService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service(QualifierConfig.SERVICE.FILE_V1)
public class FileServiceImplV1 implements FileUpService{
	
	// Spring 에서 Server 의 특정한 폴더에 접근하기 위한 중간 도구
	private final ServletContext context;
	private final ResourceLoader resourceLoader;
	
	
	
	public FileServiceImplV1(ServletContext context, ResourceLoader resourceLoader) {
		this.context = context;
		this.resourceLoader = resourceLoader;
	}
	

	@Override
	public String fileUp(MultipartFile file) throws Exception {
		// 파일이 없으면 끝내기
		if(file == null) {
			return null;
		}
//		String uploadFile = context.getResourcePaths("/upload/");
		// upload 폴더에 대한 정보를 가져와서 실제로 그 위치가 맞는지 검사
		String upLoadPath = resourceLoader.getResource("/static/upload").getURI().getPath();
		
		log.debug(upLoadPath);
		
		// 업로드한 파일 이름 추출
		String fileName = file.getOriginalFilename();
		
		// java.io.File
		File dir = new File(upLoadPath);
		// 만약 서버에 /upload 폴더가 없으면 
		if(!dir.exists()) {
			// 폴더 만드는 명령?
			dir.mkdirs();
		}
		// 파일과 관련된 커멘드 명령을 대신 만들어주는 
		File upLoadFile = new File(upLoadPath, fileName);
		
		// upLoadFile 에 자동 저장해주는
		file.transferTo(upLoadFile);
		
		return fileName;
	}

	@Override
	public List<String> filesUP(MultipartHttpServletRequest files) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean fileDelete(String filename) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
