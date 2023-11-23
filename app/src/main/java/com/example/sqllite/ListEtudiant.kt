package com.example.sqllite

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.SimpleCursorAdapter
import androidx.appcompat.app.AppCompatActivity

var dbHelper: EtudiantDBHelper? = null
val adapter: SimpleCursorAdapter? = null





class ListEtudiant : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_etudiant)

    }


    fun getDbHelper(): EtudiantDBHelper? {
        if (dbHelper == null) {
            dbHelper = EtudiantDBHelper(this)
        }
        return dbHelper
    }

//    fun getAdapter() : SimpleCursorAdapter {
//        if (adapter==null) {
//            val db:SQLiteDatabase  = getDbHelper().readableDatabase;
//            val c:Cursor  = db.rawQuery( "", null);

//            adapter = SimpleCursorAdapter(this,R.layout.ligne_etudiant,c,new String[]
//            {EtudiantBC.EtudiantEntry.COLUMN_NAME_NOM,EtudiantBC.EtudiantEntry.COLUMN_NAME_PRENOM },new int[]{R.id.nometud, R.id.preetud},0);


    //  }
//        return adapter;
//    }

}