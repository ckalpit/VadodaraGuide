package com.unb.mayur.vadodara_guide;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

public class Addr_transport extends Activity //implements View.OnClickListener{
{
    // The data to show
    List<Planet> planetsList = new ArrayList<Planet>();
    PlanetAdapter aAdpt;
    ImageButton button ;
    String msg = " ";
    EditText  editTxt;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        button = (ImageButton)findViewById(R.id.btnSearch);

        Intent intent = getIntent();
        msg = intent.getStringExtra(Stay.EXTRA_MESSAGE);
        int msg_int = Integer.parseInt(msg);//typecast

        //  button.setOnClickListener(this);

        setContentView(R.layout.activity_addr_transport);

        switch(msg_int)
        {
            case 0:
                setTitle("Airlines Offices");
                Air_office();
                break;
            case 1:
                setTitle("Travels Agencies");
                Travel_Agency();
                break;

            default:

        }






        // We get the ListView component from the layout
        ListView lv = (ListView) findViewById(R.id.listView);


        //  ;


        // This is a simple adapter that accepts as parameter
        // Context
        // Data list
        // The row layout that is used during the row creation
        // The keys used to retrieve the data
        // The View id used to show the data. The key number and the view id must match
        //  aAdpt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, planetsList);
        aAdpt = new PlanetAdapter(planetsList, this);
        editTxt = (EditText) findViewById(R.id.editText);
        lv.setAdapter(aAdpt);

        // React to user clicks on item
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parentAdapter, View view, int position,
                                    long id) {


                // We know the View is a <extView so we can cast it
                //    TextView clickedView = (TextView) view;

                //      Toast.makeText(MainActivity.this, "Item with id [" + id + "] - Position [" + position + "] - Planet [" + clickedView.getText() + "]", Toast.LENGTH_SHORT).show();

            }
        });

        // we register for the contextmneu
        registerForContextMenu(lv);

        // TextFilter
        lv.setTextFilterEnabled(true);


        editTxt.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                System.out.println("Text [" + s + "] - Start [" + start + "] - Before [" + before + "] - Count [" + count + "]");
                if (count < before) {
                    // We're deleting char so we need to reset the adapter data
                    aAdpt.resetData();
                }

                aAdpt.getFilter().filter(s.toString());

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void Travel_Agency() {

        planetsList.add(new Planet("Fateganj\n\nGf - 13 Blue Dimond Complex Ground Floor, B/h Indian Petrol Pump, Fateganj, - 390002","Dipshal Travels"));
        planetsList.add(new Planet("Padra\n\n 102, Maryland Complex, Opp. Avishkar Complex, Nr Siddharth Palace Hotel, Old Padra Road, Old Padra Road, - 390012","Anahita Tours And Travels"));
        planetsList.add(new Planet("Sayaji Ganj\n\n 20 - Basement, Paradise Complex, Nr Havour Restuarent, Sayajigung Main Road, Sayaji Ganj, Vadodara - 390005","Sai Samarth Holidays"));
        planetsList.add(new Planet("Race Course\n\n 509 Race Course Tower, Beside Pasabhai Park, Race Rourse Main Toad, Race Course, Vadodara - 390007","Aadya Travels"));
        planetsList.add(new Planet("Race Course\n\n 504, 505 Siddharth Complex, Besides Express Hotel, Race Course Road, Alkapuri, Vadodara - 390007","Cinderella Travels"));
        planetsList.add(new Planet("Harni Road\n\n Gf 20 Dhanlaxmi Complex, Opposite Mangalya Hall Air Port Circle, Harni Road, Vadodara - 390006","Apoorv Travels"));
        planetsList.add(new Planet("Rajmahal Road\n\n 25 Vraj Siddhi Tower 2nd Floor, Nr Khanderao Market, Market Cross Road, Rajmahal Road, Vadodara - 390001","I Shop Tours And Travels"));
        planetsList.add(new Planet("Rajmahal Road\n\n Pushti, Nr Kirti Stambh, Rajmahal Road, Rajmahal Road, Vadodara – 390001","Alps Leisure Holidays Pvt Ltd"));
        planetsList.add(new Planet("Rajmahal Road\n\n Kirti Stambh Opposite Nehru Bhavan, Rajmahal Road, Vadodara - 390001","Lipi Tours And Travels"));

        planetsList.add(new Planet("Sama Savli Road \n\n5 Pruthviraj Complex, Next To Bank Of Baroda, New Sama Savli Road, Sama Road, Vadodara - 390002","Kaizen Tours And Travels"));
        planetsList.add(new Planet("Makarpura\n\n Firsh Floor 7 Silver Coin Complex, Bhavans School, Makarpura Road, Manjalpur, Vadodara - 390011","Ratnam Tours And Travels"));
        planetsList.add(new Planet("Manjalpur \n\n30/b Ghanshyam Nagar 2, Opp Saraswati Complex, Manjalpur, Vadodara - 390011","Sai Yogi Travels"));
        planetsList.add(new Planet("Makarpura \n\n243 Gidc, Makarpura Industrial Estate, Vadodara - 390010","Heer Communication"));
        planetsList.add(new Planet("Makarpura\n\n F 3 Priyadarshni Nagar Appartment, Opposite Novino Battery Susen Circle Makarpura Road, Makarpura Industrial Estate, Vadodara - 390010","Ideal Overseas Consultancy"));
        planetsList.add(new Planet("Diwalipura\n\n S1 B Nisarg Complex, Diwalipura, Vadodara - 390015","Travel Tantra"));
//        planetsList.add(new Planet("",""));
 //       planetsList.add(new Planet("",""));


    }

    private void Air_office() {

        planetsList.add(new Planet("Old Padra\n\n 101-102,Taksh paradigm,5,Charotar park socity,Old Padra road,ph.0265-2357183 , 5","Air India Booking Office"));
        planetsList.add(new Planet("Harni\n\n Harni Airport,ph 0265-2466625","Air India Booking"));
        planetsList.add(new Planet("Harni\n\nOpp. PNT Colony, Harni Road,ph. 0265-2492221","IndiGo Airlines Booking Office"));
        planetsList.add(new Planet("Alkapuri\n\n 111,Panorama building, Opp. Welcome Group Hotel,R.C Dutt Road, Alkapuri,ph.0265-2337051","Jet Airways Booking Office "));
        planetsList.add(new Planet("Harni\n\n Civil Airport, Harni Airport, Harni, ph.0265-2495080","Jet Airways Booking"));





    }


/*
    // Handle user click
    public void addPlanet(View view) {
        final Dialog d = new Dialog(this);
        d.setContentView(R.layout.dialog);
        d.setTitle("Add planet");
        d.setCancelable(true);

        final EditText edit = (EditText) d.findViewById(R.id.editTextPlanet);
        Button b = (Button) d.findViewById(R.id.button1);
    	b.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
			/	String planetName = edit.getText().toString();
				MainActivity.this.planetsList.add(new Planet(planetName, 0));
				MainActivity.this.aAdpt.notifyDataSetChanged(); // We notify the data model is changed
				d.dismiss();
			}
		});

//    	d.show();
    }
}

}

  */


    public void clear(View v) {


        editTxt.setText("");


    }
}