package ru.anasoft.notes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import ru.anasoft.notes.data.NotesData;
import ru.anasoft.notes.data.NotesSource;
import ru.anasoft.notes.ui.NotesAdapter;

public class ListOfNotesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_of_notes, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_list);
        NotesSource data = new NotesData().init();
        initListOfNotes(recyclerView, data);
        return view;
    }

    private void initListOfNotes(RecyclerView recyclerView, NotesSource data) {
        recyclerView.setHasFixedSize(true);

        NotesAdapter adapter = new NotesAdapter(data);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener((view, position) -> {
            Toast.makeText(getContext(),
                    data.getNoteData(position).getNote(),
                    Toast.LENGTH_SHORT).show();
        });
    }
}