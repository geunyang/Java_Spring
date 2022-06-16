package com.callor.images.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.images.config.QualifierConfig;
import com.callor.images.model.BBsVO;
import com.callor.images.model.ImagesVO;
import com.callor.images.persistance.BBsDao;
import com.callor.images.persistance.FileDao;
import com.callor.images.service.BBsService;
import com.callor.images.service.FileUpService;

@Service(QualifierConfig.SERVICE.BBS_V1)
public class BBsServiceImplV1 implements BBsService {

	protected final BBsDao bbsDao;
	protected final FileUpService fileService;
	protected final FileDao fileDao;
	

	public BBsServiceImplV1(BBsDao bbsDao, FileUpService fileService, FileDao fileDao) {
		super();
		this.bbsDao = bbsDao;
		this.fileService = fileService;
		this.fileDao = fileDao;
	}

	@Override
	public String insertBbsAndFile(BBsVO bbsVO, MultipartFile file) {

		int ret = bbsDao.insert(bbsVO);
		// 정상적으로 BBS 내용이 insert 되었으면
		if (ret > 0) {

			try {
				String fileName = fileService.fileUp(file);
				ImagesVO imagesVO = ImagesVO.builder()
									.i_originalName(fileName)
									.i_bseq(bbsVO.getB_seq())
									.i_imageName(fileName)
									.build();
				fileDao.insert(imagesVO);
				return "OK";
			} catch (Exception e) {
				return "FILE UP FAIL";
			}
		}

		return null;

	}

	@Override
	public String insertBbsAndFiles(BBsVO bbsVO, MultipartHttpServletRequest files) {
		return null;

	}

	@Override
	public void create_bbs_table() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BBsVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BBsVO findById(Long id) {
		
		return bbsDao.findById(id);
	}

	@Override
	public int insert(BBsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BBsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
