package ir.esam.esamlibrary;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;

import java.util.Arrays;

import ir.esam.esamlibrary.methodParam.EsFontFace;
import ir.esam.esamlibrary.utility.ColorUtility;
import ir.esam.esamlibrary.utility.FontUtility;
import ir.esam.esamlibrary.utility.OsVersionUtility;
import ir.esam.esamlibrary.utility.RippleBackgroundUtility;

/**
 * Created by hosseinAmini.
 * EsamViews | Copyrights 2018 Esam.ir Crop.
 */
public class EsButton extends android.support.v7.widget.AppCompatButton {

    private int mPadding;
    private int mFontFace;
    private int mRippleColor, mFirstColor, mSecondColor, mPressColor;
    private int mCornerRadius;

    public EsButton(Context context) {
        super(context);
        initialize();
    }

    public EsButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.EsButton);

        try {
            this.mPadding = array.getDimensionPixelSize(R.styleable.EsButton_android_padding,
                    20);
            this.mFontFace = array.getInt(R.styleable.EsButton_es_fontFace,
                    EsFontFace.IRAN_SANS_LIGHT);
            this.mRippleColor = array.getColor(R.styleable.EsButton_es_rippleColor,
                    ContextCompat.getColor(context, R.color.es_button_default_ripple_color));
            this.mFirstColor = array.getColor(R.styleable.EsButton_es_firstColor,
                    ContextCompat.getColor(context, R.color.es_button_default_color));
            this.mSecondColor = array.getColor(R.styleable.EsButton_es_secondColor,
                    ContextCompat.getColor(context, R.color.es_button_default_color));
            this.mPressColor = array.getColor(R.styleable.EsButton_es_pressColor, 0);
            this.mCornerRadius = array.getInt(R.styleable.EsButton_es_cornerRadius, 7);
        } finally {
            array.recycle();
        }


        initialize();
    }

    public EsButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initialize();
    }

    private void initialize() {
        setFontFace();

        if (OsVersionUtility.isLollipopOrGreater()) {
            setStateListAnimator(null);
        }
        setPadding(this.mPadding, this.mPadding, this.mPadding, this.mPadding);

        setBackgroundColor();
    }

    private void setBackgroundColor() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setRippleBackground();
            return;
        }

        setBackground();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setRippleBackground() {
        // Todo: Why this line cause error in pre lollipop? :|
//        RippleDrawable rippleDrawable = new RippleBackgroundUtility()
//                .setBackgroundColors(new int[]{this.mFirstColor,
//                        this.mSecondColor == ContextCompat.getColor(getContext(),
//                                R.color.es_button_default_color) ? this.mFirstColor : this.mSecondColor})
//                .setRadius(mCornerRadius)
//                .setRippleColor(mRippleColor)
//                .build();
//        setBackground(rippleDrawable);


        int[] mBackgroundColors = new int[]{this.mFirstColor,
                this.mSecondColor == ContextCompat.getColor(getContext(),
                        R.color.es_button_default_color) ? this.mFirstColor : this.mSecondColor};

        ColorStateList colors = new ColorStateList(new int[][]{new int[]{}},
                new int[]{mRippleColor});

        GradientDrawable defaultBg = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,
                mBackgroundColors);
        defaultBg.setCornerRadius(mCornerRadius);

        float[] outerRadii = new float[8];
        Arrays.fill(outerRadii, mCornerRadius);
        RoundRectShape roundRectShape = new RoundRectShape(outerRadii, null, null);
        ShapeDrawable mask = new ShapeDrawable(roundRectShape);

        setBackground(new RippleDrawable(colors, defaultBg, mask));
    }

    private void setBackground() {
        this.mPressColor = this.mPressColor == 0 ? ColorUtility.darker(this.mFirstColor, .9f) :
                this.mPressColor;
        StateListDrawable stateListDrawable = new StateListDrawable();
        GradientDrawable defaultBg =
                new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,
                        new int[]{this.mFirstColor, this.mSecondColor == ContextCompat.getColor(getContext(),
                                R.color.es_button_default_color) ? this.mFirstColor : this.mSecondColor});
        GradientDrawable pressBg =
                new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,
                        new int[]{this.mPressColor, mPressColor});
        defaultBg.setCornerRadius(this.mCornerRadius);
        pressBg.setCornerRadius(this.mCornerRadius);

        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, pressBg);
        stateListDrawable.addState(new int[]{}, defaultBg);

        setBackground(stateListDrawable);
    }


    /**
     * Set font
     */
    private void setFontFace() {
        String fontFamily = FontUtility.IRANSANS_LIGHT;

        switch (mFontFace) {
            case EsFontFace.IRAN_SANS_ULTRA_LIGHT: {
                fontFamily = FontUtility.IRANSANS_ULTRA_LIGHT;
                break;
            }
            case EsFontFace.IRAN_SANS_MEDIUM: {
                fontFamily = FontUtility.IRANSANS_MEDIUM;
                break;
            }
        }

        setTypeface(FontUtility.getFont(getContext(), fontFamily));
    }


}
