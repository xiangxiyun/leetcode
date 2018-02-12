import java.util.*;

public class BinaryWatch{
	public static void main(String[] args){
		int num = 2;
		List<String> res = readBinaryWatch(num);

		System.out.println(res);

	}

	private static List<String> readBinaryWatch(int num){
		List<String> res = new ArrayList<>();

		for(int h = 0; h < 12; h++)
			for(int m = 0; m < 60; m++){
				if(Integer.bitCount(h) + Integer.bitCount(m) == num)
					res.add(String.format("%d:%02d", h, m));
			}
		return res;
	}
}