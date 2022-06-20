package com.callor.images.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BBsVO {
	
	private long b_seq;
	private String b_date;
	private String b_time;
	private String b_writer;
	private String b_subject;
	private String b_content;
	// VO에 이미지를 담는 리스트 만들어두면 별도의 모델에 담지 않고 이미지 변수에 담으면 된다
	private List<FilesVO> images;
}
