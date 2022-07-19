package com.callor.address.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.address.config.QualifyConfig;
import com.callor.address.model.AddressVO;
import com.callor.address.model.SearchPage;
import com.callor.address.service.AddressService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	private final AddressService addrService;

	public HomeController(@Qualifier(QualifyConfig.SERVICE.ADDR_V1) AddressService addrService) {
		this.addrService = addrService;
	}

	// 처음 시작 화면에 나타나게!
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model,@RequestParam(name="pageno",required = false, defaultValue = "0") int pageno) {
//		List<AddressVO> addressList = addrService.selectAll();
		SearchPage searchPage = SearchPage.builder()
				.a_name("")
				.limit(10)
				.offset(pageno * 10)
				.build();
		
		searchPage.setCurrentPageNo(pageno);
		// 페이지계산
		addrService.searchAndPage(model, searchPage);
		
		// 데이터가져오기
		List<AddressVO> addressList = addrService.searchAndPage(searchPage);
		
		model.addAttribute("ADDRS", addressList);

		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(AddressVO address) {
		addrService.insert(address);
		log.debug("받은데이터{}" + address.toString());
		return "redirect:/";
	}

	// seq 변수에 3을 담아서 보내겟다 http:localhost:8080/address/detail?seq=3

	@RequestMapping(value = "/detail", method=RequestMethod.GET)
	public String detail(@RequestParam(name = "seq", required = false, defaultValue = "0") long a_seq, Model model) {
		log.debug("SEQ{}", a_seq);
		AddressVO addrVO = addrService.findById(a_seq);
		log.debug("SEQ{}", a_seq);
		
		model.addAttribute("ADDR",addrVO);

		return "detail";
	}
	
	@RequestMapping(value = "/update",method=RequestMethod.GET)
	public String update(@RequestParam(name="seq", required = false, defaultValue = "0") long a_seq, Model model) {
		AddressVO addrVO = addrService.findById(a_seq);
		model.addAttribute("ADDR",addrVO);
		return "home";
	}
	
	@RequestMapping(value = "/delete", method=RequestMethod.GET)
	public String delete(@RequestParam(name="seq", required = false, defaultValue = "0") long a_seq) {
		addrService.delete(a_seq);
		return "redirect:/";
	}


}
