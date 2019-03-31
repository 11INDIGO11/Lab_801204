package th.ac.su.ict.keittisuk.discountcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBarPercentOff;
    TextView percentOffText;

    EditText editText;
    CheckBox checkTax;
    TextView showResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarPercentOff = findViewById(R.id.seekBarPercentOff);
        percentOffText = findViewById(R.id.percentOffText);

        editText = findViewById(R.id.editText);
        checkTax = findViewById(R.id.checkTax);
        showResult = findViewById(R.id.showResult);


        seekBarPercentOff.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int progress_value;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                percentOffText.setText(seekBarPercentOff.getProgress()+"%");
                if(editText.getText().length() != 0){
                    float result1 = 0;
                    result1 = Float.parseFloat(editText.getText().toString());

                    float result2 = seekBarPercentOff.getProgress();

                    float finalResult;

                    float result3 = 0;
                    float result4 = 0;
                    float result5 = seekBarPercentOff.getProgress();

                    result3 = (result2 / 100) * result1;

                    float tax;

                    if(checkTax.isChecked()) {
                        finalResult = result1 - result3;
                        tax = (float)0.07*finalResult;

                        finalResult += tax;
                        result4 = result3+finalResult;
                    }

                    else {
                        finalResult = result1-result3;
                    }

                    showResult.setText(Float.toString(finalResult));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


            }
        });

    }
}
