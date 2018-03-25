package ir.esam.esamlibrary.methodParam;

import android.support.annotation.IntDef;

/**
 * Created by hosseinAmini.
 * EsamViews | Copyrights 2018 Esam.ir Crop.
 */
public class EsFontFace {
    public static final int ANDROID_DEFAULT_FONT = 0;
    public static final int IRAN_SANS_ULTRA_LIGHT = 1;
    public static final int IRAN_SANS_LIGHT = 2;
    public static final int IRAN_SANS_MEDIUM = 3;

    @IntDef({ANDROID_DEFAULT_FONT, IRAN_SANS_LIGHT, IRAN_SANS_ULTRA_LIGHT, IRAN_SANS_MEDIUM})
    public @interface FontFace{}

}
