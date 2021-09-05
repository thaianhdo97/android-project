package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvContact;
    private List<ContactModel> listContacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        lvContact = (ListView) findViewById(R.id.lvContact);
        ContactAdapter adapter = new ContactAdapter(listContacts, this);
        lvContact.setAdapter(adapter);

        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ContactModel contactModel = listContacts.get(position);
                Toast.makeText(MainActivity.this, contactModel.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        ContactModel contact = new ContactModel("Do Thai Anh", "0914366644", R.drawable.ic_avatar1);
        listContacts.add(contact);
        contact = new ContactModel("Phan Van Teo", "0123456789", R.drawable.ic_avatar2);
        listContacts.add(contact);
        contact = new ContactModel("Do Thai Minh", "0943567887", R.drawable.ic_avatar3);
        listContacts.add(contact);
        contact = new ContactModel("Do Thai Tuan", "0912765009", R.drawable.ic_avatar4);
        listContacts.add(contact);
    }
}