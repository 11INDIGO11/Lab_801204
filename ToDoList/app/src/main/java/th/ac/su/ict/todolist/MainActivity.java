package th.ac.su.ict.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
                addItem();
                hideKeyboard(v);
            }
        });
        edtBox.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //Log.d("key listener","key pressed");

                if(keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN){
                    addItem();
                    hideKeyboard(v);
                }

                return false;
            }
        });


//        for(int i=0;i<30;i++){
//            toDoItems.add("นอนก่อนเลยได้ไหม"+i);
//        }

    }

    private void hideKeyboard(View v){
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(),0);
    }

    private void addItem(){
        String item = edtBox.getText().toString();
        if(!TextUtils.isEmpty(item)){
            toDoItems.add(0,item);
            arrayAdapter.notifyDataSetChanged();
            edtBox.setText("");



        }
    }


}
