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
		String password = "aaaa";
		String ivAndCiphertext = logic.encrypt(plaintext, password);
		System.out.println(ivAndCiphertext);
		String plaintext2 = logic.decrypt(ivAndCiphertext, password);
		Assert.assertEquals(plaintext, plaintext2);
	}

}
