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

public class Addr_LifeStyle extends Activity //implements View.OnClickListener{
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

        setContentView(R.layout.activity_addr__life_style);

        switch(msg_int)
        {
            case 0:
                setTitle("Aquarium Dealers");
                Aquarium();
                break;

            case 1:
                setTitle("Beauty Parlours");
                Beauty();
                break;

            case 2:
                setTitle("Clubs");
                clubs();
                break;
            case 3:

                setTitle("DJ");
                DJ();
                break;
            case 4:
                setTitle("Florist shops");
                florist();
               break;
            case 5:
                setTitle("Pet Shops");
                petshop();
                break;
            case 6:
                setTitle("Shoping Malls");
                malls();
                break;
            case 7:
                setTitle("Swimming Pools");
                swimming();
                break;
            case 8:
                setTitle("Theaters");
                Theater();
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

private void Beauty()
    {


        planetsList.add(new Planet("Akota \n\n303 Berry S Plazza, Above Samsung Showroom, Shrenikpark Char Rasta, Akota, Vadodara - 390020","Prernas Beauty Clinic And Hair Studio"));
        planetsList.add(new Planet("Akota\n\n 17/18, Pratham Plaza, 1st Floor, Opp Taj Residencym, Nr Akota Gardens, Akota, Vadodara - 390020","Jawed Habib Hair And Beauty Salon"));
        planetsList.add(new Planet("Akota\n\n 303/403, Signature, Nr 54 Urmi Society, Productivity Road, Akota, Vadodara - 390020","Monas Beauty Clinic And Hair Studio"));
        planetsList.add(new Planet("Saven Seas Mall\n\n Saven Seas Mall, 2nd Floor,","Monas Hair And Beauty Studio"));
        planetsList.add(new Planet("Jetalpur \n\n108, Kashivishweshwar Township, 1st Floor, Tower E, A/b Swagat Corn Restaurant, Jetalpur Road, Vadodara – 390005","Sakhi The Beauty Clinic"));
        planetsList.add(new Planet("Karelibaug \n\n1 /c Gulabchand Society, Ambe Mata Mandir, Karelibaug Main Road, Karelibaug, - 390018","Asha Beauty Academy"));
        planetsList.add(new Planet("Karelibaug\n\n 4 A Adhyapak Nager, Opp Swaminarayan Temple Bs Jain Temple, Water Tank Road, Karelibaug, Vadodara - 390018","Dimples Beauty Care"));
        planetsList.add(new Planet("Karelibaug\n\n 7/a Waghewari Society, Nr Sbi, Vip Road, Karelibaug, Vadodara - 390006","Herb Beauty Parlour"));
        planetsList.add(new Planet("Makarpura \n\nG/2 Pratap Tower, B/h Aangan Tower B/s Silver Coin Complex Nr Bhavans School, Makarpura, Vadodara - 390014","Krupa Beauty Clinic And Spa"));
        planetsList.add(new Planet("Manjalpur \n\nShop No 2 Ruturaj Apartment, Nr Kabir Complex, Makarpura Road, Manjalpur, Vadodara - 390011","Grooming Lounge"));
        planetsList.add(new Planet("Padra Road\n\n F 1/f 2 Tanishq Commercial Hub, Manisha Chowkdi, Padra Road, Vadodara - 390007","Lakme Beauty Salon"));
        planetsList.add(new Planet("Padra Road\n\n Zaverchand Park, Old Padra Road, Vadodara – 390020","Sterling Health Mall"));
        planetsList.add(new Planet("Race Course\n\n Trident Complex, 1st Floor, B Wing, Opp Geri, Race Course, Vadodara - 390007","Vlcc"));
        planetsList.add(new Planet("Vasna Road \n\nGf 3 Yajmaan Complex, Opp Kalyan Party Plot, Vasna Road, Vadodara - 390015","Beauty Mantra"));
        planetsList.add(new Planet("Wadi\n\n Shop No 15, Center Square Mall, 2nd Floor, Nr Genda Circle, Dr V S Road, Wadi - Wadi, Vadodara - 390023","Star And Sitara Salon"));




    }


    private void DJ()
    {
        planetsList.add(new Planet("Ajwa Road \n\nC 328, Shree Hari Township, Nr Sayaji Baug, Ajwa Road, Vadodara - 390019","Dj Rocky"));
        planetsList.add(new Planet("Atladra \n\nB - 303 Madhav Complex, Atladra, Sunpharma Road, Atlardra, Vadodara - 390012","Dj Harry"));
        planetsList.add(new Planet("Fateganj \n\nFateganj, Vadodara - 390002","Dj Pny"));
        planetsList.add(new Planet("Gorwa \n\n 538 Vrundavan Apartment, Opp Gorwa Iti, Gorwa, Vadodara – 390016","Dj Deep"));
        planetsList.add(new Planet("Gotri Road\n\n 22, Sarabhai Society, Nr Tb Hospital, Gotri Road, Vadodara - 390021","Dj Harry"));
        planetsList.add(new Planet("Gotri Road \n\n- B/3, Vardhman Park, Opp Rajesh Tower, Gotri Road, Vadodara – 390021","Dj Smash"));
        planetsList.add(new Planet("Karelibaug \n\n271, Jalaramnagar, Vip Road, Karelibaug, Vadodara - 390018","DJ Rock"));
        planetsList.add(new Planet("Manjalpur\n\n Sindhoi Mata Road, Manjalpur, Vadodara - 390011","Dj Harry"));
        planetsList.add(new Planet("Nizampura\n\n 6, Patanjali Flat, Behind Drug Laboratory, Nizampura Village, Nizampura, Vadodara - 390002","Niyati D J System"));
        planetsList.add(new Planet("Salatwada \n\n304, Hari Bhakti Complex, Mc High School, Salatwada, Vadodara - 390001","Dj Nights"));
        planetsList.add(new Planet("Varasia Ring Road \n\n B - 165, Pramukh Swami Society, Varsia Ring Road, Varasia, Vadodara - 390022","Dj Rix"));
        planetsList.add(new Planet("Varasia\n\n 94, Paras Society, Nr Rto, Varasia, Vadodara - 390022","Dj Apple"));



    }


    private void florist()
    {

        planetsList.add(new Planet("Alkapuri \n\nGround Floor Shop-9, Dwarkesh Complex, R C Dutt Road, Alkapuri, Vadodara - 390007, Near Welcome Hotel+(91)-265-2345345, +(91)-9825756601","Shrinathji Florists"));
        planetsList.add(new Planet("Alkapuri \n\n Opposite Kala Niketan Alkapuri, Vadodara - 390007,","Shrinathji Florist"));
        planetsList.add(new Planet("Akola \n\nRatanlal Plot, Akola Ho, Akola - 444001, Opposite Lrt College\n" +
                "+(91)-724-2431215, +(91)-9423128338\n","New Sanjay Flower"));
        planetsList.add(new Planet("Fatehgunj \n\n36, Blue Diamond Complex, Fateganj, Vadodara - 390002, Behind Fatehgunj Petrol Pump+(91)-265-2785444, +(91)-9824080907","J K Florist"));
        planetsList.add(new Planet("Fateganj \n\nLakshya Complex, Fatehgunj Main Road, Fateganj, Vadodara - 390002+(91)-265-3017366","Bagicha Florist"));
        planetsList.add(new Planet("Fateganj \n\n5, Eagle Apartment, Fateganj, Vadodara - 390002","Asian Florist"));
        planetsList.add(new Planet("Fateganj \n\nSb 25 & 26 Emperor Bldg, Fatehgunj Main Road, Vadodara, Vadodara – 390002+(91)-9903994470, 9903994469","Right Florist (Indiawide Worldwide)"));
        planetsList.add(new Planet("Gotri \n\nGround Floor, 32, Kishan Complex, Gotri Road, Gotri Road, Vadodara - 390021, Opposite Yash Complex, Near Bajaj Show Room\n" +
                "+(91)-9998010927, 9979852880","Shree Krishna Florist"));
        planetsList.add(new Planet("Gorwa \n\n 1, Mali Moholla, Near Datt Krupa Appartment, Behind Gorwa Ghb+(91)-265-3232088, +(91)-9898391204","Variety Flower Mart"));
        planetsList.add(new Planet("Jetalpur \n\n9, Status Avenue, Jetalpur Road, Vadodara - 390020, Sampatrao Colony, Opposite PC Jewellers, +(91)-265-2972577, +(91)-9825511449","Shri Shrinathji Florist"));
        planetsList.add(new Planet("Manjalpur \n\n D/407, SAI Baug Flats, Manjalpur, Vadodara – 390011+(91)-9909518444","Sonal Interior Flowers"));
        planetsList.add(new Planet("Nizampura\n\n 13-A, Navdurga Society, Nizampura, Vadodara - 390002, Nr SAI Ashish Fast Food Centre+(91)-9913876418","Khusboo Florist"));
        planetsList.add(new Planet("Race Course \n\nG 9/12, Indraprastha Tower A, Race Course Road, Vadodara - 390007, Race Course Circle, Opposite Ellora Park Vegetable Market+(91)-9429563181, 9099923995\n" +
                "+(91)-265-2341342, 3080603\n","Fragrance Florist"));
        planetsList.add(new Planet("Raopura \n\n Raopura, Vadodara - 390001, Opposite Khadi Gramodyag, Near Kothi Bus Stop+(91)-9925294864","Maharaja Flower Mart"));
        planetsList.add(new Planet("Sayaji Ganj \n\n41,42, Phoenix Complex, Sayaji Ganj, Vadodara - 390020, Nr Suraj Plaza +(91)-265-2222233, +(91)-9824080907","J K Florist"));
        planetsList.add(new Planet("Waghodia \n\nOld Bus Stand Cross Road, Waghodia, , Behind JAY Ambe Pan House Vadodara - 390019+(91)-9898291577","Raj Flower Decorators"));

    }



    private void petshop()
    {
        planetsList.add(new Planet("Akota \n\nShop No 6, Ground Floor, Parshwa Puja Complex, Akota, Near Sainik Park Char Rasta, Next To Samsung Company Showroom  Vadodara - 390020,\n" +
                " +(91)-9825351643, 9998240743, 9825835707\n" +
                "+(91)-265-2324720\n","Monarch Pet Shop"));
        planetsList.add(new Planet("Makarpura \n\n3, Rutushree Complex, Ground Floor, Manjalpur Road, Opp. IDBI Bank & Kabir Plaza Makarpura, Vadodara - 390014, +(91)-9825959676","Aqua World"));
        planetsList.add(new Planet("Fatepura \n\nShree Chunilal Mension, Main Road, Fatepura, Vadodara - 390006, Opp. Padakhana\n" +
                "+(91)-9825237885, 9879113509\n","Navdhansinh Chauhan"));
        planetsList.add(new Planet("Karelibaug \n\nShop No 6, Amrapali Complex, Main Road, Karelibaug, Near Karelibaug Water Tank Vadodara - 390018, +(91)-265-3063311, +(91)-9737646293","Pets Spot"));
        planetsList.add(new Planet("Makarpura \n\n36/2/8, Abhishek Complex, Vadsar Main Road, Makarpura Industrial Estate, Near Bank Of Baroda Vadodara - 390010, +(91)-9825583893\n" +
                "+(91)-265-2653345, 3043345\n" +
                "+(91)-265-2631248\n","Poly Care Pet Shop"));
        planetsList.add(new Planet("Nizampura \n\nNo 6 JAY Complex, Nizampura, , Nizampura Main Road Vadodara - 390002 \n" +
                "+(91)-9898427535\n","Paws & Claws"));
        planetsList.add(new Planet("Sayaji Ganj \n\nShop No 101, Below Hotel Vikram, Sayajigunj Main Road, Sayaji Ganj, Opposite Hotel Vikram, Vadodara - 390020, +(91)-9898128890, 9898545544\n" +
                "+(91)-265-6648877\n","The Pet Shop"));
        planetsList.add(new Planet("Subhanpura \n\nG 17 Akar Complex, Samta Road, Subhanpura, , Behind State Bank Of India Vadodara - 390007+(91)-9724283424","Aquazoo Aquarium & Pet Shop"));

        planetsList.add(new Planet("Tarsali \n\nFf 5 Ruksmani Complex, Tarsali Road, , Near Tarsali Market Vadodara - 390009+(91)-9979611397, 8530724887","Dev Aquarium & Pet Shop"));
        planetsList.add(new Planet("Vasna \n\n3 Krishna Park -2, Makrand Desai Road, Vasna Road, , Near Tribhuvan Park, Vadodara – 390015  +(91)-265-2252599, +(91)-9825977259","Petzone"));
        planetsList.add(new Planet("Waghodia \n\n11, Jasraj Complex, vaghodia ring road, Waghodia Road Vadodara, , parivar char rasta Vadodara - 390019+(91)-7698489614","Guddu Pet Shop"));

    }


    private void malls()
    {
        planetsList.add(new Planet("Alkapuri \n\nOpp Vadodara Central, Nr Hdfc Bank, Nr Gendigate Circle, Sarabhai Circle, Alkapuri, Vadodara - 390007","Centre Square Mall"));
        planetsList.add(new Planet("Alkapuri \n\nNr Genda Circle, Wadi Wadi, Sarabhai Chemical Road, Alkapuri, Vadodara - 390007","Spencers Retail Ltd"));
        planetsList.add(new Planet("Fatehgunj\n\n Gaurav Path, Fatehgunj, Vadodara - 390008","Sevenseas Mega Mall"));
        planetsList.add(new Planet("Genda \n\n19, Genda Circle, Sarabhai Road, Gorwa, Vadodara - 390016","Vadodara Central Mall"));
        planetsList.add(new Planet("Genda \n\n Near , Genda Circle, Vadodara - 390016","Inorbit Mall"));
        planetsList.add(new Planet("Jetalpur\n\n Nr Chakli Circle, Jetalpur Road, Vadodara - 390005","M Cube The Mall"));
        planetsList.add(new Planet("Nizampura \n\nOpp Mehsana Nagar, Nizampura, Vadodara - 390002","Nanubhai Leisure World"));
        planetsList.add(new Planet("Alkapuri \n\n Nr Alkapuri Petrol Pump, Rc Dutt Road, Vadodara - 390005","Shreem Shalini Mall"));
        planetsList.add(new Planet("Race Course\n\n Monalisa Centrum, Nr Inox Multiplex, Race Course Circle, Race Course Road, Vadodara - 390007","Landmark Ltd"));
        planetsList.add(new Planet("Natubhai Circle\n\n Nr Natubhai Circle, Race Course Circle, Race Course Road, Vadodara - 390007","Cine Mall"));
        planetsList.add(new Planet("Savli \n\nUdalpur Chowkdi, Timbagam Road, Savli, Vadodara - 391150","Ganesh Vasan Bhandar"));
        planetsList.add(new Planet("Vasna \n\n30-Taux Banglo Vasana Road, Vasona Road, N/R Manisha Chokdi, Vasna Road Vadodara, Vadodara - 390015","Spencers Retail"));

    }



    private void swimming()
    {

        planetsList.add(new Planet("Gotri \n\nGotri Sevasi Road, Ranoli, Vadodara - 391350, Near Podar World School\n" +
                "+(91)-265-6567575, +(91)-8866770222   \n","Baroda Presidency Sports Club"));
        planetsList.add(new Planet("Karelibaug \n\nKarelibaug 67, Gandhi Nagar Society, Vadodara, Vadodara - 390018, Behind Arya Kanya, Karelibaug, +(91)-9643203363","SAP Composites"));
        planetsList.add(new Planet("Makarpura \n\n3, Rutushree Complex, Ground Floor, Manjalpur Road, Makarpura, Vadodara - 390014, Opp. IDBI Bank & Kabir Plaza+(91)-9825959676","Aqua World"));
        planetsList.add(new Planet("Rajmahal Road \n\nThe Motibaug Palace, J N Marg, Rajmahal Road, Vadodara - 390001, The Lakshmi Villas Palace Estate+(91)-265-2433599, 6555999 ","Gaekwad Baroda Golf Club"));
        planetsList.add(new Planet("Waghodia \n\nKaladarshan Cross Road, Waghodia, Vadodara - 390019, Near Mahesh Complex , Beside Hanumanji Temple+(91)-265-2516760","Rajiv Gandhi Swimming Pool"));





    }




    private void Theater()
    {
      planetsList.add(new Planet("Salatwada \n\nTilak Road, Salatwada, , Poolbari Naka, Opposite Ssg Hospital, Anandpura Vadodara – 390001 +(91)-265-2426335","Aradhana Cinema"));
        planetsList.add(new Planet("Akota\n\n3rd Floor, Galleria Mall, Akota, Next To Sir Sayajirao Nagar Gruh, Opposite D Mart Vadodara - 390020,+(91)-9537771000, 9537772000","Cinemarc Cinemas"));
        planetsList.add(new Planet(" Alkapuri \n\n3rd Floor, Centre Square Mall, Alkapuri, Opposite Vadodara Central, Near Genda Circle Vadodara - 390007, +(91)-9375917111     +(91)-265-3025100","Mukta Arts Cinemas"));
        planetsList.add(new Planet("Chhani Road \n\nOld Chhani Road, Chhani Road, , Behind Kiran Motors Vadodara - 390024+(91)-8800900009","PVR Cinemas"));
        planetsList.add(new Planet("Chhani Jakat Naka  \n\n Bajwa, , Near Railway Station, Near Chhani Jakat Naka Vadodara - 391310 +(91)-265-2232286, +(91)-9228331967","Ravi Cinema"));
        planetsList.add(new Planet("Dabhoi\n\nCollege Road, Dabhoi, Vadodara - 391110+(91)-2663-258999","Krishna Cinema"));
        planetsList.add(new Planet("Race Course \n\n Race Course,  Ellora Park, Race Course Circle, Gopalbaug Vadodara - 390007\n" +
                "+(91)-265-6191888, 3056888","Inox Cinemas"));
        planetsList.add(new Planet("Race Course \n\n3rd Floor, Cine Mall, Race Course Road, Near Natubhai Circle Vadodara - 390007,+(91)-265-2323726","Cinemax Cinemas"));
        planetsList.add(new Planet("Fateganj \n\nLevel 4, Seven Seas Mall, Fateganj, , Near Ipcl Circle Vadodara - 390002+(91)-265-2783333","Inox Cinemas"));
        planetsList.add(new Planet("Gotri \n\nGotri Road, Sewasi, , Near Gotri Water Tank, Near Gokulnagar  Vadodara - 391101+(91)-265-2370158","Priya Cinema"));
        planetsList.add(new Planet("Miyagam Karjan \n\n Miyagam Karjan Main Road, Miyagam Karjan, Vadodara - 391240, Near Juna Bazar+(91)-2666-232008, +(91)-9328247919","Patel Cinema"));
        planetsList.add(new Planet("Nyay Mandir \n\nNyay Mandir, Near SUR Sagar Lake, Behind Pratap Cinema Vadodara - 390001,+(91)-265-2410856","Prince Cinema"));
        planetsList.add(new Planet("Pratapnagar \n\nPratapnagar Road, Pratapnagar, , Opposite Yogini Vasantdevi Hospital Vadodara - 390004 " +
                "+(91)-265-2422626, +(91)-9377393932","Cinemarc Vihar Cinemas"));
        planetsList.add(new Planet("Pratap Nagar \n\nPratap Nagar Road, Pratapnagar, Vadodara - 390009 +(91)-265-2581435","Alpana Cinema"));
        planetsList.add(new Planet("Padra \n\nPadra, , Near New Bus Stand Vadodara - 391440+ (91)-2662-222888","Krishna Talkies"));
        planetsList.add(new Planet("Raopura \n\nRajhans Business Hub, Raopura Road, Raopura, , Near Raopura Tower Vadodara - 390001+(91)-265-2420042, 2417241","Rajhans Sagar Cinema"));
        planetsList.add(new Planet("Sayaji Ganj \n\nSayaji Ganj, , Opposite Kalaghoda Vadodara - 390020+(91)-265-2361263","Rajshree Cinema"));
//        planetsList.add(new Planet("",""));

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