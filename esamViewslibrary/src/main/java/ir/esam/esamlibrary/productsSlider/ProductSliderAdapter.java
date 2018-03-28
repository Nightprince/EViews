package ir.esam.esamlibrary.productsSlider;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import ir.esam.esamlibrary.EsAdapter;
import ir.esam.esamlibrary.EsTextView;
import ir.esam.esamlibrary.R;

/**
 * Created by hosseinAmini.
 * EsamViews | Copyrights 2018 Esam.ir Crop.
 */
public class ProductSliderAdapter extends EsAdapter<ProductSliderAdapter.ViewHolder, ProductSliderItem> {


    @Override
    public void onBindViewHolder(ViewHolder holder, int position, ProductSliderItem dataSet,
                                 int viewType) {
        holder.mTxtTitle.setText(dataSet.getTitle());
    }

    @Override
    public ViewHolder onCreateViewHolder(View rootView, int viewType) {
        return new ViewHolder(rootView);
    }

    @Override
    public int getLayout(int viewType) {
        return R.layout.product_slider_item;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public EsTextView mTxtTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            mTxtTitle = itemView.findViewById(R.id.txt_title);
        }
    }
}
