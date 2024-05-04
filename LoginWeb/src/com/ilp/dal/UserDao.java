package com.ilp.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.User;
import com.dal.DaoInterface;
import com.utilities.DbCon;

public class UserDao implements DaoInterface <User>{
	
	public static String TABLE = "DDR_Login";

	@Override
	public ArrayList<User> findAll() {return null;}

	@Override
	public User findById(int id) {return null;}

	@Override
	public void update(User obj) {	}

	@Override
	public User save(User obj) {return null;}

	@Override
	public void delete(int id) {	}
	
	public boolean validate(String username, String password) {
		Connection con = DbCon.getConnection();
		int validates = 0;
		boolean valid = false;
		
		try {
			String sql = "select count(*) from "+ TABLE + " where username=? and password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				validates = rs.getInt(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		valid = (validates >0 )? true : false;
		
		return valid;
	
	}

}
