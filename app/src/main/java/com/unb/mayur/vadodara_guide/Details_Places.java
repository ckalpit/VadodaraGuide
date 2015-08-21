package com.unb.mayur.vadodara_guide;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

import static android.app.PendingIntent.getActivity;


public class Details_Places extends Activity {


    String msg =" ",destination;
    String[] des2;
    String[] tit={"Ajwa Nimeta","Jambughoda Sanctuary","Kabirwad","Pavagadh","Sardar Sarovar Dam"};
    double lx,ly;



    int[] images = {R.drawable.l_ajwanimeta, R.drawable.l_jamughoda, R.drawable.l_kabirvad,R.drawable.l_pavagadh, R.drawable.l_sadarsarovardam};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details__places);


//        getSupportActionBar().setHomeButtonEnabled(true);
        //       getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//            callthis(String msg);

        TextView tx = (TextView) findViewById(R.id.tv);
        ImageView iv = (ImageView) findViewById(R.id.imageView2);


        Intent intent = getIntent();

        Resources res = getResources();
        des2 = res.getStringArray(R.array.des2);


        // msg = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        msg = intent.getStringExtra(Attractions_s.EXTRA_MESSAGE);

        //     }
        tx.setText("" + msg);

        // Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

        int msg_int = Integer.parseInt(msg);//typecast
//int msg_int=0;


        switch(msg_int) {
            case 0:

                lx = 22.352908400000000000;
                ly = 73.303808600000020000;
                destination = "Ajwa Nimeta";
                break;

            case 1:

                lx = 22.360989900000000000;
                ly = 73.665393900000030000;


                destination = "Jambughoda Sanctuary";
                break;

            case 2:

                lx = 21.762277700000000000;
                ly = 73.142705200000020000;
                destination = "Kabirwad";
                break;

            case 3:

                lx = 22.467364;
                ly =73.524241;
                destination = "Pavagadh";
                break;

            case 4:

                lx = 21.8305054;
                ly = 73.7485212;
                destination = "Sardar Sarovar Dam";
                break;


        }


            for (int i = 0; i < 8; i++) {


            if (msg_int == i)
            {


                setTitle(tit[i]);
                tx.setText("" + des2[i]);
                iv.setImageResource(images[i]);
            }
        }




    }
    public void Show_map(View view)
    {

        String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?&daddr=%f,%f (%s)",lx, ly, destination,0, 0, "My Location");
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        startActivity(intent);


    }










/*
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_spot_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

*/

}
