package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import readfile.BankCardDetailsAmericanExpress;
import readfile.BankCardDetailsBase;
import readfile.BankCardDetailsHsbc;
import readfile.BankCardDetailsRBCanada;

public class BankCardDetailsTest {
	
	private static final String TEST_HSBC_NAME = "HSBC Canada";
	private static final String TEST_RBCANADA_NAME = "Royal Bank Of Canada";
	
	private static final String TEST_AEXPRESS_NAME = "American Express";
	BankCardDetailsBase bankDetail;
	
	
	
	@Test
	public void testBankHsbc(){
		bankDetail = new BankCardDetailsHsbc();
		bankDetail.setBankName(TEST_HSBC_NAME);
		bankDetail.setExpiryDateFromString("Nov-2017");
		bankDetail.setCardNumber("3456-1114-6543-7865");
		
		Assert.assertEquals(bankDetail.getBankName(), TEST_HSBC_NAME);
		Assert.assertEquals(bankDetail.getCardNumber(), "34xx-xxxx-xxxx-xxxx");
		Assert.assertNotNull(bankDetail.getExpiryDate());
	}
	
	
	@Test
	public void testBankRBCanada(){
		bankDetail = new BankCardDetailsRBCanada();
		bankDetail.setBankName(TEST_RBCANADA_NAME);
		
		bankDetail.setExpiryDateFromString("Oct-2017");
		bankDetail.setCardNumber("3456-1114-6543-4535");
		
		Assert.assertEquals(bankDetail.getBankName(), TEST_RBCANADA_NAME);
		Assert.assertEquals(bankDetail.getCardNumber(), "3456-xxxx-xxxx-xxxx");
		Assert.assertNotNull(bankDetail.getExpiryDate());
		
	}
	
	@Test
	public void testBankAExpress(){
		bankDetail = new BankCardDetailsAmericanExpress();
		bankDetail.setBankName(TEST_AEXPRESS_NAME);
		
		bankDetail.setExpiryDateFromString("Oct-2017");
		bankDetail.setCardNumber("3456-1114-6543-453");
		
		Assert.assertEquals(bankDetail.getBankName(), TEST_AEXPRESS_NAME);
		Assert.assertEquals(bankDetail.getCardNumber(), "xxxx-xxxx-xxxx-453");
		Assert.assertNotNull(bankDetail.getExpiryDate());
		
	}
	

}

