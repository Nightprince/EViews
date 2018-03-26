package ir.esam.esamlibrary.slideShow;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import ir.esam.esamlibrary.R;

/**
 * Created by hosseinAmini.
 * EsamViews | Copyrights 2018 Esam.ir Crop.
 */
public class EsSlideShow extends LinearLayout {

    private ViewPager mPager;

    public EsSlideShow(Context context) {
        super(context);
        initialize();
    }

    public EsSlideShow(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public EsSlideShow(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    private void initialize() {

        View layout = LayoutInflater.from(getContext()).inflate(R.layout.es_slide_show,
                this, true);

        mPager = layout.findViewById(R.id.pager);

        AppCompatActivity activity = (AppCompatActivity) getContext();

        mPager.setAdapter(new SlideShowAdapter(activity.getSupportFragmentManager()));
    }
}
