package ir.esam.esamlibrary.utility;

import android.os.Build;

/**
 * Created by hosseinAmini.
 * EsamViews | Copyrights 2018 Esam.ir Crop.
 */
public class OsVersionUtility {

    public static boolean isLollipopOrGreater() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }

    public static boolean isMarshmallowOrGreater() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }

}
