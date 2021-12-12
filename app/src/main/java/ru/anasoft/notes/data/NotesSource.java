package ru.anasoft.notes.data;

public interface NotesSource {
    NotesSource init(NotesSourceResponse notesSourceResponse);
    NoteData getNoteData(int position);
    int size();
    void addNoteData(NoteData noteData);
}
