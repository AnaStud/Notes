package ru.anasoft.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListOfNotesFragment listOfNotesFragment = new ListOfNotesFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, listOfNotesFragment)
                .commit();
    }
}