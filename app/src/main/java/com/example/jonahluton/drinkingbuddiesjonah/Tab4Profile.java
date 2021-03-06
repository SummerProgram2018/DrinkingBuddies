package com.example.jonahluton.drinkingbuddiesjonah;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.jonahluton.drinkingbuddiesjonah.utils.SharedPrefsUtil;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Tab4Profile.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Tab4Profile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab4Profile extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button edit_profile;
    private OnFragmentInteractionListener mListener;
    private TextView name,dis;
    public Tab4Profile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab4Profile.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab4Profile newInstance(String param1, String param2) {
        Tab4Profile fragment = new Tab4Profile();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab4_profile, container, false);
        initView(view);
        return view;
    }
    private void initView(View view){
        edit_profile = (Button)view.findViewById(R.id.edit_profile);
        edit_profile.setOnClickListener(this);
        name = (TextView) view.findViewById(R.id.name);
        dis = (TextView)view.findViewById(R.id.dis);
    }
    @Override
    public void onResume() {
        super.onResume();
        String name_= SharedPrefsUtil.getStringValue(getContext(),"name",null);
        String dis_=SharedPrefsUtil.getStringValue(getContext(),"dis",null);
        if (name_!=null){
            name.setText(name_);
        }
        if (dis_!=null){
            dis.setText(dis_);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.edit_profile:
                Intent intent = new Intent(getActivity(), EditProfile.class);
                startActivity(intent);

 /*               //如果是用的v4的包，则用getActivity().getSuppoutFragmentManager();
                FragmentManager fm = getActivity().getFragmentManager();
                //注意v4包的配套使用
                Fragment fragment = new EditProfile()
                fm.beginTransaction().replace(容器控件id,fragment).commit();*/
                break;
            default:
                    break;
        }
    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }

    }



    public void updateUI(String name_,String dis_){
        name.setText(name_);
        dis.setText(dis_);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
