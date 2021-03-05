package com.example.practicasemana04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button btnPing;
    private Button btnBuscar;
    private EditText ip1;
    private EditText ip2;
    private EditText ip3;
    private EditText ip4;
    private String ipFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPing = findViewById(R.id.btnPing);
        btnBuscar = findViewById(R.id.btnBuscar);
        ip1 = findViewById(R.id.ip1);
        ip2 = findViewById(R.id.ip2);
        ip3 = findViewById(R.id.ip3);
        ip4 = findViewById(R.id.ip4);


        btnPing.setOnClickListener(
                (v)-> {



                    String ip1_1 = ip1.getText().toString();
                    String ip1_2 = ip2.getText().toString();
                    String ip1_3 = ip3.getText().toString();
                    String ip1_4 = ip4.getText().toString();

                    String ipFinal = ip1_1+"."+ip1_2+"."+ip1_3+"."+ip1_4;
                    Log.e("-->>>", "ip que introdujo: " + ipFinal);




                    Intent i = new Intent(this, pingActivity.class);

                    i.putExtra("ping",ipFinal);
                    startActivity(i);
                }
        );

        btnBuscar.setOnClickListener(
                (v)->{
                    Intent h = new Intent(this, hostActivity.class);
                    startActivity(h);

                }
        );



    }

}