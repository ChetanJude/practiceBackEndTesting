package pancardMock;

import org.mockito.Mockito;
import org.testng.Assert;

class PANCard{
	public String isvalid(String pancard) {
		
		if(pancard.matches("[A-Z]{5}[0-9]{4} [A-Z]")==true) {
			return "is valid pan";
		}
			else
			{ 
				return "is invalid pan";
			}
		}	
public static PANCard getMockObject()
{
	PANCard mockobj = Mockito.mock(PANCard.class);
					  Mockito.when(mockobj.isvalid("ABCDE1234A")).thenReturn("PANcard is valid");
					  Mockito.when(mockobj.isvalid("ABCDE1234B")).thenReturn("PANcard is valid");
					  Mockito.when(mockobj.isvalid("ABCDE1234C")).thenReturn("PANcard is not valid");
	return mockobj;
}
	}
		
public class MockingTest {

	public static void main(String[] args) {
		PANCard obj = PANCard.getMockObject();
		System.out.println(obj.isvalid("ABCDE1234C"));
		//Assert.assertEquals(obj.isvalid("ABCDE1234A"),"PANcard is valid");
	}
}