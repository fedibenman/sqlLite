package com.example.sqllite

import android.provider.BaseColumns

object  EtudiantBC  {

    class EtudiantEntry : BaseColumns{
    companion object{

        const val TABLE_NAME = "etudiant"
        const val COLUMN_NAME_NOM = "nom"
        const val COLUMN_NAME_PRENOM = "prenom"
        const val COLUMN_NAME_PHONE = "phone"
        const val COLUMN_NAME_EMAIL = "email"
        const val COLUMN_NAME_LOGIN = "login"
        const val COLUMN_NAME_MDP = "mdp"

    }

    }


}