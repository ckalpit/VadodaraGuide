package com.unb.mayur.vadodara_guide;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class Imp_no extends Activity {

    ListView listView;
    String msg = " ";
    String[] Titles={"Police Stations","Emergency Numbers","Pincodes"};
    public static final String EXTRA_MESSAGE = "Message";
    int[] images = {R.drawable.poicestation,R.drawable.emergancy_number,R.drawable.pincode_number};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imp_no);


        Intent intent = getIntent();
        msg = intent.getStringExtra(Stay.EXTRA_MESSAGE);
        int msg_int = Integer.parseInt(msg);//typecast

        Resources res = getResources();
        //   Titles = res.getStringArray(R.array.Places);

        listView = (ListView)findViewById(R.id.listView);

        LVhelper adapter = new LVhelper(this, Titles, images);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
//                Toast.makeText(getApplicationContext(),
                //                      "Click ListItem Number " + position, Toast.LENGTH_LONG)
                //                     .show();


                Intent i = new Intent(Imp_no.this,Addr_imp_no.class);
                //     EditText editText =(EditText)findViewById(R.id.edit_message);

                //String msg = editText.getText().toString();
                String msg = Integer.toString(position);

                i.putExtra("Message",msg);


                startActivity(i);
                //  Toast.makeText(this,"Next activity",Toast.LENGTH_LONG).show();





            }
        });

    }


    class LVhelper extends ArrayAdapter<String> {
        Context context;
        int[] images;
        String[] titlearray;

        LVhelper(Context c, String[] titles, int imgs[]) {

            super(c, R.layout.singlerow, R.id.textView1, titles);
            this.context = c;
            this.images = imgs;
            this.titlearray = titles;
        }


        class MyViewHolder {

            ImageView myimg;
            TextView mytxt;

            MyViewHolder(View view) {

                myimg = (ImageView) view.findViewById(R.id.imageView);
                mytxt = (TextView) view.findViewById(R.id.textView1);
            }
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            MyViewHolder holder = null;
            if (row == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.singlerow, parent, false);
                holder = new MyViewHolder(row);
                row.setTag(holder);
            } else {
                holder = (MyViewHolder) row.getTag();

            }


            holder.myimg.setImageResource(images[position]);
            holder.mytxt.setText(titlearray[position]);

            return row;
        }

    }



}
