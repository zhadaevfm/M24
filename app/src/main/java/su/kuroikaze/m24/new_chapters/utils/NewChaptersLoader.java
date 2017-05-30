package su.kuroikaze.m24.new_chapters.utils;

import android.support.annotation.NonNull;
import android.util.Log;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import su.kuroikaze.m24.new_chapters.models.NewChapter;
import su.kuroikaze.m24.main.utils.ContentLoader;

/**
 * Created by fzhadaev on 28.05.17.
 */

public class NewChaptersLoader {
    public static ArrayList<NewChapter> getNewChapters(){
        ArrayList<NewChapter> result = new ArrayList<>();

        Document content = null;
        try {
            content = new ContentLoader().execute("").get();
            Elements newChapters = content.getElementsByClass("new_chapter");

            for (Element newChapter : newChapters) {
                result.add(parseChapterEntry(newChapter));
            }
        } catch (Exception e) {
            Log.e(NewChaptersLoader.class.toString(), "getNewChapters: ", e);
        }
        return result;
    }

    @NonNull
    private static NewChapter parseChapterEntry(Element newChapter) {
        String author = newChapter.getElementsByTag("address").first().text();
        Element a = newChapter.getElementsByTag("a").first();
        String href = a.attr("href");
        String name = a.text();
        return new NewChapter(author, name, href);
    }
}
