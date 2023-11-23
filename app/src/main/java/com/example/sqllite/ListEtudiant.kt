package com.example.sqllite


import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import androidx.appcompat.app.AppCompatActivity


var dbHelper: EtudiantDBHelper? = null
var adapter: SimpleCursorAdapter? = null





class ListEtudiant : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_etudiant)
        var listEtudiant = findViewById<View>(R.id.idlistetu) as ListView
        listEtudiant.setAdapter(getAdapter())
    }


    fun getDbHelper(): EtudiantDBHelper? {
        if (dbHelper == null) {
            dbHelper = EtudiantDBHelper(this)
        }
        return dbHelper
    }

    fun getAdapter() : SimpleCursorAdapter {
        if (adapter==null) {
            val db:SQLiteDatabase  = getDbHelper()!!.readableDatabase;
            val c:Cursor  = db.rawQuery("SELECT * FROM " + EtudiantBC.EtudiantEntry.TABLE_NAME, null) ;

             adapter = SimpleCursorAdapter(this,R.layout.ligne_etudiant, c, arrayOf(EtudiantBC.EtudiantEntry.COLUMN_NAME_NOM, EtudiantBC.EtudiantEntry.COLUMN_NAME_PRENOM), intArrayOf(R.id.nometud, R.id.preetud), 0)

      }
        return adapter as SimpleCursorAdapter;
    }

}