package ir.esam.esamlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by hosseinAmini.
 * EsamViews | Copyrights 2018 Esam.ir Crop.
 */
public class EsCircleImageView extends CircleImageView {

    private Drawable mPlaceholder;
    private Drawable mErrorPlaceholder;

    public EsCircleImageView(Context context) {
        super(context);
        initialize();
    }

    public EsCircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.EsCircleImageView);

        try {
            mPlaceholder = typedArray.getDrawable(R.styleable.EsCircleImageView_es_placeholder);
            mErrorPlaceholder = typedArray.getDrawable(R.styleable.EsCircleImageView_es_error_placeholder);
        } finally {
            typedArray.recycle();
        }


        initialize();
    }

    public EsCircleImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
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
        //  Picasso.get().load(url).placeholder(mPlaceholder).error(mErrorPlaceholder).into(this);
    }

    public void setImageFromFile(String uri) {
        Picasso.get().load(uri).into(this);
//        Picasso.get().load(uri).placeholder(mPlaceholder).error(mErrorPlaceholder).into(this);
    }

}
