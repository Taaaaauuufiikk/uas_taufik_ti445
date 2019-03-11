package com.example.uas_taufik_ti445;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface EvenDAO {
    @Query("SELECT * FROM even")
    List<Even> getAll();

    @Query("SELECT * FROM even WHERE `nama lengkap` LIKE :nama")
    List<Even> findByName(String nama);

    @Insert
    void insertAll(Even siswa); //tanpa id (karena id otomatis)

    @Update
    void update(Even siswa); //dengan id

    @Delete
    void delete(Even siswa); //dengan id
}
