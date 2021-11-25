package ru.anasoft.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity", "onCreate");

        if (Utils.isLandscape(getResources())) {
            Log.d("MainActivity", "isLandscape");

            ListOfNotesFragment listOfNotesFragment = new ListOfNotesFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_list, listOfNotesFragment)
                    .commit();

            NoteFragment noteFragment = new NoteFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_note, noteFragment)
                    .commit();
        }
        else {
            Log.d("MainActivity", "isPortrait");

            ListOfNotesFragment listOfNotesFragment = new ListOfNotesFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, listOfNotesFragment)
                    .commit();

        }
    }
}