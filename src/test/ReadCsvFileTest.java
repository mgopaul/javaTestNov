package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.*;

import readfile.BankCardDetailsAmericanExpress;
import readfile.BankCardDetailsBase;
import readfile.BankCardDetailsHsbc;
import readfile.BankCardDetailsRBCanada;
import readfile.ReadCsvFile;

public class ReadCsvFileTest {
	
	private static final String TEST_HSBC_NAME = "HSBC Canada";
	private static final String TEST_RBCANADA_NAME = "Royal Bank Of Canada";
	
	private static final String TEST_AEXPRESS_NAME = "American Express";
	BankCardDetailsBase bankDetail;
	ReadCsvFile readCsvFile;
	
	String fileName = "testCsv.csv";
	
	String filePath = "./";
	
	BufferedReader bufferedReader;
	
	@BeforeMethod
	public void setUp() throws FileNotFoundException{
		readCsvFile = new ReadCsvFile();
		
	}
	
	
	@Test
	public void testReadBuffered() throws FileNotFoundException{
		URL url =  this.getClass().getClassLoader().getResource("test/resources/testCsv.csv");
		System.out.println(url.getPath());
		File file = new File(url.getPath());
		bufferedReader = new BufferedReader(new FileReader(file));
		readCsvFile.processFile(bufferedReader);
		
	}
	
	
}
