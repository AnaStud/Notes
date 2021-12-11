package ru.anasoft.notes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import ru.anasoft.notes.data.NoteData;
import ru.anasoft.notes.data.NotesData;
import ru.anasoft.notes.data.NotesSource;
import ru.anasoft.notes.ui.NotesAdapter;

public class ListOfNotesFragment extends Fragment {

    private RecyclerView recyclerView;
    private NotesSource data;
    private NotesAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_of_notes, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_list);
        data = new NotesData().init();

        initListOfNotes(recyclerView, data);

        setResultListener();

        return view;
    }

    private void initListOfNotes(RecyclerView recyclerView, NotesSource data) {
        recyclerView.setHasFixedSize(true);

        adapter = new NotesAdapter(data, this);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener((view, position) -> {
            Toast.makeText(getContext(),
                    data.getNoteData(position).getNote(),
                    Toast.LENGTH_SHORT).show();
        });
    }

    private void setResultListener() {
        getParentFragmentManager()
                .setFragmentResultListener("MY_NOTE", this, (key, bundle) -> {
                    NoteData result = bundle.getParcelable("ONE_NOTE");
                    data.addNoteData(result);
                    adapter.notifyItemInserted(data.size() - 1);
                });
    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v,
                                    @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = requireActivity().getMenuInflater();
        menuInflater.inflate(R.menu.card_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_update:
                return true;
            case R.id.action_delete:
                return true;
        }
        return super.onContextItemSelected(item);
    }

}