package com.example.baikiemtraso2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddSinhVien extends AppCompatActivity {

    EditText name, describe, url;
    Button btnAdd, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sinhvien);

        name = findViewById(R.id.txtName);
        describe = findViewById(R.id.txtDescribe);
        url = findViewById(R.id.txtImageUrl);

        btnAdd = findViewById(R.id.btnAdd);
        btnBack = findViewById(R.id.btnBack);

        // luu
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inserData();
                clearAll();
            }
        });

        //thoat
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddSinhVien.this,ShowRecycle.class);
                startActivity(intent);
            }
        });
    }

    private void inserData(){

        Map<String,Object> map = new HashMap<>();
        map.put("name",name.getText().toString());
        map.put("describe",describe.getText().toString());
        map.put("url",url.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("svien").push()
                .setValue(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddSinhVien.this,"Thêm thành công!",Toast.LENGTH_SHORT).show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddSinhVien.this,"Thêm thất bại!",Toast.LENGTH_SHORT).show();

                    }
                });
    }

    private  void clearAll(){
        name.setText("");
        describe.setText("");
        url.setText("");
    }
}