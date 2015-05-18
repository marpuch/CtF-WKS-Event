package victim.priv.logic;

import java.security.Key;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Arrays;
import org.springframework.stereotype.Component;

@Component
public class CryptoLogic {

	private static final String ALGORITHM = "AES/OCB/NoPadding";

	static {
		Security.addProvider(new BouncyCastleProvider());
	}

	public String encrypt(String plaintext, String password) {
		try {
			// key init
			Key key = deriveKey(password);

			// cipher init
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, key, new SecureRandom());

			// encrypt
			byte[] message = plaintext.getBytes();
			byte[] ciphertext = new byte[cipher.getOutputSize(message.length)];
			int ctLength = cipher.update(message, 0, message.length,
					ciphertext, 0);
			cipher.doFinal(ciphertext, ctLength);

			return CryptoUtil.bytes2hex(cipher.getIV())
					+ CryptoUtil.bytes2hex(ciphertext);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public String decrypt(String ivAndCiphertext, String password) {
		try {
			// extract data
			byte[] ivAndCiphertextByte = CryptoUtil.hex2byte(ivAndCiphertext);
			byte[] ivByte = Arrays.copyOfRange(ivAndCiphertextByte, 0, 15);
			byte[] ciphertextByte = Arrays.copyOfRange(ivAndCiphertextByte, 15,
					ivAndCiphertextByte.length);

			// key + iv
			IvParameterSpec iv = new IvParameterSpec(ivByte);
			Key key = deriveKey(password);

			// init cipher
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, key, iv);

			// decrypt
			byte[] plaintext = new byte[cipher
					.getOutputSize(ciphertextByte.length)];
			int ptLength = cipher.update(ciphertextByte, 0,
					ciphertextByte.length, plaintext, 0);
			cipher.doFinal(plaintext, ptLength);

			return new String(plaintext);

		} catch (Exception e) {
			// Never do it this way in Crypto-related classes.
			throw new RuntimeException(e);
		}
	}

	private Key deriveKey(String aPassword) {
		try {
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(
					"PBKDF2WithHmacSHA1", "BC");
			byte[] salt = new byte[16];
			PBEKeySpec keySpec = new PBEKeySpec(aPassword.toCharArray(), salt,
					1024, 128);
			Key key = keyFactory.generateSecret(keySpec);
			return key;
		} catch (Exception e) {
			// Never do it this way in Crypto-related classes.
			throw new RuntimeException(e);
		}
	}
}
