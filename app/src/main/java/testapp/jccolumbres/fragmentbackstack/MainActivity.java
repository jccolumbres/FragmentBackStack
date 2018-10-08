package testapp.jccolumbres.fragmentbackstack;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();
    }

    public void addFragmentA(View view) {
        FragmentA fragmentA = new FragmentA();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container,fragmentA,"FragA");
        transaction.commit();
    }

    public void removeFragmentA(View view) {
        FragmentA fragA = (FragmentA) manager.findFragmentByTag("FragA");
        if (fragA != null) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(fragA);
            transaction.commit();
        }else{
            Toast.makeText(this,"Not attached",Toast.LENGTH_SHORT).show();
        }
    }

    public void addFragmentB(View view) {
        FragmentB fragmentB = new FragmentB();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container,fragmentB,"FragB");
        transaction.commit();
    }

    public void removeFragmentB(View view) {
        FragmentB fragB = (FragmentB) manager.findFragmentByTag("FragB");
        if (fragB != null){
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(fragB);
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
            transaction.commit();
        }else{
            Toast.makeText(this,"Not attached",Toast.LENGTH_SHORT).show();
        }
    }

    public void dummyBackClick(View view) {
    }

    public void popAddFragAIncTrans(View view) {
    }

    public void popAddFragBTrans(View view) {
    }
}
