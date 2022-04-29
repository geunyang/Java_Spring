package com.callor.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.callor.school.dbconfig.DBConnection;
import com.callor.school.dbconfig.DBContract;
import com.callor.school.domain.StudentVO;

/*
 * Dao 클래스
 * Data Access Object
 * DB와 연동하여 SQL을 보내고, 데이터를 수신하는 기능 수행
 */
//java component로 만들어라
@Component
public class StudentDao {
	
	private final Connection dbConn;
	public StudentDao() {
		// connection 객체를 dbConn 에 담음
		dbConn = DBConnection.getDBConnection();
	}
	
	public List<StudentVO> selectAll() {
		/*
		 * JDBC 통하여 DBMS 에게 Query를 ㅂ ㅗ내고
		 * 데이터를 수신하는 객체
		 */
		PreparedStatement pStr = null;
		// 작성한 명령문 어쩌구가 들어있... 
		String sql = DBContract.ST.SELECT;
		// sql문을 보낼테니 도와조
		// spq 문을 전달할 준비
		try {
			pStr = dbConn.prepareStatement(sql);
			//select 문이 db로 전달되고 그 값을 ?
			ResultSet rSet = pStr.executeQuery();
			
			List<StudentVO> stList = new ArrayList<>();
			
			// 가져올 데이터 있나
			// 있으면 읽어올 수 있도록 준비하라
			while(rSet.next()) {

				StudentVO stVO = new StudentVO();
				stVO.setStNum(rSet.getString(DBContract.ST_COL.ST_NUM));
				stVO.setStName(rSet.getString(DBContract.ST_COL.ST_NAME));
				stVO.setStDept(rSet.getString(DBContract.ST_COL.ST_DEPT));
				stVO.setStAddr(rSet.getString(DBContract.ST_COL.ST_ADDR));
				stVO.setStTel(rSet.getString(DBContract.ST_COL.ST_TEL));
				stVO.setIntGrade(rSet.getInt(DBContract.ST_COL.ST_GRADE));
				
				stList.add(stVO);
				
			}
			rSet.close();
			pStr.close();
			
			return stList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	} //end selectAll
	
	public StudentVO findByNum(String stNum) {
		PreparedStatement pStr = null;
		String sql = DBContract.ST.SELECT;
		sql += "WHERE st_num = ? ";
		
		try {
		pStr = dbConn.prepareStatement(sql);
		pStr.setString(1, stNum);
		ResultSet rSet = pStr.executeQuery();
		rSet.next();
		StudentVO stVO = new StudentVO();
		stVO.setStNum(rSet.getString(DBContract.ST_COL.ST_NUM));
		stVO.setStName(rSet.getString(DBContract.ST_COL.ST_NAME));
		stVO.setStDept(rSet.getString(DBContract.ST_COL.ST_DEPT));
		stVO.setStAddr(rSet.getString(DBContract.ST_COL.ST_ADDR));
		stVO.setStTel(rSet.getString(DBContract.ST_COL.ST_TEL));
		stVO.setIntGrade(rSet.getInt(DBContract.ST_COL.ST_GRADE));
		
		rSet.close();
		pStr.close();
		return stVO;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
