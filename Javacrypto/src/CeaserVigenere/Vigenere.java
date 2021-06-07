package CeaserVigenere;
public class Vigenere extends Cipher {

	String encrypt(String orjinalMetin, String anahtar) {
		char temp;
		String encodedMetin = "";

		for (int i = 0, j = 0; i < orjinalMetin.length(); i++)

		{
			temp = (char) ('A' + (orjinalMetin.charAt(i) + anahtar.charAt(j)) % 26);
			j = ++j % anahtar.length();
			encodedMetin += temp;

		}

		return encodedMetin;

	}

	String decrypt(String orjinalMetin, String anahtar) {
		char temp;
		String decodedMetin = "";

		for (int i = 0, j = 0; i < orjinalMetin.length(); i++)

		{
			temp = (char) ('A' + (orjinalMetin.charAt(i) - anahtar.charAt(j) + 26) % 26);
			j = ++j % anahtar.length();
			decodedMetin += temp;
		}

		return decodedMetin;

	}
}
