package ir.esam.esamlibrary.productsSlider;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import ir.esam.esamlibrary.EsAdapter;
import ir.esam.esamlibrary.EsImageView;
import ir.esam.esamlibrary.EsTextView;
import ir.esam.esamlibrary.R;

/**
 * Created by hosseinAmini.
 * EsamViews | Copyrights 2018 Esam.ir Crop.
 */
public class ProductSliderAdapter extends EsAdapter<ProductSliderAdapter.ViewHolder, ProductSliderItem> {

    private OnItemClickListener mOnItemClickListener;

    @Override
    public void onBindViewHolder(ViewHolder holder, int position, ProductSliderItem dataSet,
                                 int viewType) {
        holder.mTxtTitle.setText(dataSet.getTitle());
        holder.mTxtPrice.setText(dataSet.getPrice());
        holder.mTxtPrice.addPrefix("تومان");
        holder.mImgProduct.setImageFormUrl(dataSet.getImageUrl());
    }

    @Override
    public ViewHolder onCreateViewHolder(View rootView, int viewType) {
        return new ViewHolder(rootView);
    }

    @Override
    public int getLayout(int viewType) {
        return R.layout.product_slider_item;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

         EsTextView mTxtTitle, mTxtPrice;
         EsImageView mImgProduct;

         ViewHolder(View itemView) {
            super(itemView);
            mTxtTitle = itemView.findViewById(R.id.txt_title);
            mTxtPrice = itemView.findViewById(R.id.txt_price);
            mImgProduct = itemView.findViewById(R.id.img_product);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(mOnItemClickListener != null) {
                int position = getLayoutPosition();
                mOnItemClickListener.onClick(getDataSets().get(position), position);
            }
        }
    }

    public interface OnItemClickListener {
        void onClick(ProductSliderItem item, int position);
    }
}
