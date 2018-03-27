package ir.esam.esamviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import ir.esam.esamlibrary.EsEditText;
import ir.esam.esamlibrary.EsTextView;
import ir.esam.esamlibrary.EsToolbar;
import ir.esam.esamlibrary.EsViewPager;
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
        toolbar();
    }

    private void toolbar() {
        EsToolbar toolbar = findViewById(R.id.test_toolbar);
        toolbar.setOnItemClickListener(new EsToolbar.OnItemClickListener() {
            @Override
            public void onItemClick(View view, String item) {
                Log.d(TAG, "onItemClick: " + item);
            }
        });
    }

    private void slideShow() {
        final EsSlideShow slideShow = findViewById(R.id.slide_show);

        ArrayList<SlideShowItem> items = new ArrayList<>();

        for(int i = 0; i < 4; i++) {
            items.add(new SlideShowItem("http://www.sciencemag.org/sites/default/files/styles/article_main_image_-_1280w__no_aspect_/public/cc_iStock-478639870_16x9.jpg?itok=y1oFCoHB"));
        }

        slideShow.addItems(items.get(0));
        slideShow.addItems(items.get(1));
        slideShow.addItems(items.get(2));
        slideShow.addItems(items.get(3));

        txtTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slideShow.addItems(new SlideShowItem("http://www.sciencemag.org/sites/default/files/styles/article_main_image_-_1280w__no_aspect_/public/cc_iStock-478639870_16x9.jpg?itok=y1oFCoHB"));
            }
        });

        slideShow.setOnItemClickListener(new EsViewPager.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.d(TAG, "Clicked: " + position);
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
