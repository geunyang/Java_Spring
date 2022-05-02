package com.callor.school.exec;

import java.util.ArrayList;
import java.util.List;

public class ExecV3 {
	
	public static void main(String[] args) {
		List<ScoreVO> scList = new ArrayList<>();
		for (int i = 0; i < 10; i ++) {
			int iKor = (int) (Math.random() * 100) + 1;
			int iEng = (int) (Math.random() * 100) + 1;
			int iMath = (int) (Math.random() * 100) + 1;
			ScoreVO scVO = new ScoreVO();
			scVO.intKor = iKor;
			scVO.intEng = iEng;
			scVO.intMath = iMath;
			scVO.intSum = iKor + iEng + iMath;
			scList.add(scVO);	
		}
		int size = scList.size();
		for (int i = 0; i < size; i ++) {
			for(int j = i + 1; j < size; j ++) {
				if (scList)
				
			}
		}
	}

}
