package victim.priv.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import victim.priv.bean.PrivBean;

@Component
public class PrivDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public PrivBean find(String name) {
		String sql = "select * from private_data where login = ?";
		RowMapper<PrivBean> mapper = new RowMapper<PrivBean>() {

			@Override
			public PrivBean mapRow(ResultSet rs, int arg1) throws SQLException {
				PrivBean result = new PrivBean();
				result.setEncrypted(rs.getString("text"));
				return result;
			}
		};
		List<PrivBean> result = jdbcTemplate.query(sql, new Object[] { name },
				mapper);
		if (result.size() == 0) {
			return null;
		} else {
			return result.get(0);
		}
	}
}
