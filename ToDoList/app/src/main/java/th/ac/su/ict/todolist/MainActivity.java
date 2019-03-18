package th.ac.su.ict.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Button addBtn;
    private EditText edtBox;

    private ArrayList<String> toDoItems;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //inflate

        listView = findViewById(R.id.listView);
        addBtn = findViewById(R.id.addBtn);
        edtBox = findViewById(R.id.edtBox);

        toDoItems = new ArrayList<>(); //instantiate
        arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,toDoItems);

        listView.setAdapter(arrayAdapter);


        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = edtBox.getText().toString();
                if(!TextUtils.isEmpty(item)){
                    toDoItems.add(0,item);
                    arrayAdapter.notifyDataSetChanged();
                    edtBox.setText("");
                }
            }
        });


//        for(int i=0;i<30;i++){
//            toDoItems.add("นอนก่อนเลยได้ไหม"+i);
//        }



    }
}
