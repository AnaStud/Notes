package ru.anasoft.notes.data;

import com.google.firebase.Timestamp;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class NoteDataMapping {

    public static class Fields {
        public final static String DATE = "date";
        public final static String NAME = "name";
        public final static String NOTE = "note";
    }

    public static NoteData toNoteData(String id, Map<String, Object> doc) {
        Timestamp timeStamp = (Timestamp)doc.get(Fields.DATE);
        NoteData answer = new NoteData(
                timeStamp.toDate(),
                (String)doc.get(Fields.NAME),
                (String)doc.get(Fields.NOTE));
        answer.setId(id);
        return answer;
    }

    public static Map<String, Object> toDocument(NoteData noteData) {
        Map<String, Object> answer = new HashMap<>();
        answer.put(Fields.DATE, noteData.getOriginDate());
        answer.put(Fields.NAME, noteData.getName());
        answer.put(Fields.NOTE, noteData.getNote());
        return answer;
    }

}

