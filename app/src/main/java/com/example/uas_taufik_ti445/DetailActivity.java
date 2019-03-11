package com.example.uas_taufik_ti445;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    MyDatabase db;
    String nama, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        final EditText et_nama = (EditText) findViewById(R.id.det_et_nama);
        final EditText et_email = (EditText) findViewById(R.id.det_et_email);
        final Button bt_ubah = (Button) findViewById(R.id.det_bt_ubah);
        final Button bt_hapus = (Button) findViewById(R.id.det_bt_hapus);

        //tangkap bundle
        Bundle bundle = null;
        bundle = this.getIntent().getExtras();

        //letakkan isi bundle
        final int id = bundle.getInt("b_id", 0);
        et_nama.setText(bundle.getString("b_nama"));
        et_email.setText(bundle.getString("b_kelas"));

        getSupportActionBar().setTitle("Data Peserta"); // for set actionbar title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // for add back arrow in action back

        bt_ubah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nama =  et_nama.getText().toString();
                email =  et_email.getText().toString();

                MainActivity.db.evenDAO().update(new Even(id, nama, email));
                Toast.makeText(getApplicationContext(), "Data " + et_nama.getText().toString() + " berhasil diubah", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        bt_hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nama =  et_nama.getText().toString();
                email =  et_email.getText().toString();

                MainActivity.db.evenDAO().delete(new Even(id, nama, email));
                Toast.makeText(getApplicationContext(), "Data " + et_nama.getText().toString() + " dihapus", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
