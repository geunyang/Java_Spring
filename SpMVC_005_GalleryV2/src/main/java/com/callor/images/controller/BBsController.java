package com.callor.images.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.callor.images.model.BBsVO;
import com.callor.images.persistance.FileDao;
import com.callor.images.service.BBsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/bbs")
public class BBsController {
	

	@Autowired
	private BBsService bbsService;
	

	
	/*
	 * @ModelAttribute("bbsVO") BBsVO bbsVO
	 * Spring 에게 BBsVO type bbsVO 객체 값이 필요하니 주입(inject) 해달라고 요청하는것
	 * 
	 * 요청을 받으면 Spring 은 어딘가에 있는 @ModelAttribute("bbsVO") 가 설정된
	 * method 를 찾아서 실행하여 return 값을 주입해 줌
	 */

	@RequestMapping(value = "/write",method=RequestMethod.GET)
	public String write(@ModelAttribute("bbsVO") BBsVO bbsVO, Model model) {
		
		/*
		 * 주입받은 bbsVO 객체 데이터를 form(.jsp)로 전달
		 */
		model.addAttribute("bbsVO",bbsVO);
		return "bbs/input";
		
	}
	
	// bbsVO 와 file 데이터를 받도록 되어있음
	@RequestMapping(value = "/write",method=RequestMethod.POST)
	public String write(@ModelAttribute("bbsVO") BBsVO bbsVO, @RequestParam("up_file") MultipartFile file, Model model) {
		
		log.debug("받은데이터{}", bbsVO.toString());
		log.debug("받은파일{}", file.getOriginalFilename());
		
		String imageFile = bbsService.insertBbsAndFile(bbsVO, file);
		model.addAttribute("IMAGE",imageFile);
		return "redirect:/";
	}
	@RequestMapping(value = "/detail", method=RequestMethod.GET)
	public String detail(String seq, Model model) {
		
		try {
			long b_seq = Long.valueOf(seq);
			BBsVO bbsVO = bbsService.findById(b_seq);
			
//			bbsVO.setImages(fileDao.findByBBsSeq(b_seq));
			model.addAttribute("BBS",bbsVO);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
	
	/*
	 * 	@ModelAttribute("bbsVO")
	 * 
	 */
	@ModelAttribute("bbsVO")
	private BBsVO bbsVO() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dayFormat =  new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		BBsVO bbsVO = BBsVO.builder()
						.b_date(dayFormat.format(date))
						.b_time(timeFormat.format(date))
						.b_writer("ballza")
						.build();
		 log.debug(bbsVO.toString());
		return bbsVO;
	}
}
