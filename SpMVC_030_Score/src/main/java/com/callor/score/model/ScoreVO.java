package com.callor.score.model;

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
public class ScoreVO {
	
	private long sc_seq;	
	private String sc_stnum;
	private String sc_sbcode;
	private String sc_score;
	
	private String sb_code;
	private String sb_name;

}
