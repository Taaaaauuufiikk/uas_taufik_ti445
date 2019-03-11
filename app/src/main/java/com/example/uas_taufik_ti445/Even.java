package com.example.uas_taufik_ti445;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;


@Entity
public class Even {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "nama lengkap")
    private String nama;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "even")
    private String even;

    @Ignore
    public Even(String nama, String email, String even) {
        this.nama = nama;
        this.email = email;
        this.even = even;
    }

    public Even(int id, String nama, String email) {
        this.id = id;
        this.nama = nama;
        this.email = email;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEven() {
        return even;
    }

    public void setEven(String even) {
        this.even = even;
    }
}
