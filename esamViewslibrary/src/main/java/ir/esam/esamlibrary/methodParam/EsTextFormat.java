package ir.esam.esamlibrary.methodParam;

import android.support.annotation.IntDef;

/**
 * Created by hosseinAmini.
 * EsamViews | Copyrights 2018 Esam.ir Crop.
 */
public class EsTextFormat {

    public static final int NORMAL = 0;
    public static final int CURRENCY = 1;
    public static final int CARD_NUMBER = 2;

    @IntDef({NORMAL, CURRENCY, CARD_NUMBER})
    public @interface TextFormat {}

}
