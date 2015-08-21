package com.unb.mayur.vadodara_guide;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

import android.view.View;

import java.util.Locale;

import static android.app.PendingIntent.getActivity;


public class Details_Attract extends Activity {


    String msg =" ",destination;
    String[] des;
    String[] tit={"Baroda Golf Club","EME Temple","Laxmi Vilas Palace","Nazar Baug Palace","Old City","Sayaji Baug","Sursagar Lake","Hazira Maqbara"};

    double lx,ly;


    int[] images = {R.drawable.l_golf, R.drawable.l_eme, R.drawable.l_laxivilas,R.drawable.l_nazarbaug, R.drawable.l_oldcity, R.drawable.l_sayajibaug,R.drawable.l_susagar, R.drawable.l_hazira};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details__attract);


//        getSupportActionBar().setHomeButtonEnabled(true);
        //       getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//            callthis(String msg);

        TextView tx = (TextView) findViewById(R.id.tv);
        ImageView iv = (ImageView) findViewById(R.id.imageView2);


        Intent intent = getIntent();

        Resources res = getResources();
        des = res.getStringArray(R.array.des);


        // msg = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        msg = intent.getStringExtra(Attractions_s.EXTRA_MESSAGE);

        //     }
        tx.setText("" + msg);

        // Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

        int msg_int = Integer.parseInt(msg);//typecast
//int msg_int=0;


         switch(msg_int)
        {
            case 0:

                    lx=22.293128;
                    ly=73.193756;
                    destination="Baroda Golf Club";
                break;

            case 1:

                lx=22.331499700000000000;
                ly=73.191933300000070000;


                destination="EME Temple";
                break;

            case 2:

                lx=22.293769000000000000;
                ly=73.191980199999990000;
                destination="Laxmi Vilas Palace";
                break;

            case 3:

                lx=22.30076;
                ly=73.211659;
                destination="Nazar Baug Palace";
                break;

            case 4:

                lx=22.299999;
                ly=73.205916;
                destination="Old City";
                break;

            case 5:

                lx=22.312653900000000000;
                ly=73.189536699999960000;
                destination="Sayaji Baug";
                break;
            case 6:

                lx=22.30021;
                ly=73.205405;
                destination="Sursagar Lake";
                break;
            case 7:

                lx=22.277828;
                ly=73.206681;
                destination="Hazira Maqbara";
                break;


        }




        for (int i = 0; i < 8; i++) {


            if (msg_int == i)
            {


                setTitle(tit[i]);
                tx.setText("" + des[i]);
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
