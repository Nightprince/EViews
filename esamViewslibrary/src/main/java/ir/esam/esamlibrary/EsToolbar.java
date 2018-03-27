package ir.esam.esamlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by hosseinAmini.
 * EsamViews | Copyrights 2018 Esam.ir Crop.
 */
public class EsToolbar extends Toolbar implements View.OnClickListener {

    public static final String LEFT_ICON1 = "left_icon_1";
    public static final String LEFT_ICON2 = "left_icon_2";
    public static final String LEFT_ICON3 = "left_icon_3";
    public static final String RIGHT_ICON = "right_icon";

    private EsImageView mImgLeftIcon1, mImgLeftIcon2, mImgLeftIcon3, mImgLogo, mImgRightIcon;

    private Drawable mLeftIcon1, mLeftIcon2, mLeftIcon3, mLogo, mRightIcon;
    private OnItemClickListener mOnItemClickListener;

    public EsToolbar(Context context) {
        super(context);
        initialize();
    }

    public EsToolbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.EsToolbar);

        try {
            mLeftIcon1 = typedArray.getDrawable(R.styleable.EsToolbar_es_left_icon1);
            mLeftIcon2 = typedArray.getDrawable(R.styleable.EsToolbar_es_left_icon2);
            mLeftIcon3 = typedArray.getDrawable(R.styleable.EsToolbar_es_left_icon3);
            mLogo = typedArray.getDrawable(R.styleable.EsToolbar_es_logo);
            mRightIcon = typedArray.getDrawable(R.styleable.EsToolbar_es_right_icon);
        } finally {
            typedArray.recycle();
        }

        initialize();
    }

    public EsToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    private void initialize() {

        View layout = LayoutInflater.from(getContext()).inflate(R.layout.es_toolbar,
                this, true);

        mImgLeftIcon1 = layout.findViewById(R.id.img_left_icon1);
        mImgLeftIcon2 = layout.findViewById(R.id.img_left_icon2);
        mImgLeftIcon3 = layout.findViewById(R.id.img_left_icon3);
        mImgLogo = layout.findViewById(R.id.img_logo);
        mImgRightIcon = layout.findViewById(R.id.img_right_icon);

        setLeftIcon1(mLeftIcon1);
        setLeftIcon2(mLeftIcon2);
        setLeftIcon3(mLeftIcon3);
        setLogo(mLogo);
        setRightIcon(mRightIcon);

        mImgLeftIcon1.setOnClickListener(this);
        mImgLeftIcon2.setOnClickListener(this);
        mImgLeftIcon3.setOnClickListener(this);
        mImgRightIcon.setOnClickListener(this);

        setBackgroundColor(Color.WHITE);
        setContentInsetsAbsolute(0, 0);
    }

    public void setLeftIcon1(Drawable icon) {
        if (icon == null) {
            return;
        }
        mImgLeftIcon1.setVisibility(VISIBLE);
        mImgLeftIcon1.setImageDrawable(icon);
    }

    public void setLeftIcon2(Drawable icon) {
        if (icon == null) {
            return;
        }
        mImgLeftIcon2.setVisibility(VISIBLE);
        mImgLeftIcon2.setImageDrawable(icon);
    }

    public void setLeftIcon3(Drawable icon) {
        if (icon == null) {
            return;
        }
        mImgLeftIcon3.setVisibility(VISIBLE);
        mImgLeftIcon3.setImageDrawable(icon);
    }

    public void setLogo(Drawable logo) {
        if (logo == null) {
            return;
        }
        mImgLogo.setVisibility(VISIBLE);
        mImgLogo.setImageDrawable(logo);
    }

    public void setRightIcon(@NonNull Drawable icon) {
        if (icon == null) {
            return;
        }
        mImgRightIcon.setImageDrawable(icon);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    @Override
    public void onClick(View view) {
        if (mOnItemClickListener == null) {
            return;
        }

        int id = view.getId();
        if (id == R.id.img_left_icon1) {
            mOnItemClickListener.onItemClick(view, LEFT_ICON1);
            return;
        }
        if (id == R.id.img_left_icon2) {
            mOnItemClickListener.onItemClick(view, LEFT_ICON2);
            return;
        }
        if (id == R.id.img_left_icon3) {
            mOnItemClickListener.onItemClick(view, LEFT_ICON3);
            return;
        }

        if (id == R.id.img_right_icon) {
            mOnItemClickListener.onItemClick(view, RIGHT_ICON);
        }

    }

    public interface OnItemClickListener {
        void onItemClick(View view, String item);
    }

}
