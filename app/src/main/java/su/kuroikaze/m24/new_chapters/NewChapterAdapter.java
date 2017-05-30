package su.kuroikaze.m24.new_chapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import su.kuroikaze.m24.R;
import su.kuroikaze.m24.main.utils.ContentLoader;
import su.kuroikaze.m24.new_chapters.models.NewChapter;

/**
 * Created by fzhadaev on 28.05.17.
 */

public class NewChapterAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<NewChapter> chapters;
    public NewChapterAdapter(Context context, ArrayList<NewChapter> newChapters) {
        ctx = context;
        chapters = newChapters;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return chapters.size();
    }

    @Override
    public Object getItem(int position) {
        return chapters.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null){
            view = lInflater.inflate(R.layout.new_chapter, parent, false);
        }
        NewChapter chapter = chapters.get(position);

        ((TextView) view.findViewById(R.id.tv_ch_translator)).setText(chapter.getTranslator());
        ((TextView) view.findViewById(R.id.tv_ch_name)).setText(chapter.getName());
        ((TextView) view.findViewById(R.id.tv_ch_url)).setText(
                ContentLoader.getFullUrl(chapter.getHref()));

        return view;
    }
}
