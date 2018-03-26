package ir.esam.esamviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ir.esam.esamlibrary.EsTextView;
import ir.esam.esamlibrary.methodParam.EsTextFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EsTextView txtTest = findViewById(R.id.txt_test);

        txtTest.setTextFormat(EsTextFormat.CURRENCY);
        txtTest.setText("1000");
        txtTest.addSuffix("تومان");
    }
}
