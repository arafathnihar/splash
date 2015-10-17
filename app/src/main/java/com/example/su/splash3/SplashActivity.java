package com.example.su.splash3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.ListView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash1);
        startAnimating();

//////////////////////////////////////////////////////////////////////////////////////
        //LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_slide);
        //this.setLayoutAnimation(controller);

        //ListView listView=(ListView)findViewById(R.id.ListView_Menu);
        //listView.setLayoutAnimation(controller);
/////////////////////////////////////////////////////////////////////////////////////
    }

    /**
     * Helper method to start the animation on the splash screen
     */

    private void startAnimating() {
        //Fade in red background
        ImageView background1 = (ImageView) findViewById(R.id.bckgrnd);
        Animation fade1 = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        background1.startAnimation(fade1);

        // Fade in welcome text typewriter effect
        final TypewriterActivity writer = (TypewriterActivity)findViewById(R.id.welcome);
        //Add a character every 50ms
        writer.setCharacterDelay(50);
        writer.animateText(getString(R.string.welcome));

        // Fade in logo after a built-in delay.
        ImageView logo1 = (ImageView) findViewById(R.id.logo);
        Animation fade2 = AnimationUtils.loadAnimation(this, R.anim.fade_in2);
        logo1.startAnimation(fade2);

        // Transition to Main Menu when background finishes fading in
        fade1.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                // The animation has ended, transition to the Main Menu screen
                startActivity(new Intent(SplashActivity.this, MenuActivity.class));
                SplashActivity.this.finish();
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        /*// Load animations for all views within the TableLayout
        Animation spinin = AnimationUtils.loadAnimation(this, R.anim.custom_anim);
        LayoutAnimationController controller = new LayoutAnimationController(spinin);
        TableLayout table = (TableLayout) findViewById(R.id.TableLayout01);
        for (int i = 0; i < table.getChildCount(); i++) {
            TableRow row = (TableRow) table.getChildAt(i);
            row.setLayoutAnimation(controller);
        }*/
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Stop the animation
        ImageView background1 = (ImageView) findViewById(R.id.bckgrnd);
        background1.clearAnimation();
        //TextView welcome1 = (TextView) findViewById(R.id.welcome);
        //welcome1.clearAnimation();
        ImageView logo1 = (ImageView) findViewById(R.id.logo);
        logo1.clearAnimation();
        /*TableLayout table = (TableLayout) findViewById(R.id.TableLayout01);
        for (int i = 0; i < table.getChildCount(); i++) {
            TableRow row = (TableRow) table.getChildAt(i);
            row.clearAnimation();
        }*/
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Start animating at the beginning so we get the full splash screen experience
        startAnimating();
    }


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
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
    }*/
}
