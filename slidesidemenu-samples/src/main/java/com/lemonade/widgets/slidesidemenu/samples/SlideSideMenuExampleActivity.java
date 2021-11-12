package com.lemonade.widgets.slidesidemenu.samples;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.lemonade.widgets.slidesidemenu.SlideSideMenuTransitionLayout;

public class SlideSideMenuExampleActivity extends AppCompatActivity implements View.OnClickListener {

    private SlideSideMenuTransitionLayout mSlideSideMenu;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_side_menu_example);

        // Grab the widget
        mSlideSideMenu = (SlideSideMenuTransitionLayout)findViewById(R.id.slide_side_menu);

        // Setup the toolbar
        mToolbar = (Toolbar) findViewById(R.id.base_toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setTitleTextColor(Color.WHITE);

        // Wire SideMenu with Toolbar
        mToolbar.setNavigationIcon(R.drawable.ic_menu);
        mToolbar.setNavigationOnClickListener(v -> mSlideSideMenu.toggle());

        // 菜单的几个按钮
        ((TextView)findViewById(R.id.menu_me)).setOnClickListener(this);
        ((TextView)findViewById(R.id.menu_about)).setOnClickListener(this);
        ((TextView)findViewById(R.id.menu_service)).setOnClickListener(this);
        ((TextView)findViewById(R.id.menu_quit)).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.menu_me:
                System.out.println("R.id.menu_me = " + R.id.menu_me);
                break;
            case R.id.menu_about:
                System.out.println("R.id.menu_about = " + R.id.menu_about);
                break;
            case R.id.menu_service:
                System.out.println("R.id.menu_service = " + R.id.menu_service);
                break;
            case R.id.menu_quit:
                System.out.println("R.id.menu_quit = " + R.id.menu_quit);
                break;
            default:
                System.out.println("onclick = default");
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (mSlideSideMenu != null && mSlideSideMenu.closeSideMenu()) {
            // Closed the side menu, override the default back pressed behavior
            return;
        }
        super.onBackPressed();
    }


}
