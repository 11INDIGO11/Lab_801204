package th.ac.su.ict.keittisuk.demointent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    private EditText editInput2;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editInput2 = findViewById(R.id.edtInput2);
        btnSave = findViewById(R.id.btnSave);

        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        editInput2.setText(message);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("message",editInput2.getText().toString());
                setResult(RESULT_OK,intent);

                finish();

            }
        });//ส่งค่าไปมา
    }
}
