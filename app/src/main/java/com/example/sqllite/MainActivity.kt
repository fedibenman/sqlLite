package com.example.sqllite

import android.app.AlertDialog
import android.content.ContentValues
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


lateinit var valide_btn:Button ;
lateinit var annulerbtn :Button ;
lateinit var nom : EditText ;
lateinit var prenom :EditText;
lateinit var tel:EditText ;
lateinit var email: EditText ;
lateinit var  login: EditText ;
lateinit var mod_de_pass:EditText;
lateinit var dbhelper : EtudiantDBHelper
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       dbhelper = EtudiantDBHelper(applicationContext)
        valide_btn = findViewById(R.id.btnValider)
        annulerbtn = findViewById(R.id.btnAnnule)

        valide_btn.setOnClickListener {
            nom = findViewById(R.id.Nom);
            prenom = findViewById(R.id.Prenom);
            tel = findViewById(R.id.Phone) ;
             email = findViewById(R.id.Email);
           login = findViewById(R.id.Login) ;
             mod_de_pass = findViewById(R.id.Mdp);

if (!nom.text.isEmpty()  && !prenom.text.isBlank() && !tel.text.isBlank() && !email.text.isBlank() &&  !login.text.isBlank() && !mod_de_pass.text.isBlank() )
{
    Log.i("yes" , "here we go ")
val values:ContentValues = ContentValues() ;
    values.put(EtudiantBC.EtudiantEntry.COLUMN_NAME_NOM,
        nom.text.toString());

    values.put(EtudiantBC.EtudiantEntry.COLUMN_NAME_EMAIL , email.text.toString())
    values.put(EtudiantBC.EtudiantEntry.COLUMN_NAME_LOGIN , login.text.toString())
    values.put(EtudiantBC.EtudiantEntry.COLUMN_NAME_MDP, mod_de_pass.text.toString())
    values.put(EtudiantBC.EtudiantEntry.COLUMN_NAME_PHONE, tel.text.toString())
    values.put(EtudiantBC.EtudiantEntry.COLUMN_NAME_PRENOM, prenom.text.toString())
    val mDbHelper = EtudiantDBHelper(applicationContext)
    val db = mDbHelper.writableDatabase
    var newRowId: Long
    newRowId = db.insert(EtudiantBC.EtudiantEntry.TABLE_NAME , null , values)
    val intent = Intent(this, ListEtudiant::class.java)
    startActivity(intent)
}
            else {
    Log.i("yes" , "here we don't go" ) ;

    val builder = AlertDialog.Builder(this)
    builder.setTitle("Attention")
    builder.setMessage("Tous les champs doivent etre remplis")
    builder.setPositiveButton("OK") { dialogin: DialogInterface, i: Int ->
        kotlin.run {
            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("Attention")
            builder2.setMessage("Tous les champs doivent etre remplis")
            builder2.setPositiveButton("OUI") { dialogin: DialogInterface, i: Int -> }
            builder2.setNegativeButton("NON") { dialogin: DialogInterface, i: Int -> }

            val dialog2 = builder2.create()
            dialog2.show()
        }

        val dialog = builder.create()
        dialog.show()
    }
}

            annulerbtn.setOnClickListener {

            }
        }


    }
}