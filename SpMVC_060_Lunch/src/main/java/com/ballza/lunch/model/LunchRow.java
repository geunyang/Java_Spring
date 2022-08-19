package com.ballza.lunch.model;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class LunchRow {
	@JsonProperty("ATPT_OFCDC_SC_CODE")
	private String ATPT_OFCDC_SC_CODE;		//	시도교육청코드
	
	@JsonProperty("ATPT_OFCDC_SC_NM")
	private String ATPT_OFCDC_SC_NM;		//	시도교육청명
	
	@JsonProperty("SD_SCHUL_CODE")
	private String SD_SCHUL_CODE;		//	표준학교코드
	
	@JsonProperty("SCHUL_NM")
	private String SCHUL_NM;		//	학교명
	
	@JsonProperty("MMEAL_SC_CODE")
	private String MMEAL_SC_CODE;		//	식사코드
	
	@JsonProperty("MMEAL_SC_NM")
	private String MMEAL_SC_NM;		//	식사명
	
	@JsonProperty("MLSV_YMD")
	private String MLSV_YMD;		//	급식일자
	
	@JsonProperty("MLSV_FGR")
	private String MLSV_FGR;		//	급식인원수
	
	@JsonProperty("DDISH_NM")
	private String DDISH_NM;		//	요리명
	
	@JsonProperty("ORPLC_INFO")
	private String ORPLC_INFO;		//	원산지정보
	
	@JsonProperty("CAL_INFO")
	private String CAL_INFO;		//	칼로리정보
	
	@JsonProperty("NTR_INFO")
	private String NTR_INFO;		//	영양정보
	
	@JsonProperty("MLSV_FROM_YMD")
	private String MLSV_FROM_YMD;		//	급식시작일자
	
	@JsonProperty("MLSV_TO_YMD")
	private String MLSV_TO_YMD;		//	급식종료일자

}
