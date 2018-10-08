package testapp.jccolumbres.fragmentbackstack;

import android.support.v4.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentB extends Fragment {

    private static final String TAG = FragmentB.class.getSimpleName();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e(TAG,"onAttach()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG,"onCreate");
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b,container,false);
        Log.e(TAG,"onCreateView()");
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG,"onActivityCreated()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG,"onStart()");
    }


    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG,"onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG,"onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG,"OnStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(TAG,"OnDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"OnDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(TAG,"OnDetach()");
    }
}
