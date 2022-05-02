package com.callor.school.exec;

public class ExecV2 {

	public static void main(String[] args) {

		int[] intKor = new int[5];
		int[] intEng = new int[5];
		int[] intMath = new int[5];

		int[] intSum = new int[5];

		for (int i = 0; i < intKor.length; i++) {
			int iKor = (int) (Math.random() * 100) + 1;
			int iEng = (int) (Math.random() * 100) + 1;
			int iMath = (int) (Math.random() * 100) + 1;
			int iSum = iKor + iEng + iMath;

			intKor[i] = iKor;
			intEng[i] = iEng;
			intMath[i] = iMath;
			intSum[i] = iSum;
			
			
			
		}
		// 정렬 전 출력
		printScore(intKor, intEng, intMath, intSum);
		// 정렬하기
		for (int i = 0; i < intKor.length; i ++) {
			for (int j = i+1; j < intKor.length; j ++) {
				if (intSum[i] > intSum[j]) {
					
					int _t = intSum[i];
					intSum[i] = intSum[j];
					intSum[j] = _t;
					
					int _k = intKor[i];
					intKor[i] = intKor[j];
					intKor[j] = _k;
					
					int _e = intEng[i];
					intEng[i] = intEng[j];
					intEng[j] = _e;
					
					int _m = intMath[i];
					intMath[i] = intMath[j];
					intMath[j] = _m;
					
				}
			} 
		}
		
		// 정렬 후 출력
		printScore(intKor, intEng, intMath, intSum);

	}// end main
	
	private static void printScore(int[] intKor, int[] intEng, int[] intMath, int[] intSum) {
		System.out.println("국어\t영어\t수학\t총점");
		for (int i = 0; i < intKor.length; i ++) {
			System.out.printf("%3d\t", intKor[i]);
			System.out.printf("%3d\t", intEng[i]);
			System.out.printf("%3d\t", intMath[i]);
			System.out.printf("%3d\n", intSum[i]);
		}
	}

}
