package com.example.contactsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textViewTitle;
    private Button buttonSubmit, buttonSeeContacts;
    private EditText editTextSurname, editTextName, editTextEmailAddress;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextSurname = findViewById(R.id.editTextSurname);
        editTextName = findViewById(R.id.editTextName);
        editTextEmailAddress = findViewById(R.id.editTextEmailAddress);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonSeeContacts = findViewById(R.id.buttonSeeContacts);
        textViewTitle = findViewById(R.id.textViewTitle);

        editTextName.setHint("First Name");
        editTextSurname.setHint("Surname");
        editTextEmailAddress.setHint("Email Address");

        dbHandler = new DBHandler(MainActivity.this);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString();
                String surname = editTextSurname.getText().toString();
                String emailAddress = editTextEmailAddress.getText().toString();

                if (name.isEmpty() || surname.isEmpty() || emailAddress.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!emailAddress.contains("@")) {
                    Toast.makeText(MainActivity.this, "Please enter a valid email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHandler.addNewContact(name, surname, emailAddress);

                Toast.makeText(MainActivity.this, "Contact added!", Toast.LENGTH_SHORT).show();
                editTextName.setText("");
                editTextSurname.setText("");
                editTextEmailAddress.setText("");
            }
        });

        buttonSeeContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ViewContacts.class);
                startActivity(i);
            }
        });
    }
}