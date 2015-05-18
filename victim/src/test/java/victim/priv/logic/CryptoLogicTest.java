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
		String plaintext = "Das ist ein Test.";
		String password = "tojesthaslo1234";
		String ivAndCiphertext = logic.encrypt(plaintext, password);
		System.out.println(ivAndCiphertext);
		String plaintext2 = logic.decrypt(ivAndCiphertext, password);
		Assert.assertEquals(plaintext, plaintext2);
	}

}
