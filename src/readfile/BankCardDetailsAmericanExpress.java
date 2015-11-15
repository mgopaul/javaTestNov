package readfile;

import org.apache.commons.lang3.StringUtils;

public class BankCardDetailsAmericanExpress extends BankCardDetailsBase{
	
	public static final String BANKNAME= "American Express";

	@Override
	public String encryptCardNumber(String cardNumber) {
		String encrytedVal = StringUtils.overlay(cardNumber, "xxxx-xxxx-xxxx",0,cardNumber.length() - 4);
		return encrytedVal;
	}

}

