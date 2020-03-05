package com.chainsys.movieapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.movieapp.dao.UserInformationDAO;
import com.chainsys.movieapp.model.UserInformation;
import com.chainsys.movieapp.util.DbConnection;
import com.chainsys.movieapp.util.DbException;

public class UserInformationImpl implements UserInformationDAO{

		public int addUserInformation(UserInformation users) throws DbException {
			int row=0;
			String sql="insert into users(user_id,user_name,email_id,epassword,mobile_num,gender)values(user_id_seq.nextval,?,?,?,?,?)";
			//System.out.println(sql);
			try (   Connection con=DbConnection.getConnection();
					PreparedStatement pst=con.prepareStatement(sql);)
			{
				pst.setString(1,users.getUserName());
				pst.setString(2,users.getEmailId());
				pst.setString(3,users.getEpassword());
				pst.setLong(4,users.getMobileNum());
				pst.setString(5, users.getGender());
				row=pst. executeUpdate();
				System.out.println(row);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return row;

			
		}
		
		

		public void deleteUserInformation(int userId) throws DbException {
			String sql="delete from users where user_id=?";
			//System.out.println(sql);
			try (	Connection con=DbConnection.getConnection();
					PreparedStatement pst=con.prepareStatement(sql);
){
		pst.setInt(1,userId);
				int row=pst. executeUpdate();
				System.out.println(row);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		/** 
		 * If valid user , it returns userId 
		 * If invalid email or password, it returns null
		 */
		
		public Integer login(String emailId, String epassword) throws DbException {
           Integer userId = null;
			String sql = "select user_id,email_id,epassword from users where email_id=? and epassword =?";
			//System.out.println(sql);
            String s=null;
			try (Connection con=DbConnection.getConnection();PreparedStatement pst=con.prepareStatement(sql);)
			{
				
			pst.setString(1,emailId);
			pst.setString(2, epassword);
			
			try(ResultSet row = pst.executeQuery();)
			{				
				if (row.next())
				{
					userId = row.getInt("user_id");
				}
			}
			} 
		catch (SQLException e) {
				e.printStackTrace();
				throw new DbException("Unable to execute login query");
			}
			return userId;
}

		
		
		
		public boolean updatePassword(String emailId,String epassword) throws DbException
		{
			boolean updated = false;
			String sqlb = "update users set epassword=? where email_id=?";
			System.out.println("");
			try (	Connection con = DbConnection.getConnection();
					PreparedStatement pst = con.prepareStatement(sqlb);)
			{
				pst.setString(1, epassword);
				pst.setString(2, emailId);
				int rowb = pst.executeUpdate();
				if(rowb ==1) {
					updated = true;
				}
				//System.out.println(rowb);
			}
				
			 catch (SQLException e) {
				e.printStackTrace();
			}
			return updated;
}
		public String getEmailId(int userId) throws DbException {
			
			String sqla = "Select email_id from users where user_id=?";
			//System.out.println(sqla);
			System.out.println("");
			String email=null;
			try (	Connection con = DbConnection.getConnection();
					PreparedStatement pst = con.prepareStatement(sqla);)
			{
			pst.setInt(1, userId);
			try(ResultSet rs = pst.executeQuery();)
					
			{
			
				if (rs.next()) 
				{
					email=rs.getString("email_id");
				}
					
			} }catch (SQLException e) {
				e.printStackTrace();
			}
			return email;
		}



		@Override
		public List <UserInformation> allUserDetails() throws DbException {
			
	    List<UserInformation> list1 =new ArrayList<UserInformation>();
	    String sql ="select * from users";
	    System.out.println(sql);
	    try(Connection con = DbConnection.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);){
	    	try(ResultSet rs =pst.executeQuery();){
	    		while(rs.next()) {
	    			UserInformation reg = new UserInformation();
	    			reg.setEmailId(rs.getString("email_id"));
	    			reg.setEpassword(rs.getString("epassword"));
	    			reg.setGender(rs.getString("gender"));
	    			reg.setUserId(rs.getInt("user_id"));
	    			reg.setMobileNum(rs.getLong("mobile_num"));
	    			reg.setUserName(rs.getString("user_name"));
	    			list1.add(reg);
	    		}
	    		
	    	}
	    	 } catch(SQLException e) {
			   e.printStackTrace();
	    	 }
	    
	   return list1;
		}
		}
		
		
		
		
		

