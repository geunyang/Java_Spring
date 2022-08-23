package com.ballza.lunch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchVO {
	
	private String sc_code;
	private String sc_num;
	private String sdate;
	private String edate;

}
