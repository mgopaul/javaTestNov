package readfile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class ReadCsvFile {

	private BankCardDetailsBase bankDetail;

	public ReadCsvFile() {
		super();
	}

	public void execute() {
		BufferedReader bufferedReader = null;

		String filePath = "main/resources/mid-test.csv";
		try {
			URL url = this.getClass().getClassLoader().getResource(filePath);
			bufferedReader = new BufferedReader(new FileReader(url.getPath()));

			processFile(bufferedReader);

		} catch (FileNotFoundException e) {
			System.err.println("File not Found");
			e.printStackTrace();
		} 
	}

	public void processFile(BufferedReader bufferedReader) {
		List<BankCardDetailsBase> bankList = new ArrayList<BankCardDetailsBase>();

		try {
			String readLine;
			while ((readLine = bufferedReader.readLine()) != null) {
				String[] stringTokens = StringUtils.split(readLine, ",");
				if (stringTokens.length == 3) {
					String token1 = stringTokens[0];
					token1 = StringUtils.normalizeSpace(token1);
					bankDetail = BankFactory.getBank(token1);
					if (bankDetail != null){
						bankDetail.setBankName(token1);
						bankDetail.setCardNumber(stringTokens[1]);
						bankDetail.setExpiryDateFromString(stringTokens[2]);
						//System.out.println(String.format("Bank - %s - %s", bankDetail.getBankName(), bankDetail.getCardNumber()));
						bankList.add(bankDetail);
					}
					
				} else {
					System.err.println("Incorrect Line format -- " + stringTokens[0]);
				}

			}
			
			/*for (BankCardDetailsBase bank : bankList){
				System.out.println(
						String.format("Bank - %s - %s", bank.getBankName(), bank.getCardNumber()));
			}*/
			
			sortBankList(bankList);
		} catch (IOException e) {
			System.err.println("Cannot read File");
			e.printStackTrace();
		}

	}

	private void sortBankList(List<BankCardDetailsBase> bankList) {
		Collections.sort(bankList, BankCardDetailsBase.Comparators.DATE);
		Collections.reverse(bankList);
		for (BankCardDetailsBase bank :bankList){
			System.out.println(
					String.format("Bank - %s - %s - %s", bank.getBankName(), bank.getCardNumber(),bank.getExpiryDate()));
		}
	}

	

}
