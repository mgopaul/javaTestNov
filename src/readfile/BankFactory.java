package readfile;

public class BankFactory {
	
	public static BankCardDetailsBase getBank(String bankName){
		BankCardDetailsBase bank = null;
		if (BankCardDetailsHsbc.BANKNAME.equalsIgnoreCase(bankName) ){
			bank= new BankCardDetailsHsbc();
		}else if (BankCardDetailsRBCanada.BANKNAME.equalsIgnoreCase(bankName)){
			bank= new BankCardDetailsRBCanada();
		}else if (BankCardDetailsAmericanExpress.BANKNAME.equalsIgnoreCase(bankName)){
			bank= new BankCardDetailsAmericanExpress();
		}
		
		return bank;
		
	}

}
