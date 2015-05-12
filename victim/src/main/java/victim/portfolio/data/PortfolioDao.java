package victim.portfolio.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class PortfolioDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<String> find(String mode) {
		String sql = "select text from portfolio where mode = '" + mode + "'";
		RowMapper<String> mapper = new RowMapper<String>() {
			
			@Override
			public String mapRow(ResultSet rs, int arg1) throws SQLException {
				return rs.getString("text");
			}
		};
		List<String> result = jdbcTemplate.query(sql, new Object[] {}, mapper);
		return result;
	}
}
