package com.chainsys.movieapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.movieapp.dao.UserInformationDAO;
import com.chainsys.movieapp.exception.DbException;
import com.chainsys.movieapp.model.UserInformation;
import com.chainsys.movieapp.util.DbConnection;

public class UserInformationDAOImpl implements UserInformationDAO {
	private static final Logger logger = LoggerFactory.getLogger(UserInformationDAOImpl.class);

	public int save(UserInformation users) throws DbException {
		int row = 0;
		String sql = "insert into users(user_id,user_name,email_id,epassword,mobile_num,gender)values(user_id_seq.nextval,?,?,?,?,?)";
		// logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, users.getUserName());
			pst.setString(2, users.getEmailId());
			pst.setString(3, users.getEpassword());
			pst.setLong(4, users.getMobileNum());
			pst.setString(5, users.getGender());
			row = pst.executeUpdate();
			logger.info("" + row);
		} catch (SQLException e) {
			throw new DbException("Unable to Register User Information", e);

		}
		return row;

	}

	public void delete(int userId) throws DbException {
		String sql = "delete from users where user_id=?";
		// logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, userId);
			int row = pst.executeUpdate();
			logger.info("" + row);
		} catch (SQLException e) {
			throw new DbException("Unable to delete user Id", e);

		}

	}

	/**
	 * If valid user , it returns userId If invalid email or password, it returns
	 * null
	 */

	public Integer findByEmailIdAndPassword(String emailId, String epassword) throws DbException {
		Integer userId = null;
		String sql = "select user_id,email_id,epassword from users where email_id=? and epassword =?";
		// logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setString(1, emailId);
			pst.setString(2, epassword);

			try (ResultSet row = pst.executeQuery();) {
				if (row.next()) {
					userId = row.getInt("user_id");
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Login", e);

		}
		return userId;
	}

	public boolean update(String emailId, String epassword) throws DbException {
		boolean updated = false;
		String sqlb = "update users set epassword=? where email_id=?";
		logger.info("");
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sqlb);) {
			pst.setString(1, epassword);
			pst.setString(2, emailId);
			int rowb = pst.executeUpdate();
			if (rowb == 1) {
				updated = true;
			}
			// logger.info(rowb);
		}

		catch (SQLException e) {
			throw new DbException("Unable to update Password", e);

		}
		return updated;
	}

	public String findEmailIdByUserId(int userId) throws DbException {

		String sqla = "Select email_id from users where user_id=?";
		// logger.info(sqla);
		logger.info("");
		String email = null;
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sqla);) {
			pst.setInt(1, userId);
			try (ResultSet rs = pst.executeQuery();)

			{

				if (rs.next()) {
					email = rs.getString("email_id");
				}

			}
		} catch (SQLException e) {
			throw new DbException("Unable to find User Id", e);

		}
		return email;
	}

	@Override
	public List<UserInformation> findAll() throws DbException {

		List<UserInformation> list1 = new ArrayList<>();
		String sql = "select email_id,epassword,gender,mobile_num,user_id,user_name from users";
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					UserInformation userInformation = new UserInformation();
					userInformation.setEmailId(rs.getString("email_id"));
					userInformation.setEpassword(rs.getString("epassword"));
					userInformation.setGender(rs.getString("gender"));
					userInformation.setUserId(rs.getInt("user_id"));
					userInformation.setMobileNum(rs.getLong("mobile_num"));
					userInformation.setUserName(rs.getString("user_name"));
					list1.add(userInformation);
				}

			}
		} catch (SQLException e) {
			throw new DbException("Unable to find user details", e);

		}

		return list1;
	}
}
