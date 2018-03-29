package ir.esam.esamlibrary.chipsList;

import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import ir.esam.esamlibrary.EsAdapter;

/**
 * Created by hosseinAmini.
 * EsamViews | Copyrights 2018 Esam.ir Crop.
 */
public class ChipsListAdapter<Holder extends RecyclerView.ViewHolder> extends
        EsAdapter<Holder, ChipsListItem> {

    private int mLayout;

    @Override
    public void onBindViewHolder(Holder holder, int position, ChipsListItem dataSet, int viewType) {

    }

    @Override
    public Holder onCreateViewHolder(View rootView, int viewType) {
        return null;
    }

    public void setLayout(@IdRes int layout) {
        mLayout = layout;
    }

    @Override
    public int getLayout(int viewType) {
        return mLayout;
    }
}
