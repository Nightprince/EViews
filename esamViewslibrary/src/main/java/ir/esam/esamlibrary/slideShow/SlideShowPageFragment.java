package ir.esam.esamlibrary.slideShow;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ir.esam.esamlibrary.EsImageView;
import ir.esam.esamlibrary.R;

/**
 * Created by hosseinAmini.
 * EsamViews | Copyrights 2018 Esam.ir Crop.
 */
public class SlideShowPageFragment extends Fragment {

    private SlideShowItem mSlideshowItem;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_slide_show_page, container,
                false);

        EsImageView image = viewGroup.findViewById(R.id.img_slide_show_image);


//        image.setBackgroundColor(Color.BLACK);
        image.setImageFormUrl(mSlideshowItem.getImgUrl());

        //  image.setImageFormUrl("https://en.wikipedia.org/wiki/Tree#/media/File:Ash_Tree_-_geograph.org.uk_-_590710.jpg");

        return viewGroup;
    }

    public void setSlideshowItem(SlideShowItem slideshowItem) {
        mSlideshowItem = slideshowItem;
    }

}
