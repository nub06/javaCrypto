package CeaserVigenere;

abstract class Cipher {
	abstract String encrypt(String orjinalMetin, String anahtar);

	abstract String decrypt(String sifreliMetin, String anahtar);
}