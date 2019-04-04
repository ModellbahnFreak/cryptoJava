package encrypt;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Random;

public class RSA {
	public static BigInteger[] genKeyPair(int bits) {
		System.out.println("Started key gen");
		Random r = new Random();
		BigInteger p = new BigInteger(bits, r);
		while (!p.isProbablePrime(100)) {
			p = new BigInteger(bits, r);
		}
		//System.out.println("Generated p");
		BigInteger q = new BigInteger(bits, r);
		while (!q.isProbablePrime(100)) {
			q = new BigInteger(bits, r);
		}
		//System.out.println("Generated q");
		/*while (q.divide(p).compareTo(BigInteger.ZERO) <= 0 && q.divide(p).compareTo(BigInteger.ZERO) <= 0) {
			q = q.nextProbablePrime();
		}
		System.out.println("Changed p");*/
		BigInteger n = p.multiply(q);
		BigInteger psi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
		BigInteger e = BigInteger.valueOf(65537);
		BigInteger d = Modul.multInv(e, psi);
		psi = null;
		p = null;
		q = null;
		r = null;
		if (d == null) {
			return null;
		}
		return new BigInteger[] {e, d, n};
	}
	
	public static BigInteger encrypt(BigInteger data, BigInteger key, BigInteger modul) {
		//System.out.println("Data len: " + data.bitLength() + "; key len: " + key.bitLength());
		//System.out.println("Encrypting 1 Chunk");
		return Modul.modPot(data, key, modul);
	}
	
	public static String encrypt(String data, BigInteger key, BigInteger modul, int chunkSize) {
		try {
			chunkSize = modul.toByteArray().length;
			byte[] daten = data.getBytes("ISO-8859-1");
			byte[] datenErg = new byte[(int)Math.ceil((double)daten.length/(double)chunkSize)*chunkSize];
			//System.out.println("Start encrypting; chunkLen:" + chunkSize + "; ergLen: " + datenErg.length + "; textLen: " + daten.length);
			int i = 0;
			for (i = 0; i <= daten.length-chunkSize; i += chunkSize) {
				byte[] subData = new byte[chunkSize];
				System.arraycopy(daten, i, subData, 0, chunkSize);
				BigInteger c = encrypt(new BigInteger(subData), key, modul);
				byte[] erg = c.toByteArray();
				//System.out.println("Position: " + i + "; ResultChunk: " + erg.length);
				System.arraycopy(erg, 0, datenErg, i, erg.length);
			}
			if (daten.length%chunkSize != 0) {
				//System.out.println("Rest Position: " + i);
				byte[] subData = new byte[daten.length%chunkSize];
				System.arraycopy(daten, i, subData, 0, daten.length%chunkSize);
				BigInteger c = encrypt(new BigInteger(subData), key, modul);
				byte[] erg = c.toByteArray();
				System.arraycopy(erg, 0, datenErg, i, erg.length);
			}
			return new String(datenErg, "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}
}
