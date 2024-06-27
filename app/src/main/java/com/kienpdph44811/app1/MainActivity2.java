package com.kienpdph44811.app1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.ktx.Firebase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class MainActivity2 extends AppCompatActivity {

    FirebaseFirestore database;
    Button btnInsert, btnUpdate, btnDelete;
    TextView tvResult;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.demoTv1);
        btnInsert = findViewById(R.id.btnInsert);

        database = FirebaseFirestore.getInstance();//Khoi tao
        btnInsert.setOnClickListener(v ->{
            insertFireBase(tvResult);
        });

        btnUpdate = findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(v->{
            updateFireBase(tvResult);
        });

        btnDelete = findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(v->{
            deleteFirebase(tvResult);
        });
        SeclecDataFirebase (tvResult);
    }
    String id = "";
    ToDo toDo = null;

    public void insertFireBase(TextView tvResult){
        id = UUID.randomUUID().toString();// lay id bat ki
        //Tao doi tượng để ínert
        toDo = new ToDo(id, "title 2", "content 2");
        //Chuyen doi sang doi tuong co the thao tac voi fireBase
        HashMap<String, Object> mapToDo = toDo.converHaskMap();
        //insert  vao database
        database.collection("TODO").document(id)
                .set(mapToDo)// Doi tuong can insent
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        tvResult.setText("Them Thanh Cong");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        tvResult.setText(e.getMessage());
                    }
                })
        ;
    }
    public void updateFireBase(TextView tvResult){
         id = "ce72fea2-0d9b-462f-9579-1a0fdcab3f82";
         toDo = new ToDo(id, "sua title 1", "sua content 1");
         database.collection("TODO").document(toDo.getId())
                 .update(toDo.converHaskMap())
                 .addOnSuccessListener(new OnSuccessListener<Void>() {
                     @Override
                     public void onSuccess(Void unused) {
                         tvResult.setText("Sua Thanh Cong");
                     }
                 })
                 .addOnFailureListener(new OnFailureListener() {
                     @Override
                     public void onFailure(@NonNull Exception e) {
                         tvResult.setText(e.getMessage());
                     }
                 });
    }

    public void deleteFirebase(TextView tvResult){
        id = "ce72fea2-0d9b-462f-9579-1a0fdcab3f82";
        database.collection("TODO").document(id)
                .delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        tvResult.setText("Xoa Thanh Cong");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        tvResult.setText(e.getMessage());
                    }
                });
    }

    String strResult = "";
    public ArrayList<ToDo> SeclecDataFirebase(TextView tvResult){
        ArrayList<ToDo> list = new ArrayList<>();
        database.collection("TODO")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){ //Sau khi lay du lieu thanh cong
                            strResult = "";
                            for (QueryDocumentSnapshot document: task.getResult()){
                                //Chuyen dong doc duoc sang doi tuong
                                ToDo toDo1 = document.toObject(ToDo.class);
                                //Chuyen doi tuong thanh chuooi
                                strResult += "Id: " +toDo1.getId()+ "\n";
                                list.add(toDo1); //Them vao list
                            }
                            //Hien thi ket qua
                            tvResult.setText(strResult);
                        }else {
                            tvResult.setText("Doc du lieu that bai");
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        tvResult.setText(e.getMessage());
                    }
                });

        return list;
    }
}