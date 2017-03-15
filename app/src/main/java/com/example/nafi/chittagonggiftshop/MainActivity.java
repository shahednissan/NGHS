package com.example.nafi.chittagonggiftshop;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View address=findViewById(R.id.address_container);
        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String geoLocation="http://maps.google.com/maps?daddr=22.361781,91.820711"; //This will give the direction from user's current location.
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(geoLocation));
                if(intent.resolveActivity(getPackageManager())!=null){
                    startActivity(intent);
                }
            }
        });

        View contactNumber=findViewById(R.id.number_container);
        contactNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber="tel:"+getString(R.string.contact_phone);
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(phoneNumber));
                if(intent.resolveActivity(getPackageManager())!=null){
                    startActivity(intent);
                }
            }
        });

        View contactEmail=findViewById(R.id.email_container);
        contactEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String [] addresses={getString(R.string.contact_email)}; //It takes a array of all the to emails.
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.setType("*/*");
                intent.putExtra(Intent.EXTRA_EMAIL, addresses);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });


    }
}
