package CeaserVigenere;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		System.out.println("Orjinal metni giriniz:");
		String orjinalMetin = "";
		String anahtar = "";
		String vigenereEncoded = "";
		String ceaserEncoded = "";

		Scanner scanner = new Scanner(System.in);
		orjinalMetin = scanner.nextLine();

		System.out.println("Anahtar giriniz:");
		anahtar = scanner.nextLine();
		scanner.close();

		Vigenere test = new Vigenere();
		Ceaser test1 = new Ceaser();
		vigenereEncoded = test.encrypt(orjinalMetin, anahtar);
		ceaserEncoded = test1.encrypt(orjinalMetin, anahtar);

		System.out.println("CEASER");
		System.out.println("Orjinal metin:" + orjinalMetin + "," + "Anahtar:" + anahtar + "," + "Sifreli metin:"
				+ test1.encrypt(orjinalMetin, anahtar));
		System.out.println("Sifreli metin:" + test1.encrypt(orjinalMetin, anahtar) + "," + "Anahtar:" + anahtar + ","
				+ "Orjinal metin:" + test1.decrypt(ceaserEncoded, anahtar));
		System.out.println("*****************");
		System.out.println("VIGENERE");
		System.out.println("Orjinal metin: " + orjinalMetin + "," + "Anahtar: " + anahtar + "," + "Sifreli metin :"
				+ test.encrypt(orjinalMetin, anahtar));
		System.out.println("Sifreli metin: " + test.encrypt(orjinalMetin, anahtar) + "," + "Anahtar:" + anahtar + ","
				+ "Orjinal metin:" + test.decrypt(vigenereEncoded, anahtar));
	}
}