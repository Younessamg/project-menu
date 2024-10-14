package ma.ensa.menu;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private ImageView logo;
    private ImageView backgroundImage;  // For the stable image

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        // Assign the background and logo views
        backgroundImage = findViewById(R.id.background_image);  // Moroccan food image
        logo = findViewById(R.id.logo);  // App logo to animate

        // The background image remains stable, no animation here

        // Animate the logo on top of the static image
        // Animer le logo
        logo.animate().rotation(360f).setDuration(2000);
        logo.animate().scaleX(0.5f).scaleY(0.5f).setDuration(3000);
        logo.animate().translationYBy(1000f).setDuration(2000);
        logo.animate().alpha(0f).setDuration(6000);

        // Delay for splash screen and transition to next activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, ListActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);  // 5 seconds delay
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.finish();
    }
}
