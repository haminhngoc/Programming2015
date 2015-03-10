import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class SecondPriceAuction {
	static InputStream is;
	static PrintWriter out;
	static String INPUT = "3 4 7 8 10 5 5";

	public static void main(String[] args) throws Exception {
		oj = false;
		is = oj ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);

		long s = System.currentTimeMillis();
		solve();
		out.flush();
		tr(System.currentTimeMillis() - s + "ms");
	}

	/**
	 * @Solution:
	 */
	static void solve() {
		int n = ni();
		int MAX = 10000;
		final int F = 0; // First
		final int S = 1; // Second
		double[][] probs = new double[MAX + 1][2];
		double[][] newProbs = new double[MAX + 1][2];
		{
			int left = ni();
			int right = ni();
			float total = right - left + 1;
			for (int j = left; j <= MAX; j++) {
				if (j < right) {
					probs[j][F] = probs[j - 1][F] + 1.0 / total;
				} else {
					probs[j][F] = 1;
				}
			}
		}
		for (int i = 1; i < n; i++) {
			int left = ni();
			int right = ni();
			double total = right - left + 1;
			for (int j = 1; j <= MAX; j++) {
				double probj = (left <= j && j <= right) ? 1 / total : 0;
				double accj = j < left ? 0 : (j <= right ? (j - left + 1) / total : 1);
				newProbs[j][F] = newProbs[j - 1][F]
						+ probs[j - 1][F] * probj
						+ (probs[j][F] - probs[j - 1][F]) * accj;

				double greaterFirst = right >= j ? (right - j) / total : 0;
				accj = j < left ? 0 : (j <= right ? (j - left) / total : 1);
				newProbs[j][S] = newProbs[j - 1][S]
						+ (probs[j][F] - probs[j - 1][F]) * greaterFirst
						+ (probs[j][S] - probs[j - 1][S]) * accj
						+ probs[j - 1][S] * probj;

			}
			double[][] temps = probs;
			probs = newProbs;
			newProbs = temps;
		}

		double result = 0;
		for (int j = 1; j <= MAX; j++) {
			result += (probs[j][S] - probs[j - 1][S]) * j;
		}
		System.out.println(result);
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
