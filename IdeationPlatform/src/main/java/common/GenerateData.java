package common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//import org.apache.commons.lang3.RandomStringUtils;

public class GenerateData {
	private Date date;
	
/*	public String generateRandomString(int length){
		  return RandomStringUtils.randomAlphabetic(length);
		 }
		 
		 public String generateRandomNumber(int length){
		  return RandomStringUtils.randomNumeric(length);
		 }
		 
		 public String generateRandomAlphaNumeric(int length){
		  return RandomStringUtils.randomAlphanumeric(length);
		 }
		 
		 public String generateStringWithAllobedSplChars(int length,String allowdSplChrs){
		  String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
		    "1234567890" +   //numbers
		    allowdSplChrs;
		  return RandomStringUtils.random(length, allowedChars);
		 }
		 
		 public String generateEmail(int length) {
		  String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
		    "1234567890" +   //numbers
		    "_-.";   //special characters
		  String email="";
		  String temp=RandomStringUtils.random(length,allowedChars);
		  email=temp.substring(0,temp.length()-9)+"@test.org";
		  return email;
		 }
		 
		 public String generateUrl(int length) {
		  String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
		    "1234567890" +   //numbers
		    "_-.";   //special characters
		  String url="";
		  String temp=RandomStringUtils.random(length,allowedChars);
		  url=temp.substring(0,3)+"."+temp.substring(4,temp.length()-4)+"."+temp.substring(temp.length()-3);
		  return url;
		 }*/
		 
		 
		 public void PrintCurrentDateTime(String format)
		 {
			 //Create object of SimpleDateFormat class and decide the format
              DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
              //get current date with Date()
              this.date = new Date();
              
              //Now format the date
              String date1 = dateFormat.format(date);
              //return string with current date and time             
              System.out.println("Current date&time: "+date1);
		 }

		 public String getCurrentDate(String format) {
			 //Create object of SimpleDateFormat class and decide the format
             DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
             //get current date with Date()
             this.date = new Date();
             
             //Now format the date
             String date1 = dateFormat.format(date);
			 return date1;
		 }
		 
		 public String getCurrentDateNextYear(String format) {
			//Create object of SimpleDateFormat class and decide the format
             DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
             //get current date with Date()
             this.date = new Date();
            //Now format the date
             String date1 = dateFormat.format(date);
             String date2 =date1.substring(0,6);
             date1 = date2+"2017";
			 return date1;
		 }
		 
	}
	

