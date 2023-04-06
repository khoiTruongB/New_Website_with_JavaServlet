package com.khoi.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.khoi.dao.IGenericDAO;
import com.khoi.mapper.IRowMapper;

/** */
public class AdstractDAO<T> implements IGenericDAO<T> {

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String URL = "jdbc:mysql://localhost:3306/newdb";
			String USER = "root";
			String PASS = "";
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public <T> List<T> query(String sql, IRowMapper<T> rowMapper, Object... parameter) {

		List<T> results = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stm = conn.prepareStatement(sql);
			// set parameter
			setParameter(stm, parameter);
			rs = stm.executeQuery();
			while (rs.next()) {
				results.add(rowMapper.mapRow(rs));
			}
			return results;
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			try {
				if (conn != null) {
					conn.close();

				}
				if (conn != null) {
					stm.close();
				}
				if (conn != null) {
					rs.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
		return null;
	}

	private void setParameter(PreparedStatement stm, Object... parameter) {

		try {
			for (int i = 0; i < parameter.length; i++) {
				int index = i + 1;
				Object para = parameter[i];
				if (para instanceof String) {
					stm.setString(index, (String) para);
				}else if (para instanceof Long) {
					stm.setLong(index, (Long) para);
				}else if (para instanceof Integer) {
					stm.setInt(index, (Integer) para);
				}else if (para instanceof Timestamp) {
					stm.setTimestamp(index, (Timestamp) para);
				}
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}

	}

	@Override
	public void update(String sql, Object... parameter) {

		Connection conn = null;
		PreparedStatement stm = null;

		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			stm = conn.prepareStatement(sql);
			setParameter(stm, parameter);
			stm.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}finally {
			try {
				if (conn != null) {
					conn.close();

				}
				if (conn != null) {
					stm.close();
				}
			} catch (SQLException e) {
				
			}
		}
	}

	@Override
	public Long insert(String sql, Object... parameter) {
		Long id = null;
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			stm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParameter(stm, parameter);
			stm.executeUpdate();
			rs = stm.getGeneratedKeys();
			if(rs.next()) {
				id = rs.getLong(1);
			}
			conn.commit();
			return id;
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}finally {
			try {
				if (conn != null) {
					conn.close();

				}
				if (conn != null) {
					stm.close();
				}
				if (conn != null) {
					rs.close();
				}
			} catch (SQLException e) {
				
			}
		}
		return null;
	}

}
