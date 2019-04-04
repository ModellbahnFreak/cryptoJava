package encrypt;

import java.math.BigInteger;

public class Modul {
	public static BigInteger modPot(BigInteger basis, BigInteger exp, BigInteger modul) {
		BigInteger buchhaltung = BigInteger.ONE;
		while (exp.compareTo(BigInteger.ZERO) == 1) {
			if (exp.testBit(0)) {
				exp = exp.subtract(BigInteger.ONE);
				buchhaltung = (buchhaltung.multiply(basis)).mod(modul);
			} else {
				exp = exp.shiftRight(1);
				basis = (basis.multiply(basis)).mod(modul);
			}
		}
		return buchhaltung;
	}
	
	public static BigInteger multInv(BigInteger zahl, BigInteger modul) {
		BigInteger a1 = modul, a2 = BigInteger.ONE, a3 = BigInteger.ZERO;
		BigInteger b1 = zahl, b2 = BigInteger.ZERO, b3 = BigInteger.ONE;
		//System.out.println("MultInv started");
		while (!a1.equals(b1) && a1.compareTo(BigInteger.ZERO) == 1 && b1.compareTo(BigInteger.ZERO) == 1) {
			if (a1.compareTo(b1) == 1) {
				BigInteger n = a1.divide(b1);
				a1 = a1.subtract(b1.multiply(n));
				a2 = a2.subtract(b2.multiply(n));
				a3 = a3.subtract(b3.multiply(n));
			} else {
				BigInteger n = b1.divide(a1);
				b1 = b1.subtract(a1.multiply(n));
				b2 = b2.subtract(a2.multiply(n));
				b3 = b3.subtract(a3.multiply(n));
			}
			/*System.out.println(a1 + " " + a2 + " " + a3);
			System.out.println(b1 + " " + b2 + " " + b3);
			System.out.println("-----------------------");*/
		}
		//System.out.println("MultInv finished");
		if (a1.compareTo(BigInteger.ONE) == 0) {
			if (a3.compareTo(BigInteger.ZERO) == 1) {
				return a3;
			} else {
				return a3.add(modul);
			}
		} else if (b1.compareTo(BigInteger.ONE) == 0) {
			if (b3.compareTo(BigInteger.ZERO) == 1) {
				return b3;
			} else {
				return b3.add(modul);
			}
		}
		return null;
	}
}
