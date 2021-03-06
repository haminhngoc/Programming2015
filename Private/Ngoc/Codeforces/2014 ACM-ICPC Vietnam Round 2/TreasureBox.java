import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class TreasureBox {
	static InputStream is;
	static PrintWriter out;
	static String INPUT = "2 2";

	public static void main(String[] args) throws Exception {
		oj = true;
		is = oj ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);

		long s = System.currentTimeMillis();

		// randomTest();

		int T = ni();
		for (int t = 0; t < T; t++) {
			System.out.println(solve(ni(), ni()));
		}

		out.flush();
		tr(System.currentTimeMillis() - s + "ms");
	}

	static long solve(long n, int k) {
		int[] map = new int[101];
		int x = (int) (n % 100);
		int i = 0;
		while (map[x % 100] == 0) {
			map[x % 100] = i++;
			x = x + (x % 100);
		}
		int startRepeat = map[x % 100];
		int repeat = i - startRepeat;
		int sumRepeat = x % 100;
		for (int j = 0; j < repeat; j++) {
			sumRepeat = sumRepeat + sumRepeat % 100;
		}
		sumRepeat -= (x % 100);

		for (int j = 0; k > 0 && j < startRepeat; j++) {
			n = n + n % 100;
			k--;
		}

		n += ((long) sumRepeat * (k / repeat));
		k %= repeat;
		for (int j = 0; j < k; j++) {
			n = n + n % 100;
		}

		return n;
	}

	static long simple(long n, int k) {
		for (int i = 0; i < k; i++) {
			n = n + n % 100;
		}
		return n;
	}

	static void randomTest() {
		for (int i = 0; i < 1000; i++) {
			int n = (int) (Math.random() * 1000000000);
			int k = (int) (Math.random() * 1000000000);

			long re = solve(n, k);
			long res = simple(n, k);
			if (re != res) {
				System.out.println("FALSE: " + n + ", " + k + " => " + re + ", " + res);
			}
		}
	}

	/*****************************************************************
	 ******************** BASIC READER *******************************
	 *****************************************************************/

	static byte[] inbuf = new byte[1024];
	static int lenbuf = 0, ptrbuf = 0;

	static int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	static boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	static int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	static double nd() {
		return Double.parseDouble(ns());
	}

	static char nc() {
		return (char) skip();
	}

	static String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	static char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	static char[][] nm(int n, int m) {
		char[][] map = new char[n][];
		for (int i = 0; i < n; i++)
			map[i] = ns(m);
		return map;
	}

	static int[] na(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = ni();
		return a;
	}

	static int ni() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}

		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	static long nl() {
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}

		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	static boolean oj = System.getProperty("ONLINE_JUDGE") != null;

	static void tr(Object... o) {
		if (!oj) {
			System.out.println(Arrays.deepToString(o));
		}
	}
}
