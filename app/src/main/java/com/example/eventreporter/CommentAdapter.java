package com.example.eventreporter;

import android.content.Context;
import android.view.LayoutInflater;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentAdapter {
    private Context context;
    private final static int TYPE_EVENT = 0;
    private final static int TYPE_COMMENT = 1;

    private List<Comment> commentList;
    private Event event;

    private DatabaseReference databaseReference;
    private LayoutInflater inflater;

    public CommentAdapter(Context context) {
        this.context = context;
        commentList = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
    }
}
