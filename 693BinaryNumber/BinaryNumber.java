public class BinaryNumber{
	public static void main(String[] args){
		int n = 0;
		boolean res = hasAlternatingbits(n);
		System.out.println(res);

	}
	private static boolean hasAlternatingbits(int n){
		int pre = n%2;
		n = n/2;

		while(n!= 0){
			int cur = n%2;
			if(cur == pre)
				return false;
			pre = cur;
			n = n/2;
		}

		return true;
	}
}