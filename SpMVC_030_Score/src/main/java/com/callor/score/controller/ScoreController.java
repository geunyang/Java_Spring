package com.callor.score.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.score.model.ScoreVO;
import com.callor.score.service.ScoreService;

public class ScoreController {
	
	private final ScoreService scoreService;

	public ScoreController(ScoreService scoreService) {
		this.scoreService = scoreService;
	}
	
	@RequestMapping(value = "/detail", method=RequestMethod.GET)
	public String detail(@RequestParam("sc_stnum") String sc_stnum, Model model) {
		List<ScoreVO> scoreVO = scoreService.findByStNum(sc_stnum);
		model.addAttribute("SCORE", scoreVO);
		return "student/detail";
	}
}
