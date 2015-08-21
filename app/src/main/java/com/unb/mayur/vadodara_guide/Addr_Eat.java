package com.unb.mayur.vadodara_guide;

import android.os.Bundle;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

public class Addr_Eat extends Activity //implements View.OnClickListener{
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

        setContentView(R.layout.activity_addr__eat);





                Hotel();


           /* case 1:
                Local_food();
                break;

            case 2:
                Resturant();
                break;*/







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

    private void Resturant()
    {


        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));

    }

    private void Local_food() {

/*
        planetsList.add(new Planet("Alkapuri\n\n Ambedkar Circle ,Opp. Geb ,Alkapuri","Rajasthan kulfi house"));
        planetsList.add(new Planet("Alkapuri\n\n Alkapuri Arcade, RC Dutt Road ,Alkapuri","baskin robbins"));
        planetsList.add(new Planet("Alkapuri\n\n 3, Sheetal Apts., RC Dutt Road ,Alkapuri","rasanand"));
        planetsList.add(new Planet("Alkapuri\n\n SB/37, 49, Windsor Plaza, Alkapuri","paras paan"));
        planetsList.add(new Planet("Nizampura \n\n F-5, Sapphire 1, Daksha Colony, Opposite Jay Complex, Nizampura, Gujarat 390024, India\n" +
                " +91-265-2784179\n","Bhailal Shivlal"));
        planetsList.add(new Planet("Genda Circle \n\n Centre Square Mall, Kiosk No. 3, Ground Floor, Genda Circle ,In Centre Square Mall ,Wadai","Cookie Man"));
        planetsList.add(new Planet("Gotri Road \n\nNatubhai Center, Gotri Road, Race Course Circle ,Subhanpura","goodies cafeteria"));
        planetsList.add(new Planet("Gotri Road\n\n Gotri Road, Vadodara.","om garden restaurant"));
        planetsList.add(new Planet("Jetalpur\n\n Tapan Bldg. ,Beside M Cube ,Jetalpur Road","bread & more"));
        planetsList.add(new Planet("Ajwa Road \n\n D/14, Road No. 2, Sardar Estate, Ajwa Road, Vadodara, Gujarat 390019, India\n" +
                " +91-265-6455869 \n","Shree Gandhi Bakery/Mr. Puff"));
        planetsList.add(new Planet("Sayaji Gunj\n\n 2, Amin Nivas ,Sayaji Gunj","dairy den"));
        planetsList.add(new Planet("Fateganj\n\n Near M S University, Fateganj, Vadodara Gujrat 390002, India","Shere punjab dhaba"));
        planetsList.add(new Planet("Karelibaug\n\n Amit Nagar, Karelibaug, Vadodara, Gujarat, India","Neelkanth garden restaurant"));
*/



        planetsList.add(new Planet("Ayurvediv \n\nB-17 Sahajanand Apartment,Ayurvedic 3 Rasta,Outside Panigate,Vadodara-390019\n\n +91 9428978604\n\n www.bhaibhaidabeliwala.com\n\n Timing:11:00Am - 8:30Pm  ","Bhai Bhai Dabeli"));
        planetsList.add(new Planet("Ayurvediv \n\nB-17 Sahajanand Apartment,Ayurvedic 3 Rasta,Outside Panigate,Vadodara-390019\n +91 9428978604\n www.bhaibhaidabeliwala.com\n Timing:11:00Am - 8:30Pm  ","Bhai Bhai Dabeli"));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));



    }

    private void Hotel() {

        planetsList.add(new Planet("Sayaji Ganj \n\nRevival Lords Inn Hotel, Nr Kalaghoda Circle, Nr Sayaji Gardens, University Road, Sayaji Ganj, Vadodara - 390005","Revival Lords Inn Hotel"));
        planetsList.add(new Planet("Sayaji Ganj\n\nAmbassador Hotel, Nr Ambassador Sweet Mart, Sayaji Ganj, Vadodara - 390005","Ambassador Hotel"));
        planetsList.add(new Planet("Sayaji Ganj\n\n Hotel Sapphire, Nr, Suraj Plaza, Sayaji Ganj, Vadodara - 390005","Sapphire Regency"));
        planetsList.add(new Planet("Sayaji Ganj \n\nSayaji Ganj, Vadodara - 390005","Hotel Surya"));
        planetsList.add(new Planet("Dandia Bazar \n\nHotel Vrundavan Residency, Shiddhi Vinayak Mandir, Dandia Bazar Main Road, Dandia Bazar, Vadodara - ","Hotel Vrundavan Residency"));
        planetsList.add(new Planet("Alkapuri\n\n 14 Friends Co - Op Society, Opp. Alkapuri Gymkhana, Alkapuri, - 390007","Hotel Hilton S Hampton"));
        planetsList.add(new Planet("Alkapuri \n\n33, Sampatrao Colony, R.c. Dutt Road, Opp. Circuit House, Alkapuri, Vadodara - 390007","Hotel Grg"));
        planetsList.add(new Planet("Alkapuri \n\n18/19 Alkapuri Society, R C Dutt Road, Alkapuri, - 390007","Hotel Express Residency"));
        planetsList.add(new Planet("Mangal Bazar \n\nGita Nivas Lodge, Opposite Pratap Cinema, Sursager Road, Mangal Bazar, Vadodara - 390001","Gita Lodge"));
        planetsList.add(new Planet("Pratap Gunj \n\nOpp Rosary High School, Pratap Gunj, Vadodara - 390002","Tulsi Hotel"));
        planetsList.add(new Planet("Karelibaug \n\nDash Continental, Opp Bright School, V I P Main Road, Karelibaug, Vadodara - 390018","Dash Continental Hotel"));
        planetsList.add(new Planet("Padra Road \n\nMansi Chowkdi, Behind Gali, Old Padra Road, Vadodara - 390012","Yahvi Hotel"));
        planetsList.add(new Planet("Railway Station \n\nNext To Old Central Bus Depo Opp Railway Station, Vadodara, Vadodara - 390002","Gaurav Hotel"));
        planetsList.add(new Planet("Raopura \n\nNavrang Complex Compound, Dandia Bazar, Manekrao Road, Raopura, Vadodara - 390001","Utsav Hotel Pvt Ltd"));



    }


/*
    // We want to create a context Menu when the user long click on an item
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterContextMenuInfo aInfo = (AdapterContextMenuInfo) menuInfo;

        // We know that each row in the adapter is a Map
        Planet planet = aAdpt.getItem(aInfo.position);

        menu.setHeaderTitle("Options for " + planet.getName());
        menu.add(1, 1, 1, "Details");
        menu.add(1, 2, 2, "Delete");

    }

*/
    // This method is called when user selects an Item in the Context menu
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        AdapterContextMenuInfo aInfo = (AdapterContextMenuInfo) item.getMenuInfo();
        planetsList.remove(aInfo.position);
        aAdpt.notifyDataSetChanged();
        return true;
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