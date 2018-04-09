package ir.esam.esamlibrary;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by hosseinAmini.
 * EsamViews | Copyrights 2018 Esam.ir Crop.
 */
public class EsNavHeader extends FrameLayout {

    private EsCircleImageView imgLogo;
    private LinearLayout lneLogin, lneUsername;
    private EsTextView txtUsername;

    public EsNavHeader(@NonNull Context context) {
        super(context);
        initialize();
    }

    public EsNavHeader(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public EsNavHeader(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    private void initialize() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.es_nav_header, this, true);

        imgLogo = view.findViewById(R.id.img_logo);
        lneLogin = view.findViewById(R.id.lne_login);
        lneUsername = view.findViewById(R.id.lne_username);
        txtUsername = view.findViewById(R.id.txt_username);
    }

    public void setUserInfo(@NonNull String username, @Nullable String logoUrl) {
        lneLogin.setVisibility(GONE);
        lneUsername.setVisibility(VISIBLE);
        txtUsername.setText(username);
        if(logoUrl != null) {
            imgLogo.setImageFormUrl(logoUrl);
        }
    }



}
