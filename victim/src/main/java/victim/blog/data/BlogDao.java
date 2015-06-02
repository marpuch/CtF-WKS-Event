package victim.blog.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import victim.blog.bean.BlogData;

@Component
public class BlogDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<BlogData> find(String number) {
		String sql = "select * from blog_comments order by tstmp desc limit " + number;
		RowMapper<BlogData> mapper = new RowMapper<BlogData>() {

			@Override
			public BlogData mapRow(ResultSet rs, int arg1) throws SQLException {
				BlogData result = new BlogData();
				result.setDate(rs.getDate("tstmp"));
				result.setName(rs.getString("name"));
				result.setText(rs.getString("text"));
				return result;
			}
		};
		List<BlogData> result = jdbcTemplate.query(sql, new Object[] {}, mapper);
		return result;
	}
}
