package com.unb.mayur.vadodara_guide;

//import android.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class abt_ extends DialogFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
   private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
//    public static final String TAG = Life_style.class.getSimpleName();

 /*   public static abt_ newInstance()
    {
        return new abt_();
    };
*/
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

//    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment abt_.
     */
    // TODO: Rename and change types and number of parameters
 /*   public static abt_ newInstance(String param1, String param2) {
        abt_ fragment = new abt_();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
*/
    public abt_() {
        // Required empty public constructor
    }

 /*     @Override
  public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
*/
    /*
  @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


            View rootView = inflater.inflate(R.layout.fragment_abt_, container,
                    false);
            getDialog().setTitle("About Diu Guide");
            // Do something else
            return rootView;
        }

        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_abt_, container, false);

*/




/*
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }

*/


/*

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
*/
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }



    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                // Set Dialog Icon
                .setIcon(R.drawable.ic_launcher)
                        // Set Dialog Title
                .setTitle("About Vadodara Guide")
                        // Set Dialog Message
                .setMessage("A travel guide tool that will make you familiar with the city.\n\nVersion 1.0\nDeveloped by: Mayur Sarang  \n\n").create();

     /*                   // Positive button
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Do something else
                    }
                })

                        // Negative Button
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,	int which) {
                       // Do something else
                    }
                }).create();
*/
    }

}
