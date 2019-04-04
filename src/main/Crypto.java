package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import encrypt.Caesar;
import encrypt.RSA;

public class Crypto {
	
	static String[][] params = null;//new String[][] {{"rsa-key", "0", "0", "0"}, {"rsa", "Hallo Welt", "lastPublic", "last"}, {"rsa", "last", "lastPrivate", "last"}};

	public static void main(String[] args) throws IOException {
		/*if (params == null || params.length == 0 || params[0].length == 0) {
			if (args.length < 4) {
				System.out.println("Usage: Crypto [Algoritmus] [Daten] [Key] [Modul]");
				return;
			}
			params = new String[][] {args};
		}
		BigInteger[] lastKeys = null;
		String lastText = "";
		for (String[] param : params) {
			if (param.length >= 3) {
				switch (param[0].toLowerCase()) {
				case "rsa-key":
					BigInteger[] keys = RSA.genKeyPair(512);
					System.out.println("Public key: " + keys[0].toString(16));
					//System.out.println("Private key: " + keys[1].toString(16));
					System.out.println("Modul: " + keys[2].toString(16));
					PrintStream ps = new PrintStream(new FileOutputStream(param[1] + ".key"));
					ps.print(keys[1].toString(16));
					ps.flush();
					ps.close();
					ps = new PrintStream(new FileOutputStream(param[1] + ".rsaMod"));
					ps.print(keys[2].toString(16));
					ps.flush();
					ps.close();
					lastKeys = keys;
					break;
				case "rsa":
					if (lastText != null && !lastText.isEmpty() && "last".equals(param[1].toLowerCase())) {
						param[1] = lastText;
					}
					if (lastKeys != null && lastKeys.length >= 3) {
						if ("lastpublic".equals(param[2].toLowerCase())) {
							lastText = RSA.encrypt(param[1], lastKeys[0], lastKeys[2], 10);
						} else if ("lastprivate".equals(param[2].toLowerCase())) {
							lastText = RSA.encrypt(param[1], lastKeys[1], lastKeys[2], 10);
						}
					} else {
						
					}
					System.out.println("Raw: " + lastText);
					System.out.println("Base64: " + Base64.getEncoder().encodeToString(lastText.getBytes("ISO-8859-1")));
					break;
				case "rsadecrypt":
					if (lastText != null && !lastText.isEmpty() && "last".equals(param[1].toLowerCase())) {
						param[1] = lastText;
					}
					if (lastKeys != null && lastKeys.length >= 3) {
						if ("lastpublic".equals(param[2].toLowerCase())) {
							lastText = RSA.encrypt(new String(Base64.getDecoder().decode(param[1]), "ISO-8859-1"), lastKeys[0], lastKeys[2], 10);
						} else if ("lastprivate".equals(param[2].toLowerCase())) {
							lastText = RSA.encrypt(new String(Base64.getDecoder().decode(param[1]), "ISO-8859-1"), lastKeys[1], lastKeys[2], 10);
						}
					} else {
						if (param[2].endsWith(".key")) {
							param[2] = new String(Files.readAllBytes(Paths.get(param[2])));
						}
						if (param[3].endsWith(".rsaMod")) {
							param[3] = new String(Files.readAllBytes(Paths.get(param[3])));
						}
						File inDatei = new File(param[1]);
						if (inDatei.exists() && inDatei.isFile() && !inDatei.isDirectory()) {
							BufferedReader buf = new BufferedReader(new InputStreamReader(new FileInputStream(inDatei)));
							param[1] = buf.readLine();
							buf.close();
						}
						lastText = RSA.encrypt(new String(Base64.getDecoder().decode(param[1]), "ISO-8859-1"), new BigInteger(param[2], 16), new BigInteger(param[3], 16), 10);
					}
					System.out.println(lastText);
					break;
				case "rsaencrypt":
					if (lastText != null && !lastText.isEmpty() && "last".equals(param[1].toLowerCase())) {
						param[1] = lastText;
					}
					if (lastKeys != null && lastKeys.length >= 3) {
						if ("lastpublic".equals(param[2].toLowerCase())) {
							lastText = RSA.encrypt(param[1], lastKeys[0], lastKeys[2], 10);
						} else if ("lastprivate".equals(param[2].toLowerCase())) {
							lastText = RSA.encrypt(param[1], lastKeys[1], lastKeys[2], 10);
						}
					} else {
						if (param[2].endsWith(".key")) {
							param[2] = new String(Files.readAllBytes(Paths.get(param[2])));
						}
						if (param[3].endsWith(".rsaMod")) {
							param[3] = new String(Files.readAllBytes(Paths.get(param[3])));
						}
						File inDatei = new File(param[1]);
						if (inDatei.exists() && inDatei.isFile() && !inDatei.isDirectory()) {
							param[1] = new String(Files.readAllBytes(Paths.get(param[1])));
						}
						lastText = RSA.encrypt(param[1], new BigInteger(param[2], 16), new BigInteger(param[3], 16), 10);
					}
					System.out.println(Base64.getEncoder().encodeToString(lastText.getBytes("ISO-8859-1")));
					break;
				case "caesar":
					if (param[2].length() > 2 || (param[2].charAt(0) != '-' && param[2].length() == 2)) {
						
					} else {
						if (param[2].length() == 2 && param[2].charAt(0) == '-') {
							System.out.println(Caesar.caesar26(param[1], (param[2].charAt(0))));
						} else if (param[2].length() == 1) {
							System.out.println(Caesar.caesar26(param[1], param[2].charAt(0)));
						}
					}
					break;
				case "vigenere":
					
					break;
				}
			}
		}*/
		System.out.println((int)((char)((Character.MAX_VALUE+1)-1)));
		System.out.println((int)((char)((Character.MAX_VALUE+1)-0)));
	}

}
