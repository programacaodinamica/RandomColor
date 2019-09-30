package br.com.programacaodinamica.randomcolor.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import br.com.programacaodinamica.randomcolor.model.NamedColor

@Database(entities = [NamedColor::class], version = 2)
abstract class ColorDatabase: RoomDatabase() {

    abstract fun colorDAO(): NamedColorDAO

    companion object{
        private var INSTANCE: ColorDatabase? = null
        fun get(context: Context): ColorDatabase {
            return INSTANCE ?: run {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ColorDatabase::class.java,
                    "ColorDatabase")
                    .addMigrations(MIGRATION_1_2)
                    .allowMainThreadQueries() // REMOVER
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

}

