package application.mob.utils;

public class UtilsMob {
	
	public UtilsMob() {
		
	}
	
	public int stringToInt(String textFibonacci) {
		return Integer.parseInt(textFibonacci);
	}
	
	public String intToString(int textFibonacci) {
		return Integer.toString(textFibonacci);
	}
	
	public String formatUserText(String text) {
		return text.substring(0, 6);
	}
	
	public String concatUsertext(String textUser, String textFibonacci) {
		return new StringBuilder(textUser).append(textFibonacci).toString();
	}

	public boolean isNumeric(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
}
