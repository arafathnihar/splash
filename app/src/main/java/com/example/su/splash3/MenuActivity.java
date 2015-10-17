package com.example.su.splash3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ArrayAdapter;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
/**
 * Created by su on 9/14/2015.
 */
public class MenuActivity extends AppCompatActivity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ListView menuList = (ListView) findViewById(R.id.ListView_Menu);
        String[] items = {
                getResources().getString(R.string.menu_item_knowledge),
                getResources().getString(R.string.menu_item_business),
                getResources().getString(R.string.menu_item_events),
                getResources().getString(R.string.menu_item_food),
                getResources().getString(R.string.menu_item_language),
                getResources().getString(R.string.menu_item_support),
                getResources().getString(R.string.menu_item_notices),};
        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this, R.layout.menu_item, items);
        menuList.setAdapter(adapt);
        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                // Note: if the list was built "by hand" the id could be used.
                // As-is, though, each item has the same id
                TextView textView = (TextView) itemClicked;
                String strText = textView.getText().toString();
                if (strText.equalsIgnoreCase(getResources().getString(R.string.menu_item_knowledge))) {
                    // Launch the Knowledge Activity
                    startActivity(new Intent(MenuActivity.this, KnowledgeActivity.class));
                } else if (strText.equalsIgnoreCase(getResources().getString(R.string.menu_item_business))) {
                    // Launch the Business Activity
                    startActivity(new Intent(MenuActivity.this, BusinessActivity.class));
                } else if (strText.equalsIgnoreCase(getResources().getString(R.string.menu_item_events))) {
                    // Launch the Events Activity
                    startActivity(new Intent(MenuActivity.this, EventsActivity.class));
                } else if (strText.equalsIgnoreCase(getResources().getString(R.string.menu_item_food))) {
                    // Launch the Food Activity
                    startActivity(new Intent(MenuActivity.this, FoodActivity.class));
                } else if (strText.equalsIgnoreCase(getResources().getString(R.string.menu_item_language))) {
                    // Launch the language Activity
                    startActivity(new Intent(MenuActivity.this, LanguageActivity.class));
                } else if (strText.equalsIgnoreCase(getResources().getString(R.string.menu_item_support))) {
                    // Launch the Support Activity
                    startActivity(new Intent(MenuActivity.this, SupportActivity.class));
                } else if (strText.equalsIgnoreCase(getResources().getString(R.string.menu_item_notices))) {
                    // Launch the Notices Activity
                    startActivity(new Intent(MenuActivity.this, NoticesActivity.class));
                }
            }
        });
    ////////////////////////////////////////////////////
        LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_slide);
        menuList.setLayoutAnimation(controller);

        //ListView listView=(ListView)findViewById(R.id.ListView_Menu);
        //listView.setLayoutAnimation(controller);

    }
}

