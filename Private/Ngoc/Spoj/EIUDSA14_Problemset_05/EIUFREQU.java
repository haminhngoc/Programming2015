import java.util.*;

public class EIUFREQU {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Map<String, Integer> dic = new Hashtable<String, Integer>();
		for (int i = 0; i < N; i++) {
			String name = sc.next();
			Integer value = dic.get(name);
			if (value == null) {
				value = 0;
			}
			value++;
			dic.put(name, value);
		}

		for (String key : dic.keySet()) {
			System.out.println(key + " " + dic.get(key));
		}
	}

}
