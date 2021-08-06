package regex;

import java.util.regex.*;

public class Regex{

	public boolean check(String input, String data) {
		boolean ans = false;
		
		if(input.equals("a")) 
		{
			ans = checkSSNFormat(data);
		}
		else if(input.equals("b"))
		{
			ans = checkUSPhoneNumberFormat(data);
		}
		else if(input.equals("c"))
		{
			ans = checkEmailAddressFormat(data);
		}
		else if(input.equals("d"))
		{
			ans = checkClassRosterFormat(data);
		}
		else if(input.equals("e"))
		{
			ans = checkDateFormat(data);			
		}
		else if(input.equals("f"))
		{
			ans = checkHouseAddress(data);
		}
		else if(input.equals("g"))
		{
			ans = checkCityStateZipFormat(data);
		}
		else if(input.equals("h"))
		{
			ans = checkMilitaryTimeFormat(data);
		}
		else if(input.equals("i"))
		{
			ans = checkUSCurrencyFormat(data);
		}
		else if(input.equals("j"))
		{
			ans = checkURLFormat(data);
		}
		else if(input.equals("k"))
		{
			ans = checkPasswordFormat(data);
		}
		else if(input.equals("l"))
		{
			ans = checkStringFormat(data);
		}
		return ans;
	}

	private boolean checkSSNFormat(String data) {
		String ssn_regex = "^(?!666|000|9\\d{2})\\d{3}[- ]?(?!00)\\d{2}[- ]?(?!0{4})\\d{4}$";
		return Pattern.matches(ssn_regex, data);
	}

	private boolean checkUSPhoneNumberFormat(String data) {
		String us_phone_regex = "(?:\\d{1}\\s?)?\\(?(\\d{3})\\)?-?\\s?(\\d{3})-?\\s?(\\d{4})";
		return Pattern.matches(us_phone_regex, data);
	}

	private boolean checkEmailAddressFormat(String data) {
		String email_regex = "^([A-Za-z0-9+_.-])+@([a-zA-Z0-9])+\\.([a-zA-Z]{2,6})$";
		return Pattern.matches(email_regex, data);
	}

	private boolean checkClassRosterFormat(String data) {;
		String roaster_regex = "([a-zA-z]+)([ ][a-zA-z]+)([ ][a-zA-z]+)*";
		return Pattern.matches(roaster_regex, data);
	}

	private boolean checkDateFormat(String data) {
		
		String date_regex = "((0[1-9])|(1[0-2]))[-\\/]((0[1-9])|([12][0-9])|(3[01]))[-\\/]([0-9]{4})";
		boolean isDatePatternCorrect = Pattern.matches(date_regex, data);

		if(isDatePatternCorrect) {
			
			String []arr = data.split("[-\\/]") ;
			
		
			int month = Integer.parseInt(arr[0]);
			int day = Integer.parseInt(arr[1]);
			int year = Integer.parseInt(arr[2]);
			
			switch(month) {
			case 4:
			case 6:
			case 9:
			case 11:
				if(day==31) {
					return false;
				}
				return true;
			case 2:
				if(checkLeapYear(year)) {
					if(day <= 29) {
						return true;
					}
					return false;
				}
				else {
					if(day <= 28) {
						return true;
					}
					return false;
				}
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return true;
			}
		}
		return true;
	}

	private boolean checkHouseAddress(String data) {
		String house_address_regex = "[0-9]+([a-zA-Z0-9 ,.]+)";
		System.out.println("I am in house address "+data);
		return Pattern.matches(house_address_regex, data);
	}

	private boolean checkCityStateZipFormat(String data) {	
		String city_state_zip_regex = "^([A-Za-z ,]+)[0-9]{5}(?:-[0-9]{4})?$";
		return Pattern.matches(city_state_zip_regex, data);
	}

	private boolean checkMilitaryTimeFormat(String data) {
		String military_time_regex = "([01]?[0-9]|2[0-3]):?([0-5][0-9])(:?[0-5][0-9])?$";
		return Pattern.matches(military_time_regex, data);
	}

	private boolean checkUSCurrencyFormat(String data) {
		String us_currency_regex = "^\\$(0|[1-9][0-9]{0,2})(,\\d{3})*(\\.\\d{1,2})?$";
		return Pattern.matches(us_currency_regex, data);
	}

	private boolean checkURLFormat(String data) {
		String url_regex = "^(https?:\\/\\/)([\\da-z\\.-]+\\.[a-z\\.]{2,6}|[\\d\\.]+)([\\/:?=&#]{1}[\\da-z\\.-]+)*[\\/\\?]?$";
		return Pattern.matches(url_regex, data);
	}

	private boolean checkPasswordFormat(String data) {
		if(Pattern.matches(".*(?:[a-z]{4,}).*", data)) {
			return false;
		}
		
		String password_regex = "^(?=(.*[0-9]))(?=(.*[a-z]))(?=(.*[A-Z]))(?=(.*[!\"#$%&'*+,\\-.\\/:;\\[\\]<=>?@()^_`{|}~]))(?:[0-9a-zA-Z!\"#$%&'\\[\\]*+,()\\-.\\/:;<=>?@^_`{|}~]){10,}$";
                                                
		return Pattern.matches(password_regex, data);
		
	}

	private boolean checkStringFormat(String data) {
		String word_regex = "^([a-zA-A]{2})*ion$";
		return Pattern.matches(word_regex, data);
	}
	
	private boolean checkLeapYear(int year) {
		if (year % 400 == 0) {
			return true;
		}
	     
	    if (year % 100 == 0) {
	    	return false;
	    }
	    
	    if (year % 4 == 0) {
	        return true;
	    }
	    
	    return false;
	}
	
}