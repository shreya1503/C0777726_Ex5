package com.shreya.c0777726_ex5;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Activity2 extends AppCompatActivity
{
    private String[] suffix;
    private Spinner suffixsp;
    private String[] empstatus;
    private Spinner empstatussp;
    private String[] issue;
    private  Spinner issuesp ;
    private  String[] designation;
    private Spinner designationsp;
    private TextView firstname;
    private TextView lastname;
    private TextView streetno;
    private TextView streetname;
    private TextView province;
    private TextView city;
    private TextView country;
    private TextView postalcode;
    private TextView email;
    private TextView  countrycode;
    private TextView cellnumber;
    private TextView detaildescription;
    private Button Register;
    private Button Clear;
    private TextView Datetxt;
    private RatingBar ratingbar;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Register = findViewById(R.id.register);
        Clear = findViewById(R.id.btnClear);
        suffix = getResources().getStringArray(R.array.suffix);
        suffixsp = findViewById(R.id.spinner);
        empstatus = getResources().getStringArray(R.array.status);
        empstatussp = findViewById(R.id.status);
        designation = getResources().getStringArray(R.array.designation);
        designationsp = findViewById(R.id.designation);
        issue = getResources().getStringArray(R.array.issue);
        issuesp = findViewById(R.id.issue);
        firstname = findViewById(R.id.first_name);
        lastname = findViewById(R.id.last_name);
        streetno = findViewById(R.id.stno);
        streetname = findViewById(R.id.streetname);
        province = findViewById(R.id.provinance);
        city = findViewById(R.id.city);
        country = findViewById(R.id.country);
        postalcode = findViewById(R.id.postalcode);
        email = findViewById(R.id.email);
        countrycode = findViewById(R.id.countrycode);
        cellnumber = findViewById(R.id.cellnumber);
        detaildescription = findViewById(R.id.description);
        Datetxt = findViewById(R.id.txtDate);
        ratingbar = findViewById(R.id.rating);
        ArrayAdapter<String> mStringArrayAdapter = new ArrayAdapter<>(Activity2.this, android.R.layout.simple_spinner_dropdown_item, suffix);
        suffixsp.setAdapter(mStringArrayAdapter);
        suffixsp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                Toast.makeText(Activity2.this, suffix[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                Toast.makeText(Activity2.this, "onNothingSelected", Toast.LENGTH_SHORT).show();
            }
        });
        ArrayAdapter<String> eStringArrayAdapter = new ArrayAdapter<>(Activity2.this, android.R.layout.simple_spinner_dropdown_item, empstatus);
        empstatussp.setAdapter(eStringArrayAdapter);
        empstatussp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                Toast.makeText(Activity2.this, empstatus[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                Toast.makeText(Activity2.this, "onNothingSelected", Toast.LENGTH_SHORT).show();
            }
        });
        ArrayAdapter<String> dStringArrayAdapter = new ArrayAdapter<>(Activity2.this, android.R.layout.simple_spinner_dropdown_item, designation);
        designationsp.setAdapter(dStringArrayAdapter);
        designationsp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                Toast.makeText(Activity2.this, designation[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                Toast.makeText(Activity2.this, "onNothingSelected", Toast.LENGTH_SHORT).show();
            }
        });
        ArrayAdapter<String> iStringArrayAdapter = new ArrayAdapter<>(Activity2.this, android.R.layout.simple_spinner_dropdown_item, issue);
        issuesp.setAdapter(iStringArrayAdapter);
        issuesp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                Toast.makeText(Activity2.this, issue[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                Toast.makeText(Activity2.this, "onNothingSelected", Toast.LENGTH_SHORT).show();
            }
        });

        final Calendar myCalendar = Calendar.getInstance();


        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "MM/dd/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                Datetxt.setText(sdf.format(myCalendar.getTime()));

            }

        };

        Datetxt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                new DatePickerDialog(Activity2.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }

        });
        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            @Override
            public void onRatingChanged(final RatingBar ratingBar, final float rating, final boolean fromUser) {
                setCurrentRating(rating);
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (firstname.getText().toString().matches(""))
                {
                    firstname.setError("Enter First Name");
                } else if (lastname.getText().toString().matches(""))
                {

                    lastname.setError("Enter Last Name");
                } else if (streetno.getText().toString().matches(""))
                {
                    streetno.setError("Enter Street No.");
                } else if (streetname.getText().toString().matches(""))
                {
                    streetname.setError("Enter Street Name");

                } else if (province.getText().toString().matches(""))
                {
                    province.setError("Enter Province");

                } else if (city.getText().toString().matches(""))
                {
                    city.setError("Enter City");

                } else if (country.getText().toString().matches(""))
                {
                    country.setError("Enter Country");

                } else if (postalcode.getText().toString().matches(""))
                {
                    postalcode.setError("Enter Postal Code");

                } else if (email.getText().toString().matches(""))
                {
                    email.setError("Enter Email");

                } else if (countrycode.getText().toString().matches(""))
                {
                    countrycode.setError("Enter Country Code");

                } else if (cellnumber.getText().toString().matches(""))
                {
                    cellnumber.setError("Enter Cell Number");

                } else
                {

                    Intent mintent = new Intent(Activity2.this, Activity3.class);


                    String selectedsuffix =  suffixsp.getSelectedItem().toString();
                    String selectedfirstname = firstname.getText().toString();
                    String selectedlastname = lastname.getText().toString();
                    String selectedempStatus = empstatussp.getSelectedItem().toString();
                    String selectedDesgs= designationsp.getSelectedItem().toString();
                    String selectedStreetNo= streetno.getText().toString();
                    String selectedStreetName= streetname.getText().toString();
                    String selectedProvince= province.getText().toString();
                    String selectedCity= city.getText().toString();
                    String selectedCountry= country.getText().toString();
                    String selectedPostalcode= postalcode.getText().toString();
                    String selectedEmail= email.getText().toString();
                    String selectedCountrycode= countrycode.getText().toString();
                    String selectedCellnumber= cellnumber.getText().toString();
                    String selectedpickedDate= Datetxt.getText().toString();
                    int selectedRatingbar= (int) ratingbar.getRating();
                    String selectedIssues= issuesp.getSelectedItem().toString();
                    String selectedDetailDescription= detaildescription.getText().toString();

                    complaintIssues c1 = new complaintIssues(selectedsuffix,selectedfirstname,selectedlastname,selectedempStatus,selectedDesgs,selectedStreetNo,selectedStreetName,selectedProvince,selectedCity,selectedCountry,selectedPostalcode,selectedEmail,selectedCountrycode,selectedCellnumber,selectedpickedDate,selectedIssues,selectedRatingbar,selectedDetailDescription);

                    mintent.putExtra("object", (Serializable) c1);

                    startActivity(mintent);



                }
            }


        });
        Clear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                firstname.setText("");
                lastname.setText("");
                streetno.setText("");
                streetname.setText("");
                province.setText("");
                city.setText("");
                country.setText("");
                postalcode.setText("");
                email.setText("");
                countrycode.setText("");
                cellnumber.setText("");
                Datetxt.setText("");
                detaildescription.setText("");

            }
        });
    }
    private void setCurrentRating(float rating)
    {
        LayerDrawable drawable = (LayerDrawable)ratingbar.getProgressDrawable();
        if(drawable!=null)
        {
            switch (Math.round(rating))
            {
                case 1:
                    drawable.getDrawable(2).setColorFilter(Color.CYAN, PorterDuff.Mode.SRC_ATOP);
                    break;
                case 2:
                    drawable.getDrawable(2).setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);
                    break;
                case 3:
                    drawable.getDrawable(2).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
                    break;
                case 4:
                    drawable.getDrawable(2).setColorFilter(Color.MAGENTA, PorterDuff.Mode.SRC_ATOP);
                    break;
                case 5:
                    drawable.getDrawable(2).setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                    break;
            }

        }
    }

    private class complaintIssues
    {
        public complaintIssues(String selectedsuffix, String selectedfirstname, String selectedlastname, String selectedempStatus, String selectedDesgs, String selectedStreetNo, String selectedStreetName, String selectedProvince, String selectedCity, String selectedCountry, String selectedPostalcode, String selectedEmail, String selectedCountrycode, String selectedCellnumber, String selectedpickedDate, String selectedIssues, int selectedRatingbar, String selectedDetailDescription) { }
    }
}