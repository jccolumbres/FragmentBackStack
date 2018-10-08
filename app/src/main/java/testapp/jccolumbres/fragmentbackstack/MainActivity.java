package testapp.jccolumbres.fragmentbackstack;

import android.nfc.Tag;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();
        manager.addOnBackStackChangedListener(this);
    }

    public void addFragmentA(View view) {
        FragmentA fragmentA = new FragmentA();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container,fragmentA,"FragA");
        transaction.addToBackStack("AddFragA");
        transaction.commit();
    }

    public void removeFragmentA(View view) {
        FragmentA fragA = (FragmentA) manager.findFragmentByTag("FragA");
        if (fragA != null) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(fragA);
            transaction.addToBackStack("RemFragA");
            transaction.commit();
        }else{
            Toast.makeText(this,"Not attached",Toast.LENGTH_SHORT).show();
        }
    }

    public void addFragmentB(View view) {
        FragmentB fragmentB = new FragmentB();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container,fragmentB,"FragB");
        transaction.addToBackStack("AddFragB");
        transaction.commit();
    }

    public void removeFragmentB(View view) {
        FragmentB fragB = (FragmentB) manager.findFragmentByTag("FragB");
        if (fragB != null){
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(fragB);
            transaction.addToBackStack("RemFragB");
            transaction.commit();
        }else {
            Toast.makeText(this,"Not attached",Toast.LENGTH_SHORT).show();
        }
    }

    public void replaceByFragmentA(View view) {
        FragmentA fragmentA = new FragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA!=null) {
            transaction.replace(R.id.container, fragmentA, "FragA");
            transaction.addToBackStack("RepFragA");
            transaction.commit();
        }else{
            Toast.makeText(this,"Not attached",Toast.LENGTH_SHORT).show();
        }
    }

    public void replaceByFragmentB(View view) {
        FragmentB fragmentB = new FragmentB();
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentB!=null) {
            transaction.replace(R.id.container, fragmentB, "FragB");
            transaction.addToBackStack("RepFragB");
            transaction.commit();
        }else{
            Toast.makeText(this,"Not attached",Toast.LENGTH_SHORT).show();
        }
    }

    public void attachFragmentA(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("FragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA!=null){
            transaction.attach(fragmentA);
            transaction.addToBackStack("AttachFragA");
            transaction.commit();
        }else{
            Toast.makeText(this,"Not attached",Toast.LENGTH_SHORT).show();
        }
    }


    public void detachFragmentA(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("FragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA!=null){
            transaction.detach(fragmentA);
            transaction.addToBackStack("DetachFragA");
            transaction.commit();
        }else{
            Toast.makeText(this,"Not attached",Toast.LENGTH_SHORT).show();
        }
    }

    public void showFrag(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("FragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA!=null){
            transaction.show(fragmentA);
            transaction.addToBackStack("ShowFragA");
            transaction.commit();
        }else{
            Toast.makeText(this,"Not attached",Toast.LENGTH_SHORT).show();
        }
    }

    public void hideFrag(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("FragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA!=null){
            transaction.hide(fragmentA);
            transaction.addToBackStack("HideFragA");
            transaction.commit();
        }else{
            Toast.makeText(this,"Not attached",Toast.LENGTH_SHORT).show();
        }
    }

    public void dummyBackClick(View view) {
        manager.popBackStack();
    }

    public void popAddFragAIncTrans(View view) {
        manager.popBackStack("AddFragA",FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    public void popAddFragBTrans(View view) {
        manager.popBackStack("AddFragB", 0);
    }

    @Override
    public void onBackStackChanged() {
        int length = manager.getBackStackEntryCount();

        StringBuilder msg = new StringBuilder("");

        for (int i = length-1;i >= 0; i--){
            msg.append("Index ").append(i).append(" : ");
            msg.append(manager.getBackStackEntryAt(i).getName());
            msg.append("\n");
        }

        Log.i(TAG,"\n" + msg.toString() + "\n");
    }
}
