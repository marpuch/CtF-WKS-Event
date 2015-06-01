package victim.priv.logic;

import org.junit.Assert;

import org.junit.Test;

// Nah, we don't need it for this test
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = VictimCtFApplication.class)
public class CryptoLogicTest {

	@Test
	public void testEncryptDecrypt() {
		CryptoLogic logic = new CryptoLogic();
		String plaintext = "If you can see this... give me a call.\n"
				+ "\n"
				+ "flag-alfa&omega";
		String password = "octopus";
//		String plaintext = "And now only one more step to go.\n"
//				+ "Administrators password is an english dictionary word.\n"
//				+ "\n"
//				+ "flag-password_breaker2!";
//		String password = "brutu51996";
//		String plaintext = "Good job comming this far. Now try this one:\n"
//				+ "\n"
//				+ "Alices parents are Bob and Eve.\n"
//				+ "Her dog is named Brutus.\n"
//				+ "She was born in 1996.\n"
//				+ "She wanted badly to be a hacker.\n"
//				+ "Her best friends are Janice, Timmy and Joe.\n"
//				+ "\n"
//				+ "And this time use Common User Password Profiler. :>\n"
//				+ "flag-firstTimePasswordBreaker";
//		String password = "erteeb";
		String ivAndCiphertext = logic.encrypt(plaintext, password);
		System.out.println(ivAndCiphertext);
		String plaintext2 = logic.decrypt(ivAndCiphertext, password);
		Assert.assertEquals(plaintext, plaintext2);
	}

}
