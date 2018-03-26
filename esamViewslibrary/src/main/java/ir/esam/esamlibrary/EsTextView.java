package ir.esam.esamlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import ir.esam.esamlibrary.methodParam.EsFontFace;
import ir.esam.esamlibrary.methodParam.EsTextFormat;
import ir.esam.esamlibrary.utility.FontUtility;
import ir.esam.esamlibrary.utility.TextUtility;

/**
 * Created by hosseinAmini.
 * EsamViews | Copyrights 2018 Esam.ir Crop.
 */
public class EsTextView extends android.support.v7.widget.AppCompatTextView {

    private boolean mUseTextFormat;
    private int mFontFace;
    private int mTextFormat;

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
                    EsTextFormat.NORMAL);
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
        mUseTextFormat = true;
        setFontFace(mFontFace);
        setTextFormat(mTextFormat);
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

    public void setTextFormat(@EsTextFormat.TextFormat int textFormat) {
        mTextFormat = textFormat;
        setText(getRawValue());
    }

    public void addPrefix(String prefix) {
        String result = String.format("%s %s", getText().toString(), prefix);
        mUseTextFormat = false;
        setText(result);
    }

    public void addSuffix(String suffix) {
        String result = String.format("%s %s", suffix, getText().toString());
        mUseTextFormat = false;
        setText(result);
    }

    // Todo: Maybe need to get raw value of "Card Number"
    public String getRawValue() {

        if(mTextFormat == EsTextFormat.CURRENCY) {
            return String.valueOf(TextUtility.getCurrencyValue(getText().toString()));
        }

        return getText().toString();
    }

    // override setText for formatting text
    @Override
    public void setText(CharSequence text, BufferType type) {
        if (mUseTextFormat) {
            if (mTextFormat == EsTextFormat.CURRENCY) {
                text = TextUtility.convertToCurrency(text.toString());
            } else if (mTextFormat == EsTextFormat.CARD_NUMBER) {
                text = TextUtility.convertToPan(text.toString());
            }
        }

        mUseTextFormat = true;
        super.setText(text, type);
    }
}
