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


public class All_eat_details extends Activity {


    String msg =" ",destination;
    String[] Food_array;
    String[] tit={"Bhai Bhai Dabeli","Jay Mahakali Sevsual-1","Jay Mahakali Sevsual-2","Tasty Vadapav","Vishal Sandwich","Da Vintage-1","Da Vintage-2","Neelkanth Juice Parlour","Keshav Kutir Pavbhaji","Keshav Restaurant","Anadi Khaman","Hyderabadis","Paras Pan","Anand Snacks"};

    double lx,ly;


    int[] images = {R.drawable.ic_dabeli, R.drawable.k_sev, R.drawable.k_sev,R.drawable.k_vadaapav, R.drawable.k_sand, R.drawable.k_maggim,R.drawable.k_maggim, R.drawable.k_juice,R.drawable.k_pavbhaji, R.drawable.k_resturant, R.drawable.k_khaman,R.drawable.k_hyderabadi,R.drawable.k_pan,R.drawable.anand_full};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_eat_details);


//        getSupportActionBar().setHomeButtonEnabled(true);
        //       getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//            callthis(String msg);

        TextView tx = (TextView) findViewById(R.id.tv);
        ImageView iv = (ImageView) findViewById(R.id.imageView2);


        Intent intent = getIntent();

        Resources res = getResources();
        Food_array = res.getStringArray(R.array.Food_array);


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

                lx=22.29993;
                ly=73.221326;
                destination="Bhai Bhai Dabeli,Vadodara";
                break;

            case 1:

                lx=22.295694;
                ly=73.198259;


                destination="Jay Mahakali Sevusal,Vadodara";
                break;

            case 2:

                lx=22.320850;
                ly=73.159147;
                destination="Jay Mahakali Sevusal,Vadodara";
                break;

            case 3:

                lx=22.323044;
                ly=73.187815;
                destination="Tasty Vadapav,Vadodara";
                break;

            case 4:

                lx=22.311118;
                ly=73.168362;
                destination="Vishal Sandwich,Vadodara";
                break;

            case 5:

                lx=22.32132;
                ly=73.18835;
                destination="Da Vintage,Vadodara";
                break;
            case 6:

                lx=22.301888;
                ly=73.166046;

                destination="Da Vintage,Vadodara";
                break;

            case 7:

                lx=22.320816;
                ly=73.188409;

                destination="Neelkanth Juice Parlour,Vadodara";
                break;

            case 8:

                lx=22.293458;
                ly=73.23006;

                destination="Keshav Kutir Pavbhaji,Vadodara";
                break;
            case 9:

                lx=22.301515;
                ly=73.238467;

                destination="Keshav Resturant,Vadodara";
                break;

            case 10:

                lx=22.304204;
                ly=73.229175;

                  destination="Anadi Khaman,Vadodara";
                break;

            case 11:

                lx=22.323417;
                ly=73.188052;

                destination="Hyderabadis,Vadodara";
                break;

            case 12:

                lx=22.309886;
                 ly=73.170328;
             destination="Paras Pan,Vadodara";
                break;

            case 13:
                lx=22.300752;
                ly=73.233886;
              destination="Anand Snacks,Vadodara";

        }




        for (int i = 0; i < 14; i++) {


            if (msg_int == i)
            {


                setTitle(tit[i]);
                tx.setText("" + Food_array[i]);
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
