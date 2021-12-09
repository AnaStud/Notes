package ru.anasoft.notes.data;

import java.util.ArrayList;
import java.util.List;

import java.util.Date;

public class NotesData implements NotesSource {

    private List<NoteData> dataSource;

    public NotesData(){
        dataSource = new ArrayList<>(12);
    }

    public NotesSource init(){

        Date today = new Date();
        //TODO заменить на массив заметок
        dataSource.add(new NoteData(today, "Заметка 1", "Белеет парус одинокий"));
        dataSource.add(new NoteData(today, "Заметка 2", "В тумане моря голубом."));
        dataSource.add(new NoteData(today, "Заметка 3", "Что ищет он в стране далёкой?"));
        dataSource.add(new NoteData(today, "Заметка 4", "Что кинул он в краю родном?"));
        dataSource.add(new NoteData(today, "Заметка 5", "Играют волны, ветер свищет"));
        dataSource.add(new NoteData(today, "Заметка 6", "И мачта гнётся и скрипит."));
        dataSource.add(new NoteData(today, "Заметка 7", "Увы, он счастия не ищет"));
        dataSource.add(new NoteData(today, "Заметка 8", "И не от счастия бежит."));
        dataSource.add(new NoteData(today, "Заметка 9", "Под ним - струя светлей лазури,"));
        dataSource.add(new NoteData(today, "Заметка 10", "Над ним - луч солнца золотой,"));
        dataSource.add(new NoteData(today, "Заметка 11", "А он, мятежный, просит бури,"));
        dataSource.add(new NoteData(today, "Заметка 12", "Как будто в бурях есть покой."));

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
}
