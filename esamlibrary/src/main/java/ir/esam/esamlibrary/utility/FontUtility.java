package ir.esam.esamlibrary.utility;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Android Views Project at ZarinPal
 * Created by hosseinAmini on 12/17/17.
 * Copyright Hossein Amini All Rights Reserved.
 */

public class FontUtility {

    public static final String IRANSANS_ULTRA_LIGHT = "iranSansUltraLight.ttf";
    public static final String IRANSANS_LIGHT  = "iranSansLight.ttf";
    public static final String IRANSANS_MEDIUM   = "iranSansMedium.ttf";

    public static Typeface getFont(Context context, String font) {
        return Typeface.createFromAsset(context.getAssets(), font);
    }


}
