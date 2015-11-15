package readfile;

import org.apache.commons.lang3.StringUtils;

public class BankCardDetailsHsbc extends BankCardDetailsBase{
	
	public static final String BANKNAME= "Hsbc Canada";

	@Override
	public String encryptCardNumber(String cardNumber) {
		String encrytedVal = StringUtils.overlay(cardNumber, "xx-xxxx-xxxx-xxxx",2,cardNumber.length());
		return encrytedVal;
	}

}

