package readfile;

import org.apache.commons.lang3.StringUtils;

public class BankCardDetailsRBCanada extends BankCardDetailsBase{
	
	public static final String BANKNAME= "Royal Bank Of Canada";

	@Override
	public String encryptCardNumber(String cardNumber) {
		String encrytedVal = StringUtils.overlay(cardNumber, "xxxx-xxxx-xxxx",5,cardNumber.length());
		return encrytedVal;
	}

}

