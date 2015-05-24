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
		String plaintext = "In case I would forget - certificate for the ssh connection: \n"
				+ "\n"
				+ "-----BEGIN RSA PRIVATE KEY-----\n"
				+ "MIIEpAIBAAKCAQEA6w4C6cA4AAy0GOppAMINdib1/7I3GuRuVuS6bh5tpRv/qc7X\n"
				+ "2z8ikJo4i9dPSLW1GE+djIydNzKxcAaNg0cpwqHxkxSW0FaeCVQzA4EsukJHxL7v\n"
				+ "A/ur0hPF1lKlQLTyizrje+zyC2zU05Vmz3BRv7lwIPo0kDzwTlpm7sGnBcoZxnJM\n"
				+ "3fWEleux+tB3l8uV57IqkH3JOOBlGozAWf1QLozVedRs5zO327wLTJHKXZO+pWXo\n"
				+ "bMA8fbZhqxid8BktsTP9Dmgx9/sj00vnXniiBBGgRS9Y+ya2n5NPiYcQnejmSwYd\n"
				+ "Cw8w14Cr6z0cATW8ruDWMj8ZuxmphPIIpGfkiQIDAQABAoIBAQDAeYO3Jzh0CfL7\n"
				+ "qA99mGlvg63SyHtJIR6dNsTWYUJFfmzW/tJQ7Rz/rdl54UBB+NEm7CLFsWsXhQI5\n"
				+ "CpScmAxBHVz0pFpulU7psrHnP8KBbr7YA8UyzMXAy4In4xsApmspyXn3w2ncIy0P\n"
				+ "aPp8CKxYQ5/m0RtztQLOFkbNYXPET00U/VFVsnIFjH+0aKVb31G4uHuR865YyT3w\n"
				+ "2Pc9cPEE1MNzQr+sDANHeocWFxthlkJx4K3e3j6UP34u1xY6WCrTONLQING5+CM6\n"
				+ "vR9kOPnXLL4oK86MhMlmyH6lWdP4GN91WxsIzXCF6dsx3JAdhkrbex3chpja0pwM\n"
				+ "NOH2DI6FAoGBAPdKparrqFUX9BAjR10F5n5dRpR6A9n60lIMkajr6crSLSowC2jK\n"
				+ "18WqMAVdfC9S08H4+9ORre7cHR3YDfFvmPm8mOXIu0ibkGLMwPnNG67YURBRvfkK\n"
				+ "YXUhzl8L+p4fc/2MeqgdCA9/sjuA2V66IAdTPxeaRkq128gexSmM7tYzAoGBAPNV\n"
				+ "DEqKIfyY7njRR6zMGWo4TrlwTO4GE7qES4wtXaUc/v82bR7jPGS9we9PX2e9DqZQ\n"
				+ "wugDEfjSZ1TwUhrAeoe8KjcP2UbAN8NQ31L6jU50jxyHQbJVCV32cyBKN7Ip+sWJ\n"
				+ "xJHyu+Gl1nUhSQ8aUWq47OUMjBJlCZCYZc8yf8ZTAoGAJjJ+kn8iGjq/9TotzL2b\n"
				+ "k8s+mrKaI7JtiETuvuPp0e1TEqAnMwGaAKtADaQaCYlGskCOTWjEMBAJ41E7Hh75\n"
				+ "xyGNkHjIDPgSfmBYMn2vF/vL0bR+npgu45PcN6w3AvOiy/hF/e+2DgbQdgZ6DPq8\n"
				+ "9cSzCydGUkXy899k3v0o6ycCgYEAllXTNDJHcTJjE03pRH8MrK2BJdyWCvDCO5gE\n"
				+ "vORCWQKjILZVkKG/7FW4fcvCG+uYI3T+Fi3faqVDphyb/V8x1K6SPlaSXL3hNdC/\n"
				+ "SRr3NqOYz31ZP35+PQlIc4inBHIfNvA4/BrFrVGyP8eCxcvyxUbfRVwNJkg6MpWV\n"
				+ "QP/oJXUCgYAzJVr2gKVDjE2Gzf1PGh0xWxsI/KoC19g636XzC60WamjcmLDaxSNX\n"
				+ "I5mC2BtDOgxsrY14djeohhCrzlvxGGbqe1r+e5bvqTaGKagRV1zTSXFTvhbPVBmh\n"
				+ "mvCOhXMqYEjjnKn316ppXDxjIvvTUZHncdyDDSew8WrUaNh5U7Pfzg==\n"
				+ "-----END RSA PRIVATE KEY-----\n"
				+ "\n"
				+ "Oh, and don't forget to remind eve to use a stronger password.\n"
				+ "5 small letters is not enough.\n";
		String password = "tojesthaslo1234";
		String ivAndCiphertext = logic.encrypt(plaintext, password);
		System.out.println(ivAndCiphertext);
		String plaintext2 = logic.decrypt(ivAndCiphertext, password);
		Assert.assertEquals(plaintext, plaintext2);
	}

}
