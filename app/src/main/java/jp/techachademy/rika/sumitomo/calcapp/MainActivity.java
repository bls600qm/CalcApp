package jp.techachademy.rika.sumitomo.calcapp;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.content.Intent;
import android.util.Log;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    EditText mEditText ;
    EditText mEditText2 ;

    float answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.tasu);
        button.setOnClickListener(this);
        Button button2 = (Button)findViewById(R.id.hiku);
        button2.setOnClickListener(this);
        Button button3 = (Button)findViewById(R.id.kakeru);
        button3.setOnClickListener(this);
        Button button4 = (Button)findViewById(R.id.waru);
        button4.setOnClickListener(this);


        mEditText = (EditText)findViewById(R.id.editText);
        mEditText2 = (EditText)findViewById(R.id.editText2);
    }

    @Override
    public void onClick(View v) {

        try {
            String text = mEditText.getText().toString();
            String text2 = mEditText2.getText().toString();

            float value = Float.parseFloat(text);
            float value2 = Float.parseFloat(text2);

            if (v.getId() == R.id.tasu) {
                answer = value + value2;
            } else if (v.getId() == R.id.hiku) {
                answer = value - value2;
            } else if (v.getId() == R.id.kakeru) {
                answer = value * value2;
            } else {
                answer = value / value2;
            }
            Log.d("UI_PARTS", String.valueOf(answer));


            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("watasu", answer);
            startActivity(intent);
        } catch (NullPointerException ex) {
            String text = "0";
            String text2 = "0";
            showAlertDialog();
        }

}
    private void showAlertDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("エラー");
        alertDialogBuilder.setMessage("数値を入力してください");

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
