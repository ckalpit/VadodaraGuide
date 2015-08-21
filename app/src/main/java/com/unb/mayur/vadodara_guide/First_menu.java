package com.unb.mayur.vadodara_guide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

//import android.app.Fragment;


public class First_menu extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final String TAG =Stay.class.getSimpleName();
    public static String msg = "";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public static final String EXTRA_MESSAGE = "Message";


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Stay.
     */
    // TODO: Rename and change types and number of parameters
    public static Stay newInstance(String param1, String param2) {
        Stay fragment = new Stay();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public First_menu() {
        // Required empty public constructor
    }

    public static First_menu newInstance()
    {
        return new First_menu();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_first_menu, container, false);


        Button b1 = (Button) v.findViewById(R.id.b_history);
        Button b2 = (Button) v.findViewById(R.id.b_About_city);
        Button b3 = (Button) v.findViewById(R.id.b_htr);
        Button b4=(Button)v.findViewById(R.id.b_map);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);


        return v;
    }
    //     OnClickListener cameraListener = new OnClickListener() {


    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.b_history:
//                msg = "0";

                Intent intent =new Intent(v.getContext(),History.class);
  //              intent.putExtra("Message",msg);
                getActivity().startActivity(intent);


                break;
            case R.id.b_About_city:
    //            msg = "3";
                Intent i =new Intent(v.getContext(),About_vadodara.class);
      //          i.putExtra("Message",msg);
                getActivity().startActivity(i);
                break;

            case R.id.b_htr:
        //        msg = "2";
                Intent it =new Intent(v.getContext(),HoW_t_R.class);
                // it.putExtra("Message",msg);
                getActivity().startActivity(it);
                break;

            case R.id.b_map:
          //      msg = "2";
                Intent itt =new Intent(v.getContext(),MAp_Activity.class);
                //   itt.putExtra("Message",msg);
                getActivity().startActivity(itt);
                break;


            default:

                break;

        }

    }


}



/*        b1.setOnClickListener((View.OnClickListener) cameraListener);
        b2.setOnClickListener((View.OnClickListener) cameraListener);
        b3.setOnClickListener((View.OnClickListener) cameraListener);

*/





