package com.example.weektwodaytowhomework;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class ResultActivity extends AppCompatActivity {

    public static final int RESPONSE_CODE = 422 ;

    //When declaring at the top of a class it is known as declaring globally
    Intent passedIntent ;

    EditText etCarMake;
    EditText etCarModel;
    EditText etCarYear;
    EditText etCarTitleStatus;
    EditText etCarColor;
    EditText etCarEngine;
    EditText etCarTransmission;

    SharedPreferences sharedPreferences ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        etCarMake = findViewById(R.id.etCarMake);
        etCarModel = findViewById(R.id.etCarModel);
        etCarYear = findViewById(R.id.etCarYear);
        etCarTitleStatus = findViewById(R.id.etCarTitleStatus);
        etCarColor = findViewById(R.id.etCarColor);
        etCarEngine = findViewById(R.id.etCarEngine);
        etCarTransmission = findViewById(R.id.etCarTransmission);

        sharedPreferences = getSharedPreferences("shared_pref", MODE_PRIVATE) ;

        //get values from shared preferences
        etCarMake.setText(sharedPreferences.getString("name", "")) ;
        etCarModel.setText(sharedPreferences.getString("email", "")) ;

        passedIntent = getIntent() ;
    }

    public void onClick(View view) {

        String carMake = etCarMake.getText().toString();
        String carModel = etCarModel.getText().toString();
        String carYear = etCarYear.getText().toString();
        String carTitleStatus = etCarTitleStatus.getText().toString();
        String carColor = etCarColor.getText().toString();
        String carEngine = etCarEngine.getText().toString();
        String carTransmission = etCarTransmission.getText().toString();

        Car car = new Car(carMake,carModel,carYear,carTitleStatus,carColor,carEngine,carTransmission);

        //create a Bundle object
        Bundle extras = new Bundle();
        //Adding key value pairs to this bundle
        //there are quite a lot data types you can store in a bundle
        extras.putParcelable("car",car);

        passedIntent = new Intent();
        passedIntent.putExtras(extras);

        setResult(RESPONSE_CODE, passedIntent) ;
        //Make sure to destroy activity after we are done
        finish() ;
    }
}


