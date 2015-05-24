package victim.priv.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import victim.login.bean.UserBean;
import victim.priv.bean.PrivBean;
import victim.priv.data.PrivDao;

@Component
public class PrivLogic {

	@Autowired
	private PrivDao privDao;
	
	@Autowired
	private CryptoLogic cryptoLogic;
	
	public PrivBean getText(UserBean userBean) {
		PrivBean bean = privDao.find(userBean.getLogin());
		String decryptedText = cryptoLogic.decrypt(bean.getEncrypted(), userBean.getPassword());
		String decryptedFixedNewLine = htmlify(decryptedText);
		bean.setDecrypted(decryptedFixedNewLine);
		return bean;
	}

	private String htmlify(String decryptedText) {
		String result = decryptedText.replaceAll("\n", "<br/>");
		return result;
	}

	// Spring setters
	
	public void setCryptoLogic(CryptoLogic cryptoLogic) {
		this.cryptoLogic = cryptoLogic;
	}

	public void setPrivDao(PrivDao privDao) {
		this.privDao = privDao;
	}
}
