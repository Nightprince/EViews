package ir.esam.esamlibrary;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;

import ir.esam.esamlibrary.productsSlider.ProductSliderAdapter;

/**
 * Created by hosseinAmini.
 * EsamViews | Copyrights 2018 Esam.ir Crop.
 */
public abstract class EsAdapter<Holder extends RecyclerView.ViewHolder, DataSetType>
        extends RecyclerView.Adapter<Holder> {

    private ArrayList<DataSetType> mDataSets;

    public abstract void onBindViewHolder(Holder holder, int position, DataSetType dataSet, int viewType);
    public abstract Holder onCreateViewHolder(View rootView, int viewType);
    public abstract int getLayout(int viewType);

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        onBindViewHolder(holder, position, mDataSets.get(position), getItemViewType(position));
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(getLayout(viewType),
                parent, false);
        return onCreateViewHolder(rootView, viewType);
    }

    @Override
    public int getItemCount() {
        return mDataSets != null ? mDataSets.size() : 0;
    }

    public void swapData(DataSetType... dataSets) {
        mDataSets = new ArrayList<>(Arrays.asList(dataSets));
        notifyDataSetChanged();
    }

    public void swapData(ArrayList<DataSetType> dataSets) {
        mDataSets = dataSets;
        notifyDataSetChanged();
    }

    public void addData(DataSetType dataSet) {
        if(mDataSets == null) {
            mDataSets = new ArrayList<>();
        }

        addData(mDataSets.size(), dataSet);
    }

    public void addData(int index, DataSetType dataSet) {
        if(mDataSets == null) {
            mDataSets = new ArrayList<>();
        }

        mDataSets.add(index, dataSet);
        notifyDataSetChanged();
    }

    public void removeData(int index) {
        mDataSets.remove(index);
    }

    public void removeData(DataSetType dataSet) {
        mDataSets.remove(dataSet);
    }

}
