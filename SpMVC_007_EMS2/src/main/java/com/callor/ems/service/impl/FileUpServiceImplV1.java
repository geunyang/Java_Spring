package com.callor.ems.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.ems.model.FilesVO;
import com.callor.ems.service.FileUpService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service(QualifyConfig.SERVICE.)
public class FileUpServiceImplV1 implements FileUpService{
	
	@Autowired
	private String upPath;
	private final String upLoadFolder;
	
	public FileUpServiceImplV1(String upLoadFolder) {
		this.upLoadFolder = upLoadFolder;
	}
	
	@Override
	public String fileUp(MultipartFile file) throws IllegalStateException, IOException  {
		if(file == null) {
			return null;
		}
		
		File dir = new File(upLoadFolder);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		String fileName = file.getOriginalFilename();
		
		String strUUID = UUID.randomUUID().toString();
		
		fileName = String.format("%s-%s", strUUID, fileName);
		log.debug("변경된 파일 이름{}", fileName);
		File upLoadFile = new File(upLoadFolder, fileName);
		file.transferTo(upLoadFile);
		

		return fileName;
	}

	@Override
	public List<String> filesUp(MultipartHttpServletRequest mFile) {
		
		List<String> retFiles = new ArrayList<>();
		List<MultipartFile> fileList = files.getFiles("mFile");
		
		for(MultipartFile file : fileList) {
			String originName = file.getOriginalFilename();
			String uuName = this.fileUp(file);
			FilesVO fileVO = FilesVO.builder()
						.i_originalName(originName)
						.i_imageName(uuName)
						.build();
			retFiles.add(fileVO);
		}
		return retFiles;vh
	}

}
