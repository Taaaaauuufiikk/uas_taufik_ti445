package com.example.uas_taufik_ti445;

import android.arch.persistence.room.Room;
import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder dialog;
    LayoutInflater inflater;

    EditText isi_nama, isi_email;
    Spinner evens;

    static MyDatabase db;

//    List<Siswa> siswas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        db = Room.databaseBuilder(getApplicationContext(),
                MyDatabase.class,
                "db-even")
                .allowMainThreadQueries()
                .build();

        viewRecyclerView(null);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new AlertDialog.Builder(MainActivity.this);

                inflater = getLayoutInflater();
                view = inflater.inflate(R.layout.form_regis, null);

                final View diagView = view;

                dialog.setView(view);
                dialog.setCancelable(true);
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setTitle("Form Biodata");

                isi_nama = (EditText) view.findViewById(R.id.et_nama);
                evens = (Spinner) view.findViewById(R.id.tv_even);


                dialog.setPositiveButton("SIMPAN", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        final String nama, email;

                        nama = isi_nama.getText().toString();
                        email = evens.getSelectedItem().toString();

                        //simpan data
//                        db.evenDAO().insertAll(new Even(nama, email));

                        viewRecyclerView(null);
                    }
                });

                dialog.setNegativeButton("BATAL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });




//        bt_refresh.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewRecyclerView(null);
//            }
//        });
    }

//    private void defineData()
//    {
//        for (int i = 1; i < 5; i++) {
//            siswaArrayList.add(new Siswa("Nama - "+ i, "Kelas - "+ i));
//        }
//    }


    @Override
    protected void onResume() {
        super.onResume();

        viewRecyclerView(null);
    }

    public void viewRecyclerView(String cari) {
        //definisi
        RecyclerView rv = (RecyclerView)findViewById(R.id.rv_container);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);

//        if (cari == null || cari.isEmpty()){
//            evens = db.evenDAO().getAll();
//        }else{
//            evens = db.evenDAO().findByName(cari);
//        }

        RvAdapter rvAdapter = new RvAdapter(this);
        rvAdapter.setListEven((List) evens); //ambil nilai array dari main activity
        rv.setAdapter(rvAdapter);
    }

}