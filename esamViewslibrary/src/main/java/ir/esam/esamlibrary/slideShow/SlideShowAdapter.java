package ir.esam.esamlibrary.slideShow;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by hosseinAmini.
 * EsamViews | Copyrights 2018 Esam.ir Crop.
 */
public class SlideShowAdapter extends FragmentStatePagerAdapter {

    private ArrayList<SlideShowItem> mItems;

    public SlideShowAdapter(FragmentManager fm) {
        super(fm);
        mItems = new ArrayList<>();
    }

    public void addItems(SlideShowItem... items) {
        mItems.addAll(new ArrayList<>(Arrays.asList(items)));
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        SlideShowPageFragment slideShowPageFragment = new SlideShowPageFragment();
        slideShowPageFragment.setSlideshowItem(mItems.get(position));
        return slideShowPageFragment;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }
}
