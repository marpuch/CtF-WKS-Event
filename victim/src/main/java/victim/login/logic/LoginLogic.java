package victim.login.logic;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import victim.login.bean.LoginBean;
import victim.login.bean.UserBean;
import victim.login.bean.UserData;
import victim.login.data.LoginDao;
import victim.priv.logic.CryptoUtil;

@Component
public class LoginLogic {

	@Autowired
	private LoginDao loginDao;
	
	public UserBean login(LoginBean bean, BindingResult bindingResult) {
		UserData userData = loginDao.find(bean.getName());
		if (userData == null) {
			bindingResult.addError(new ObjectError("other.unknownUser", "Unknown user"));
			return null;
		}
		return checkPassword(bean, userData, bindingResult);
	}

	private UserBean checkPassword(LoginBean bean, UserData userData,
			BindingResult bindingResult) {
		switch (userData.getPassEncryptionMethod()) {
		case "NONE": return handleNoEncryption(bean, userData, bindingResult);
		case "MD5": return handleMd5Hash(bean, userData, bindingResult);
		case "BCRYPT": return handleBCryptHash(bean, userData, bindingResult);
		case "BCRYPTP": return handleBCryptPepperHash(bean, userData, bindingResult);
		default: throw new RuntimeException("Unknown password encryption method");
		}
	}

	private UserBean handleBCryptPepperHash(LoginBean bean, UserData userData,
			BindingResult bindingResult) {
		if (BCrypt.checkpw("db381b8a76e81061d2a3767ccebAADS6a843cae84f7560c6e" + bean.getPassword(), userData.getPassword())) {
			return data2bean(userData, bean.getPassword());
		} else {
			bindingResult.addError(new ObjectError("other.wrongPassword", "Wrong password"));
			return null;
		}
	}

	private UserBean handleBCryptHash(LoginBean bean, UserData userData,
			BindingResult bindingResult) {
		if (BCrypt.checkpw(bean.getPassword(), userData.getPassword())) {
			return data2bean(userData, bean.getPassword());
		} else {
			bindingResult.addError(new ObjectError("other.wrongPassword", "Wrong password"));
			return null;
		}
	}

	private UserBean handleMd5Hash(LoginBean bean, UserData userData,
			BindingResult bindingResult) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5", "BC");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		byte[] hash = md.digest(bean.getPassword().getBytes());
		if (Arrays.equals(CryptoUtil.hex2byte(userData.getPassword()), hash)) {
			return data2bean(userData, bean.getPassword());
		} else {
			bindingResult.addError(new ObjectError("other.wrongPassword", "Wrong password"));
			return null;
		}
	}

	private UserBean handleNoEncryption(LoginBean bean, UserData userData,
			BindingResult bindingResult) {
		String base64Password = userData.getPassword();
		byte[] password = Base64.getDecoder().decode(base64Password);
		if (Arrays.equals(password, bean.getPassword().getBytes())) {
			return data2bean(userData, bean.getPassword());
		} else {
			bindingResult.addError(new ObjectError("other.wrongPassword", "Wrong password"));
			return null;
		}
	}

	private UserBean data2bean(UserData userData, String password) {
		UserBean bean = new UserBean();
		bean.setLogin(userData.getLogin());
		bean.setName(userData.getFullName());
		bean.setPassword(password);
		return bean;
	}
	
}
