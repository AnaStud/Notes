package ru.anasoft.notes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import java.util.Date;

import ru.anasoft.notes.data.NoteData;

public class NewNoteFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_new_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_add).setOnClickListener(v -> {

            EditText editTextNameNote = requireActivity().findViewById(R.id.editText_nameNote);
            String nameNote = editTextNameNote.getText().toString();
            EditText editTextNote = requireActivity().findViewById(R.id.editText_note);
            String note = editTextNote.getText().toString();

            NoteData noteData = new NoteData(new Date(), nameNote, note);

            Bundle result = new Bundle();
            result.putParcelable("ONE_NOTE", noteData);
            getParentFragmentManager().setFragmentResult("MY_NOTE", result);

            Snackbar.make(view, "Добавлено", Snackbar.LENGTH_LONG).show();

            requireActivity()
                    .getSupportFragmentManager()
                    .popBackStack ();

        });
    }
}