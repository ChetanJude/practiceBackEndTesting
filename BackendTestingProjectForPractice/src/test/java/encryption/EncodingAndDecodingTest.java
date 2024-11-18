package encryption;

import java.util.Base64;

import org.testng.annotations.Test;

public class EncodingAndDecodingTest {

	@Test
	public void sampleTest()
	{
		String encode = new String(Base64.getEncoder().encode("CHANDAN".getBytes()));
		System.out.println(encode);
		
		String decode = new String(Base64.getDecoder().decode(encode.getBytes()));
		System.out.println(decode);
	}
}
