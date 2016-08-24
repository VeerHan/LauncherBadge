package com.leihan.launcherbadge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import me.leolin.shortcutbadger.ShortcutBadger;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int badgeCount = 6;
    private Button btnAdd, btnRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = (Button) findViewById(R.id.btn_add);
        btnRemove = (Button) findViewById(R.id.btn_remove);
        btnAdd.setOnClickListener(this);
        btnRemove.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                ShortcutBadger.applyCount(this, badgeCount);
                break;
            case R.id.btn_remove:
                ShortcutBadger.removeCount(this);
                break;
        }
    }
}
