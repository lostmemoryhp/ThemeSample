package com.example.lhp.themesample;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;


public class MainActivity extends ActionBarActivity {
    static int FontStyleId = R.style.FontSizeStyle_Small;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getTheme().applyStyle(FontStyleId,true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment  implements View.OnClickListener{
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            rootView.findViewById(R.id.changeTheme).setOnClickListener(this);
            return rootView;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.changeTheme:
                    switch (FontStyleId){
                        case R.style.FontSizeStyle_Small:
                            FontStyleId=R.style.FontSizeStyle_Medium;
                            getActivity().setTheme(FontStyleId);
                            break;
                        case R.style.FontSizeStyle_Medium:
                            FontStyleId=R.style.FontSizeStyle_Large;
                            getActivity().setTheme(FontStyleId);
                            break;
                        case R.style.FontSizeStyle_Large:
                            FontStyleId=R.style.FontSizeStyle_xLarge;
                            getActivity().setTheme(FontStyleId);
                            break;
                        case R.style.FontSizeStyle_xLarge:
                            FontStyleId = R.style.FontSizeStyle_Small;
                            getActivity().setTheme(FontStyleId);
                            break;
                    }
                    getActivity().finish();
                    startActivity(new Intent(getActivity(),MainActivity.class));
                    break;
            }
        }
    }
}
