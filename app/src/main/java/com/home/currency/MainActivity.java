package com.home.currency;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView jp, us;
    private Button btnCal;
    private double usRate = 30.9, jpRate = 0.26;
    private EditText ntd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        us.setText(String.valueOf(usRate));
        jp.setText(String.valueOf(jpRate));

        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double NTDIn = Double.parseDouble(ntd.getText().toString().trim());
                if (NTDIn.equals("")){
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle(R.string.problem)
                            .setMessage(R.string.please_enter_ntd)
                            .setPositiveButton("OK",null)
                            .show();
                }else {
                    String usResult = String.format("%.4f",(NTDIn / usRate));
                    String jpResult = String.format("%.4f",(NTDIn / jpRate));
//                    double usResult = NTDIn / usRate;
//                    double jpResult = NTDIn / jpRate;
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle(R.string.result)
                            .setMessage(getString(R.string.usd_is)+usResult +"\n" + getString(R.string.jp_is) + jpResult)
                            .setPositiveButton(R.string.ok,null)
                            .show();
                }
            }
        });

    }

    private void findViews() {
        jp = findViewById(R.id.jp);
        us = findViewById(R.id.us);
        ntd = findViewById(R.id.ntd);
        btnCal = findViewById(R.id.btnCal);
    }
}
