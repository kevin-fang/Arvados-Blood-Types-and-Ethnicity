import java.io.*;
import java.util.zip.GZIPInputStream;

public class GZipTester
{
	public static void main(String args[]) throws IOException {
		GZIPInputStream gzip = new GZIPInputStream(new FileInputStream(args[0]));
		BufferedReader br = new BufferedReader(new InputStreamReader(gzip));
		String nextLine = br.readLine();
		while (nextLine != null) {
			System.out.println(br.readLine());
			nextLine = br.readLine();
		}
	}
}