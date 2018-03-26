package ir.esam.esamviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import ir.esam.esamlibrary.EsEditText;
import ir.esam.esamlibrary.EsTextView;
import ir.esam.esamlibrary.methodParam.EsTextFormat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView();
        editText();

    }

    private void textView() {
        EsTextView txtTest = findViewById(R.id.txt_test);

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
