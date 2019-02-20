package com.example.weektwodaytowhomework;

import android.app.Activity ;
import android.os.Bundle ;
import android.view.View ;
import android.widget.TextView ;
import android.content.Intent ;
import android.content.SharedPreferences ;

public class MainActivity extends Activity {

    SharedPreferences sharedPreferences ;

    public static final int REQUEST_CODE = 421 ;
    TextView tvCarMake;
    TextView tvCarModel;
    TextView tvCarYear;
    TextView tvCarTitleStatus;
    TextView tvCarColor;
    TextView tvCarEngine;
    TextView tvCarTransmission;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCarMake = findViewById(R.id.tvCarMake);
        tvCarModel = findViewById(R.id.tvCarModel);
        tvCarYear = findViewById(R.id.tvCarYear);
        tvCarTitleStatus = findViewById(R.id.tvCarTitleStatus);
        tvCarColor = findViewById(R.id.tvCarColor);
        tvCarEngine = findViewById(R.id.tvCarEngine);
        tvCarTransmission = findViewById(R.id.tvCarTransmission);

        sharedPreferences = getSharedPreferences("shared_pref", MODE_PRIVATE) ;

    }


    public void onStartForResult(View view) {
        Intent intent = new Intent(this, ResultActivity.class) ;
        startActivityForResult(intent, REQUEST_CODE) ;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data) ;

        if(data != null) {

            //get the attached bundle from the intent
            Bundle extras = data.getExtras();
            Car car = extras.getParcelable("car" );


//            String carMake = extras.getString("CARMAKE") ;
//            String carModel = extras.getString("CARMODEL");
//            String carYear = extras.getString("CARYEAR") ;
//            String carTitleStatus = extras.getString("CARTITLESTATUS") ;
//            String carColor = extras.getString("CARCOLOR") ;
//            String carEngine = extras.getString("CARENGINE") ;
//            String carTransmission = extras.getString("CARTRANSMISSION") ;

            tvCarMake.setText(car.carMake) ;
            tvCarModel.setText(car.carModel);
            tvCarYear.setText(car.carYear);
            tvCarTitleStatus.setText(car.carTitleStatus);
            tvCarColor.setText(car.carColor);
            tvCarEngine.setText(car.carEngine);
            tvCarTransmission.setText(car.carTransmission);

            SharedPreferences.Editor editor = sharedPreferences.edit() ;
            editor.putString("carMake", car.carMake);
            editor.putString("carModel", car.carModel) ;
            editor.apply() ;
            editor.commit();

        }
    }
}
