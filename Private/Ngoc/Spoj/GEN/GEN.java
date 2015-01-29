import java.io.File;
import java.io.FileWriter;

public class GEN {

	public static void main(String[] args) throws Exception {
		// gen_EIUAPPEA(9, 100000, 1000000, 1000000 + 100000);
		// gen_EIUAPPEA(10, 100000, 1000000, 1000000 + 100000);
		// gen_EIUAPPEA(11, 6, 1, 4);
		
		
	}

	public static int randBetween(int start, int end) {
		if (start == end) {
			end++;
		}
		return start + (int) Math.floor(Math.random() * (end - start - 0.000001));
	}

	public static void gen_EIUFREQU(int id, String[] names, int n) throws Exception {
		String root = "D:\\GitHub\\Programming2015\\Private\\Ngoc\\Spoj\\";
		String basePath = root + "EIUDSA14_Problemset_05\\";
		String classPath = root + "bin\\";
		String javaClass = "EIUAPPEA";

		String outPath = basePath + javaClass + "\\";
		File theDir = new File(outPath);
		theDir.mkdir();
		String inFilename = outPath + id + ".in";
		String outFilename = outPath + id + ".out";
		FileWriter in = new FileWriter(inFilename);

		StringBuffer inBuffer = new StringBuffer();
		inBuffer.append(n + "\r\n");
		for (int i = 0; i < n; i++) {
			int value = randBetween(0, names.length);
			inBuffer.append(value + " ");
		}

		in.write(inBuffer.toString() + "\r\n");
		in.close();

		String command = "java -cp " + classPath + " " + javaClass + " < " + inFilename + " > " + outFilename;
		System.out.println(command);
	}

	public static void gen_EIUAPPEA(int id, int n, int minRange, int maxRange) throws Exception {
		String basePath = "D:\\GitHub\\Programming2015\\Private\\Ngoc\\Spoj\\MidTerm\\EIUAPPEA\\";
		String classPath = "D:\\GitHub\\Programming2015\\Private\\Ngoc\\Spoj\\bin";
		String javaClass = "EIUAPPEA";

		String inFilename = basePath + id + ".in";
		String outFilename = basePath + id + ".out";
		FileWriter in = new FileWriter(inFilename);

		StringBuffer inBuffer = new StringBuffer();
		inBuffer.append(n + "\r\n");

		for (int i = 0; i < n; i++) {
			int value = randBetween(minRange, maxRange);
			inBuffer.append(value + " ");
		}

		in.write(inBuffer.toString() + "\r\n");
		in.close();

		String command = "java -cp " + classPath + " " + javaClass + " < " + inFilename + " > " + outFilename;
		System.out.println(command);
	}

}
