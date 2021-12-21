package com.example.pabo4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity {

    double originLat = -7.937679;
    double originLong = 110.4018026;
    double destApotekLat = -7.738080;
    double destApotekLong = 110.4234561;
    double destPenerimaLat = -7.838080;
    double destPenerimaLong = 110.6234561;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        /*
        Penjemputan
        */
        Button btnCheckJemput = (Button) findViewById(R.id.btnCheckJemput);
        TextView tvJemput = (TextView) findViewById(R.id.tvJemput);
        EditText edJemput = (EditText) findViewById(R.id.edJemput);
        CheckBox cbJemput = (CheckBox) findViewById(R.id.cbJemput);
        Button btnJemput = (Button) findViewById(R.id.btnJemput);

        /*
        Pengantaran
        */
        Button btnCheckAntar = (Button) findViewById(R.id.btnCheckAntar);
        TextView tvAntar = (TextView) findViewById(R.id.tvAntar);
        EditText edAntar = (EditText) findViewById(R.id.edAntar);
        CheckBox cbAntar = (CheckBox) findViewById(R.id.cbAntar);
        Button btnAntar = (Button) findViewById(R.id.btnAntar);

        btnCheckJemput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MapsActivity.class);
                intent.putExtra("asalLat", originLat);
                intent.putExtra("asalLong", originLong);
                intent.putExtra("tujuanLat", destApotekLat);
                intent.putExtra("tujuanLong", destApotekLong);
                view.getContext().startActivity(intent);
            }
        });

        cbJemput.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(edJemput.length()>0 && cbJemput.isChecked()){
                    btnJemput.setEnabled(true);
                }else{
                    btnJemput.setEnabled(false);
                }
            }
        });

        btnJemput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edJemput.length()>0 && cbJemput.isChecked()){
                    tvJemput.setText("Sudah Dijemput");
                    tvAntar.setText("Sedang Diantar");
                    edAntar.setEnabled(true);
                    cbAntar.setEnabled(true);
                    btnCheckAntar.setEnabled(true);
                }else{
                    tvJemput.setText("Sedang Dijemput");
                    tvAntar.setText("Belum Diantar");
                    edAntar.setEnabled(false);
                    cbAntar.setEnabled(false);
                    cbAntar.setChecked(false);
                    btnCheckAntar.setEnabled(false);
                }
            }
        });

        btnCheckAntar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), MapsActivity.class);
                i.putExtra("asalLat", destApotekLat);
                i.putExtra("asalLong", destApotekLong);
                i.putExtra("tujuanLat", destPenerimaLat);
                i.putExtra("tujuanLong", destPenerimaLong);
                view.getContext().startActivity(i);
            }
        });

        cbAntar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(edAntar.length()>0 && cbAntar.isChecked()){
                    btnAntar.setEnabled(true);
                }else{
                    btnAntar.setEnabled(false);
                }
            }
        });
        btnAntar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edAntar.length()>0 && cbAntar.isChecked()){
                    tvAntar.setText("Sudah Diantar");
                }
            }
        });

    }
}