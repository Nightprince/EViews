package ir.esam.esamlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;

import ir.esam.esamlibrary.methodParam.EsFontFace;
import ir.esam.esamlibrary.methodParam.EsTextFormat;
import ir.esam.esamlibrary.utility.FontUtility;
import ir.esam.esamlibrary.utility.TextUtility;

/**
 * Created by hosseinAmini.
 * EsamViews | Copyrights 2018 Esam.ir Crop.
 */
public class EsEditText extends android.support.v7.widget.AppCompatEditText implements TextWatcher {

    private int mFontFace;
    private int mTextFormat;
    private OnTextChangeListener mOnTextChangeListener;

    public EsEditText(Context context) {
        super(context);
        initialize();
    }

    public EsEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.EsEditText);

        try {
            mFontFace = typedArray.getInt(R.styleable.EsEditText_es_fontFace, EsFontFace.IRAN_SANS_LIGHT);
            mTextFormat = typedArray.getInt(R.styleable.EsEditText_es_textFormat, EsTextFormat.NORMAL);
        } finally {
            typedArray.recycle();
        }

        initialize();
    }

    public EsEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    private void initialize() {
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

        if(mTextFormat == EsTextFormat.NORMAL) {
            return;
        }

        if(mTextFormat == EsTextFormat.CURRENCY) {
            setMaxLength(13);
        }

        if(mTextFormat == EsTextFormat.CARD_NUMBER) {
            setMaxLength(19);
        }

        addTextChangedListener(this);
        setRawInputType(InputType.TYPE_CLASS_NUMBER);
    }

    public void setMaxLength(int length) {
        if(mTextFormat == EsTextFormat.CURRENCY && length > 13) {
            return;
        }
        if(mTextFormat == EsTextFormat.CARD_NUMBER && length > 19) {
            return;
        }

        setFilters(new InputFilter[]{new InputFilter.LengthFilter(length)});
    }

    public void setOnTextChangeListener(@NonNull OnTextChangeListener onTextChangeListener) {
        mOnTextChangeListener = onTextChangeListener;
        addTextChangedListener(this);
    }

    // Todo: Maybe need to get raw value of "Card Number"
    public String getRawValue() {

        if(mTextFormat == EsTextFormat.CURRENCY) {
            return String.valueOf(TextUtility.getCurrencyValue(getText().toString()));
        }

        return getText().toString();
    }

    // Start TextWatcher Interface
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void afterTextChanged(Editable editable) {

        removeTextChangedListener(this);

        if (mOnTextChangeListener != null) {
            mOnTextChangeListener.onTextChange(editable.toString());
//            addTextChangedListener(this);
//            return;
        }

        editable.replace(0, editable.length(),
                editable.toString().replaceAll("[^\\d]", ""));

        String currentVal = editable.toString();
        int    length     = editable.length();

        if (currentVal.isEmpty()) {
            addTextChangedListener(this);
            return;
        }

        if (mTextFormat == EsTextFormat.CURRENCY) {

            long currencyVal = TextUtility.getCurrencyValue(currentVal);

            if (currencyVal == 0) {
                editable.replace(0, length, "");
                addTextChangedListener(this);
                return;
            }

            editable.replace(0, length, TextUtility.convertToCurrency(String.valueOf(currencyVal)));

        } else if (mTextFormat == EsTextFormat.CARD_NUMBER) {
            editable.replace(0, editable.length(),
                    TextUtility.convertToPan(editable.toString()));
        }

        addTextChangedListener(this);
    }
    // End TextWatcher Interface

    public interface OnTextChangeListener {
        void onTextChange(String val);
    }

}
