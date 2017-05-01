package com.anwesome.ui.switchselectlistdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.anwesome.ui.switchselectlist.OnSelectionChangeListener;
import com.anwesome.ui.switchselectlist.SwitchSelectLayout;
import com.anwesome.ui.switchselectlist.SwitchSelectList;

public class MainActivity extends AppCompatActivity {
    private String titles[] = {"ADD","ICON","SHOW","DELETE","NOPE"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SwitchSelectList switchSelectList = new SwitchSelectList(this);
        for(String title:titles) {
            final String option  = title;
            switchSelectList.addOption(option, new OnSelectionChangeListener() {
                @Override
                public void onSelect() {
                    Toast.makeText(MainActivity.this,String.format("%s selected",option), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onUnSelect() {
                    Toast.makeText(MainActivity.this,String.format("%s unselected",option), Toast.LENGTH_SHORT).show();
                }
            });
        }
        switchSelectList.show();
    }
}
