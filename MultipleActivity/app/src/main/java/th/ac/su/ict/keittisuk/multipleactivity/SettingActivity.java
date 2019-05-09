package th.ac.su.ict.keittisuk.multipleactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingActivity extends AppCompatActivity {

    Button redBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        redBtn = findViewById(R.id.redBtn);

        redBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("selected_color","red");

                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}


