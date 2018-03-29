package ir.esam.esamlibrary.chipsList.categoryChipsList;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import ir.esam.esamlibrary.EsAdapter;
import ir.esam.esamlibrary.chipsList.EsChipsList;

/**
 * Created by hosseinAmini.
 * EsamViews | Copyrights 2018 Esam.ir Crop.
 */
public class EsCategoryChipsList extends EsChipsList {

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
    public EsAdapter getAdapter() {
        return null;
    }
}
