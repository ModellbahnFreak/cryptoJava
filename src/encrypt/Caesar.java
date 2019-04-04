package encrypt;

public class Caesar {
	public static String caesar26decrypt(String text, char key) {
		key = (char) (26-(Character.toUpperCase(key)-'A')%26+'A');
		return caesar26(text, key);
	}
	
	public static String caesar26(String text, char key) {
		char[] in = text.toCharArray();
		key = (char) (Character.toUpperCase(key)-'A');
		if (key >= 0 && key <= 25) {
			for (int i = 0; i < in.length; i++) {
				if (in[i] >= 'A' && in[i] <= 'Z') {
					in[i] = (char) (((in[i]-'A')+key)%26+'A');
				} else if (in[i] >= 'a' && in[i] <= 'z') {
					in[i] = (char) (((in[i]-'a')+key)%26+'a');
				}
			}
		}
		return new String(in);
	}
	
	public static String caesar256decrypt(String text, char key) {
		key = (char) (((Character.MAX_VALUE+1)-key)%Character.MAX_VALUE);
		return caesar256(text, key);
	}
	
	public static String caesar256(String text, char key) {
		char[] in = text.toCharArray();
		for (int i = 0; i < in.length; i++) {
			in[i] = (char) ((in[i]+key)%Character.MAX_VALUE);
		}
		return new String(in);
	}
	
	public static String vigenere26(String text, String key) {
		char[] in = text.toCharArray();
		char[] keyArr = key.toUpperCase().replaceAll("[^A-Z]", "").toCharArray();
		for (int i = 0; i < in.length; i++) {
			char keyC = (char) (keyArr[i%keyArr.length]-'A');
			if (in[i] >= 'A' && in[i] <= 'Z') {
				in[i] = (char) (((in[i]-'A')+keyC)%26+'A');
			} else if (in[i] >= 'a' && in[i] <= 'z') {
				in[i] = (char) (((in[i]-'a')+keyC)%26+'a');
			}
		}
		return new String(in);
	}
	
	public static String vigenere256(String text, String key) {
		char[] in = text.toCharArray();
		char[] keyArr = key.toCharArray();
		for (int i = 0; i < in.length; i++) {
			char keyC = keyArr[i%keyArr.length];
			in[i] = (char) ((in[i]+keyC)%Character.MAX_VALUE);
		}
		return new String(in);
	}
}
