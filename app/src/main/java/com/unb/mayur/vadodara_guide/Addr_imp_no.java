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

public class Addr_imp_no extends Activity //implements View.OnClickListener{
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

        setContentView(R.layout.activity_addr_imp_no);

        switch(msg_int)
        {
            case 0:
                setTitle("Police Stations");
                Police();
                break;
            case 1:
                setTitle("Emergency Numbers");
                Emergency();
//                editTxt.setVisibility(View.GONE);
                break;

            case 2:
                setTitle("Pincodes");
                Post_code();
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

    private void Post_code() {


        planetsList.add(new Planet("390001","Baranpura"));
        planetsList.add(new Planet("390001","Dandia Bazar"));
        planetsList.add(new Planet("390001","Jubilee Garden"));
        planetsList.add(new Planet("390001","Khanderao Market"));
        planetsList.add(new Planet("390001","Madanzampa"));
        planetsList.add(new Planet("390001","Mandvi"));
        planetsList.add(new Planet("390001","Nagarwada"));
        planetsList.add(new Planet("390001","Padmavati Chaugan"));
        planetsList.add(new Planet("390001","Vadodara Head office"));
        planetsList.add(new Planet("390002","Chhani Road"));
        planetsList.add(new Planet("390002","Fatehganj HeadOffice"));
        planetsList.add(new Planet("390002","Pratapganj"));
        planetsList.add(new Planet("390002","Sardarnagar Socity"));
        planetsList.add(new Planet("390003","Vadodara Chemical Industry"));
        planetsList.add(new Planet("390004","Pratapnagar Railway station "));
        planetsList.add(new Planet("390006","Harni Airport"));
        planetsList.add(new Planet("390006","Saantkanvar Colony"));
        planetsList.add(new Planet("390006","Fatepura"));
        planetsList.add(new Planet("390007","Alkapuri"));
        planetsList.add(new Planet("390007","GEB"));
        planetsList.add(new Planet("390007","Race Course"));
        planetsList.add(new Planet("390008","EME School"));
        planetsList.add(new Planet("390009","Sundarnagar"));
        planetsList.add(new Planet("390009","ONGC Colony"));
        planetsList.add(new Planet("390004","Makarpura Industry"));
        planetsList.add(new Planet("390011","Manjalpura Industrial Estate"));
        planetsList.add(new Planet("390011","Manjalpur"));
        planetsList.add(new Planet("390012","Atladra"));
        planetsList.add(new Planet("390013","Maneja"));
        planetsList.add(new Planet("390014","Makarpura"));
        planetsList.add(new Planet("390015","Vidyutnagar Colony"));
        planetsList.add(new Planet("390016","Gorwa Industry Estate"));
        planetsList.add(new Planet("390018","ID(Infectious disease) Hospital Road,Karelibaug"));
        planetsList.add(new Planet("390004","Ajwa Road,Waghodia Road"));
        planetsList.add(new Planet("390020","Akota, Sayajigunj"));
        planetsList.add(new Planet("390021","Gotri, TB Sanatorium"));
        planetsList.add(new Planet("390022","Harni Colony"));
        planetsList.add(new Planet("390023","Subhanpura"));
        planetsList.add(new Planet("390002","Chhani Road"));
        planetsList.add(new Planet("390025","Soma Talav"));
//        planetsList.add(new Planet("",""));
 //       planetsList.add(new Planet("",""));


    }

    private void Emergency() {


        planetsList.add(new Planet("100","Police Control Room"));
        planetsList.add(new Planet("108","Ambulance Service "));
        planetsList.add(new Planet("2427592","Disaster Helpline"));
        planetsList.add(new Planet("1090","Terror Helpline"));
        planetsList.add(new Planet("101","Fire Brigade"));
        planetsList.add(new Planet("1098","Helpline for Children"));
        planetsList.add(new Planet("1091","Helpline for Women "));
        planetsList.add(new Planet("2344618","Gas Emergency Service"));
        planetsList.add(new Planet("155333","Electricity General Complaints"));
        planetsList.add(new Planet("198","BSNL Landline Complaints "));
        planetsList.add(new Planet("9409027166","Vadodara Center for Animal rescue & Emergency "));
        planetsList.add(new Planet("6555552","vadodara Socity for Prevention of Cruelty to Animals"));



    }

    private void Police() {

        planetsList.add(new Planet("Jail Road\n\n:Police Bhavan, 1st Floor, Near Narmada Bhavan ,Jail Road, Vadodara HO, Vadodara - 390001, \n" +
                "+(91)-265-2431414, 2431515\n","Jail Road"));
        planetsList.add(new Planet("Jail Road \n\nJail Road, Vadodara HO, Vadodara - 390001\n" +
                "+(91)-265-2432020, 2414996\n","Jail Road"));
        planetsList.add(new Planet("Jail Road \n\n Near Central Jail , Vadodara - 390002,\n" +
                "2415111, 2415100, 100\n","Jail Road"));
        planetsList.add(new Planet("Near Narmada \n\n4th Floor, Police Bhavan, Jail Road, , Near Narmada Bhavan, Vadodara HO, Vadodara - 390001  +(91)-265-2432626","Narmada Bhavan "));
        planetsList.add(new Planet("Near Narmada \n\nPolice Bhavan, 4th Floor, Kothi, Near Narmada Bhavan, VADODARA - 390001, \n" +
                "+(91)-265-2432424\n" +
                "+(91)-265-2432582\n","Narmada Bhavan "));
        planetsList.add(new Planet("Raopura\n\n:Kothi Building, Raopura, Vadodara - 390001  +(91)-265-2459777","Raopura"));
        planetsList.add(new Planet("Raopura \n\nKothi Cross Road, Raopura,, Nr Khadigram Udhyog, Vadodara - 390001\n" +
                "+(91)-265-2459991\n","Raopura"));
        planetsList.add(new Planet("Raopura \n\nRaopura Main Road, Jubilee Baug, Near Jubliee Baug Garden, Vadodara - 390001,\n" +
                "+(91)-265-2423150\n","Raopura"));
        planetsList.add(new Planet("Mandvi \n\nMain Road, Mandvi, Nr State Bank Of India, Vadodara - 390001\n" +
                "+(91)-265-2561310, 2571211\n","Navapura"));
        planetsList.add(new Planet("Mandvi \n\nVadodara HO, Vadodara - 390001\n" +
                "+(91)-265-2562600\n","Mandvi"));
        planetsList.add(new Planet("Mandvi \n\nMain Road, Mandvi, Nr State Bank Of India, Vadodara - 390001\n" +
                "+(91)-265-2561310, 2571211\n","Mandvi"));
        planetsList.add(new Planet("Alkapuri \n\nMain Road, Alkapuri, Vadodara - 390007\n" +
                "+(91)-265-2352800\n","Alkapuri"));
        planetsList.add(new Planet("Bahucharaji \n\nBahucharaji Road, Vadodara - 390018\n" +
                "+(91)-265-2434550\n","Bahucharaji Road"));
        planetsList.add(new Planet("Gotri Road \n\nGotri Road, Opposite Machhi Market, Vadodara - 390021,\n" +
                "+(91)-265-2355090\n","Gotri Road"));
        planetsList.add(new Planet("Gotri Road \n\nMgvcl Gotri Ond M Circle Office, Gotri Road, Opposite Kalpavruksh Complex, Nr Gotri Circle, Vadodara - 390021\n" +
                "+(91)-265-2313222\n","Gotri Road"));
        planetsList.add(new Planet("Railway Station \n\nSayaji Ganj, Opposite Sayaji Ganj Railway Station, Vadodara - 390020\n" +
                "+(91)-265-2362400, 2361479\n","Railway Station"));
        planetsList.add(new Planet("Fateganj \n\nNava Road, Fateganj, Near TVS Showroom, Vadodara - 390002\n" +
                "+(91)-265-2771500, 2776722\n","Fateganj"));
        planetsList.add(new Planet("Sayaji Ganj \n\nMain Road, Sayaji Ganj, Sayaji Hospital , Vadodara - 390020,\n" +
                "+(91)-265-2426242\n","Sayaji Ganj"));
        planetsList.add(new Planet("Gorwa \n\nGorwa, Vadodara - 390016\n" +
                "+(91)-265-2281313\n","Gorwa"));
        planetsList.add(new Planet("Karelibaug \n\nKarelibaug, Near Bhutadi Zapa, Near Raymond Showroom Main Road, Vadodara - 390018,\n" +
                "+(91)-265-2432592, 2421468\n","Karelibaug"));
        planetsList.add(new Planet("Wadi \n\nWadi Vadodara, Near Gendigate Darwaja, , Vadodara - 390023\n" +
                "+(91)-265-2431400, 2424397\n","Wadi"));
        planetsList.add(new Planet("Panigate \n\nMain Road, Pani Gate, Near Panigate Darwaja, , Vadodara - 390019\n" +
                "+(91)-265-2562899\n","Pani Gate"));
        planetsList.add(new Planet("Manjalpur\n\nManjalpur, Vadodara - 390011\n" +
                "+(91)-265-2635856\n","Manjalpur"));
        planetsList.add(new Planet("Tandalja \n\nPatrkar Cross Road, J P Road, Tandalja, Vadodara - 390012\n" +
                "+(91)-265-2358132\n","Tandalja"));
        planetsList.add(new Planet("Chhani \n\nChhani, Near Sabji Mandi, Vadodara - 391740\n" +
                "+(91)-265-2773394\n","Chhani"));
        planetsList.add(new Planet("Ranoli Gaon \n\nJawahar Nagar, Near Ranoli Gaon, Nr G A C L, Vadodara - 391320\n" +
                "+(91)-265-2232382\n","Ranoli Gaon"));
        planetsList.add(new Planet("Ranoli Gaon \n\nSavli, Vadodara - 391121\n" +
                "+(91)-2663-244243\n","Ranoli Gaon"));
        planetsList.add(new Planet("Ranoli Gaon \n\nMakarpura, Near Baroda Dairy, Vadodara - 390014\n" +
                "+(91)-265-2651915, 2656000, 2637200\n","Ranoli Gaon"));
        planetsList.add(new Planet("Ranoli Gaon \n\nKishanwadi, Vadodara - 390022\n" +
                "+(91)-265-2510821\n","Ranoli Gaon"));
        planetsList.add(new Planet("Padra \n\nA-01, Choksi Bazaar, Station Road, Padra, Near Arpit Clinic, Vadodara - 391440","•\tPadra"));
        planetsList.add(new Planet("Padra \n\nPadra, Vadodara - 391440 \n" +
                "+(91)-2662-222333\n","Padra"));
        planetsList.add(new Planet("Miyagam Karjan \n\nMiyagam Karjan, Vadodara - 391240\n" +
                "+(91)-2666-232060\n","Miyagam Karjan"));
        planetsList.add(new Planet("Dabhoi \n\nDabhoi, Near Railway Station, Vadodara - 391110 \n" +
                "+(91)-2663-254800\n","Dabhoi"));
        planetsList.add(new Planet("Kavitha \n\nKavitha, Vadodara - 391125\n" +
                "+(91)-2665-254133\n","Kavitha"));
        planetsList.add(new Planet("Sankheda \n\nSankheda, Vadodara - 391145\n" +
                "+(91)-2665-243233\n","Sankheda"));
        planetsList.add(new Planet("Sinor \n\nSinor, Vadodara - 391115\n" +
                "+(91)-2666-264343\n","Sinor"));
        planetsList.add(new Planet("Naswadi \n\nNaswadi, Vadodara - 391150\n" +
                "+(91)-2661-272033\n","Naswadi"));
        planetsList.add(new Planet("Bodeli \n\nMain Road, Bodeli, Near Police Station, Vadodara - 391135\n" +
                "+(91)-2665-220333\n","Bodeli"));
        planetsList.add(new Planet("Pavijetpur \n\nPavijetpur, Vadodara - 391160\n" +
                "+(91)-2664-253333\n","Pavijetpur"));
        planetsList.add(new Planet("Chhota Udepur \n\nChhota Udepur, Vadodara - 391165\n" +
                "+(91)-2669-232068\n","Chhota Udepur"));
/*
*/
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