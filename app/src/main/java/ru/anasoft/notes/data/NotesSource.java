package ru.anasoft.notes.data;

public interface NotesSource {
    NoteData getNoteData(int position);
    int size();
}
