package ir.esam.esamlibrary.chipsList.categoryChipsList;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import java.util.ArrayList;

import ir.esam.esamlibrary.EsAdapter;
import ir.esam.esamlibrary.chipsList.ChipsListAdapter;
import ir.esam.esamlibrary.chipsList.ChipsListItem;
import ir.esam.esamlibrary.chipsList.EsChipsList;

/**
 * Created by hosseinAmini.
 * EsamViews | Copyrights 2018 Esam.ir Crop.
 */
public class EsCategoryChipsList extends EsChipsList {

    private CategoryChipsListAdapter mAdapter;

    public EsCategoryChipsList(@NonNull Context context) {
        super(context);
    }

    public EsCategoryChipsList(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public EsCategoryChipsList(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public ChipsListAdapter getAdapter() {
        return mAdapter;
    }

    @Override
    public void createAdapter() {
        mAdapter = new CategoryChipsListAdapter();
    }

}
