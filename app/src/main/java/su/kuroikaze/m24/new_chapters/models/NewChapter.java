package su.kuroikaze.m24.new_chapters.models;

/**
 * Created by fzhadaev on 28.05.17.
 */

public class NewChapter {
    String translator;
    String name;
    String href;

    public NewChapter(String translator, String name, String href) {
        this.translator = translator;
        this.name = name;
        this.href = href;
    }

    public String getTranslator() {
        return translator;
    }

    public String getName() {
        return name;
    }

    public String getHref() {
        return href;
    }

}
