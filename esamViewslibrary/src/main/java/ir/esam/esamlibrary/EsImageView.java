package ir.esam.esamlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.squareup.picasso.Picasso;

/**
 * Created by hosseinAmini.
 * EsamViews | Copyrights 2018 Esam.ir Crop.
 */
public class EsImageView extends android.support.v7.widget.AppCompatImageView {

    private Drawable mPlaceholder;
    private Drawable mErrorPlaceholder;

    public EsImageView(Context context) {
        super(context);
        initialize();
    }

    public EsImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.EsImageView);

        try {
            mPlaceholder = typedArray.getDrawable(R.styleable.EsImageView_es_placeholder);
            mErrorPlaceholder = typedArray.getDrawable(R.styleable.EsImageView_es_error_placeholder);
        } finally {
            typedArray.recycle();
        }

        initialize();
    }

    public EsImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    private void initialize() {

        setPlaceholder(mPlaceholder);
        setErrorPlaceholder(mErrorPlaceholder);
    }

    private void setPlaceholder(Drawable placeholder) {
        if(placeholder == null) {
            // Todo: set default placeholder into mPlaceholder
        }
        mPlaceholder = placeholder;
    }

    private void setErrorPlaceholder(Drawable errorPlaceholder) {
        if(errorPlaceholder == null) {
            // Todo: set default error placeholder into mErrorPlaceholder
        }
        mErrorPlaceholder = errorPlaceholder;
    }

    public void setImageFormUrl(String url) {
        Picasso.get().load(url).into(this);
      //  Picasso.get().load(url).placeholder(mPlaceholder).centerCrop().error(mErrorPlaceholder).into(this);
    }

    public void setImageFromFile(String uri) {
        Picasso.get().load(uri).placeholder(mPlaceholder).centerCrop().error(mErrorPlaceholder)
                .into(this);
    }

}
