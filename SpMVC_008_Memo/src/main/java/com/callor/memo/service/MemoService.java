package com.callor.memo.service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.memo.model.MemoVO;
import com.callor.memo.persistance.MemoDao;

public interface MemoService extends MemoDao {
	
//	public String insertMemoAndFile(MemoVO memoVO, MultipartFile file);
//	public String insertMemoAndFiles(MemoVO memoVO, MultipartHttpServletRequest files);

}
