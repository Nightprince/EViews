package ir.esam.esamlibrary.utility;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;

import java.util.Arrays;

import ir.esam.esamlibrary.R;

/**
 * Created by hosseinAmini.
 * EsamViews | Copyrights 2018 Esam.ir Crop.
 */
public class RippleBackgroundUtility {

    private Context mContext;
    private int mRippleColor;
    private int[] mBackgroundColors;
    private int mRadius;

    public RippleBackgroundUtility(Context context) {
        mContext = context;
    }

    public RippleBackgroundUtility setRippleColor(@ColorRes int rippleColor) {
        mRippleColor = rippleColor;
        return this;
    }

    public RippleBackgroundUtility setBackgroundColors(@NonNull int... backgroundColors) {
        mBackgroundColors = backgroundColors;
        return this;
    }

    public RippleBackgroundUtility setRadius(int radius) {
        mRadius = radius;
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RippleDrawable build() {

        if(mRippleColor == 0) {
            mRippleColor = R.color.es_button_default_ripple_color;
        }

        if(mBackgroundColors == null) {
            mBackgroundColors = new int[1];
            mBackgroundColors[0] = R.color.es_button_default_color;
        }

        if(mRadius == 0) {
            mRadius = 7;
        }

        ColorStateList colors = new ColorStateList(new int[][]{new int[]{}},
                new int[]{mRippleColor});

        GradientDrawable defaultBg = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,
                mBackgroundColors);
        defaultBg.setCornerRadius(mRadius);

        float[] outerRadii = new float[8];
        Arrays.fill(outerRadii, mRadius);
        RoundRectShape roundRectShape = new RoundRectShape(outerRadii, null, null);
        ShapeDrawable mask = new ShapeDrawable(roundRectShape);

        return new RippleDrawable(colors, defaultBg, mask);
    }
}
