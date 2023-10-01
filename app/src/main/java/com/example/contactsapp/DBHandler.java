package com.example.contactsapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "contactsDB";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "contactsTable";
    private static final String ID_COL = "ID";
    private static final String NAME_COL = "name";
    private static final String SURNAME_COL = "surname";
    private static final String EMAIL_COL = "emailAddress";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + SURNAME_COL + " TEXT,"
                + EMAIL_COL + " TEXT)";

        db.execSQL(query);
    }

    public void addNewContact(String name, String surname, String emailAddress) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(NAME_COL, name);
        values.put(SURNAME_COL, surname);
        values.put(EMAIL_COL, emailAddress);

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    public ArrayList<ContactModal> readContacts() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorContacts = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<ContactModal> contactModalArrayList = new ArrayList<>();

        if (cursorContacts.moveToFirst()) {
            do {
                contactModalArrayList.add(new ContactModal(cursorContacts.getString(1),
                        cursorContacts.getString(2),
                        cursorContacts.getString(3)));
            } while (cursorContacts.moveToNext());
        }

        cursorContacts.close();
        return contactModalArrayList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}
