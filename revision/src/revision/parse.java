package revision;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.*;

import com.sun.xml.internal.txw2.Document;
import com.sun.xml.internal.ws.developer.MemberSubmissionEndpointReference.Elements;
public class parse {


	public static TreeMap<String, LinkedHashMap<String, Integer>>  words = new TreeMap<>();
	public static HashMap<String, Integer> totalFreq = new HashMap();
	public static int Ng = 1;
	public static void main(String[] args) throws IOException {



		String url = "https://en.wikipedia.org/wiki/Sustainable_Energy";

		org.jsoup.nodes.Document doc = Jsoup.connect(url).timeout(20000).get();
		doc.select("sup").remove();


		File file = new File("/Users/revanthrajualluri/Desktop/IRdocs/" + returnFileName(url));
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		String filename = returnFileName(url);

		//parse for parah
		org.jsoup.select.Elements parah = doc.select("title,p,h");

		for(Element p: parah){

			String tmp = p.text().toLowerCase();
			tmp = tmp.replaceAll("[\\Q][(){};!^\"?\\E]", "");


			tmp = tmp.replaceAll("/", " ");
			tmp = tmp.replaceAll("(?<![0-9])[\\,\\.]", "");
			tmp = tmp.replaceAll("[\\,\\.](?![0-9])", "");
			bw.write(tmp + "\n");
			nGramFunc(filename, tmp);

		}

		fw.close();
		for(String word : words.keySet()){
			System.out.println(word + ": " + words.get(word));
		}

		for(String word : words.keySet()){
			int frequency =0;
			LinkedHashMap<String, Integer> list = new LinkedHashMap<>();
			list = words.get(word);
			for(String docid: list.keySet()){
				frequency = frequency + list.get(docid);
				totalFreq.put(word, frequency);
			}


		}
		for(String word : totalFreq.keySet()){
			System.out.println(word + "\t" + totalFreq.get(word));
		}
	}


	public static void nGramFunc(String fn, String tmp){


		String[] temp = tmp.split(" ");
		for(int i = 0; i<temp.length-Ng+1; i++){
            String str = "";
            int start = i;
            int end = i+Ng;
            
            for(int k = start; k<end;k++){
            	str = str + " " + temp[k];
            }

			
				
				if(words.containsKey(str)){
					LinkedHashMap<String, Integer> fileWithTerms = new LinkedHashMap<>();
					fileWithTerms = words.get(str);
					if(fileWithTerms.containsKey(fn)){
						fileWithTerms.put(fn, fileWithTerms.get(fn) + 1);
						
					}
					else{
						fileWithTerms.put(fn,  1);
						
					}
					words.put(str, fileWithTerms);
				}
				else{
					LinkedHashMap<String, Integer> fileWithTerms = new LinkedHashMap<>();
					fileWithTerms.put(fn, 1);
					words.put(str, fileWithTerms);
				}
			
		}
	}

	public static String returnFileName(String url){
		int pos = url.lastIndexOf("/");
		String x =url.substring(pos+1 , url.length());
		x = x.replaceAll("\\p{Punct}+", "");

		return x+".txt"; 


	}

}
