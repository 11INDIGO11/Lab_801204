package th.ac.su.ict.keittisuk.testactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView img1;
    ImageView img2;
    ImageView img3;
    TextView name1;
    TextView name2;
    TextView name3;
    TextView userid1;
    TextView userid2;
    TextView userid3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
