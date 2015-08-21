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

public class Addr_Health extends Activity //implements View.OnClickListener{
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

        setContentView(R.layout.activity_addr__health);

        switch(msg_int)
        {
            case 0:

                setTitle("Blood Banks");
                Blood_bank();
                break;

            case 1:
                setTitle("Hospitals");
               Hospitals();
                break;

            case 2:
                setTitle("Yoga Centers");
                Yoga();
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

    private void Yoga() {

        planetsList.add(new Planet("Old Padra \n\n Zaverchand Park, Old Padra Road, Vadodara – 390020","Sterling Health Mall"));
        planetsList.add(new Planet("Old Padra \n\n311, Abhishek Complex, Akshar Chowk, Old Padra Road, Vadodara – 390012","Mind Body Zone"));
        planetsList.add(new Planet("Old Padra 50 G/f Avishkar Complex, Beside Geb Colony, Old Padra Road, Vadodara - 390012","Life Spring Wellness Sevices"));
        planetsList.add(new Planet("Alkapuri \n\n25 Kunj Society, Alkapuri, Vadodara – 390007","Banyan Club"));
        planetsList.add(new Planet("Dandia Bazar \n\nShree Aurobindo Niwas, Dandia Bazar, Vadodara – 390001","Shree Aurobindo Memorial Trust"));
        planetsList.add(new Planet("Manjalpur \n\nPrushti, Vaishnodevi Shopping Centre, Opp Haridham Flat, Manjalpur Gidc Road, Manjalpur, Vadodara – 390011","10 The Health Spa"));
        planetsList.add(new Planet("Ajwa Road \n\n10 A Vinay Society, Nr Sardar Estate, Ajwa Road, Vadodara – 390019","Apex Institute Of Mind Energy"));
        planetsList.add(new Planet("Ajwa Road \n\n204 Pusti Smruti Apartment, Opp Suryanagar Bus Stop, Waghodia Road, Ajwa Road, Vadodara - 390019","Bodyline Slimming Centre"));
        planetsList.add(new Planet("Makarpura 2, Jay Mahalaxmi Park, Opp Hanuman Temple, Novino Tarsali Road, Makarpura, Vadodara – 390014","Aum Yoga Kendra"));
        planetsList.add(new Planet("Subhanpura \n\n322 Viswamohini Complex, Subhanpura, Vadodara – 390023","Brahma Nature Foundation"));
        planetsList.add(new Planet("Ellora Park \n\nC/11, Mayur Park 2, Opp Rameshwar Temple, Opp Madhav Tower, Ellora Park, Vadodara – 390023","Diva The Naturo Spa And Wellness Centre"));
        planetsList.add(new Planet("Race Course 22, Kalpana Society, B/h Narmada Guest House, Race Course, Vadodara - 390007","Inches Away"));
        planetsList.add(new Planet("Race Course H - 58, Kalindi Apartments, Pasha Bhai Park And Natubhai Centre, Race Course Road, Vadodara – 390007","Neetas Holistic Centre For Mind Body And Soul"));
        planetsList.add(new Planet("Udepur \n\nClub Road, Chhota Udepur, Vadodara - 391165","Patanjali Arogya Kendra"));
      // planetsList.add(new Planet("",""));
       // planetsList.add(new Planet("",""));







    }

    private void Hospitals() {
/*
        planetsList.add(new Planet("SANI ROAD \n\n Category: GENERAL HOSPITAL\n" +
                "Hospital Address: NARISAD COMPLEX OPP SANGAM BUSSTOP, SANI ROAD, \n" +
                "Pin Code :390022\n" +
                "Phone Number :0265-2483911\n","AMEE DEEP HOSPITAL"));
        planetsList.add(new Planet("ELLORA PARK\n\n Category: GENERAL HOSPITAL\n" +
                "Hospital Address: OPP. VIDYA VIKAS SCHOOL, SUBHANPURA ELLORA PARK.\n" +
                "Pin Code :390023\n" +
                "Phone Number :0265-2282111/2282112\n","BALAJI HOSPITAL A UNIT OF SHRI VHMRC PVT LTD"));
        planetsList.add(new Planet("ELLORA PARK\n\nCategory: GENERAL HOSPITAL\n" +
                "Hospital Address: PUSHTHI COMPLEX, HARIOM NAGAR BUS STOP, NR. ATMAJYOTI ASHRAM, ELLORA PARK,\n" +
                "Pin Code :380023\n" +
                "Phone Number :0265-2394264\n","PATANJALY HOSPITAL"));
        planetsList.add(new Planet("OLD PADRA ROAD \n\nCategory: GENERAL HOSPITAL\n" +
                "Hospital Address: NEAR TAGORE NAGAR, OLD PADRA ROAD, OPP SURYA KIRAN BUILDING.\n" +
                "Pin Code :390015\n" +
                "Phone Number :0265-2320404\n","BANKERS HEART INSTITUTE"));
        planetsList.add(new Planet("OLD PADRA ROAD \n\nCategory: SINGLE SPECIALITY CARDIAC\n" +
                "Hospital Address: # 44, HARIBHAKTI COLONY, OLD PADRA ROAD,\n" +
                "Pin Code :390007\n" +
                "Phone Number :0265-2322021,\n" +
                "Fax :0265-2351091\n","BARODA HEART INST.AND HEART CENTER"));
        planetsList.add(new Planet("OLD PADRA ROAD \n\nCategory: GENERAL HOSPITAL\n" +
                "Hospital Address: #7, MANISHA SOCIETY, OLD PADRA ROAD,\n" +
                "Pin Code :390020\n" +
                "Phone Number :0265-2252920/6532920\n" +
                "Fax :0265-22532630265-\n","SHREE VRAJ HOSPITAL"));
        planetsList.add(new Planet("RING ROAD\n\nCategory: NURSING HOME\n" +
                "Hospital Address: 112-116,CHATURBHAI PARK SANGAM WARASIA RING ROAD\n" +
                "Pin Code :390006\n" +
                "Phone Number :0265-2563066\n" +
                "Fax :0265-2530173\n","BATRA HOSPITAL"));
        planetsList.add(new Planet("RING ROAD\n\n Category: GENERAL HOSPITAL\n" +
                "Hospital Address: D-187/188/189,DAJI NAGAR SOC,HARNI WARASIYA RING ROAD\n" +
                "Pin Code :390006\n" +
                "Phone Number :0265-2569505/6994630\n" +
                "Fax :0265-2569505\n","KALAVATI HOSPITAL"));
        planetsList.add(new Planet("GORWA\n\nCategory: GENERAL HOSPITAL\n" +
                "Hospital Address: BHAILAL AMIN MARG GORWA\n" +
                "Pin Code :390003\n" +
                "Phone Number :0265-2285555/2282255\n" +
                "Fax :0265-2307097\n","BHAILAL AMIN GENERAL HOSPITAL"));
        planetsList.add(new Planet("SUBHANPURA MAIN ROAD\n\n Category: NURSING HOME\n" +
                "Hospital Address: ANJANA PARK COMPLEX,SUBHANPURA MAIN ROAD\n" +
                "Pin Code :390023\n" +
                "Phone Number :0265-2392954\n" +
                "Fax :0265-2392954\n","BHARUCHA HOSPITAL"));
        planetsList.add(new Planet("MANJALPUR\n\n Category: NURSING HOME\n" +
                "Hospital Address: DEVPUSHP COMPLEX TULSIDHAM CROSS ROAD, MANJALPUR\n" +
                "Pin Code :390011\n" +
                "Phone Number :0265-6562997\n" +
                "Fax :0265-2636591\n","DEVPUSHP MATERNITY & LAPROSCOPY HOSPITAL"));
        planetsList.add(new Planet("MANJALPUR\n\nCategory: GENERAL HOSPITAL\n" +
                "Hospital Address: 102, ABHISHEK HOUSE, OPP. TULSIDHAM APPT., MANJALPUR,\n" +
                "Pin Code :390011\n" +
                "Phone Number :0265-640030,644437\n","MANJALPUR HOSPITAL"));
        planetsList.add(new Planet("MANJALPUR\n\nCategory: GENERAL HOSPITAL\n" +
                "Hospital Address: INKH COMPLEX OPP. PARSHWA FLATS NR SITABAUG GROUND MANJALPUR\n" +
                "Pin Code :390011\n" +
                "Phone Number :0265-2656218/2645218\n","RUSHAB NURSING HOME"));
        planetsList.add(new Planet("SOMA TALAV\n\nCategory: NURSING HOME\n" +
                "Hospital Address: 2ND FLOOR NIVEDANAM COMPLEX,SOMA TALAV CHAR RASTA\n" +
                "Pin Code :390019\n" +
                "Phone Number :0265-3257598\n","DHANVANTARI HOSPITAL"));
        planetsList.add(new Planet("DANDIA BAZAR\n\nCategory: SINGLE SPECIALITY CARDIAC\n" +
                "Hospital Address: PRATAP ROAD,DANDIA BAZAR\n" +
                "Pin Code :390001\n" +
                "Phone Number :0265-2426112/2426543\n" +
                "Fax :0265-2436543\n","DR.B.R.PATEL HOSPITAL"));
        planetsList.add(new Planet("DANDIA BAZAR\n\nHospital Address: LAKDIPUL DANDIA BAZAR MAIN ROAD,DANDIA BAZAR.\n" +
                "Pin Code :390001\n" +
                "Phone Number :(0265)2432205\n","SAMIR HOSPITAL"));
        planetsList.add(new Planet("NIZAMPURA\n\nCategory: SINGLE SPECIALITY EYE\n" +
                "Hospital Address: 1, DEVDEEP COMPLEX, DELUX CROSS, NIZAMPURA ABOVE ICICI BANK\n" +
                "Pin Code :390002\n" +
                "Phone Number :0265-2783092/2786451\n" +
                "Fax :0265-2783397/2783456\n","DR.NUTAN SHAH EYE HOSPITAL& ADVANCED PHACO CENTRE"));
        planetsList.add(new Planet("NIZAMPURA\n\nCategory: GENERAL HOSPITAL\n" +
                "Hospital Address: NIZAMPURA MAIN ROAD, NEXT TO JAY COMPLEX,\n" +
                "Pin Code :390002\n" +
                "Phone Number :0265-2780504\n","MODI CLINIC"));
        planetsList.add(new Planet(" MAKARPURA\n\nCategory: GENERAL HOSPITAL\n" +
                "Hospital Address: MAKARPURA ROAD, KABIR COMPLEX, MR.DONBOSCH SCHOOL\n" +
                "Pin Code :390009\n" +
                "Phone Number :0265-2649602\n","GUPTA HOSPITAL"));
        planetsList.add(new Planet("GOTRI ROAD\n\nCategory: SINGLE SPECIALITY EYE\n" +
                "Hospital Address: ABOVE PARAMOUNT C T SCAN CENTRE, RACE COURSE- GOTRI ROAD, 1NOX ROAD\n" +
                "Pin Code :390007\n" +
                "Phone Number :0265-2397198\n" +
                "Fax :0265-2398251/2389576\n","I CARE HOSPITAL & PHACO CENTRE"));
        planetsList.add(new Planet("WAGHODIA ROAD \n\nCategory: GENERAL HOSPITAL\n" +
                "Hospital Address: UMA CROSS ROADS,WAGHODIA ROAD.\n" +
                "Pin Code :390019\n" +
                "Phone Number :0265-2515658/2512770\n" +
                "Fax :0265-2515658\n","KAKA HOSPITAL"));

        planetsList.add(new Planet("AKOTA STADIUM \n\n Category: SINGLE SPECIALITY UROLOGY\n" +
                "Hospital Address: 15, VINAYAK SOCIETY OPP SNDT SCHOOL BEHIND AKOTA STADIUM\n" +
                "Pin Code :390020\n" +
                "Phone Number :0265-2322463\n" +
                "Fax :0265-2427169\n","KAMATH KIDNEY & EYE HOSPITAL"));
        planetsList.add(new Planet("AKOTA STADIUM \n\n Category: GENERAL HOSPITAL\n" +
                "Hospital Address: 409-412, SHRINAGAR, AKOTA, VRMI CHAR RASTA\n" +
                "Pin Code :390020\n" +
                "Phone Number :0265-2356212\n" +
                "Fax :0265-2350640\n","SHUBHECHHA MULTISPECIALITY HOSPITALS PVT LTD"));
        planetsList.add(new Planet("AKOTA STADIUM \n\n PUNJAB NATIONAL BANK, SHRENIK PARK CROSS ROAD AKOTA\n" +
                "Pin Code :390015\n" +
                "Phone Number :0265-6535615\n" +
                "Fax :0265-2340351\n","VRAJ HOSPPITAL"));
        planetsList.add(new Planet("PADRA \n\n Category: NURSING HOME\n" +
                "Hospital Address: A-7,NARAYAN NAGAR SOCIETY,B/H NEW S.T DEPOT,PADRA\n" +
                "Pin Code :391440\n" +
                "Phone Number :02662-222135\n" +
                "Fax :02662-221218\n","KRISHNA SURGICAL HOSPITAL & TRAUMA CARE CENTRE"));
        planetsList.add(new Planet("RACE COUSE CIRCLE\n\n Category: GENERAL HOSPITAL\n" +
                "Hospital Address: 101/3,AKASHGANGA COMPLEX,RACE COUSE CIRCLE\n" +
                "Pin Code :390007\n" +
                "Phone Number :0265-2337172/2353670\n" +
                "Fax :0265-6623670\n","CENTRE FOR KNEE SURGERY"));
        planetsList.add(new Planet("RACE COUSE CIRCLE \n\n Category: MULTISPECIALITY HOSPITAL\n" +
                "Hospital Address: STERLING HOSPITAL,RACE COURSE CIRCLE WEST\n" +
                "Pin Code :390007\n" +
                "Phone Number :0265-2354455/66/88\n" +
                "Fax :0265-2352900\n","STERLING HOSPITAL"));
        planetsList.add(new Planet("RACE COUSE CIRCLE \n\n Category: GENERAL HOSPITAL\n" +
                "Hospital Address: RACECOURSE CIRCLE WEST,VADODARA.\n" +
                "Pin Code :390007\n" +
                "Phone Number :0265-2354455/66/88/\n" +
                "Fax :0265-2352900\n","UNITY HOSPITAL"));
        planetsList.add(new Planet("RAOPURA \n\n Category: GENERAL HOSPITAL\n" +
                "Hospital Address: OLD NAVARANG COMP OPP.OTEL UTSAV, RAOPURA. \n" +
                "Pin Code :390001\n" +
                "Phone Number :0265-2430254\n" +
                "Fax :0265-2430253\n","CHANDAN HOSPITAL"));
        planetsList.add(new Planet("RAOPURA \n\n Category: GENERAL HOSPITAL\n" +
                "Hospital Address: NIRALI CLINIC, B/17 MAHARANI SCHOOL, SURSAGAR, RAOPURA VADODARA\n" +
                "Pin Code :390001\n" +
                "Phone Number :9825025725\n","DEEP INTENSIVE AND CRITICAL CARE"));
        planetsList.add(new Planet("RAOPURA \n\n Category: GENERAL HOSPITAL\n" +
                "Hospital Address: SANTHA VASAHAT, PRAOPURA.\n" +
                "Pin Code :390001\n" +
                "Phone Number :0265-2412600\n" +
                "Fax :0265-2422955\n","KRISHNASHRAY HOSPITAL & ICU"));
        planetsList.add(new Planet("RAOPURA \n\n Category: NURSING HOME\n" +
                "Hospital Address: KASAR FALIYA, KOTHI RAOPURA, OPP.SSG HOSPITAL\n" +
                "Pin Code :390001\n" +
                "Phone Number :0265-2412242\n" +
                "Fax :0265-2412311\n","NAIK BURNS CENTRE PLASTIC SURGERY CANCER HOSPITAL"));
        planetsList.add(new Planet("RAOPURA \n\n Category: GENERAL HOSPITAL\n" +
                "Hospital Address: 1ST FLOOR, SANSTHA VASAHAT, RAOPURA\n" +
                "Pin Code :390001\n" +
                "Phone Number :0265-2431617/2458719\n" +
                "Fax :0265-2424008\n","NEUROSURGICAL HOSPITAL"));
        planetsList.add(new Planet("AJWA ROAD \n\nCategory: NURSING HOME\n" +
                "Hospital Address: A-8-9- SHREE HARI TOWNSHIP, AJWA ROAD\n" +
                "Pin Code :390019\n" +
                "Phone Number :0265-2510997\n" +
                "Fax :0265-2510997\n","MAA HOSPITAL"));
        planetsList.add(new Planet("JETALPUR ROAD \\n\\nCategory: GENERAL HOSPITAL\n" +
                "Hospital Address: LABH COMPLEX, JETALPUR ROAD, NEAR NEW INDIA MILL\n" +
                "Pin Code :390007\n" +
                "Phone Number :0265-2361894/2226472\n" +
                "Fax :0265-2361894\n","MAITRI HOSPITAL"));
        planetsList.add(new Planet("HARNI \n\nCategory: MULTISPECIALITY HOSPITAL\n" +
                "Hospital Address: HARNI-SAVLI ROAD, HARNI\n" +
                "Pin Code :390022\n" +
                "Phone Number :0265-2492525\n","METRO HOSPITAL & RESEARCH INSTITUTE"));
        planetsList.add(new Planet("ANANDPURA \n\nCategory: NURSING HOME\n" +
                "Hospital Address: SECOND FLOOR, HERAMB HOUSE, NEAR GOVT PRESS KOTHI, ANANDPURA\n" +
                "Pin Code :390001\n" +
                "Phone Number :0265-2414888/3294777\n","NIRMAL SURGICAL HOSPITAL"));
        planetsList.add(new Planet("PATEL PLAZA \n\n Category: NURSING HOME\n" +
                "Hospital Address: PATEL PLAZA,FIRST FLOOR\n" +
                "Pin Code :390015\n" +
                "Phone Number :0265-2326843/2333873\n" +
                "Fax :0265-2326843\n","RUTVIJ HOSPITAL"));
        planetsList.add(new Planet("ANGAN LALBAG ROAD BARODA \\n\\nCategory: GENERAL HOSPITAL\n" +
                "Hospital Address: 6F, CHANDRAKALA TOWER, B/H, ANGAN LALBAG ROAD BARODA.\n" +
                "Pin Code :380009\n" +
                "Phone Number :0265-2644133\n","SAMARPAN HOSPITAL"));
        planetsList.add(new Planet("RAILWAY STATION ROAD \n\n Category: GENERAL HOSPITAL\n" +
                "Hospital Address: NEAR CENTRAL S.T DEPOT, RAILWAY STATION ROAD\n" +
                "Pin Code :390002\n" +
                "Phone Number :0265-2793765/2794209\n" +
                "Fax :2794797\n","SANJIV HOSPITAL"));
        planetsList.add(new Planet("CHHANI \n\n Category: GENERAL HOSPITAL\n" +
                "Hospital Address: ABHISHEK SOE, OPP RAMAKAKA MANDIR,CHHANI.NEAR GEB NATIONAL HIGHWAY NO 8 BARODA\n" +
                "Pin Code :391740\n" +
                "Phone Number :0265-2760599/2776952\n" +
                "Fax :0265-2772201\n","SHREEJI HOSPITAL AND TRAUMA CENTRE"));
        planetsList.add(new Planet("CHHANI \n\n Category: NURSING HOME\n" +
                "Hospital Address: 110,1ST FLOOR,YAKSHSHREE COMPLEX,CHHANIJAKAT NAKA\n" +
                "Pin Code :390002\n" +
                "Phone Number :0265-3014948/2776999\n" +
                "Fax :0265-2761781\n","VRAJ HOSPITAL PVT LTD"));
        planetsList.add(new Planet("SUBHANPUR \n\n Category: NURSING HOME\n" +
                "Hospital Address: UTANG,ANANDVAN COMPLEX,NEW IPCL ROAD,SUBHANPUR\n" +
                "Pin Code :390023\n" +
                "Phone Number :0265-2395055\n" +
                "Fax :0265-2397624\n","SHREENATH HOSPITAL"));
        planetsList.add(new Planet("RAGHODIA ROAD \n\n Category: GENERAL HOSPITAL\n" +
                "Hospital Address: 12 MANAR SOIL, RAGHODIA ROAD, SURYANAGAR BUS STAND, RAGHODIA ROAD, \n" +
                "Pin Code :390019\n" +
                "Phone Number :0265-460678/462188\n","UDAY CLINIC"));
        planetsList.add(new Planet("PRATIBHA ROAD \n\nCategory: GENERAL HOSPITAL\n" +
                "Hospital Address: ARMI SOUTHERN ,DHANYA BAZAR, PRATIBHA ROAD, OPP MH LOGIN\n" +
                "Pin Code :390001\n" +
                "Phone Number :0265-2439190/5591848\n" +
                "Fax :0265-2414160\n","URJA BURNS CENTRE"));
        planetsList.add(new Planet("SULTHANPUR \n\n Category: NURSING HOME\n" +
                "Hospital Address: 2,SUNIKETAN PARK,SAMATA SOCIETY,SULTHANPUR\n" +
                "Pin Code :390023\n" +
                "Phone Number :0265-2395476\n" +
                "Fax :0265-2395476\n","YOGESHWAR HOSPITAL"));
        planetsList.add(new Planet("Pratap Nagar \n\nCategory: Children's and Pediatric Hospital\n" +
                "Hospital Address: D/2, Sarang Duplex, Sindhwai Mata Road, Pratap Nagar, Baroda\n" +
                "Pin Code: 395004\n" +
                "\n" +
                "Phone Number: 02652635600\n","Aashirvad Super Specialty Children's Hospital"));


*/

        planetsList.add(new Planet("Akota \n\n2 Krishna Shantis Society, Akota Main Road Vadodara - 390020\n" +
                "2414959\n","Aashirvad Hospital"));
        planetsList.add(new Planet("Gotri Road\n\nGotri Road, Race Course Circle, \n" +
                "Vadodara - 390007\n" +
                "2344137\n","Adarsh General Hospital"));
        planetsList.add(new Planet("Alkapuri \n\n51 Sampatrao Colony, \n" +
                "Alkapuri, Vadodara - 390005\n" +
                "2312875\n","Ami Surgical Hospital"));
        planetsList.add(new Planet("WAGHODIA ROAD \n\nCategory: GENERAL HOSPITAL\n" +
                "Hospital Address: UMA CROSS ROADS,WAGHODIA ROAD.\n" +
                "Pin Code :390019\n" +
                "Phone Number :0265-2515658/2512770\n" +
                "Fax :0265-2515658\n","KAKA HOSPITAL"));
        planetsList.add(new Planet("Near Jain Mandir Road \n\n3 Ashapuri Society, Near Jain Mandir Road Vadodara - 390020\n" +
                "2337895\n","Amish Plastic Surgical Hospital"));
        planetsList.add(new Planet("Raopura \n\nMasjid Pratap Road, Opp Depali Store Raopura, Vadodara -390001\n" +
                "2434241\n","Anil Hospitals"));
        planetsList.add(new Planet("Fatehgunj \n\n1-A Biren Apartments, Above Punjab National Bank, Fatehgunj, Vadodara - 390002\n" +
                "2791637\n","Anjali Memorial Hospital"));
        planetsList.add(new Planet("Fatehgunj \n\n1-A Biren Apartments, Above Punjab National Bank, Fatehgunj, Vadodara - 390002\n" +
                "2791637\n","Ankur Children Hospital"));
        planetsList.add(new Planet("Manjalpur \n\n101 Pratap Tower, Behind Angan Tower Manjalpur, Vadodara - 390011\n" +
                "2651778\n","Anmol Hospital"));
        planetsList.add(new Planet("Fatehgunj \n\nFirdosh Apartment, Fatehgunj Main Road Fatehgunj, Vadodara – 390002\n" +
                "2792121\n" +
                "2425580\n","Anuja Hospital"));
        planetsList.add(new Planet("Jetalpur Road \n\n12 Shriniketan Society, Opp New India Mill Jetalpur Road, Vadodara - 390005\n" +
                "2332727\n","Ashutosh Orthopaedic Hospital"));
        planetsList.add(new Planet("Karelibaug\n\n110, Konark Complex, Water Tank Road, Karelibaug, Vadodara – 390018\n" +
                "2486356\n","Astha Hospital"));
        planetsList.add(new Planet("M.G.Road \n\nShamal Bechar Pole, M.G.Road, \n" +
                "Vadodara - 390001\n" +
                "2413260\n","B.M.Parikh Foundation Trust"));
        planetsList.add(new Planet("M.G.Road \n\n57 Maikrupa Society, Mental Hospital Road Karelibaug, Vadodara - 390006\n" +
                "2429320\n","Baba Orthopaedic Hospital"));
        planetsList.add(new Planet("Old Padra Road \n\n44 Haribhakti Colony, Old Padra Road, Vadodara – 390007\n" +
                "2325444\n","Baroda Heart Institute & Research Centre"));
        planetsList.add(new Planet("Raopura\n\nDeepak Chambers, Nawabwada, Raopura, Vadodara – 390001\n" +
                "2429262\n","Baroda Hospital"));
        planetsList.add(new Planet("Ring Road\n\n112 Chaturbhai Park, Ring Road, \n" +
                "Vadodara - 390006\n" +
                "2563066\n","Batra Hospital"));
        planetsList.add(new Planet("Gorwa \n\nBhailal Amin Road, Gorwa, \n" +
                "Vadodara - 390003\n" +
                "2280300\n","Bhailal Amin General Hospital"));
        planetsList.add(new Planet("Makarpura \n\nMadhavbaug Shopping Centre, \n" +
                "Makarpura Road, Vadodara - 390009\n" +
                "2651715\n","Bharaney Hospital"));
        planetsList.add(new Planet("Akota \n\nA/10 Shrenik Park, Opp Jain Temple, Akota, Vadodara - 390020\n" +
                "2355998\n","Chandan Charitable Hospital"));
        planetsList.add(new Planet("Gorwa\n\nAmbica Complex, Gorwa Refinery Road, Gorwa, Vadodara - 390016\n" +
                "2281033\n","Children & Dental Hospital"));
        planetsList.add(new Planet("Raopura\n\nMahajan Gali, Raopura, \n" +
                "Vadodara - 390001\n" +
                "2427255\n","Chintamani Orthopaedic Hospital"));
        planetsList.add(new Planet("Akota\n\n5A, White House, Tarang Society, Akota, Vadodara - 390020\n" +
                "2331691\n","Chintu Children Hospital"));
        planetsList.add(new Planet("R.V.Desai Road\n\nR.V.Desai Road, Opp Gangotri Apartments, Vadodara - 390001\n" +
                "2420510\n","Daya Madhav Hospital"));
        planetsList.add(new Planet("Gotri\n\nGotri Road, Opposite Basera Flats, \n" +
                "Vadodara - 390021\n" +
                "2331692\n","Dhara Hospital"));
        planetsList.add(new Planet("VIP Road\n\n1st Floor, Balaji Shopping Centre, VIP Road, Vadodara - 390018\n" +
                "2443519\n","Doshi Orthopaedic Hospital"));
        planetsList.add(new Planet("Urmi Char Rasta\n\n8-A Urmi Society, Productivity Road, \n" +
                "Urmi Char Rasta, Vadodara - 390005\n" +
                "2335506\n","Dr.Kadam's Eye Hospital & Institute"));
        planetsList.add(new Planet("Raopura\n\nRadha, Near Sardar Bhavan, Raopura, \n" +
                "Vadodara - 390001\n" +
                "2420374\n","Drashti Eye Hospital"));
        planetsList.add(new Planet("Race Course\n\nGround Floor, Indraprasth, Race Course, Vadodara - 390007\n" +
                "2334412\n","Eye Hospital"));
        planetsList.add(new Planet("Near Gorwa Police Station, \n" +
                "Opp Alembic Nagar, Vadodara - 390016\n" +
                "2280299\n","Gorwa Hospital"));
        planetsList.add(new Planet("Makarpura \n\nKabir Complex, Makarpura Road, \n" +
                "Near Don Bosco School, \n" +
                "Vadodara - 390010\n" +
                "2649602\n","Gupta Hospital"));
        planetsList.add(new Planet("Sant Kabir Road\n\nVittaldas Chambers, Sant Kabir Road Vadodara – 390001\n" +
                "2439164\n","Harsic Children Hospital"));
        planetsList.add(new Planet("Fatehgunj\n\n22, 2nd Floor, The Emperor, Fatehgunj, Vadodara - 390002\n" +
                "2700707\n","Holistic Health Clinic & Research Centre"));
        planetsList.add(new Planet("Gotri\n\nGotri Road, Race Course Circle, \n" +
                "Above Paramount CT Scan Centre, \n" +
                "Vadodara - 390007\n" +
                "2397198\n","I Care Hospital & Phaco Centre"));
        planetsList.add(new Planet("Karelibaug\n\nOpposite Sadhana Nagar, Karelibaug, Vadodara - 390018\n" +
                "2429800\n","I.D.Hospital"));
        planetsList.add(new Planet("Uma Char Rasta\n\nWaghodia Road, Uma Char Rasta, \n" +
                "Vadodara – 390019\n" +
                "2519151\n","Indrapuri Hospital"));
        planetsList.add(new Planet("WAGHODIA ROAD \n\n Category: GENERAL HOSPITAL\n" +
                "Hospital Address: 1ST FLOOR, ADITYA PLAZA, NEAR ZAVERNAGAR BUS STOP WAGHODIA ROAD \n" +
                "Pin Code :390019\n" +
                "Phone Number :0265-2570570\n" +
                "Fax :0265-2524716\n","SAMARPAN HOSPITAL"));
        planetsList.add(new Planet("Dandia Bazar\n\nKala Bhavan, Dandia Bazar, \n" +
                "Vadodara - 390001\n" +
                "2431396\n","Jasuben Hospital"));
        planetsList.add(new Planet("Gorwa\n\n204 Ambica Complex, Gorwa Refinery Road, Vadodara - 390016\n" +
                "2281033\n","Jeevan Jyot Children Hospital"));
        planetsList.add(new Planet("Old Padra Road\n\nMaryland Complex, Old Padra Road, Vadodara - 390015\n" +
                "2334304\n","Jyoti Hospital"));
        planetsList.add(new Planet("Karelibaug\n\nJalaram Marg, Karelibaug, \n" +
                "Vadodara - 390018\n" +
                "2462404\n","K.G.Patel Children Hospital"));
        planetsList.add(new Planet("Warashiya Ring Road\n\nChaturbhai Park, Warashiya Ring Road, \n" +
                "Opposite Rajdhani Society, \n" +
                "Vadodara - 390006\n" +
                "2569505\n","Kala Surgical Hospital"));
        planetsList.add(new Planet("Raopura\n\nKamal Manik Rao Road, \n" +
                "Opposite Union Bank Of India, Raopura, \n" +
                "Vadodara - 390001\n" +
                "2427733\n","Kamal Hospital"));
        planetsList.add(new Planet("Natubhai Centre\n\nOverseas Avenue, Near Natubhai Centre, Vadodara - 390007\n" +
                "2398131\n","Kapilaben Cancer Centre"));
        planetsList.add(new Planet("Dandia Bazar\n\n2nd Floor Sumangal Chamber, Kharivav Road, Dandia Bazar, Vadodara - 390001\n" +
                "2422555\n","Kidney Care Hospital"));
        planetsList.add(new Planet("Race Course Circle\n\nAnuradha Complex, Near Police Chowki, Race Course Circle, Vadodara - 390007\n" +
                "2281501\n","Killol Children Hospital"));
        planetsList.add(new Planet("Raopura\n\nSanstha Vasahat, Raopura, \n" +
                "Vadodara - 390001\n" +
                "2352888\n","Krishna Shray Hospital"));
        planetsList.add(new Planet("Raopura\n\nSanstha Vasahat, Pratap Road Raopura, Vadodara - 390001\n" +
                "2421011\n","Mahi Hospital"));
        planetsList.add(new Planet("Sayajigunj\n\nOpp Purohit Apartments, Near Rainbow Hotel Sayajigunj, Vadodara - 390005\n" +
                "2361894\n","Maitri Hospital"));
        planetsList.add(new Planet("Subhanpura\n\nNear Sitram Apartments, Subhanpura, Vadodara - 390007\n" +
                "2397253\n","Manusmriti Poly Clinic Hospital"));
        planetsList.add(new Planet("Koth\n\nOpposite Khadi Gram Kothi, \n" +
                "Vadodara - 390001\n" +
                "2432322\n","Mehta Eye Hospital"));
        planetsList.add(new Planet("Karelibaug\n\nKarelibaug, \n" +
                "Vadodara - 390018\n" +
                "2411493\n","Mental Hospital"));
        planetsList.add(new Planet("Dandia Bazar\n\nAnshira Apartments, Kharivav Road, \n" +
                "Dandia Bazar, Vadodara - 390001\n" +
                "2322748\n","Mona Eye Hospital"));
        planetsList.add(new Planet("Gorwa\n\n7 Chitrakut Flat, Opposite Alembic Nagar Gorwa, Vadodara - 390016\n" +
                "2282308\n","Netra Deep Eye Hospital"));
        planetsList.add(new Planet("Ellora Park\n\n3 Tarun Co-Op Society, Ellora Park, Vadodara - 390007\n" +
                "2396200\n","New Ashish Hospital"));
        planetsList.add(new Planet("Old Padra Road\n\n203, Silver Plaza, Old Padra Road, \n" +
                "Vadodara - 390020\n" +
                "2313017\n","Niramaya Hospital"));
        planetsList.add(new Planet("Raopura\n\nAnand Pura, Near Government Press, Raopura, Vadodara - 390001\n" +
                "2414888\n","Nirmal Surgical Hospita"));
        planetsList.add(new Planet("Gotri\n\n10, Ramtirth Society, Near Esis Hospital, Gotri, Vadodara - 390015\n" +
                "2340254\n","Omkar Hospital"));
        planetsList.add(new Planet("Fatehgunj\n\nFatehgunj Main Road, Fatehgunj, \n" +
                "Vadodara - 390002\n" +
                "2795484\n","Our Lady Of Pillar Hospital"));
        planetsList.add(new Planet("Nizampura\n\nArpan Complex, Nizampura Main Road, Vadodara - 390002\n" +
                "2782828\n","Param Orthopaedic Hospital"));
        planetsList.add(new Planet("R.V.Desai Road\n\n101 Gangotri Apartments, R.V.Desai Road, Vadodara - 390004\n" +
                "2421740\n","Pinku Child Hospital"));
        planetsList.add(new Planet("Old Padra Road\n\nMaryland Complex, Old Padra Road, Vadodara - 390015\n" +
                "2350143\n","Prahel Urology Hospital"));
        planetsList.add(new Planet("Old Padra Road\n\nAkshar Chowk, Old Padra Road, \n" +
                "Vadodara - 390015\n" +
                "2332232\n","Pramukhswami Hospital"));
        planetsList.add(new Planet("Dandia Bazar\n\nNear Bumiya Dary, Dandia Bazar, \n" +
                "Vadodara - 390001\n" +
                "2418970\n","Raghuvir Hospital"));
        planetsList.add(new Planet(" Raopura\n\nSanstha Vasahat, Raopura, \n" +
                "Vadodara - 390001\n" +
                "2412379\n","Rahat Hospital"));
        planetsList.add(new Planet("New Sama\n\n1st Floor, Near Abhilasha Char Rasta, \n" +
                "New Sama, Vadodara - 390008\n" +
                "2793205\n","Ridd Children Hospital"));
        planetsList.add(new Planet("Alkapuri\n\nR.C.Dutt Road, Alkapuri, \n" +
                "Vadodara - 390005\n" +
                "2322033\n","Rituma Hospital"));
        planetsList.add(new Planet("Old Padra Road\n\n61/62 1st Floor, Surya Kiran Complex, \n" +
                "Old Padra Road, Vadodara - 390015\n" +
                "2340266\n","Roshni Eye Hospital"));
        planetsList.add(new Planet("Nizampura\n\nNilkanthvarni Apartments, Abhilasha Road, Near Bhadranagar, Nizampura, \n" +
                "Vadodara - 390008\n" +
                "2785914\n","Sadhbavana Hospital"));
        planetsList.add(new Planet("Madanzampa\n\nAmardeep Apartments, Madanzampa, Vadodara - 390001\n" +
                "2412431\n","Sadhu Vaswani Mission"));
        planetsList.add(new Planet("Akota/n/n1/17 Professional Plaza, Punit Nagar Society, 17 Old Padra Road, Akota, \n" +
                "Vadodara - 390020\n" +
                "2353553\n","Sagar Hospital"));
        planetsList.add(new Planet("Gorwa\n\nRefinery Road, Gorwa Industrial Estate Vadodara - 390016\n" +
                "2380201\n","Sahayog Surgical Hospital"));
        planetsList.add(new Planet("Manjalpur\n\nTriveni Flats, Behind Vrajdham Temple, Manjalpur, Vadodara - 390011\n" +
                "2648569\n","Sahprem Children Hospital"));
        planetsList.add(new Planet("Alkapuri\n\n63 Urmi Society, Productivity Road, Alkapuri, Vadodara - 390007\n" +
                "2332651\n","Sai Smruti Hospital"));
        planetsList.add(new Planet("Manalpur Road\n\nJyoti Apartment, Opposite Angan Tower, Manalpur Road, Vadodara - 390009\n" +
                "2651965\n","Saikrupa Hospital"));
        planetsList.add(new Planet("Lal Baug Road\n\nLal Baug Road, Behind Angan Tower, Vadodara - 390004\n" +
                "2641488\n","Samarpan Hospital"));
        planetsList.add(new Planet("Kharivav Road\n\n101 Hariom Chambers, Kharivav Road, Vadodara - 390001\n" +
                "2412388\n","Samarpan Surgical Hospital"));
        planetsList.add(new Planet("Race Course\n\n41/251 New Ellora Park, Race Course, Vadodara - 390007\n" +
                "2396215\n","Sanjivani Eye Hospital"));
        planetsList.add(new Planet("Dandia Bazar\n\nShri Ramway Plaza, Kharivav Road, \n" +
                "Dandia Bazar, Vadodara - 390001\n" +
                "2411539\n","Sankalp Hospital"));

        planetsList.add(new Planet("Raopura\n\nSanstha Vasahat, Raopura, \n" +
                "Vadodara - 390001" +
                "2412379\n","Sardar Patel Hospital"));


        planetsList.add(new Planet("Salatwada Road\n\nShivdhara Kothi, Opposite Union Bank, Salatwada Road, Vadodara - 390001\n" +
                "2424276\n","Sashwat Hospital"));
        planetsList.add(new Planet("Akota\n\n23 Shree Nagar Society, Productivity Road, Akota, Vadodara - 390020\n" +
                "2332424\n","Shabnam Eye Hospital"));
        planetsList.add(new Planet("Karelibaug\n\nPaniki Tanki, Near Harinagar Hospital, Karelibaug, Vadodara - 390018\n" +
                "2398081\n","Shivani Hospital"));
        planetsList.add(new Planet("J.N.Marg\n\nKismat Building, J.N.Marg, \n" +
                "Vadodara - 390001\n" +
                "2436644\n","Shree Maharani Shantadevi Hospital"));
        planetsList.add(new Planet("Raopura\n\n1st Floor, Pavandham Appartment, \n" +
                "Chittekhan Hanumans Lane, Raopura, \n" +
                "Vadodara - 390001\n" +
                "2428026\n","Shree Maruti Surgical & Trauma Hospital"));
        planetsList.add(new Planet("Fatehgunj\n\nNarayan Bhavan, Fatehgunj, \n" +
                "Vadodara - 390002\n" +
                "2794413\n","Shree Narhari Arogya Kendra"));
        planetsList.add(new Planet("Chhani\n\nRamakaka Road, Near Amin Nagar, Chhani, Vadodara - 390002\n" +
                "2760599\n","Shreeji Hospital"));
        planetsList.add(new Planet("Rajmahal Road\n\nRajmahal Road, Opposite K.H.Market, Vadodara - 390001\n" +
                "2334780\n","Shrey Nursing Hospital"));
        planetsList.add(new Planet("Pratap Nagar\n\nC/2 Tejal Appartment, Pratap Nagar, Vadodara - 390004\n" +
                "2435694\n","Shrikrishna Surgical Hospital"));
        planetsList.add(new Planet("Subhanpura\n\nAnandvan Complex, Gorwa Road, Subhanpura, Vadodara - 390023\n" +
                "2395055\n","Shrinath Hospital"));
        planetsList.add(new Planet("Fatehgunj\n\nBehind Kalyan Hotel, Fatehgunj, \n" +
                "Vadodara - 390002\n","Siddharth Hospital"));
        planetsList.add(new Planet("Subhanpura\n\nA-22 Ravi Complex, Subhanpura Main Road Vadodara - 390007\n" +
                "2390540\n","Sneh Children Hospital"));
        planetsList.add(new Planet("Dandia Bazar\n\nSumangal Chamber, Kharivav Road, \n" +
                "Dandia Bazar, Vadodara - 390001\n" +
                "2437001\n","Sujay Hospital"));
        planetsList.add(new Planet("Alkapuri\n\n9 Anand Society, Near Express Hotel, Alkapuri, Vadodara - 390007\n" +
                "2353034\n","Sundram Hospital"));
        planetsList.add(new Planet("105 Patel Plaza, \n" +
                "Gotri Road\\n\\nOpposite Hari Nagar Bus Stand, Gotri Road, Vadodara - 390015\n" +
                "2331836\n","Sunil Children Hospital"));
        planetsList.add(new Planet("Makarpura\n\n3 Deepkunj Society, Makarpura Road, Vadodara - 390009\n" +
                "2649833\n","Surbhi Hospital"));
        planetsList.add(new Planet("Rajmahal Road\n\nUday Bhavan, Near Radhakrishna Pole, Rajmahal Road, Vadodara - 390001\n" +
                "2410991\n","Surgical Hospital"));
        planetsList.add(new Planet("Productivity Road\n\n3A Tarang Society, Productivity Road Vadodara - 390020\n" +
                "2323548\n","Surusha Hospital"));
        planetsList.add(new Planet("Ellora Park\n\nEllora Park, Opposite Police Station, Vadodara - 390023\n" +
                "2281155\n","Suvidha Maternity Hospital"));
        planetsList.add(new Planet("Alkapuri\n\n11 Sampatrao Colony, R.C.Dutt Road, Opposite Circuit House, Alkapuri, \n" +
                "Vadodara - 390005\n" +
                "2331296\n","Uma Children Hospital"));
        planetsList.add(new Planet("Karelibaug\n\n24 Chandravali Society, Near Water Tank, Karelibaug, Vadodara - 390018\n" +
                "2445719\n","Urgita Hospital"));
        planetsList.add(new Planet("Nizampura\n\n14 Green Park, Opposite Jay Complex, Nizampura, Vadodara - 390002\n" +
                "2780300\n","Urmi Children Hospital"));
        planetsList.add(new Planet("Urmi Cahr Rasta\n\n23 Purshottam Bpc Road, Urmi Cahr Rasta Vadodara - 390005\n" +
                "2322049\n","Uro Care Hospital"));
        planetsList.add(new Planet("Manjalpur \n\nManjalpur, \n" +
                "Vadodara - 390011\n" +
                "2656381\n","Vallabh Arogya Mandir"));
        planetsList.add(new Planet("Harni\n\n4 Suhas Society, Harni Water Tank Road, Opposite Shastri School, \n" +
                "Vadodara - 390006\n" +
                "2444103\n","Varun Children Hospital"));
        planetsList.add(new Planet("Pani Gate\n\n1 Navnit Park, Pani Gate, \n" +
                "Vadodara - 390019\n" +
                "2561222\n","Vinayak Hospital"));
        planetsList.add(new Planet("Raopura\n\nSeva Sadan, Shiyapura, \n" +
                "Near Raopura Tower, \n" +
                "Vadodara - 390001\n" +
                "2426983\n","Vitson Orthosys"));
        planetsList.add(new Planet("Productivity Road\n\nSumant Park, Opposite Shrenik Park, Productivity Road, Vadodara - 390020\n" +
                "2354141\n","Vraj Children Hospital"));
        planetsList.add(new Planet("Chhani\n\nYakshshree Complex, Near Keya Motors Chhani Jakat Naka, Vadodara - 390002\n" +
                "2761781\n","Vraj Hospital (Polyclinic)"));
        planetsList.add(new Planet("Makarpura\n\nB-22 Nandigram Society, Vadsar Road, Makarpura, Vadodara - 390010\n" +
                "2651137\n","Yash Hospital & Maternity Home"));

      /*
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
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));
        planetsList.add(new Planet("",""));

*/

    }

    private void Blood_bank() {
        planetsList.add(new Planet("Karelibaug \n\nJalaram Temple Road, Karelibaug, Vadodara - 390018","Kashiben Gordhandas Patel Childrens Hospital"));
        planetsList.add(new Planet("Raopura \n\nKala Godha Circle, Opp Aradhana Cinema, Jail Road, Raopura, Vadodara - 390001","Shree Sayaji General Hospital"));
        planetsList.add(new Planet("Raopura\n\n Red Cross Building, Gpo, Opp Police Parade Ground, Raopura, Vadodara - 390001","Indian Red Cross Society"));
        planetsList.add(new Planet("Akota \n\n409/412, Shrinagar Society, Nr Urmi Cross Road, Off Productivity Road, Akota, Vadodara - 390020","Shubhechha Multispeciality Hospital"));

        planetsList.add(new Planet("Gorwa \n\nBhailal Amin Marg, Gorwa, Vadodara, Gujarat, Gorwa, Vadodara - 390016","Bhailal Amin General Hospital"));
        planetsList.add(new Planet("Rajmahal Road \n\nSsg Hospital, Nr Ward No 18, Rajmahal Road, Vadodara - 390001","Citizen Blood Bank"));
        planetsList.add(new Planet("Alkapuri\n\n 35, Sampatrao Colony, Alkapuri, Vadodara - 390007","Dr Monali Desai"));
        planetsList.add(new Planet("Kothi \n\nAnkodia, Sevasi, Kothi, Vadodara - 390001","Indu College Of Medical Science"));
        planetsList.add(new Planet("Kothi\n\n Vinraj Plaza, 3rd Floor, Opp Government Press, Kothi, Vadodara - 390001","Indu Voluntary Blood Bank"));
        planetsList.add(new Planet("Nizampura\n\n 16, 1st Flr, Devdeep Complex, Nizampura, Vadodara - 390002","Nidhi Laboratory"));
        planetsList.add(new Planet("Sayaji Ganj\n\n Blue Chip Complex, Behind Rajshree Talkies, Sayaji Ganj, Vadodara - 390005","Suraktam Blood Bank"));



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


    private void Aquarium(){
        // We populate the planets

        planetsList.add(new Planet("Alkapuri \n\n Upper Ground 13,Concorde Building, Alkapuri Main Road, Vadodara – 390007 +(91)-9879173005, 9737482836","Aqua Fauna Aquarium"));
        planetsList.add(new Planet("Alkapuri \n\n 5-A, Alkapuri Society, Alkapuri, VADODARA - 390007, Alkapuri +(91)-9825047295","Yash Aquarium"));
        planetsList.add(new Planet("Ajwa Road \n" +
                "\nShop No 4, Sudarshan Complex, Mahavir Hall Cross Road, Ajwa Road, Vadodara - 390019, Opposite Parivar School +(91)-9824019687, 9904736654","Aashish Aquarium"));
        planetsList.add(new Planet("Akota \n" +
                "\nSb/3 10 and Gf/27, Ground Floor Classic Building, Productivity Road, Akota, Vadodara - 390020, Opposite Akota Gardens+(91)-9898553858","Sagar Aquarium"));
        planetsList.add(new Planet("Chhani road \n" +
                "\n B5, manorath tenement ,tp 13,ph9898686948","South aquarium"));
        planetsList.add(new Planet("Vasna\n" +
                "\n Shop no 11 Devraj Complex, gotri road, Vasna, Vadodara - 391140, Near, Ward No 11 Beside Utkarash Vidhyalaya +(91)-9428066034","Om Pet Shop Aquarium"));
        planetsList.add(new Planet("Harni\n" +
                "\n B/131, Nathiba Nagar Society, Harni Road, Vadodara - 390006, Behind Harni Air Port +(91)-265-2489951, +(91)-9428975714","Patel Fish Farm"));
        planetsList.add(new Planet("Makarpura\n" +
                "\n 3, Rutushree Complex, Ground Floor, Manjalpur Road, Makarpura, Vadodara - 390014, Opp. IDBI Bank and Kabir Plaza +(91)-9825959676","World pet shop"));
        planetsList.add(new Planet("Makarpura\n" +
                "\n 35, Saraswati Complex, Gidc Road, Manjalpur, Vadodara - 390011, Nr Shantikunj Society, Opp Manjalpur Atithi Gruh +(91)-9824350010","Pet Planet"));
        planetsList.add(new Planet("Makarpura\n" +
                "\n F/4, Siddhivinayak Flat, Ground Floor, Manjalpur Main Road, Manjalpur, Vadodara - 390011, Opposite Panchsheel High School+(91)9016944157, 8734879919, 9924235647","Maruti Aquarium Pets"));
        planetsList.add(new Planet("Nizampura\n" +
                "\n Ground Floor, 38,B-28,B-18, Maruti Complex, Nizampura, Vadodara - 390002, Near Nizampura New St Depo, Opposite Swaminarayan Nagar +(91)-9377747896","Rikin Aquatics"));
        planetsList.add(new Planet("Old Padra\n" +
                "\n RoadG/16, Welcome Shopping Centre, Race Course Road, Vadodara - 390007, Old Padra Road","Umiya Distributors"));
        planetsList.add(new Planet("Pratapnagar\n" +
                "\n Opp Sompal Petrol Pump, Opp Polich Chawki +(91)–265-2580332, +(91)-9825940478","Zoom Aquarium"));
        planetsList.add(new Planet("Subhanpura\n" +
                "\n H 2-42, Aastha Avenue, New I P C L Road, Subhanpura, Vadodara - 390023, Near Anandvan Complex +(91)-265-3193535, +(91)-9924004193","Royal Aquarium House"));
        planetsList.add(new Planet("Subhanpura \n" +
                "\n 6, Park View Complex, Subhanpura Main Road, Subhanpura, Vadodara - 390023, Opposite Vardhaman Complex +(91)-9898393188, 9429400404","DAS Aquarium"));
        planetsList.add(new Planet("Tarsali\n" +
                "\n Ff 5 Ruksmani Complex, Tarsali Road, Vadodara - 390009, Near Tarsali Market +(91)-9979611397, 8530724887","Dev Aquarium Pet Shop"));
        planetsList.add(new Planet("Vasna\n" +
                "\n 3 Krishna Park -2, Makrand Desai Road, Vasna Road, Vadodara - 390015, Near Tribhuvan Park +(91)-265-2252599, +(91)-9825977259","Petzone"));
        planetsList.add(new Planet("Vasna\n" +
                "\n D/30, Vasna Road, Vadodara - 390015, Near Taksh Complex +(91)-265-2252815, +(91)-9825664942","Blue H2o Aquariums"));
        planetsList.add(new Planet("Wadi \n" +
                "\nParvati Sadan, Pomli Faliya Main Road, Wadi Vadodara, Vadodara – 39002 +(91)-265-2582412, +(91)-9825666783","Harshe Aquarium"));
        planetsList.add(new Planet("Old Padra\n" +
                "\n 1, Shivang Complex, Malhar Point Cross Road, Old Padra Road, Vadodara - 390012, Opposite Shivmahal Society, Opposite Malhar Point, Near GAIL India Ltd +(91)-9824929779 +(91)-265-2322675","Daalis Aqua Nature"));
        planetsList.add(new Planet("Yakutpura\n" +
                "\n Gani Manzil, Main Road, Yakutpura, Vadodara - 390006, Opposite Daud Shaikh Dargah +(91)-265-2515130, +(91)-9375938510","Shalimar Aquarium"));


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