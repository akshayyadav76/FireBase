package com.example.akshay.firebase;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {

    TextView t1,t2;
    FirebaseApp data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1=findViewById(R.id.textView1);
        t2=findViewById(R.id.textView2);



//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("message");
//
//        // Read from the database
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                String value = dataSnapshot.getValue(String.class);
//                Log.d( "see","Value is: " + value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w("seee" ,"Failed to read value.", error.toException());
//            }
//        });







    }

//    public void click(View view)
//    {
//   String name = t1.getText().toString();
//   String address = t2.getText().toString();
//
//   if(name.equals("")| address.equals(""))
//   {
//       Toast.makeText(this, "enter the values", Toast.LENGTH_SHORT).show();
//   }else
//   {
//       User user =new User();
//       user.setName(name);
//       user.setAddress(address);
//
//       FirebaseDatabase database = FirebaseDatabase.getInstance();
//       DatabaseReference myRef = database.getReference();
//
//       myRef.child("user").push().setValue(user);
//
//
//
////        data= new FirebaseApp(Config.url);
////       data.child("person").setValue(user);
////       Toast.makeText(this, "data saved", Toast.LENGTH_SHORT).show();
//
//   }
//
//
//    }


    public void load(View view) {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("status");

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChildren())
                {
                    for(DataSnapshot csnap:dataSnapshot.getChildren())
                    {
                        User user=csnap.getValue(User.class);
//                       t1.setText(user.getFirst());
//                       t2.setText(user.getSecond());
                        Toast.makeText(MainActivity.this, "first="+user.getFirst()+"second "+user.getSecond(), Toast.LENGTH_SHORT).show();

                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
