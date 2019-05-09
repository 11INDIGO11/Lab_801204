package th.ac.su.ict.keittisuk.demointent;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editInput1;
    private Button btnEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editInput1 = findViewById(R.id.edtInput1);
        btnEdt = findViewById(R.id.btnEdt);

        btnEdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("message",editInput1.getText().toString());
                startActivityForResult(intent,1000);
            }
        });
    }//ส่งค่าไปมา

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1000 & resultCode == RESULT_OK){
            String editMessage = data.getStringExtra("message");
            editInput1.setText(editMessage);
        }
    }
}
