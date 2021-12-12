package ru.anasoft.notes.data;

import java.util.ArrayList;
import java.util.List;

import java.util.Date;

public class NotesData implements NotesSource {

    private List<NoteData> dataSource;

    public NotesData(){
        dataSource = new ArrayList<>(12);
    }

    public NotesSource init(NotesSourceResponse notesSourceResponse){
        if (notesSourceResponse != null){
            notesSourceResponse.initialized(this);
        }
        return this;
    }

   @Override
    public NoteData getNoteData(int position) {
        return dataSource.get(position);
    }

    @Override
    public int size() {
        return dataSource.size();
    }

    @Override
    public void addNoteData(NoteData noteData) {
        dataSource.add(noteData);
    }
}
