package readfile;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public abstract class BankCardDetailsBase {

	private String bankName;
	private Date expiryDate;
	private String cardNumber;

	public BankCardDetailsBase() {
	}

	public BankCardDetailsBase(String bankName, Timestamp expiryDate, String cardNumber) {
		super();
		this.bankName = bankName;
		this.expiryDate = expiryDate;
		this.cardNumber = cardNumber;
	}

	public abstract String encryptCardNumber(String cardNumber);

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = encryptCardNumber(cardNumber);
	}
	
	public void setExpiryDateFromString(String expiryDatestr) {
		SimpleDateFormat formatter1 = new SimpleDateFormat("MMM-yyyy");
		
		try {
			this.expiryDate = formatter1.parse(expiryDatestr);
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
	}
	
	public static class Comparators {

        public static Comparator<BankCardDetailsBase> DATE = new Comparator<BankCardDetailsBase>() {
            @Override
            public int compare(BankCardDetailsBase o1, BankCardDetailsBase o2) {
                return o1.expiryDate.compareTo(o2.expiryDate);
            }
        };
       
	}

}
