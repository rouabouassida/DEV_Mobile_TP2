package com.example.bouassida_roua_lsi3_messure_glycemie;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etValeur ;
    private Button btnConsulter;
    private SeekBar sbAge;
    private RadioButton rbIsFasting ,rbIsNotFasting;
    private TextView tvAge,tvResultat;
    private RadioGroup group;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        //listener seekbar
        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                Log.i("INFORMATION","onProgressChanged"+progress);
                tvAge.setText("Votre age="+progress);}


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        }
            public void calculer(View v){

            group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    RadioButton  selectedRadioButton =findViewById(checkedId);
                    String selectedValue= selectedRadioButton.getText().toString();
                    if(selectedValue.equals("Oui")){
                        jéuner=true;
                    }else {
                        jéuner=false;
                    }
                }


        btnConsulter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int age = sbAge.getProgress();
                    double vM = Double.parseDouble(vm.getText().toString());

                    if (jéuner) {
                        if (age >= 13 && (vM >= 5.0 && vM <= 7.2)) {
                            res.setText("niveau de glycémie est normale 1");
                        } else if ((age < 13 && age >= 6) && (vM >= 5.0 && vM <= 10.0)) {
                            res.setText("niveau de glycémie est normale 2");
                        } else if ((age < 13 && age >= 6) && (vM >= 5.5 && vM <= 10.0)) {
                            res.setText("niveau de glycémie est normale 3");
                        } else {
                            res.setText("niveau de glycémie est trop bas  ou niveau de glycémie est trop élevée 1");
                        }
                    } else {
                        if (age >= 13 && vM < 10.5) {
                            res.setText("niveau de glycémie est normale");
                        } else {
                            res.setText("niveau de glycémie est trop bas  ou niveau de glycémie est trop élevée 2 ");
                        }
                    }
                
                    vm.setText("");
                    sbAge.setProgress(0);

                }
            }

            }

    }


    public void init()
    {
        etValeur =(EditText) findViewById(R.id.etValeur);
        sbAge = (SeekBar) findViewById(R.id.sbAge);
        btnConsulter =(Button) findViewById(R.id.btnConsulter);
        rbIsFasting =(RadioButton) findViewById(R.id.rbIsFasting);
        rbIsNotFasting =(RadioButton) findViewById(R.id.rbIsNotFasting);
        tvAge =(TextView) findViewById(R.id.tvAge);
        tvResultat =(TextView) findViewById(R.id.tvResultat);

    }


}