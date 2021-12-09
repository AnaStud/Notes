package ru.anasoft.notes;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbarAndDrawer();

        showFragments();
    }

    private void showFragments() {

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            ListOfNotesFragment listOfNotesFragment = new ListOfNotesFragment();
            replaceFragmentContainer(listOfNotesFragment, R.id.fragment_container_list);

            NoteFragment noteFragment = new NoteFragment();
            replaceFragmentContainer(noteFragment, R.id.fragment_container);
        }
        else {
            ListOfNotesFragment listOfNotesFragment = new ListOfNotesFragment();
            replaceFragmentContainer(listOfNotesFragment, R.id.fragment_container);
        }
    }

    private void initToolbarAndDrawer() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initDrawer(toolbar);
    }

    private void initDrawer(Toolbar toolbar) {

        final DrawerLayout drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(
                item -> {
                    int id = item.getItemId();
                    switch (id) {
                        case R.id.action_drawer_new:
                            openNewNoteFragment();
                            drawer.closeDrawers();
                            return true;
                        case R.id.action_drawer_settings:
                            openSettingsFragment();
                            drawer.closeDrawers();
                            return true;
                        case R.id.action_drawer_about:
                            openAboutFragment();
                            drawer.closeDrawers();
                            return true;
                    }
                    return false;
                });
    }

    private void openNewNoteFragment() {
        NewNoteFragment newNoteFragment = new NewNoteFragment();
        replaceFragmentContainer(newNoteFragment, R.id.fragment_container);
    }

    private void openSettingsFragment() {
        SettingsFragment settingsFragment = new SettingsFragment();
        replaceFragmentContainer(settingsFragment, R.id.fragment_container);
    }

    private void openAboutFragment() {
        AboutFragment aboutFragment = new AboutFragment();
        replaceFragmentContainer(aboutFragment, R.id.fragment_container);
    }

    private void replaceFragmentContainer(Fragment fragment, int container) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(container, fragment)
                .addToBackStack("")
                .commit();
    }

}