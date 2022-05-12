package com.callor.school.dao;

public class SQL {
	
	// c+s+y
	// 소문자로 바꾸고 뒤에 ,"; 붙이고 앞에 +"빈칸 붙여넣기
	// final이어야함
	public static class STUDENT {
		public static final String INSERT 
		= " INSERT INTO tbl_student ( "
						+" st_num,"
						+" st_name,"
						+" st_dept,"
						+" st_grade,"
						+" st_tel,"
						+" st_addr"
						+" ) VALUES( "
						+" #{st_num},"
						+" #{st_name},"
						+" #{st_dept},"
						+" #{t_grade},"
						+" #{st_tel},"
						+" #{st_addr})";
		public static final String UPDATE = ""
				+" UPDATE SET tbl_student "
				+" st_num		= #{st_num},"
				+" st_name		= #{st_name},"
				+" st_dept		= #{st_dept},"
				+" st_grade		= #{st_grade},"
				+" st_tel		= #{st_tel},"
				+" st_addr		= #{st_addr}"
				+" WHERE st_num = #{st_num}";

		
	}


}
