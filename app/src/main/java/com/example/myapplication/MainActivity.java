package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Optional: Setup NavController with Toolbar if you add one
        // NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
        //        .findFragmentById(R.id.nav_host_fragment);
        // if (navHostFragment != null) {
        //     NavController navController = navHostFragment.getNavController();
        //     // Example: Setup with an ActionBar/Toolbar
        //     // Toolbar toolbar = findViewById(R.id.toolbar);
        //     // setSupportActionBar(toolbar);
        //     // NavigationUI.setupActionBarWithNavController(this, navController);
        // }
    }

    // Optional: If using an ActionBar/Toolbar with NavController
    // @Override
    // public boolean onSupportNavigateUp() {
    //    NavController navController = NavHostFragment.findNavController(getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment));
    //    return NavigationUI.navigateUp(navController, (androidx.drawerlayout.widget.DrawerLayout) null)
    //            || super.onSupportNavigateUp();
    // }
}