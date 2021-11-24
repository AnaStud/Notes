package ru.anasoft.notes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ListOfNotesFragment extends Fragment {

    private static final String CURRENT_NOTE = "currentNote";
    private int currentNote;

    public static ListOfNotesFragment newInstance(int currentNote) {
        ListOfNotesFragment fragment = new ListOfNotesFragment();
        Bundle args = new Bundle();
        args.putInt(CURRENT_NOTE, currentNote);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_of_notes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            currentNote = getArguments().getInt(CURRENT_NOTE);
        }
        initListOfNotes(view);
    }

    private void initListOfNotes(View view) {

        //TODO заменить на массив заметок
        NoteData[] notes = new NoteData[4];
        notes[0] = new NoteData("Заметка 1", new Date(), "Белеет парус одинокий");
        notes[1] = new NoteData("Заметка 2", new Date(), "В тумане моря голубом.");
        notes[2] = new NoteData("Заметка 3", new Date(), "Что ищет он в стране далёкой?");
        notes[3] = new NoteData("Заметка 4", new Date(), "Что кинул он в краю родном?");

        LinearLayout layout = (LinearLayout) view;

        for(NoteData note : notes){

            TextView noteDate = new TextView(getContext());
            noteDate.setText(note.getDate());
            layout.addView(noteDate);

            TextView noteName = new TextView(getContext());
            noteName.setText(note.getName());
            noteName.setTextSize(24);
            layout.addView(noteName);

            TextView space = new TextView(getContext());
            space.setText("");
            layout.addView(space);

            noteName.setOnClickListener(v -> showOneNote(note));
        }
    }

    private void showOneNote(NoteData note) {
        NoteFragment noteFragment = NoteFragment.newInstance(note);
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, noteFragment)
                .commit();
    }

}