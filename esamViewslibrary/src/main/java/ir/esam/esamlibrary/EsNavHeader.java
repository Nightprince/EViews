package ir.esam.esamlibrary;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
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
    private EsImageView imgArrow;

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
        imgArrow = view.findViewById(R.id.img_arrow);

        lneUsername.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAGGGGGG", "onClick: " + imgArrow.getRotation());



                RotateAnimation rotate = new RotateAnimation(0,
                         180f,
                        Animation.RELATIVE_TO_SELF, .5f,
                        Animation.RELATIVE_TO_SELF, .5f);
                rotate.setDuration(500);
                rotate.setRepeatCount(0);
                imgArrow.startAnimation(rotate);
                rotate.setFillAfter(true);
                rotate.setFillEnabled(true);
                rotate.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        imgArrow.setRotation(180);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

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
