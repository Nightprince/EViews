package ir.esam.esamlibrary.slideShow;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import ir.esam.esamlibrary.SlideShowPageFragment;

/**
 * Created by hosseinAmini.
 * EsamViews | Copyrights 2018 Esam.ir Crop.
 */
public class SlideShowAdapter extends FragmentStatePagerAdapter {

    public SlideShowAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new SlideShowPageFragment();
    }

    @Override
    public int getCount() {
        return 5;
    }
}
