package th.ac.su.ict.keittisuk.multipleactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    Button calculateBtn;

    private static final  int SETTING_ACTIVITY_REQUEST_CODE = 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        calculateBtn = findViewById(R.id.calculateBtn);


        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {


                int e1 = Integer.parseInt(editText1.getText().toString());
                int e2 = Integer.parseInt(editText2.getText().toString());
                int result = e1+e2;
//                Toast.makeText(MainActivity.this,result+"",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
//                intent.putExtra("result",result);
//                intent.putExtra("name","Keittisuk");
//                intent.putExtra("id",13600166);
//                intent.putExtra("gpa",3.99);//ส่งไปทีละตัว

                Bundle bundle = new Bundle();
                bundle.putInt("id",13600166);
                bundle.putString("name","Keittisuk");
                bundle.putDouble("gpa",3.99);

                intent.putExtra("student",bundle);

                startActivity(intent);



            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_setting){
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);

//            startActivity(intent);

            startActivityForResult(intent,SETTING_ACTIVITY_REQUEST_CODE);

        }

        return  super.onOptionsItemSelected(item);
    }
}
