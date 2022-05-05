package it.engineering.web.test.repository.impljdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import it.engineering.web.test.domain.User;
import it.engineering.web.test.repository.UserRepository;

public class UserRepositoryJDBCImpl implements UserRepository{

	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void saveOrUpdate(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUsername(String username) {
		System.out.println("jdbc repository called");
		String query = "select * from user where username=?";
		User user =jdbcTemplate.queryForObject(query, new UserMapper(), username);
		
		return user;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	class UserMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getLong("id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			return user;
		}	
	}

}
