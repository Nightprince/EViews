package ir.esam.esamlibrary.slideShow;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import ir.esam.esamlibrary.R;
import me.relex.circleindicator.CircleIndicator;

/**
 * Created by hosseinAmini.
 * EsamViews | Copyrights 2018 Esam.ir Crop.
 */
public class EsSlideShow extends LinearLayout {

    private SlideShowAdapter mAdapter;

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

        ViewPager pager = layout.findViewById(R.id.pager);
        CircleIndicator indicator = layout.findViewById(R.id.slide_show_indicator);

        mAdapter = new SlideShowAdapter(((AppCompatActivity) getContext()).getSupportFragmentManager());

        pager.setAdapter(mAdapter);
        indicator.setViewPager(pager);
        mAdapter.registerDataSetObserver(indicator.getDataSetObserver());
    }

    public void addItems(SlideShowItem... items) {
        mAdapter.addItems(items);
    }

}
