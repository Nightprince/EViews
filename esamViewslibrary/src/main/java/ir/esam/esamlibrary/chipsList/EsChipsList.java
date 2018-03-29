package ir.esam.esamlibrary.chipsList;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import ir.esam.esamlibrary.EsAdapter;
import ir.esam.esamlibrary.R;
import ir.esam.esamlibrary.productsSlider.ProductSliderAdapter;

/**
 * Created by hosseinAmini.
 * EsamViews | Copyrights 2018 Esam.ir Crop.
 */
public abstract class EsChipsList extends FrameLayout{

    private RecyclerView mRecyclerChips;

    public abstract EsAdapter getAdapter();

    public EsChipsList(@NonNull Context context) {
        super(context);
        initialize();
    }

    public EsChipsList(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public EsChipsList(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    protected void initialize() {

        View rootView = LayoutInflater.from(getContext()).inflate(R.layout.es_chips_list,
                this, true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, true);

        mRecyclerChips = rootView.findViewById(R.id.recycler_chips);
        mRecyclerChips.setAdapter(getAdapter());
        mRecyclerChips.setHasFixedSize(hasFixedSize());
        mRecyclerChips.setLayoutManager(layoutManager);

    }

    public boolean hasFixedSize() {
        return true;
    }


}
