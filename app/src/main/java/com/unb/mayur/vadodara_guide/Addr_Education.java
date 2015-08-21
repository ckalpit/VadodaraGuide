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

public class Addr_Education extends Activity //implements View.OnClickListener{
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

        setContentView(R.layout.activity_addr__education);

        switch(msg_int)
        {
            case 0:

                Book();
               setTitle("Book Stall");
                break;

            case 1:
                setTitle("Colleges");
                College();
                break;

            case 2:
                setTitle("Cybercafe");
                Cybercafe();
                break;
            case 3:
                setTitle("Placement Agencies");
                Placement();
                break;
            case 4:
                setTitle("Print and Publishers");
                print();
                break;

            case 5:
                setTitle("Dance Classes");
                Dance();
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

    private void Dance() {

        planetsList.add(new Planet("VIP Road,\n\n 12, VIP View Complex, VIP Road, Opposite Bright Day School, Vadodara - 390022\n" +
                "+(91)-9998979394, 9725585591\n","Shiv Sadhana Nrutya Sangeet Academy"));
        planetsList.add(new Planet("Ajwa Road \n\n Office No 7, First Floor, Aditya Avenue, Mahavir Hall Cross Road & Ahinsa Circle, Ajwa Road,  Above Anadi Khaman, Vadodara – 390019 ,+(91)-9879254683+(91)-9725480115","Misty Dance Studio"));
        planetsList.add(new Planet("VIP Road \n\n Sb-13, VIP View Complex, VIP Road, Opposite Bright School Vadodara - 390006,+(91)-9426034330, 9824191782","Bittu Dance Academy"));
        planetsList.add(new Planet("Alkapuri \n\n 302 Bhagwaan Chamber, Alkapuri, Opposite Circuit House Vadodara - 390007,+(91)-7874025103, 9033692860","D My Choice Dance Studio"));
        planetsList.add(new Planet("Alkapuri \n\n 10-A, Rangyogi Park Society, Shrenik Park Cross Road, Akota, Near Akota Stadium Vadodara - 390020,\n" +
                "+(91)-9825582733+(91)-9427381970+(91)-8390364050\n","Vinay Nrutya Kala Kendra"));
        planetsList.add(new Planet("Varasia \n\n 101-C, Bilipatra Complex, Harni Warasia Ring Road, Varasia, Near Shiv Vatika Party Plot Vadodara - 390022,+(91)-9824414942 , +(91)-9375957329","Agile Dance Galaxy"));
        planetsList.add(new Planet("Kala Darshan \n\n A-39, Ratilal Park Society, Kala Darshan Char Rasta, Opp State bank of india\n" +
                "Vadodara - 390002+(91)-8485992226\n","Shree Sainath Patel Classes"));
        planetsList.add(new Planet("Vasna Road \n\n GF/1A Rajhans Avenue, Vasna Road, Near Anant Park Society,Behind Sabri School Vadodara - 390015,+(91)-9510171217+(91)-9726289245 +(91)-265-2251876","Crawlers To Flyers"));
        planetsList.add(new Planet("Manjalpur \n\n B-3, Silver Coin Complex, Makarpura Road, Manjalpur, Opposite Bhavans School Vadodara - 390011\n" +
                "+(91)-9825437376 , +(91)-9898081585\n","Dance World"));
        planetsList.add(new Planet("Old Padra Road \n\n First Floor, 47, Avishkar Complex, Old Padra Road, Vadodara - 390012 \n" +
                "Vadodara - 390012 +(91)-9979979988 , +(91)-9898356653\n","D Virus Dance Academy Dharmesh Sir"));
        planetsList.add(new Planet("Gotri Road \n\n 103, Radheshyam Residency, Geri Compound Road, Gotri Road, Behind Yash Complex Vadodara - 390021,+(91)-9033655482","Natyanjaly Dance Academy"));
        planetsList.add(new Planet("Manjalpur \n\n 4/5, Mebal Appartment, Dmart Road, Manjalpur, Vadodara - 390011, Opposite Shantikunj Society 2\n" +
                "+(91)-9898351257+(91)-7567458232\n","Troop Dance Academy"));
        planetsList.add(new Planet("Akota \n\n Basement, Anand Vihar Complex, Akota, Opposite R C Patel Estate, Near Gold Gym, Vadodara - 390020\n" +
                "+(91)-9824326928\n","Znk Dance N Aerobic Studio"));
        planetsList.add(new Planet("Chani Jakat Naka \n\n Mahshi Shopping Center, Tp 13, Chani Jakat Naka Vadodara - 391740\n" +
                "+(91)-9714858415 , +(91)-8460556859\n","Sandy Step Dance Academy"));
        planetsList.add(new Planet("Old Padra Road \n\n C 3, Shivmahal Apartment, Swami Shivanand Marg, Old Padra Road, Near Nehrupark Society Vadodara - 390015\n" +
                "+(91)-9167124838\n","Prince Dance Company"));
        planetsList.add(new Planet("Raopura \n\n 202, Narmada Apartment, Raopura, Near Navrang Cinema Road  Vadodara - 390001\n" +
                "+(91)-9825337271, 9925837778\n" +
                "+(91)-265-2432700\n","Raj Dance Class"));
        planetsList.add(new Planet("Alkapuri \n\n 201, Anjali Chambers, Alkapuri, Opposite Panchshil Hotel Vadodara - 390007,\n" +
                "+(91)-9825513319, 9426353200\n","Oscar Academy"));
        planetsList.add(new Planet("Alkapuri \n\n Sainath Avenue, Fatehgunj, Near Emperor Complex, Vadodara - 390008,\n" +
                "+(91)-9725678333\n","Street Dancers Crew"));
        planetsList.add(new Planet("Old Padra \n\n 4-5, Ashray Flat, Sainath Marg, Old Padra Road, Vadodara - 390012, Nr Utkarsh Vidhyalay, Ahead Of Meridan Hospital\n" +
                "+(91)-9227788500, 9327492621\n" +
                "+(91)-265-6453106\n","Nupur Kathak Academy Nupur Kala Kendra"));
        planetsList.add(new Planet("Sama \n\n 3rd Floor, Amar Complex, Chankyapuri Road, Sama, Vadodara - 390008 \n" +
                "+(91)-9825712060\n","Western Dance Academy"));
        planetsList.add(new Planet("Manjalpur \n\n 7/8 Aangan Tower, Makarpura Road, Manjalpur, Near Bhavans Schoolm, Near Vadodara Dairy , Opp Makarpura Police Satation Vadodara - 390011,\n" +
                "+(91)-9825337271, 9925837778\n" +
                "+(91)-265-2432700\n","Raj Dance Class"));
        planetsList.add(new Planet("Old Padra Road \n\n C/19, Nand Tenements, Olp Padra Road, Old Padra Road, B/H Aims Oxygen Vadodara - 390020,\n" +
                "+(91)-9825081077\n" +
                "+(91)-265-2359989\n","Shree Kala Kendra"));
        planetsList.add(new Planet("Old Padra Road \n\n 1st Floor, Jetalpur Road, Above Only Parathas  Vadodara - 390020\n" +
                "+(91)-9825032211\n","Spin Academy"));
        planetsList.add(new Planet("Subhanpura \n\n Pujer Complex, Subhanpura, Vadodara - 390007  \n" +
                "+(91)-9327251226\n" +
                "+(91)-265-2520851\n","Pace Creaters Dance Academy"));


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

*/

    }

    private void print()
    {
        planetsList.add(new Planet("Raopura \n\nAlankar Apartment, Opp Jubilee Garden, Raopura Char Rasta, Raopura, Vadodara - 390001","Bindoo Book Stall"));
        planetsList.add(new Planet("Karelibaug \n\nSandesh Bhavan, Jalaram Temple Ke Piche, Bahucharaji Road, Karelibaug, Vadodara - 390018","Sandesh Ltd"));
        planetsList.add(new Planet("Karelibaug\n\n 2nd Floor, Hiravanti Chambers, Opp Mira Kanya Chhatralaya, Arya Kanya Vidyalaya, Karelibaug, Vadodara - 390018","Gujarat Mitra"));
        planetsList.add(new Planet("Rc Dutt Road\n\n 407, Dwarkesh Complex, 4th Floor, Opp Panorama Complex, Nr Welcom Hotel, Rc Dutt Road, Vadodara - 390005","Indian Express Newspapers Bombay Ltd"));
        planetsList.add(new Planet("Alkapuri\n\n E 1/201 Kashivisheshwar Town Ship, Nr Pizza Inn, Alkapuri, Jetalpur Road, Vadodara - 390005","India Global"));
        planetsList.add(new Planet("Alkapuri\n\n 506/b Alkapuri Arcade, Alkapuri Baroda, R.c Dutt Road, Alkapuri, Vadodara - 390007","Bhomiya Media Pvt"));
        planetsList.add(new Planet("Alkapuri \n\n202, Concorde Building, Above Times Of India Office, R C Dutta Road, Alkapuri, Vadodara - 390007","Chemical Engineering World"));
        planetsList.add(new Planet("Alkapuri\n\n 4th Flr 422 Centre Point, Alkapuri, Vadodara - 390007","Chitralekha Group"));
        planetsList.add(new Planet("Chowkhandi\n\n Oppoiste Mugal Restaturant, Chowkhandi, Vadodara - 390017","Amin Book Depot"));
        planetsList.add(new Planet("Fatepura\n\n Jubliee Garden, Fatepura, Vadodara - 390006","Baroda Book Depot"));
        planetsList.add(new Planet("Jetalpur Road\n\n Shreji Avenue, Jetalpur Road, Vadodara - 390005","Exim India"));
        planetsList.add(new Planet("Gotri Road \n\nF/51, Sivangali Society, B/h Saurabh Park, Yash Complex Road, Gotri Road, Vadodara - 390021","Gaurav News Paper"));
        planetsList.add(new Planet("Race Course\n\n 1st Floor, Indraprasth, B - Towers, Inox Multiplex, Race Course Circle, Ellora Park, Vadodara - 390023","Indiacom Ltd"));
        planetsList.add(new Planet("Makarpura\n\n 201, Kalapi Chamber, Opposite Novino, Makarpura, Vadodara - 390014","Indian Age Communication"));
        planetsList.add(new Planet("Nyay Mandir\n\n Janmabhoomi News Bureau Padmavati Shpng Cntr 3/2 Semi Base, Nyay Mandir, Vadodara - 390001","Janmabhoomi"));
//        planetsList.add(new Planet("",""));
 //       planetsList.add(new Planet("",""));



    }

    private void Placement() {

        planetsList.add(new Planet("Alkapuri\n\n 306 Opal Square, Bh Express Hotel, Alkapuri, Vadodara - 390007","Innovative Placement And Managment Services"));
        planetsList.add(new Planet("Alkapuri\n\n 425, Centre Point, R C Dutta Road, Alkapuri, Vadodara - 390007","Utkarsh Placement Pvt Ltd"));
        planetsList.add(new Planet("Fateganj\n\n C 206 Time Square Building, Nr Fateganj Petrol Pump, Fateganj, Vadodara - 390002","Rushabh Consultancy Instant Naukri Com"));
        planetsList.add(new Planet("Sayaji Ganj\n\n 301 - A, Helix Complex, Opp Hotel Surya, Sayaji Ganj, - 390005","Jewel Consultancy"));
        planetsList.add(new Planet("Sayaji Ganj\n\n 702 Silverlime Complex, Opposite Bbc Tower, Sayaji Ganj, Vadodara - 390005","Bright Consultancy"));
        planetsList.add(new Planet("Sayaji Ganj\n\n Sb - 41 Paradise Complex, Nr Rajashree Cinema, Sayaji Ganj, Vadodara - 390005","Job Ki Duniya Com"));
        planetsList.add(new Planet("Sayaji Ganj\n\n Silver Line Complex, Opp Bbc Tower, Sayaji Ganj, Vadodara - 390005","Rb Tek"));
        planetsList.add(new Planet("Productivity Road\n\n 301, A Square Building, 3rd Floor 82, Urmi Society, Baroda Productivity Council Road, Productivity Road, Vadodara - 390003","Ma Foi Management Consultants Ltd"));
        planetsList.add(new Planet("Productivity Road \n\nS/13, Vrund Complex, 2nd Floor, Productivity Road, Vadodara - 390003","Havoc Job Consultants"));
        planetsList.add(new Planet("Karelibaug\n\n 101, Sai Samruddhi Complex, Muktanand Crossing, Karelibaug, Vadodara - 390018","Shah Placements"));
        planetsList.add(new Planet("Padra Road\n\n 64 - , Suryakiran Complex, 1st Floor, Old Padra Road, Vadodara - 390012","Absolute Placement Services"));
        planetsList.add(new Planet("Padra Road\n\n 304, Shivang, 12, Gr Floor Shivmahal Societ, Old Padra Road, Vadodara - 390012","Crystal Placement"));
        planetsList.add(new Planet("Subhanpura\n\n 13, Nakulesh Park, Laxmipura Road, Subhanpura, Opp. Darpan Vatika, Samta, Subhanpura, Vadodara - 390007","Bbb Manpower And Security Solution Pvt Ltd"));
        planetsList.add(new Planet("B P C Road\n\n Tarang Society, B P C Road, Vadodara, Vadodara - 390002","Nidhi Placement"));
        planetsList.add(new Planet("Nizampura \n\n58, Sardar Nagar Society, Nizampura, Vadodara – 390002","Shine International"));


    }

    private void Cybercafe() {

        planetsList.add(new Planet("Makarpura\n\n Sb - 9, Silver Coin Complex, Opp Bhavan's School, Makarpura Road, Makarpura, Vadodara - 390014","Blue Chip Cyber Cafe"));
        planetsList.add(new Planet("Rajmahal \n\n Radhakrishna Building, Mari Mata Mandir, Rajmahal Road, Vadodara - 390001","Gnp Cyber Station"));
        planetsList.add(new Planet("Subhanpura \n\n84, Vimalnath Complex, H T Road, Subhanpura, Vadodara – 390023","Hatkesh Agencies"));
        planetsList.add(new Planet("Subhanpura\n\n Shop No 6, Amivision Complex, Hi Tension Road, Subhanpura, Vadodara – 390007","Amul Net Cyber Cafe"));
        planetsList.add(new Planet("Subhanpura\n\n Sb 11/12, Pujer Complex, Opp Gold Silver Apartment, Subhanpura, Vadodara - 390023","Blue Cyber Cafe And Stationery"));
        planetsList.add(new Planet("waghodia Road \n\nC 24 Prarambh Complex, Opp Rajiv Gandhi Swimming Pool, Mahesh Cmplx Crossing,waghodia Road, Vadodara – 390019","I 4 U Cyber Cafe"));
        planetsList.add(new Planet("waghodia Road\n\n Shop No 6, Vraj Complex, Sbi Bank, Parivar Cross Road, waghodia, Vadodara - 391760","Acs Cyber Cafe"));
        planetsList.add(new Planet("Alkapuri \n\n39/2 Arunoday Society, Alkapuri, Vadodara – 390007","Sify I Way"));
        planetsList.add(new Planet("Alkapuri\n\n Shop No.1 Sco 90, Wood Moor Apartment, Alkapuri, Vadodara - 390007","Bharati Communications"));
        planetsList.add(new Planet("Chowkhandi\n\n Opp Gaekawad Chamber, Chowkhandi Cross Road, Chowkhandi, Vadodara - 390017","Aashirwad Communication"));
        planetsList.add(new Planet("Pani Gate\n\n Svaminaarayan Nagar Complex, Panigate, Panigate, Pani Gate, Vadodara - 390019","Aashpuri Cyber"));
        planetsList.add(new Planet("Sama\n\n New Sama Road, Sama Road, Vadodara - 390002","Ashish Surfing House"));
        planetsList.add(new Planet("Nizampura\n\n 265, Swami Narayan Nagar, Opp Maruti Complex, Nizampura, Vadodara - 390002","Avz Cyber Tech"));
        planetsList.add(new Planet("Kareli Baug \n\nOld #9, Narayan Complex Kareli Baug, Karelibaug, Vadodara - 390018","Blue Moon Cyber Point"));
        planetsList.add(new Planet("Old Padra \n\n6, Ananya Complex, Akshar Chowk, Old Padra Road, Old Padra Road, Vadodara - 390020","Chanakya Cyber Cafe"));




    }

    private void College() {

/*
        planetsList.add(new Planet("Fateganj \n\nOpp Food And Drugs Laboratory, Fateganj, Vadodara - 390002","The Maharaja Sayajirao University Of Baroda"));
        planetsList.add(new Planet("Sama \n\nNr Swati, New Sama Road, Sama, Vadodara - 390008","Navrachna College Of Education"));
        planetsList.add(new Planet("Ajwa Nimeta\n\n Opp Sayajipura Village, Nr Sagar Studio, Ajwa Nimeta Road, Ajwa Road, Vadodara - 390019","American School Of Baroda"));
        planetsList.add(new Planet("National Highway \n\n Varnama, Vadodara Mumbai National Highway No 8, Vadodara H O, Vadodara - 390001","Babaria Institute Of Pharmacy And Echnology"));
        planetsList.add(new Planet("Karelibaug \n\nDevraj Building, Opp Arya Kanya School, Karelibaug, Vadodara - 390018","Akshar Mahila B Ed College"));
        planetsList.add(new Planet("Sewasi\n\n Sonarkui And Opposite Jbs Technical Inst, Sewasi Sindhrot Road, Sewasi, Vadodara - 391101","Baroda Homeopathic Medical College And Hospital"));
        planetsList.add(new Planet("Sayaji Ganj\n\n Shg Hospital Compound, Sayaji Ganj, Vadodara - 390005","Dean Government Medical College"));
        planetsList.add(new Planet("Vip Road \n\n Ring Road, Vip Road, Vadodara - 390006","Raghukul Vidhyalay"));
        planetsList.add(new Planet("Nizampura\n\n 42/43, Kobe House, Tapovan Society, Beside Kalpana Nursing Home, Nizampura, Vadodara - 390002","Aisect College For Information Technology"));
        planetsList.add(new Planet("Mandvi\n\n Ladvada, Mandvi, Vadodara - 390017","H V Shroff Memorial High School"));
        planetsList.add(new Planet("Waghodia\n\n Limda,waghodia – 391760 Dist-Vadodara","Parul University"));
        planetsList.add(new Planet("waghodia \n\nUdyognagar, B/H Ayurvedic College, Vaghodia, Vadodara - 391760","K M Shah Dental College And Hospital"));
        planetsList.add(new Planet("Raopura \n\nSur Sagar Lake, Raopura, Vadodara – 390001","Maharani High School"));

*/


        planetsList.add(new Planet("Vasna Road \n\nVasna Road , Vadodara- 391410 0265 - 2250705","Navrachana University- School of Engineering and Technology"));
        planetsList.add(new Planet("Waghodia \n\nPlot 6512, Ajwa Nimeta Road, Ravaal, Taluka Waghodia,  Vadodara  08000 861008 ,07817 080861 / 62  1800 209 9727\n" +
                "\n","ITM Vocational University"));
        planetsList.add(new Planet("Waghodia \n\nP.O.Limda, Ta.Waghodia - 391760 Dist. Vadodara, Gujarat(India) +91-2668-260312/202/300/307 Mob : +91-9099040577, +91-9978993371,+91-9879105593/64\n" +
                "\n","Parul University"));
        planetsList.add(new Planet("Vasna \n\nVadodara Mumbai NH 8, Vasna, Vadodara - 391240Land Mark: Near State Bank of India 0265 - 6549999","Babaria Institute of Technology"));
        planetsList.add(new Planet("Kotambi \n\nVadodara Halol Toll Road, Kotambi, Waghodia,Vadodara - 391510Land Mark: Near Kotambi Bus Stop 0265 - 3915900, 0265 - 3915901","Vadodara Institute Of Engineering"));
        planetsList.add(new Planet("Waghodia \n\nAjwa Nimata Road, Waghodia, Vadodara - 391760, Post Bakrol, Opposite Madhavnagar  +(91)-9909976843 , +(91)-9909962787  +(91)-2668 267000, 267111, 267222 18002336700","Sigma Group Of Institute"));
        planetsList.add(new Planet("Savli \n\nK J Campus, Savli, Vadodara - 391770, Opposite I T I Javla, Post Office Savli\n" +
                "+(91)-9825458295 , +(91)-8980314190 +(91)-2667-222264\n" +
                "\n","K J Institute Of Engineering & Technology"));
        planetsList.add(new Planet("Alkapuri \n\nB 506, Alkapuri Arcade, Rc Dutt Road, Alkapuri, Vadodara - 390007, Opposite Welcome Hotel  +(91)-9601613513 +(91)-265-3954988 www.iimtbaroda.com","Iimt"));
        planetsList.add(new Planet("Fateganj \n\nFateganj, Vadodara - 390002, Opposite Food & Drugs Laboratory  \n" +
                "+(91)-265-2789485 +(91)-265-2793693 www.msubaroda.ac.in\n","The Maharaja Sayajirao University Of Baroda"));
        planetsList.add(new Planet("Gotri \n\nOld Tb Hospital Campus, Gotri Main Road, Gotri Road, Vadodara - 390021\n" +
                "+(91)-265-2398008, 2398108 +(91)-265-2398009 www.gmersmcgv.ac.in\n","Gujarat Medical Education and Research Society Medical College"));
        planetsList.add(new Planet("Munjmohda \n\nVishwa Jyoti Ashram, Munjmohda, Vadodara - 390020, Opposite Gujarat Tractors, Near Vishwamitra Bridge   +(91)-9898769811, 9824012583 +(91)-265-2338055, 2336350, 2330762 +(91)-265-2330362 www.mpdentalcollege.edu.in","Manubhai Patel Dental College & Hospital"));
        planetsList.add(new Planet("Ajwa \n\nNational Highway No 8, Ajwa Nimeta Road, Ajwa Road, Vadodara - 390019, Near Ajwa Cross Road, Near Sayajipura   +(91) 9714855993,  9824511694,  9924003900,  9824011693  +(91)-265-2971624, 2971625","Pioneer Pharmacy Degree College"));
        planetsList.add(new Planet("Waghodia \n\nWaghodia, Vadodara - 391760, Behind Ayurvedic College, Udyog Nagar  \n" +
                "+(91)-2668-245262, 245264, 245266 www.sumandeepuniversity.co.in\n","K M Shah Dental College & Hospital"));
        planetsList.add(new Planet("Sayaji Ganj \n\nShg Hospital Compound, Sayaji Ganj, Vadodara - 390020  \n" +
                "+(91)-265-2427545, 2424848\n","Dean Government Medical College"));
        planetsList.add(new Planet("Padra \n\nMk College Campus, Station Road, Padra, Vadodara - 391440, Behind Shroff High School  +(91)-2662-222997, 222297","Mk Amin Arts Science & Commerce College"));
        planetsList.add(new Planet("Sewasi \n\nSindhrot Road, Sewasi, VADODARA - 391101, Near Sonarkui & Opposite Xavier Technical Institute  +(91)-9825108556, 9198244755 +(91)-265-2370319, 2370153 +(91)-265-2370002 www.bhmcindia.in","Baroda Homeopathic Medical College & Hospital"));
        planetsList.add(new Planet("Fatehgunj \n\nFatehgunj, VADODARA - 390008, Near Shashtri Bruigh, Near Pandya Hotel  \n" +
                "+(91)-265-2783914, 2783915 +(91)-265-2783531 www.msubaroda.ac.in\n" +
                "\n","Polytechnic College"));
        planetsList.add(new Planet("Sewasi \n\nAnkodia, Sewasi Koyli Road Main Road, Sewasi, Vadodara - 391101\n" +
                "+(91)-265-2233220, 2233110 +(91)-265-2233220, 2233110 www.indueducation.org\n","Indu College Of Medical Science"));
        planetsList.add(new Planet("Nizampura \n\n42/43, Kobe House, Tapovan Society, Nizampura, Vadodara - 390002, Beside Kalpana Nursing Home   +(91)-9825044445, 9825359591","Aisect College For Information Technology"));
        planetsList.add(new Planet("Dandia Bazar \n\nPerforming Arts & Music College Building, Dandia Bazar, Vadodara - 390001, Opposite Sursagar Lake, Near Nyay Mandir   +(91)-265-2410194 +(91)-265-2410194\n" +
                "www.msubaroda.ac.in\n","Faculty Of Performing Arts"));
        planetsList.add(new Planet("Waghodia \n\nWaghodia, Vadodara - 390019, Post Pipaliya +(91)-9925058099,  9998869329,  9925628739, 9274107862 +(91)-265-245245 +(91)-265-245245 www.sitpipaliya.org\n" +
                "\n","Sanskar Institute Of Technology"));
        planetsList.add(new Planet("Munjmohda \n\nMain Road, Munjmohda, Vadodara - 390020, Near Gujarat Tractor, Under Vishwamitra Bridge +(91)-265-2322614, 2322615, 2322616, 2322617","Shree Mahalaxmiji Mahila Homoeopathic Medical College"));
        planetsList.add(new Planet("Ajwa \n\nJAY Yogeshwar Town Ship, Ajwa Road, Vadodara - 390019, Near Hotel Khatti Emli  \n" +
                "+(91)-9879571285 +(91)-265-2565633\n","S D Patel B Ed College"));
        planetsList.add(new Planet("Bodeli \n\nA 01, Chhota Udepur Road, Bodeli, Vadodara - 391135, Near Bk Patel Petrol Pump, Dhokaliya +(91)-2665-221017, 221018\n" +
                "\n","Sheth Tc Kapadia Arts And Commerce College"));
        planetsList.add(new Planet("Raopura \n\nRaopura, VADODARA - 390001, Near Sursagar Lake, Near Maharani School\n" +
                "+(91)-9898904992 +(91)-265-2418819\n","M M Shah College Of Commerce & Management"));
        planetsList.add(new Planet("Akota \n\nKeravni Trust Vidhyalay Compound, Old Padra Road, Akota, VADODARA - 390020, Behind Akota Music Stadium +(91)-265-6530741, 6540507","Dr Thakor Patel Girls College"));
        planetsList.add(new Planet("Savli \n\nNatvar Nagar, Savli, VADODARA - 391121 +(91)-9825804551,  9714874623, 9979189632 +(91)-2663-292100","Sanskar Bharti College Of Education"));
        planetsList.add(new Planet("Atladara \n\nAtladara, Vadodara HO, Vadodara - 390001\n" +
                "+(91)-265-2681416, 2681417\n","Pramukh Swami Institute Of Information Technology"));
     /* planetsList.add(new Planet("",""));
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

    private void Book()
    {
        planetsList.add(new Planet("Fateganj\n\n Seven Seas Mall, Nr Diamond Jubilee Girls Hostel, Opp Arvind Baug, Fateganj, Vadodara - 390002","Big Bazaar"));
        planetsList.add(new Planet("Alkapuri\n\n 2/1, Arunoday Society, Opp Sbi Bank, Alkapuri, Vadodara – 390007","Crossword Bookstores Ltd"));
        planetsList.add(new Planet("Alkapuri\n\n Sb/5, Ivory Terrace, Beside Dawat Hotel, R C Dutt Road, Alkapuri, Vadodara - 390007","Umakant Book Sellers And Stationers"));
        planetsList.add(new Planet("Alkapuri \n\n209, Shri Dwarkesh Apartment, Sampatrao Colony, Alkapuri, Vadodara – 390007","Sagar Law House"));
        planetsList.add(new Planet("Alkapuri\n\n 9, Gayatri Chambers, Nr Rajpath Hotel, R C Dutt Road, Alkapuri, Vadodara – 390007","Bansal Book Stall"));
        planetsList.add(new Planet("Race Course\n\n Monalisa Centrum, Nr Inox Multiplex, Race Course Circle, Race Course Road, Vadodara - 390007","Landmark Ltd"));
        planetsList.add(new Planet("Jubilee Baug\n\n Sitadel Complex, Opposite Gandhinagar Ground, Jubilee Baug, Vadodara - 390001","Acharya Book Depot"));
        planetsList.add(new Planet("Raopura\n\n Alankar Apartment, Opp Jubilee Garden, Raopura Char Rasta, Raopura, Vadodara - 390001","Bindoo Book Stall"));
        planetsList.add(new Planet("Sayaji Ganj \n\n7, Payal Complex, Manubhai Tower, Opp Ms University, Sayaji Ganj, Vadodara - 390005","Manish Book Store"));
        planetsList.add(new Planet("Bajwada\n\n Nr Kalyanji Temple, Mandvi Road, Bajwada, Vadodara - 390001","Acharya Book & Shringar Centre"));
        planetsList.add(new Planet("Kothi Char\n\n 2, Vinraj Plaza, Opp Govt Press, Kothi Char Rasta, Kothi, Vadodara - 390001","Medical Book Company Pvt Ltd"));
        planetsList.add(new Planet("Kothi Char\n\n Ssg Hospital And Opp Medical College Main Gate, Kothi Road, Kothi, Vadodara - 390001","Tamsh Book Depot"));
        planetsList.add(new Planet("Rc Dutt Road \n\n5, Niharika Apartment, Vishwas Colony, Behind Alkapuri Petrol Pump, Rc Dutt Road, Vadodara - 390005","Acharya Book Seller And Stationers"));
        planetsList.add(new Planet("Chowkhandi\n\n Oppoiste Mugal Restaturant, Chowkhandi, Vadodara - 390017","Amin Book Depot"));
        planetsList.add(new Planet("Chowkhandi\n\n Opp Mugal Restaurant, Chowkhandi Bumbakhana, Wadi Sn Road, Vadodara - 390017","Amin Book Depot"));


    }

    private void clubs()
    {
        planetsList.add(new Planet("Alkapuri \n\nAlkapuri Club, Alkapuri, Vadodara - 390007, Near Baroda High School +(91)-265-2350698","The Friends Co Operative Housing Society Ltd"));
        planetsList.add(new Planet("Rajmahal Road \n\nJawaharlal Naheru Road, Rajmahal Road, Vadodara - 390001, Near Jillapanchayat Bhavan+(91)-265-2433536, 2433989  ","Maharaja Pratapsinh Coronation Gymkhana "));
        planetsList.add(new Planet("Rajmahal Road \n\n The Motibaug Palace, J N Marg, Rajmahal Road, Vadodara - 390001, The Lakshmi Villas Palace Estate+(91)-265-2433599, 6555999","Gaekwad Baroda Golf Club"));
        planetsList.add(new Planet("Rajmahal Road \n\nRajmahal Road, Vadodara - 390001, Near Khandarao Market\n" +
                "+(91)-265-2431570\n","Sayaji Vihar Club"));
        planetsList.add(new Planet("Ranoli \n\nGotri Sevasi Road, Ranoli, Vadodara - 391350, Near Podar World School\n" +
                "+(91)-265-6567575, +(91)-8866770222\n","Baroda Presidency Sports Club"));
        planetsList.add(new Planet("Waghodia Road \n\n12/B,Mira Soc, Vaghodia Road, Vadodara - 390019, Bhd Surya Nagar Soc+(91)-265-2510393","Spen Victoria Sports Club"));



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