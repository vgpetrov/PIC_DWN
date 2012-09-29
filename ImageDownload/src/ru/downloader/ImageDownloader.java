package ru.downloader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import ru.api.interfaces.IImageDownload;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageDownloader implements IImageDownload {

    private final String IMG_PATTERN_STR = "(http:[A-Za-z0-9_\\./]*\\.[jpg|jpeg|png|gif]{3,4})";
    private final Pattern imagePattern = Pattern.compile(IMG_PATTERN_STR);

    @Override
    public byte[] getImageFromSite(String url) {
        URL siteUrl = null;
        ByteArrayOutputStream out = null;
        InputStream in = null;
        byte[] response = null;
        try {
            siteUrl = new URL(url);
            in = new BufferedInputStream(siteUrl.openStream());
            out = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int n = 0;
            while (-1 != (n = in.read(buf))) {
                out.write(buf, 0, n);
            }
            response = out.toByteArray();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null)
                    out.close();
                if (in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return response;
    }

    @Override
    public List<String> getImagesList(String url) {
        ArrayList<String> imgList = new ArrayList<String>();
        try {
            String pageStr = readPage(new URL(url));
            Matcher m = imagePattern.matcher(pageStr);
            while (m.find()) {
                imgList.add(m.group(1));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imgList;
    }

    private String readPage(URL url) throws Exception {
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
