package victim.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TestLogic {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void test() {
		System.out.println("test");
		jdbcTemplate.execute("select 1 from dual");
	}
}
