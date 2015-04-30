package victim.login.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import victim.login.bean.UserData;

@Component
public class LoginDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public UserData find(String name) {
		String sql = "select * from vict_users where login = ?";
		RowMapper<UserData> mapper = new RowMapper<UserData>() {
			
			@Override
			public UserData mapRow(ResultSet rs, int arg1) throws SQLException {
				UserData result = new UserData();
				result.setFullName(rs.getString("full_name"));
				result.setLogin(rs.getString("login"));
				result.setPassEncryptionMethod(rs.getString("pass_encryption_method"));
				result.setPassReminder(rs.getString("pass_reminder"));
				result.setPassword(rs.getString("password"));
				return result;
			}
		};
		List<UserData> result = jdbcTemplate.query(sql, new Object[] {name}, mapper);
		if (result.size() == 0) {
			return null;
		} else {
			return result.get(0); 
		}
	}
}
