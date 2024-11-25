package Practice;

public class ReverseThe3WordInAString {

	public static void main(String[] args) {
		String s="Good thing are about to come";
		String [] arr=s.split(" ");
		int rev =arr.length/2;
		System.out.println(rev);

		for(int i=0; i<arr.length;i++){
			if(i==rev){
				StringBuilder st = new StringBuilder(arr[i]);
				System.out.print(st.reverse()+" ");
			}
			else{
				System.out.print(arr[i]+" ");
			}	
		}
	}

}
