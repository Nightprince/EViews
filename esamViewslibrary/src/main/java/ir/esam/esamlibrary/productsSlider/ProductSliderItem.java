package ir.esam.esamlibrary.productsSlider;

/**
 * Created by hosseinAmini.
 * EsamViews | Copyrights 2018 Esam.ir Crop.
 */
public class ProductSliderItem {
    //Todo: This model class must populate from json by GSON
    //Todo: This class properties must change and complete later

    private int mId;
    private String mImageUrl;
    private String mTitle;
    private String mPrice;

    public void setId(int id) {
        mId = id;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public void setPrice(String price) {
        mPrice = price;
    }

    public int getmId() {
        return mId;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getmPrice() {
        return mPrice;
    }
}
