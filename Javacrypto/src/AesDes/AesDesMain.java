package AesDes;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class AesDesMain {

	public static void main(String[] args) {

		try {

			String filePath = "path file";
			InputStream inputStream = new FileInputStream(filePath);
			byte[] resBytes = inputStream.readAllBytes();
			inputStream.close();

			KeyGenerator keyGenAES = KeyGenerator.getInstance("AES");
			KeyGenerator keygenDES = KeyGenerator.getInstance("DES");
			SecretKey keyAES = keyGenAES.generateKey();
			SecretKey keyDES = keygenDES.generateKey();

			byte[] IV = new byte[16];
			byte[] IV_8bytes = new byte[8];
			SecureRandom random = new SecureRandom();
			random.nextBytes(IV);
			random.nextBytes(IV_8bytes);
			
			// ***********************************************
			
			Cipher cipher_AES_CBC = Cipher.getInstance("AES/CBC/PKCS5Padding");

			SecretKeySpec keySpecAES = new SecretKeySpec(keyAES.getEncoded(), "AES");
			IvParameterSpec ivSpecAES = new IvParameterSpec(IV);

			cipher_AES_CBC.init(Cipher.ENCRYPT_MODE, keySpecAES, ivSpecAES);
			long t1 = System.currentTimeMillis();
			byte[] sifreliMetin_AES_CBC = cipher_AES_CBC.doFinal(resBytes);
			long t2 = System.currentTimeMillis();

			System.out.println("Ýslem:Encryption Anahtar:AES Sifreleme Modu: AES/CBC/PKCS5Padding Zaman(ms): " + (t2 - t1));

			cipher_AES_CBC.init(Cipher.DECRYPT_MODE, keySpecAES, ivSpecAES);
			long t3 = System.currentTimeMillis();
			byte[] cozulmusMetin_AES_CBC = cipher_AES_CBC.doFinal(sifreliMetin_AES_CBC);
			long t4 = System.currentTimeMillis();

			System.out.println("Ýslem:Decryption Anahtar:AES Sifreleme Modu: AES/CBC/PKCS5Padding Zaman(ms): " + (t4 - t3));
			
			// ***********************************************
			
			Cipher cipher_AES_ECB = Cipher.getInstance("AES/ECB/PKCS5Padding");
			
			cipher_AES_ECB.init(Cipher.ENCRYPT_MODE, keySpecAES);
			long t5 = System.currentTimeMillis();
			byte[] sifreliMetin_AES_ECB = cipher_AES_ECB.doFinal(resBytes);
			long t6 = System.currentTimeMillis();
			
			System.out.println("Ýslem:Encryption Anahtar:AES Sifreleme Modu: AES/ECB/PKCS5Padding Zaman(ms): " + (t6 - t5));
			
			cipher_AES_ECB.init(Cipher.DECRYPT_MODE, keySpecAES);
			long t7 = System.currentTimeMillis();
			byte[] cozulmusMetin_AES_ECB = cipher_AES_ECB.doFinal(sifreliMetin_AES_ECB);
			long t8 = System.currentTimeMillis();
			
			System.out.println("Ýslem:Decryption Anahtar:AES Sifreleme Modu: AES/ECB/PKCS5Padding Zaman(ms): " + (t8 - t7));
			
			// ***********************************************
			
			Cipher cipher_DES_CBC = Cipher.getInstance("DES/CBC/PKCS5Padding");

			SecretKeySpec keySpecDES = new SecretKeySpec(keyDES.getEncoded(), "DES");
			IvParameterSpec ivSpecDES = new IvParameterSpec(IV_8bytes);

			cipher_DES_CBC.init(Cipher.ENCRYPT_MODE, keySpecDES, ivSpecDES);
			long t9 = System.currentTimeMillis();
			byte[] sifreliMetin_DES_CBC = cipher_DES_CBC.doFinal(resBytes);
			long t10 = System.currentTimeMillis();
			
			System.out
					.println("Ýslem:Encryption Anahtar:DES Sifreleme Modu: DES/CBC/PKCS5Padding Zaman(ms): " + (t10 - t9));
			
			cipher_DES_CBC.init(Cipher.DECRYPT_MODE, keySpecDES, ivSpecDES);
			long t11 = System.currentTimeMillis();
			byte[] cozulmusMetin_DES_CBC = cipher_DES_CBC.doFinal(sifreliMetin_DES_CBC);
			long t12 = System.currentTimeMillis();
			
			System.out
					.println("Ýslem:Decryption Anahtar:DES Sifreleme Modu: DES/CBC/PKCS5Padding Zaman(ms): " + (t12 - t11));

			// ***********************************************

			Cipher cipher_DES_ECB = Cipher.getInstance("DES/ECB/PKCS5Padding");

			cipher_DES_ECB.init(Cipher.ENCRYPT_MODE, keySpecDES);
			long t13 = System.currentTimeMillis();
			byte[] sifreliMetin_DES_ECB = cipher_DES_ECB.doFinal(resBytes);
			long t14 = System.currentTimeMillis();

			System.out
					.println("Ýslem:Encryption Anahtar:DES Sifreleme Modu: DES/ECB/PKCS5Padding Zaman(ms): " + (t14 - t13));

			cipher_DES_ECB.init(Cipher.DECRYPT_MODE, keySpecDES);
			long t15 = System.currentTimeMillis();
			byte[] cozulmusMetin_DES_ECB = cipher_DES_ECB.doFinal(sifreliMetin_DES_ECB);
			long t16 = System.currentTimeMillis();

			System.out
					.println("Ýslem:Decryption Anahtar:DES Sifreleme Modu: DES/ECB/PKCS5Padding Zaman(ms): " + (t16 - t15));
			
			// ***********************************************
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
