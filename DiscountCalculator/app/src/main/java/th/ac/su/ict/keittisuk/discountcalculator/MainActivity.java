package th.ac.su.ict.keittisuk.discountcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edtPriceOriginal;
    private EditText edtPercentOff;
    private CheckBox cbTax;
    private Button calculate_btn;
    private TextView tvPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPriceOriginal = findViewById(R.id.edtPriceOriginal);
        edtPercentOff = findViewById(R.id.edtPercentOff);
        cbTax = findViewById(R.id.cbTax);
        calculate_btn = findViewById(R.id.calculate_btn);
        tvPrice = findViewById(R.id.tvPrice);

        calculate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float originalPrice = 0;
                originalPrice = Float.parseFloat(edtPriceOriginal.getText().toString());

                float perccentOff = 0;
                perccentOff = Float.parseFloat(edtPercentOff.getText().toString());

                float discount=0;
                discount = (perccentOff/100)*originalPrice;

                float finalPrice=0;
                float tax=0;

                if(cbTax.isChecked()){
                    finalPrice=originalPrice-discount;
                    tax = (float)0.07*finalPrice;

                    finalPrice +=tax;
                }
                else{
                    finalPrice=originalPrice-discount;
                }

                tvPrice.setText(Float.toString(finalPrice));


            }
        });



    }

}
