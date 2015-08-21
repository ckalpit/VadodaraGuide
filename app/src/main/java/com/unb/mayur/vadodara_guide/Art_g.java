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

public class Art_g extends Activity //implements View.OnClickListener{
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

        setContentView(R.layout.activity_art_g);

 //               Air_office();
             Art_GG();






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

    private void Art_GG() {

            planetsList.add(new Planet("Akota \n\n Spandan Complex, 2-Amrakunj Society, Opp Spring Velly Banglows,, Near Urmi Cross Road,Alkapuri, Vadodara, Gujarat 390007\n" +
                    "0265 232 6900\n","Kalanidhi"));
            planetsList.add(new Planet("Akota \n\n 187 Wing A, Radhakrishna Flat, Productivity Road, Akota, Near Akota Garden, Akota, Vadodara, Gujarat 390005\n" +
                    "Phone:099244 33483\n","Omkar art gallery"));
            planetsList.add(new Planet("Akota \n\n B/22, Shrinagar Society, Akota, Nr Urmy Cross Road, Akota, Vadodara - 390020 \n" +
                    "Vadodara, Gujarat\n","Myth Design"));
            planetsList.add(new Planet("ALKAPURI\n\n Spandan Complex, 2-Amrakunj Society, Opp Spring Velly Banglows,Near Urmi Cross Road,Alkapuri, Vadodara, Gujarat 390007","Kalanidhi"));
            planetsList.add(new Planet("ALKAPURI\n\n Gold corft, ground floor, opp only parathas, next to Indusind Bank & Trisha Gallery,\n" +
                    " ph-0265-2334514.\n","Kkalaveshh Gallery"));
            planetsList.add(new Planet("ALKAPURI\n\n Dak Bunglaw, Sayajigunj, Vadodara, Gujarat 390001\n" +
                    "Phone:0265 279 3801\n","Baroda Heritage Art Gallery  & Museum "));
            planetsList.add(new Planet(" ALKAPURI\n\n f17 national plaza rc dutt road alkapuri, Vadodara, Gujarat 390007\n" +
                    "Phone:076002 75196\n","Kashmir Art Palace"));
            planetsList.add(new Planet("ALKAPURI\n\n Alkapuri arcrade, opp.  Welcome Hotel, R.C.Dutt road\n" +
                    "Ph- 9898018228\n","Elegant Gallery"));
        planetsList.add(new Planet("ALKAPURI\n\n Mezanin floor, panorama,  r.c.dutt road,\n" +
                "Ph-0265-2321438\n","Artcore"));
        planetsList.add(new Planet(" ALKAPURI\n\n Hobby Centre, RC Dutt Rd, Niharika-1, Vishwas Colony, Alkapuri, Vadodara, Gujarat 390007\n" +
                "Phone:0265 233 8351\n","Sarjan Art Gallery"));
        planetsList.add(new Planet("ALKAPURI\n\n sb/35, widsor plaza, R.c. dutt road, alkapuri, vadodara, Vadodara, Gujarat 390005\n" +
                "Phone:0265 234 2335\n","Kala Gujari"));
        planetsList.add(new Planet("CHHANI ROAD\n\n OPP.Ambika nagar no.3,Nr.Narmada Canal,\n" +
                "Ph-0265-2771843\n","SPACE THE ARTISTS STUDIO"));
        planetsList.add(new Planet("Gorwa\n\n 188,Vrajbhumi Society Samta,Gorwa Road, Behind Pavan Dham,\n" +
                " ph-026502397040\n","Shivalay Art"));
        planetsList.add(new Planet("Chhani Jakat Naka\n\n Shop No.12, Radhika Residency, D. D Marg, Vadilal Cold Storage, Chhani Jakat Naka, Vadodara, Gujarat 390024\n" +
                "Phone:099985 36524\n","Looks The Art Gallery"));
        planetsList.add(new Planet("HARNI ROAD\n\n 38 Chandragupt Complex,Opp Nageshwar Mandir\n" +
                "Nr Vrundavan Township,\n" +
                "Harni Road , Vadodara\n","Dharmesh Art Gallery"));
        planetsList.add(new Planet("NYAY MANDIR \n\n Diwaji Chambers, Besides Reliance Web World, Dandia Bazar, \n" +
                "Ph-0265-65544889\n","Krishna Art Gallery"));
        planetsList.add(new Planet("OLD PADRA ROAD\n\n F 46/47 ,Earth Complex, Akshar Chowk,\n" +
                "Ph-9327566755 \n","The Mothers Art Exhibition Gallery"));
        planetsList.add(new Planet("VASNA ROAD\n\n 18A, Shivsakti Society, Nr. Shabri Vidhyalaya","ARTREE"));
        planetsList.add(new Planet("SAYAJIGUNJ\n\n 47, Paradise Complex,\n" +
                "Ph-0265-2351993\n","Harmony Arts"));
        planetsList.add(new Planet("SAYAJIGUNJ\n\n 203, Payal Complex, Nr. Stock Exchange Building,\n" +
                "Ph-0265-3926484\n","Allure Art Gallery"));
        planetsList.add(new Planet("RACE COURSE ROAD\n\n Shop no.7 & 8, K P Infinity,Next To TBZ, Opp. Yes Bank, Race COURCE,\n" +
                "Ph-0265-2351993\n","Hiya Gallery"));
        planetsList.add(new Planet("Alkapuri\n\n SB/6, Niharika, Behind Alkapuri Petrol, \n" +
                "Ph-0265-2395711\n","Gurjari Handicrafts"));
        planetsList.add(new Planet("3,Amrakunj Society, Behind Ellora Park,\n" +
                "Ph-0265-2395711\n","Rashika S Gallery"));
        planetsList.add(new Planet("2, Trupti Apartment, Patwa Estate,\n" +
                "Ph-9824841303 \n","Srujana Art"));
       // planetsList.add(new Planet("",""));
        //planetsList.add(new Planet("",""));
       // planetsList.add(new Planet("",""));
        //planetsList.add(new Planet("",""));


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