package com.sukanya.emetest;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by Sukanya123 on 06-05-2018.
 */

public class FlipperAdpater extends BaseAdapter {

    int[] slides;
    Context context;

    // constructor
    public FlipperAdpater(Context context, int[] slides) {
        this.slides = slides;
        this.context = context;
    }

    @Override
    public int getCount() {
        return slides.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.flipper_view, null);

        ImageView image = v.findViewById(R.id.image);
        image.setImageResource(slides[position]);
        Log.v("ankur", "item added to flipper : " + slides[position]);

        return v;
    }
}