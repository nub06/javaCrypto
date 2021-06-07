package CeaserVigenere;

public class Ceaser extends Cipher {

	@Override
	String encrypt(String orjinalMetin, String anahtar) {
		String encodedMetin = "";

		for (char e : orjinalMetin.toCharArray()) {

			if (e + anahtar.length() > 122) {
				e = (char) ('A' + (e + anahtar.length() - 123));
			} else {
				e += anahtar.length();
			}
			encodedMetin += e;

		}
		return encodedMetin;

	}

	@Override
	String decrypt(String orjinalMetin, String anahtar) {
		String decodedMetin = "";
		for (char e : orjinalMetin.toCharArray()) {
			if (e - anahtar.length() < 65) {
				int a = e - anahtar.length();
				int b = 65 - a;
				e = (char) ('z' - b + 1);

			} else {

				e -= anahtar.length();

			}

			decodedMetin += e;

		}
		return decodedMetin;

	}
}
