package encryption;

import javax.crypto.NoSuchPaddingException;

import org.testng.annotations.Test;

public class AESEncryptTest {
	
	@Test
	public void sampleTest() throws NoSuchPaddingException, Exception
	{
		String privatekey = "Ac03tEam@j!tu_#1" ;
		String data = "â€œActiveâ€?";
		
		EncryptAndDecryptUtility eadu = new EncryptAndDecryptUtility();
		String encrypted = (eadu.encrypt(data, privatekey));
		System.out.println(encrypted);
		
		String decrypted = (eadu.decreypt(encrypted,privatekey));
		System.out.println(decrypted);
	}
}
