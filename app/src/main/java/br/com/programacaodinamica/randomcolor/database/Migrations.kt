package br.com.programacaodinamica.randomcolor.database

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database
            .execSQL(
                "ALTER TABLE Color ADD COLUMN timestamp INTEGER NOT NULL DEFAULT 1569865484"
            )
    }
}