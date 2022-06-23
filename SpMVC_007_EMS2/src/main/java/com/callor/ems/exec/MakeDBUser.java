package com.callor.ems.exec;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class MakeDBUser {
	
	public static void main(String[] args) {
		
		// 키보드 입력
		Scanner scan = new Scanner(System.in);
		
		// 암호화 도구
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();
		
		// 환경변수
		Map<String, String> envList = System.getenv();
		
		// 암호화시키는 키 명명 saltKey
		String saltPass = envList.get("NAVER");
		System.out.println("salt Pass" + saltPass);
		// 환경 변수가 설정되어 있지 않으면
		if(saltPass == null) {
			System.out.println("NAVER 환경 변수를 설정해 주세요");
			return;
		}
		pbEnc.setAlgorithm("PBEWithMD5AndDES");
		pbEnc.setPassword(saltPass);
		
		String propsDir = "./src/main/webapp/WEB-INF/spring/props";
		
		// .properties 는 고정된 이름
		// secFiles의 key 값을 조회 문자열 데이터 배열??? 다시 물어보기 
		Map<String, String[]> secFiles = new TreeMap<String, String[]>();
		secFiles.put("db.connection.properties", 
				new String[] {"mysql.username","mysql.password"}
		);

		
		System.out.println(secFiles.get("db.connection.properties")[0]);
		System.out.println(secFiles.get("db.connection.properties")[1]);
		
		// Map은 for 반복문 사용할수 없기 때문에 key값 만 뽑아서 set에 담아 핸들링
		// set 형식은 중복되지 않은 데이터만 넣을수 있다
		Set<String> files = secFiles.keySet();
		
		// key 값을 for() ?????
		for(String file : files) {
			
			// naver.email.properties, db.connection.properties 이름으로 파일 생성
			File propsFile = new File(propsDir, file);
			try {
				PrintWriter out = new PrintWriter(propsFile);
				
				System.out.println("=".repeat(100));
				
				System.out.println(file);
				String[] datas = secFiles.get(file);
				for(String data : datas) {
					System.out.printf("%s >> ", data);
					String value = scan.nextLine();
					out.printf("%s=ENC(%s)\n", data, pbEnc.encrypt(value));
				}
				out.flush();
				out.close();
				System.out.println("File Write OK");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

	}

}
