package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IOnChildItemClick {
    private List<ContactModel> listContacts = new ArrayList<>();
    private ListView lvContact;
    private ContactAdapter mAdapter;
    private ImageView ivUser;
    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();

        mAdapter = new ContactAdapter(this, listContacts);
        mAdapter.registerChildItemClick(this);
        lvContact.setAdapter(mAdapter);
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ContactModel contactModel = listContacts.get(i);
                Toast.makeText(MainActivity.this, contactModel.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        lvContact = (ListView) findViewById(R.id.lvContact);
        ivUser = (ImageView) findViewById(R.id.ivUser);
        tvName = (TextView) findViewById(R.id.tvName);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAdapter.unregisterChildItemClick();
    }

    @Override
    public void onItemChildClick(int position) {
        ContactModel contact = listContacts.get(position);
        ivUser.setImageResource(contact.getAvatar());
        tvName.setText(contact.getName());
    }
}