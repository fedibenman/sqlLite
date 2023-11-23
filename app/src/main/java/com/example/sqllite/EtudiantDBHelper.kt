package com.example.sqllite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.sqllite.EtudiantBC.EtudiantEntry




class EtudiantDBHelper(context:Context) :SQLiteOpenHelper(context , DATABASE_NAME , null , DATABASE_VERSION) {
    val db  = writableDatabase

    override fun onCreate(p0: SQLiteDatabase?) {
        Log.i("refrence" ,SQL_CREATE_ENTRIES)
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
       onUpgrade(db , oldVersion ,newVersion)

    }




    companion object {
        private const val TEXT_TYPE = " TEXT"
        private const val INT_TYPE = " INTEGER"
        private const val COMMA_SEP = ","
        const val DATABASE_NAME = "your_database.db"
        const val DATABASE_VERSION = 1
        const val SQL_CREATE_ENTRIES :String =
            "CREATE TABLE " + EtudiantBC.EtudiantEntry.TABLE_NAME + "(" +
                    EtudiantBC.EtudiantEntry.COLUMN_NAME_NOM + TEXT_TYPE + " PRIMARY KEY ," +
                    EtudiantBC.EtudiantEntry.COLUMN_NAME_EMAIL + TEXT_TYPE +" , "+
                    EtudiantBC.EtudiantEntry.COLUMN_NAME_LOGIN + TEXT_TYPE +" , "+
                    EtudiantBC.EtudiantEntry.COLUMN_NAME_MDP + TEXT_TYPE +" , "+
                    EtudiantBC.EtudiantEntry.COLUMN_NAME_PHONE + INT_TYPE +" , "+
                    EtudiantBC.EtudiantEntry.COLUMN_NAME_PRENOM + TEXT_TYPE + " )";
        const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + EtudiantEntry.TABLE_NAME
    }
    }