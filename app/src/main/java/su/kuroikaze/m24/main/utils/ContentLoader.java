package su.kuroikaze.m24.main.utils;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by fzhadaev on 28.05.17.
 */

public class ContentLoader extends AsyncTask<String,Void, Document>{

    public static final String MAIN_URL = "http://manga24.ru/";

    private Exception exception = null;

    public static String getFullUrl(String relativePath){
        int startIndex = 0;
        char [] chars = relativePath.toCharArray();
        while (startIndex< relativePath.length() && chars[startIndex] == '/')
            startIndex++;
        return MAIN_URL+relativePath.trim().substring(startIndex);
    }

    @Override
    protected Document doInBackground(String... params) {
        Document result = null;
        try {
            String relativePath = params[0];
            result = Jsoup.connect(getFullUrl(relativePath)).get();
        } catch (IOException e) {
            this.exception = e;
            Log.e(ContentLoader.class.toString(), "getContent: ", e);
        }
        return result;
    }

    public Exception getException() {
        return exception;
    }
}
