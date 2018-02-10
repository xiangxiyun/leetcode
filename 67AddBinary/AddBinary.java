import java.util.*;

public class AddBinary{
	public static void main(String[] args){
		String a = "11";
		String b = "1";
		String res = AddBinary(a, b);
		System.out.println(res);

	}

	public static String AddBinary(String a, String b){
		if(a == null || a.length() == 0)
			return b;
		if(b == null || b.length() == 0)
			return a;

		char[] aArray = a.toCharArray();
		char[] bArray = b.toCharArray();

		int i = aArray.length - 1;
		int j = bArray.length - 1;

		int carry = 0;
		int res;
		int aByte, bByte;

		StringBuilder s = new StringBuilder();

		while(i > -1 || j > -1 || carry == 1){
			aByte = (i>-1) ? Character.getNumericValue(aArray[i--]): 0;
			bByte = (j>-1) ? Character.getNumericValue(bArray[j--]): 0;
			res = aByte ^ bByte ^ carry;
			carry = ((aByte + bByte + carry) >= 2)? 1:0;
			s.append(res);
		}
		return s.reverse().toString();
	}
}