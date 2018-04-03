package ir.esam.esamlibrary.chipsList.categoryChipsList;

import android.graphics.drawable.Drawable;

import ir.esam.esamlibrary.chipsList.ChipsListItem;

/**
 * Created by hosseinAmini.
 * EsamViews | Copyrights 2018 Esam.ir Crop.
 */
public class CategoryChipsListItem extends ChipsListItem {

    private Drawable image;

    public void setImage(Drawable image) {
        this.image = image;
    }

    public Drawable getImage() {
        return image;
    }
}
