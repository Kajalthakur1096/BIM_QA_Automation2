package bil.helper;

public class Utils {
	public static String get4DigitRandomNumberString() {
		return getRandomNumberString(4);

	}

	public static String getRandomNumberString(int randomSize) {
		StringBuilder sb = new StringBuilder(randomSize);
		String numericString = "0123456789";
		for (int i = 0; i < randomSize; i++) {
			int index = (int) (numericString.length() * Math.random());
			sb.append(numericString.charAt(index));
		}
		return sb.toString();
	}

}
