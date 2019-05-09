package th.ac.su.ict.keittisuk.firebasedemo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText id;
    private EditText gpa;
    private EditText phone;
    private Button savebtn;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        id = findViewById(R.id.id);
        gpa = findViewById(R.id.gpa);
        phone = findViewById(R.id.phone);
        savebtn = findViewById(R.id.savebtn);


        database = FirebaseDatabase.getInstance();


        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



//                DatabaseReference names = database.getReference("namedb");
//                names.setValue(name.getText().toString());
//
//                DatabaseReference ids = database.getReference("iddb");
//                ids.setValue(id.getText().toString());
//
//                DatabaseReference gpas = database.getReference("gpadb");
//                gpas.child("2017").child("1").setValue(gpa.getText().toString());
//                gpas.child("2018").child("2").setValue(gpa.getText().toString());
//
//                DatabaseReference phones = database.getReference("phonedb");
//                phones.setValue(phone.getText().toString());

                DatabaseReference studentRef = database.getReference("student");
                Map student = new HashMap();
                Map advisor = new HashMap();
                student.put("name",name.getText().toString());
                student.put("id",13600166);
                student.put("gpa",3.5);
                student.put("phone",phone.getText().toString());

                advisor.put("name","phanuphong");
                advisor.put("id","1555489");

                student.put("advisor",advisor);

                studentRef.push().setValue(student);
//                studentRef.child("id").setValue(student);

            }

        });


//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                String value = dataSnapshot.getValue(String.class);
//
//                firstname.setText(value);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
    }
}
