import java.util.*;

public class RecurringDecimal{
	/*
	coner case: 
	1. negative
	2. -1, -2147483648 thus the product will overflow

	*/
	public static void main(String[] args){
		int numerator = -1, denominator = -2147483648;
		String res = fractionToDecimal(numerator, denominator);
		System.out.println(res);

	}

	private static String fractionToDecimal(int numerator, int denominator){
		if(numerator == 0)
			return "0";
		
		StringBuilder res = new StringBuilder();
		res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");

		long num = Math.abs((long)numerator);
		long den = Math.abs((long)denominator);

		res.append(num/den);

		if(num%den == 0){
			return res.toString();
		}

		num %= den;

		res.append(".");
		HashMap<Long, Integer> map = new HashMap<>();
		while(num!= 0){
			if(map.containsKey(num)){
				int index = map.get(num);
				res.insert(index, "(");
				res.append(")");
				break;
			}else{
				map.put(num, res.length());
				num*=10;
				res.append(num/den);
				num%=den;
			}
		}

		return res.toString();
	}

}