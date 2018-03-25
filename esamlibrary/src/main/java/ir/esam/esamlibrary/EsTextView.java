package ir.esam.esamlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by hosseinAmini.
 * EsamViews | Copyrights 2018 Esam.ir Crop.
 */
public class EsTextView extends android.support.v7.widget.AppCompatTextView {

    private int mFontFace;
    private int mTextFormat;

    //
    private static final int FONT_FACE_ANDROID_DEFAULT_FONT = 0;
    private static final int FONT_FACE_IRAN_SANS_LIGHT = 1;
    private static final int FONT_FACE_IRAN_SANS_ULTRA_LIGHT = 2;
    private static final int FONT_FACE_IRAN_SANS_NORMAL = 3;

    //
    private static final int TEXT_FORMAT_NORMAL = 0;
    private static final int TEXT_FORMAT_CURRENCY = 1;
    private static final int TEXT_FORMAT_CARD_NUMBER = 2;

    public EsTextView(Context context) {
        super(context);
    }

    public EsTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.EsTextView);

        try {
            mFontFace = typedArray.getInt(R.styleable.EsTextView_es_fontFace,
                    FONT_FACE_IRAN_SANS_NORMAL);
            mTextFormat = typedArray.getInt(R.styleable.EsTextView_es_textFormat,
                    TEXT_FORMAT_NORMAL);
        } finally {
            typedArray.recycle();
        }

    }

    public EsTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
