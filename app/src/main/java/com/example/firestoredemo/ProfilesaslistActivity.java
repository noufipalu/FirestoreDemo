package com.example.firestoredemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.auth.User;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

public class ProfilesaslistActivity extends AppCompatActivity {

    //ListView listDetails;
    //ArrayAdapter<User> adapter;
    FirebaseFirestore firestore;
    private static final String TAG = "ProfilesaslistActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilesaslist);

        firestore = FirebaseFirestore.getInstance();
        //listDetails = findViewById(R.id.list_users);
        //adapter = new ArrayAdapter<User>(this, android.R.layout.simple_list_item_1, new ArrayList<User>());
        //listDetails.setAdapter(adapter);

        firestore.collection("user").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        //ArrayList<User> user = new ArrayList<>();
                        for (QueryDocumentSnapshot document : queryDocumentSnapshots) {
                            //User u = document.toObject(User.class);
                            Log.d(TAG, document.getId() + " " + document.getData());
                            //user.add(u);
                        }
                        //adapter.clear();
                        //adapter.addAll(user);
                    }
                });
    }
}