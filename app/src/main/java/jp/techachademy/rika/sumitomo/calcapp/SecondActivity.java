package jp.techachademy.rika.sumitomo.calcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent =getIntent();
        float VALUE = intent.getFloatExtra("value",0);
        float VALUE2 = intent.getFloatExtra("value2",0);

        TextView textView =(TextView)findViewById(R.id.textview);
        textView.setText(String.valueOf(VALUE+VALUE2));


    }
}
