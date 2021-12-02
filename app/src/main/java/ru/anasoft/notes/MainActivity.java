package ru.anasoft.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

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

        if (Utils.isLandscape(getResources())) {

            ListOfNotesFragment listOfNotesFragment = new ListOfNotesFragment();
            replaceFragmentContainer(listOfNotesFragment, R.id.fragment_container_list);

            NoteFragment noteFragment = new NoteFragment();
            replaceFragmentContainer(noteFragment, R.id.fragment_container_note);
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
                        case R.id.action_drawer_groups:
                            openGroupsFragment();
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

    private void openGroupsFragment() {
        GroupsFragment groupsFragment = new GroupsFragment();
        choiceContainer(groupsFragment);
    }

    private void openSettingsFragment() {
        SettingsFragment settingsFragment = new SettingsFragment();
        choiceContainer(settingsFragment);
    }

    private void openAboutFragment() {
        AboutFragment aboutFragment = new AboutFragment();
        choiceContainer(aboutFragment);
    }

    private void choiceContainer(Fragment fragment) {

        if (Utils.isLandscape(getResources())) {
            replaceFragmentContainer(fragment, R.id.fragment_container_note);
        }
        else {
            replaceFragmentContainer(fragment, R.id.fragment_container);
        }
    }

    private void replaceFragmentContainer(Fragment fragment, int container) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(container, fragment)
                .addToBackStack("")
                .commit();
    }

}