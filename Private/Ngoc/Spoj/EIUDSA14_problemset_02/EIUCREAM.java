import java.util.Scanner;

class EIUCREAM {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int nBox = n;
		while (n >= m) {
			int bonus = n / m;
			nBox += bonus;			
			n = n - bonus * m + bonus;
		}
		System.out.println(nBox);
	}
}
