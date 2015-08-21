package com.unb.mayur.vadodara_guide;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.os.Handler;


public class Splash extends Activity {
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 2000;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        try {
            super.onCreate(savedInstanceState);


            //      ActionBar actionBar = getSupportActionBar();
             //    actionBar.hide();


//            android:theme="@android:style/Theme.Holo.Light.NoActionBar.Fullscreen"


            setContentView(R.layout.activity_splash);

/*
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
*/
//        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
            //       getActionBar().hide();


            //  getActionBar().hide();

            //    ActionBar actionBar=getActionBar();
            //   actionBar.hide();

            new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

                @Override
                public void run() {
                    // This method will be executed once the timer is over
                    // Start your app main activity
                    Intent i = new Intent(Splash.this, MainActivity.class);
                    startActivity(i);

                    // close this activity
                    finish();
                }
            }, SPLASH_TIME_OUT);


        }catch (Exception e) {
                // this is the line of code that sends a real error message to the
                // log
                Log.e("ERROR", "ERROR IN CODE: " + e.toString());
                // this is the line that prints out the location in
                // the code where the error occurred.
                e.printStackTrace();
            Toast.makeText(getApplicationContext(),
                                          "Click ListItem Number " , Toast.LENGTH_LONG)
                                         .show();



             //   return "ERROR_IN_CODE";
            }



    }

}