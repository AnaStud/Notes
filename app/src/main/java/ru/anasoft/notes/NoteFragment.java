package ru.anasoft.notes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import ru.anasoft.notes.data.NoteData;

public class NoteFragment extends Fragment {

    private static final String ARG_NOTE_DATA = "noteData";
    private NoteData noteData;

     public static NoteFragment newInstance(NoteData note) {
        NoteFragment fragment = new NoteFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_NOTE_DATA, note);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            noteData = getArguments().getParcelable(ARG_NOTE_DATA);
            initNote(view);
        }

    }

    private void initNote(View view) {

        LinearLayout layout = (LinearLayout) view;

        TextView noteDate = new TextView(getContext());
        noteDate.setText(noteData.getDate());
        layout.addView(noteDate);

        TextView noteName = new TextView(getContext());
        noteName.setText(noteData.getName());
        noteName.setTextSize(24);
        layout.addView(noteName);

        TextView noteNote = new TextView(getContext());
        noteNote.setText(noteData.getNote());
        noteNote.setTextSize(16);
        layout.addView(noteNote);

    }
}