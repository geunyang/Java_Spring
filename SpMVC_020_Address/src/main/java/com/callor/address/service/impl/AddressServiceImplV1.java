package com.callor.address.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.callor.address.config.QualifyConfig;
import com.callor.address.model.AddressVO;
import com.callor.address.model.SearchPage;
import com.callor.address.persistence.AddressDao;
import com.callor.address.service.AddressService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(QualifyConfig.SERVICE.ADDR_V1)
public class AddressServiceImplV1 implements AddressService {

	/*
	 * Service interface 에서 Dao 를 상속받고 있는 상태에서 ServiceImpl 클래스에서 Dao 를 생성자로 주입 받을때
	 * 생성자에서 오류가 발생하는 경우가 있다 ... circular: 무한 반복 주입 오류, 순환 참조 오류 이 오류가 발생하는 경우 생성자
	 * 주입 대신 setter 주입으로 변경하면 오류가 발생하지 않는다 생성자 빼고 @Autowired 부착
	 */
	@Autowired
	private AddressDao addrDao;

	public AddressServiceImplV1() {

	}

	// 프로젝트가 시작될때 table 을 자동으로 생성하기 위한 자동실행 method
	@Autowired
	public void create_table() {
		addrDao.create_addr_table();
	}

	@Override
	public List<AddressVO> selectAll() {
		return addrDao.selectAll();
	}

	@Override
	public AddressVO findById(Long a_seq) {
		return addrDao.findById(a_seq);
	}

	@Override
	public int insert(AddressVO address) {
		log.debug("서비스에서 받은 데이터{}" + address.toString());
		return addrDao.insert(address);
	}

	@Override
	public int update(AddressVO address) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long a_seq) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * 이 method 에서 dao 의 create_addr_table() method 를 호출하여 table 을 생성할수 있으나 dao 같은
	 * 이름의 method 를 호출하면 circular reference 오류가 발생하는 경우가 있다 때문에 이 method 를 사용하지 않고
	 * 별도의 method 를 만들어 사용
	 */
	@Override
	public void create_addr_table() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<AddressVO> searchAndPage(SearchPage searchPage) {
		// TODO Auto-generated method stub
		return addrDao.searchAndPage(searchPage);
	}

	/*
	 * 조건에 맞는 데이터를 가져와 pagenation 을 만들기 위한 searchPage 클래스의 데이터 작성
	 */

	@Override
	public void searchAndPage(Model model, SearchPage searchPage) {

		// 전체개수로 리미트 키워둠
		searchPage.setLimit(addrDao.selectAll().size());
		searchPage.setOffset(0);

		// 검색어 조건에 맞는 모든 데이터 불러오기
		List<AddressVO> addrList = addrDao.searchAndPage(searchPage);

		long totalCount = addrList.size();

		// 조건에 맞는 데이터가 없으면 중단
		if (addrList.size() < 1)
			return;

		// 보여질 리스트 개수
		searchPage.setListPerPage(10);

		// 하단의 페이지 번호 개수
		searchPage.setPageNoCount(10);

		// 조건에 맞는 전체 데이터 개수
		searchPage.setTotalCount(addrList.size());

		// 마지막 페이지 계산하는 공식
		// (전체 데이터 개수 - 1) / 보여질 페이지 개수
		long finalPageNo = (totalCount - 1) / searchPage.getListPerPage();
		searchPage.setFinalPageNo(finalPageNo);

		//
		if (searchPage.getCurrentPageNo() > finalPageNo)
			searchPage.setCurrentPageNo(finalPageNo);

		if (searchPage.getCurrentPageNo() < 1)
			searchPage.setCurrentPageNo(1);

		long startPageNo = ((searchPage.getCurrentPageNo() - 1) / searchPage.getPageNoCount())
				* searchPage.getPageNoCount() + 1;
		long endPageNo = startPageNo + searchPage.getPageNoCount() - 1;

		searchPage.setStartPageNo(startPageNo);
		searchPage.setEndPageNo(endPageNo);
		searchPage.setLimit(searchPage.getPageNoCount());
		searchPage.setOffset(searchPage.getCurrentPageNo() * searchPage.getPageNoCount());

		model.addAttribute("PAGE", searchPage);

	}

}
