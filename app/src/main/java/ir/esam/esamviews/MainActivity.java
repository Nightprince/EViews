package ir.esam.esamviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import ir.esam.esamlibrary.EsEditText;
import ir.esam.esamlibrary.EsTextView;
import ir.esam.esamlibrary.methodParam.EsTextFormat;
import ir.esam.esamlibrary.slideShow.EsSlideShow;
import ir.esam.esamlibrary.slideShow.SlideShowItem;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    EsTextView txtTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView();
        editText();
        slideShow();
    }

    private void slideShow() {
        final EsSlideShow slideShow = findViewById(R.id.slide_show);

        ArrayList<SlideShowItem> items = new ArrayList<>();

        for(int i = 0; i < 4; i++) {
            items.add(new SlideShowItem("adsfsdf"));
        }

        slideShow.addItems(items.get(0));
        slideShow.addItems(items.get(1));
        slideShow.addItems(items.get(2));
        slideShow.addItems(items.get(3));

        txtTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slideShow.addItems(new SlideShowItem("alsdjfldfjldsf"));
                Log.d(TAG, "onClick: ");
            }
        });

    }

    private void textView() {
        txtTest = findViewById(R.id.txt_test);

        txtTest.setTextFormat(EsTextFormat.CURRENCY);
        txtTest.setText("1000");
        txtTest.addSuffix("تومان");
    }

    private void editText() {
        EsEditText edtTest = findViewById(R.id.edt_test);
        edtTest.setOnTextChangeListener(new EsEditText.OnTextChangeListener() {
            @Override
            public void onTextChange(String val) {
                Log.d(TAG, val);
            }
        });


    }
}
