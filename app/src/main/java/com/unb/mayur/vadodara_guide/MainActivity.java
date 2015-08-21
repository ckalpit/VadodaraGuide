package com.unb.mayur.vadodara_guide;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends FragmentActivity {

	private static final String TAG = MainActivity.class.getSimpleName();
    FragmentManager fm = getSupportFragmentManager();
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;
	
	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	private String[] mDrawerItmes;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mTitle = mDrawerTitle = getTitle();
		
		mDrawerItmes = getResources().getStringArray(R.array.drawer_titles);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);
		
		// set a custom shadow that overlays the main content when the drawer oepns
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,  GravityCompat.START);
		
		// Add items to the ListView
		mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, mDrawerItmes));
		// Set the OnItemClickListener so something happens when a 
		// user clicks on an item.
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
		
		// Enable ActionBar app icon to behave as action to toggle nav drawer
		getActionBar().setDisplayHomeAsUpEnabled(true);
	//	getActionBar().setHomeButtonEnabled(true);
		
		mDrawerToggle = new ActionBarDrawerToggle(
				this, 
				mDrawerLayout, 
				R.drawable.ic_drawer, 
				R.string.drawer_open, 
				R.string.drawer_close
				) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu
			}
			
			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu
			}
		};
		
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		
		// Set the default content area to item 0
		// when the app opens for the first time
		if(savedInstanceState == null) {
			navigateTo(0);
		}
	
	}
	
	/*
	 * If you do not have any menus, you still need this function
	 * in order to open or close the NavigationDrawer when the user 
	 * clicking the ActionBar app icon.
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

        if(mDrawerToggle.onOptionsItemSelected(item)) {


            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;


            }

            return super.onOptionsItemSelected(item);
//            return true;
        }

        switch (item.getItemId()) {
            case R.id.action_settings:

                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Being one of the largest cities of Gujarat, it is not easy to explore the glorious charm of Vadodara. \"Vadodara Guide\"- an application that serves as a guide to help you navigate across the city of Vadodara, providing you all details of Vadodara- from eateries to beautiful sites, from its history till city lifestyle!\n" +
                        "LINK:https://play.google.com/store/apps/details?id=com.unb.mayur.vadodara_guide";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Vadodara Guide");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));

              //  Toast.makeText(getApplicationContext(),"Item 1 Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_settings2:
               // Toast.makeText(getApplicationContext(),"Item 2 Selected",Toast.LEN
               // GTH_LONG).show();

               Intent i=new Intent(MainActivity.this,Help.class);
                startActivity(i);
                return true;
            case R.id.action_settings3:
               // Toast.makeText(getApplicationContext(),"Item 3 Selected",Toast.LENGTH_LONG).show();

                Intent ii=new Intent(MainActivity.this,About_app.class);
                startActivity(ii);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }





	}
	
	/*
	 * When using the ActionBarDrawerToggle, you must call it during onPostCreate()
	 * and onConfigurationChanged()
	 */
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}
	
	private class DrawerItemClickListener implements OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			Log.v(TAG, "ponies");
			navigateTo(position);
		}
	}
    Fragment fragment;
	private void navigateTo(int position) {
		Log.v(TAG, "List View Item: " + position);
		
		switch(position) {
		case 0:
			/*getSupportFragmentManager()
				.beginTransaction()
				.add(R.id.content_frame, 
						ItemOne.newInstance(),
						ItemOne.TAG).commit();*/
			getSupportFragmentManager()
				.beginTransaction()
				.replace(R.id.content_frame, TabbedActivity.newInstance(), TabbedActivity.TAG).commit();
			break;

     /*      case 6:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame,
                                abt_.newInstance(),
                                abt_.TAG).commit();
                break;
*/
            case 5:
     /*           abt_ dFragment = new abt_();
                // Show DialogFragment
                dFragment.show(fm, "Dialog Fragment");
       */

                startActivity(new Intent(this,Help.class));
                break;

            case 6:
/*			getSupportFragmentManager()
				.beginTransaction()
				.replace(R.id.content_frame,
						H_T_R_.newInstance(),
						H_T_R_.TAG).commit();
*/

                startActivity(new Intent(this,About_app.class));

                break;


            case 3:
/*                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame,
                                Stay.newInstance(),
                                Stay.TAG).commit();
  */

                startActivity(new Intent(this,HoW_t_R.class));
                break;


            case 2:/*
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame,
                                Abt_Vdr_.newInstance(),
                                Abt_Vdr_.TAG).commit();
               */

                startActivity(new Intent(this,History.class));
                break;

            case 4:
 /*               getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame,
                                Sightseeing.newInstance(),
                                Sightseeing.TAG).commit();
*/
                startActivity(new Intent(this,Feedback.class));
                break;



            case 1:


                startActivity(new Intent(this,About_vadodara.class));
                break;


        }
        mDrawerLayout.closeDrawer(mDrawerList);
	}
	
	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ho_w_t__r, menu);
        return true;
    }



}
