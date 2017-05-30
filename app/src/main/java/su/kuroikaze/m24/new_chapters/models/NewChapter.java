package su.kuroikaze.m24.new_chapters.models;

/**
 * Created by fzhadaev on 28.05.17.
 */

public class NewChapter {
    String author;
    String name;
    String href;

    public NewChapter(String author, String name, String href) {
        this.author = author;
        this.name = name;
        this.href = href;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public String getHref() {
        return href;
    }

}
