package ir.esam.esamlibrary.productsSlider;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;

import ir.esam.esamlibrary.EsButton;
import ir.esam.esamlibrary.EsTextView;
import ir.esam.esamlibrary.R;
import ir.esam.esamlibrary.utility.RecyclerViewEqualSpace;

/**
 * Created by hosseinAmini.
 * EsamViews | Copyrights 2018 Esam.ir Crop.
 */
public class EsProductsSlider extends FrameLayout {

    private String mTitle;
    private EsButton mBtnMore;
    private EsTextView mTxtTitle;
    private RecyclerView mRecyclerProducts;
    private ProductSliderAdapter mAdapter;

    private OnClickListener mOnMoreClickListener;

    public EsProductsSlider(@NonNull Context context) {
        super(context);
        initialize();
    }

    public EsProductsSlider(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.EsProductsSlider);

        try {
            mTitle = typedArray.getString(R.styleable.EsProductsSlider_es_title);
        } finally {
            typedArray.recycle();
        }

        initialize();
    }

    public EsProductsSlider(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    private void initialize() {

        View rootView = LayoutInflater.from(getContext()).inflate(R.layout.es_product_slider,
                this, true);

        mBtnMore = rootView.findViewById(R.id.btn_more);
        mTxtTitle = rootView.findViewById(R.id.txt_title);
        mRecyclerProducts = rootView.findViewById(R.id.recycler_products);

        mAdapter = new ProductSliderAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, true);

        mRecyclerProducts.setAdapter(mAdapter);
        mRecyclerProducts.setHasFixedSize(true);
        mRecyclerProducts.addItemDecoration(new RecyclerViewEqualSpace(20));
        mRecyclerProducts.setLayoutManager(layoutManager);

        mBtnMore.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mOnMoreClickListener != null) {
                    mOnMoreClickListener.onClick(view);
                }
            }
        });

        setTitle(mTitle);
    }

    public void setTitle(@NonNull String title) {
        mTitle = title;
        mTxtTitle.setText(mTitle);
    }

    public void setOnItemClickListener(ProductSliderAdapter.OnItemClickListener onItemClickListener) {
        mAdapter.setOnItemClickListener(onItemClickListener);
    }

    public void setOnMoreClickListener(OnClickListener onMoreClickListener) {
        mOnMoreClickListener = onMoreClickListener;
    }

    public void swapData(ProductSliderItem... products) {
        mAdapter.swapData(products);
    }

    public void swapData(ArrayList<ProductSliderItem> products) {
        mAdapter.swapData(products);
    }

    public ProductSliderAdapter getAdapter() {
        return mAdapter;
    }

}
