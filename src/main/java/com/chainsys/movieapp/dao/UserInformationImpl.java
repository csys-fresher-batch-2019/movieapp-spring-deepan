package com.chainsys.movieapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chainsys.movieapp.model.UserInformation;
import com.chainsys.movieapp.util.DbConnection;
import com.chainsys.movieapp.util.DbException;
//import com.movieapp.dao.UserInformationDAO;
//import com.movieapp.model.UserInformation;

public class UserInformationImpl implements UserInformationDAO{

		public void addUserInformation(UserInformation users) throws DbException {
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
				int row=pst. executeUpdate();
				System.out.println(row);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			
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
		
		
		
		
		public Integer login(String emailId, String epassword) throws DbException {
           Integer userId = null;
			String sql = "select user_id,email_id,epassword from users where email_id= '" + emailId + "' and epassword = '"+ epassword + "'";
			//System.out.println(sql);
            String s=null;
			try (Connection con=DbConnection.getConnection();
				ResultSet row = con.createStatement().executeQuery(sql);
)
			{
				
				if (row.next())
				{
					userId = row.getInt("user_id");
				}
} 
		catch (SQLException e) {
				e.printStackTrace();
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
		}

		

