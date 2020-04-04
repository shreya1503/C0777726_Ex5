package com.shreya.c0777726_ex5;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {

    private TextView form;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        form = findViewById(R.id.txtForm);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String su = extras.getString("SuFix");
        String FN = extras.getString("firstName");
        String LN = extras.getString("lastName");
        String ES = extras.getString("empStatus");
        String DS = extras.getString("Desgs");
        String SNO = extras.getString("StreetNo");
        String SN = extras.getString("StreetName");
        String P = extras.getString("Province");
        String CI = extras.getString("City");
        String CY = extras.getString("Country");
        String PC = extras.getString("Postalcode");
        String EM = extras.getString("Email");
        String CYC = extras.getString("Countrycode");
        String CNO = extras.getString("Cellnumber");
        String DT = extras.getString("pickedDate");
        String IS = extras.getString("Issues");
        int RB = extras.getInt("Ratingbar");
        String DD = extras.getString("DetailDescription");
        

        form.setText("**********COMPLAINT DETAILS FORM**********"+
                "**********\n"+"Name :    " +su+" " +FN+" " +LN+" \n Employment Status :    "+ ES+" \n Designation :    "  +DS+" \n Street No. :    " +SNO+" \n Street Name :    " +SN+" \n Province :    "+
                P+" \n City :    " +CI+" \n Country :   " +CY+" \n Postal Code :    " +PC+" \n Email :    " +EM+" \n Country Code :    " +CYC
                +" \n Contact No. :    " +CNO+" \n Complaint Issue Date :    " +DT+" \n Issues :    " +IS+" \n Rating :    " +RB+" \n Detailed Description :    " +DD);
        form.setTextColor(Color.DKGRAY);
        form.setTextSize(20);

    }
}
