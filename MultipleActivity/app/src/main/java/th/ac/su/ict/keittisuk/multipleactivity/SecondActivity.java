package th.ac.su.ict.keittisuk.multipleactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView showResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        showResult = findViewById(R.id.showResult);

        Intent intent = getIntent();
        Bundle bundle = getIntent().getBundleExtra("student");
        int id = bundle.getInt("id");
        String name = bundle.getString("name");
        Double gpa = bundle.getDouble("gpa");
        showResult.setText(id+name+gpa+"");

//        Intent intent = getIntent();
//        int result = intent.getIntExtra("result",-1);//สำคัญ
//        String name = intent.getStringExtra("name");
//        int id = intent.getIntExtra("id" ,-1);
//        Double gpa = intent.getDoubleExtra("gpa",-1);
//        showResult.setText(name+id+gpa+"");


    }
}
