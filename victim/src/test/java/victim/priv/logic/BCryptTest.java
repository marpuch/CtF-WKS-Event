package victim.priv.logic;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class BCryptTest {

	@Test
	public void testBCrypt() {
		String salt = BCrypt.gensalt(10);
		System.out.println(BCrypt.hashpw("db381b8a76e81061d2a3767ccebAADS6a843cae84f7560c6eoctopus", salt));
	}
}
