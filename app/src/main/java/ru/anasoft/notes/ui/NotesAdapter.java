package ru.anasoft.notes.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.anasoft.notes.R;
import ru.anasoft.notes.data.NoteData;
import ru.anasoft.notes.data.NotesSource;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    private final static String TAG = "NotesAdapter";
    private NotesSource dataSource;
    private OnItemClickListener itemClickListener;

    public NotesAdapter(NotesSource dataSource){
        this.dataSource = dataSource;
    }


    @NonNull
    @Override
    public NotesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesAdapter.ViewHolder holder, int position) {
        holder.bind(dataSource.getNoteData(position));
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.dateNote);
            name = itemView.findViewById(R.id.nameNote);

            name.setOnClickListener(view -> {
                if (itemClickListener != null){
                    itemClickListener.onItemClick(view, getAdapterPosition());
                }
            });
        }

        public void bind(NoteData noteData){
            date.setText(noteData.getDate());
            name.setText(noteData.getName());
        }
    }

}
