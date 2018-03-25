package ir.esam.esamlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import ir.esam.esamlibrary.methodParam.EsFontFace;
import ir.esam.esamlibrary.utility.FontUtility;

/**
 * Created by hosseinAmini.
 * EsamViews | Copyrights 2018 Esam.ir Crop.
 */
public class EsTextView extends android.support.v7.widget.AppCompatTextView {

    private int mFontFace;
    private int mTextFormat;

    //
    private static final int TEXT_FORMAT_NORMAL = 0;
    private static final int TEXT_FORMAT_CURRENCY = 1;
    private static final int TEXT_FORMAT_CARD_NUMBER = 2;

    public EsTextView(Context context) {
        super(context);

        initialize();
    }

    public EsTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.EsTextView);

        try {
            mFontFace = typedArray.getInt(R.styleable.EsTextView_es_fontFace,
                    EsFontFace.IRAN_SANS_LIGHT);
            mTextFormat = typedArray.getInt(R.styleable.EsTextView_es_textFormat,
                    TEXT_FORMAT_NORMAL);
        } finally {
            typedArray.recycle();
        }

        initialize();
    }

    public EsTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initialize();
    }

    private void initialize() {

        setFontFace(mFontFace);

    }

    public void setFontFace(@EsFontFace.FontFace int fontFace) {

        switch (fontFace) {
            case EsFontFace.ANDROID_DEFAULT_FONT: {
                break;
            } case EsFontFace.IRAN_SANS_ULTRA_LIGHT: {
                setTypeface(FontUtility.getFont(getContext(), FontUtility.IRANSANS_ULTRA_LIGHT));
                break;
            } case EsFontFace.IRAN_SANS_LIGHT: {
                setTypeface(FontUtility.getFont(getContext(), FontUtility.IRANSANS_LIGHT));
                break;
            } case EsFontFace.IRAN_SANS_MEDIUM: {
                setTypeface(FontUtility.getFont(getContext(), FontUtility.IRANSANS_MEDIUM));
                break;
            }
        }


    }


}
