package com.callor.memo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.memo.model.MemoVO;
import com.callor.memo.persistance.MemoDao;
import com.callor.memo.service.MemoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemoServiceImplV1 implements MemoService {

	@Autowired
	private MemoDao memoDao;

	@Override
	public List<MemoVO> selectAll() {
		return memoDao.selectAll();
	}

	@Override
	public MemoVO findById(Long id) {
		return memoDao.findById(id);
	}

	@Override
	public int insert(MemoVO vo) {
		return memoDao.insert(vo);
	}

	@Override
	public int update(MemoVO vo) {
		return memoDao.update(vo);
	}

	@Override
	public int delete(Long id) {
		return memoDao.delete(id);
	}
//	protected final MemoDao memoDao;
//	protected final FileUpService fileService;
//	protected final FileDao fileDao;
//
//	public MemoServiceImplV1(MemoDao memoDao, @Qualifier(QualifierConfig.SERVICE.FILE_V1) FileUpService fileService,
//			FileDao fileDao) {
//		this.memoDao = memoDao;
//		this.fileService = fileService;
//		this.fileDao = fileDao;
//	}
//
//	@Override
//	public String insertMemoAndFile(MemoVO memoVO, MultipartFile file) {
//		int ret = memoDao.insert(memoVO);
//		log.debug("INSERT {}", ret);
//
//		if (ret > 0) {
//			try {
//				String fileName = fileService.fileUp(file);
//				FilesVO imageVO = FilesVO.builder().i_originalName(file.getOriginalFilename()).i_mseq(memoVO.getM_seq())
//						.i_imageName(fileName).build();
//				fileDao.insert(imageVO);
//				log.debug(imageVO.toString());
//				return imageVO.getI_imageName();
//
//			} catch (Exception e) {
//				return "FILE UP FAIL";
//			}
//		}
//		return null;
//	}
//
//	@Override
//	public String insertMemoAndFiles(MemoVO memoVO, MultipartHttpServletRequest files) {
//		int ret = memoDao.insert(memoVO);
//
//		try {
//			List<FilesVO> fileNames = fileService.filesUP(files);
//			for (FilesVO file : fileNames) {
//				file.setI_mseq(memoVO.getM_seq());
//			}
//			ret = fileDao.insertFiles(fileNames);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	@Override
//	public void create_memo_table() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public List<MemoVO> selectAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public MemoVO findById(Long id) {
//		return memoDao.findById(id);
//	}
//
//	@Override
//	public int insert(MemoVO vo) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int update(MemoVO vo) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int delete(Long id) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

}
