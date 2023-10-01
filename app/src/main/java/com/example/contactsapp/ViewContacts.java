package com.example.contactsapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewContacts extends AppCompatActivity {

    private ArrayList<ContactModal> contactModalArrayList;
    private DBHandler dbHandler;
    private ContactRVAdapter contactRVAdapter;
    private RecyclerView contactsRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contacts);

        contactModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ViewContacts.this);

        contactModalArrayList = dbHandler.readContacts();

        contactRVAdapter = new ContactRVAdapter(contactModalArrayList, ViewContacts.this);
        contactsRV = findViewById(R.id.idRVContacts);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewContacts.this, RecyclerView.VERTICAL, false);
        contactsRV.setLayoutManager(linearLayoutManager);

        contactsRV.setAdapter(contactRVAdapter);

    }
}