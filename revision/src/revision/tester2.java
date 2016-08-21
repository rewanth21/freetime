package revision;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class tester2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder contentBuilder = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new FileReader("cacm.html"));
			String str;
			while ((str = in.readLine()) != null) {
				contentBuilder.append(str);
			}
			in.close();
		} catch (IOException e) {
		}
		String content = contentBuilder.toString();
        System.out.println(contentBuilder);
	}
}
