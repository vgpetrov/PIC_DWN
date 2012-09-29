package ru.zzz;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class Main {

    /*
      * // .jpg | .gif | .png | .jpeg
      */

    /**
     * @param args
     */
    public static void main(String[] args) {
//        ([a-z\-_0-9\/\:\.]*\.(jpg|jpeg|png|gif))/i
//        Pattern MY_PATTERN = Pattern.compile("(.*.[jpg|gif])");
        Pattern MY_PATTERN = Pattern.compile("(http:[A-Za-z0-9_\\./]*\\.[jpg|jpeg|png|gif]{3,4})");
//        Matcher m =
//                MY_PATTERN.matcher("<a src=\"http:va_sya/pequacomasdasdwwqskaasdhdppp.jpg\"></a><b>http://vasyapetu.com/asdasdwwqska/asdhd/tttt.gif</b>");
//        while (m.find()) {
//            String s = m.group(1);
//            System.out.println(s);
//        }

		try {
			String pageStr = readPage(new URL(
					"http://showusyourass.tumblr.com/"));
			Matcher m = MY_PATTERN.matcher(pageStr);
			while (m.find()) {
				String s = m.group(1);
				System.out.println(s);
			}
            System.out.println("______________");
            System.out.println(pageStr);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    private static String readPage(URL url) throws Exception {
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url.toURI());
        HttpResponse response = client.execute(request);
        Reader reader = null;
        try {
            reader = new InputStreamReader(response.getEntity().getContent());
            StringBuffer sb = new StringBuffer();
            int read;
            char[] cbuf = new char[1024];
            while ((read = reader.read(cbuf)) != -1) {
                sb.append(cbuf, 0, read);
            }
            return sb.toString();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
