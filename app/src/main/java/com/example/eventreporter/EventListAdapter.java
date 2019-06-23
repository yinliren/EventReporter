package com.example.eventreporter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.ViewHolder> {
    private List<Event> eventList;

    /**
     * Constructor for EventListAdapter
     * @param events events that are showing on the screen
     */
    public EventListAdapter(List<Event> events) {
        eventList = events;
    }

    /**
     * Use ViewHolder to hold view widget, view holder is required to be used in recycler view
     * https://developer.android.com/training/improving-layouts/smooth-scrolling.html
     * describe the advantage of using view holder
     */
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView title;
        public TextView location;
        public TextView description;
        public TextView time;
        public ImageView imgview;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            title = (TextView) v.findViewById(R.id.event_item_title);
            location = (TextView) v.findViewById(R.id.event_item_location);
            description = (TextView) v.findViewById(R.id.event_item_description);
            time = (TextView) v.findViewById(R.id.event_item_time);
            imgview = (ImageView) v.findViewById(R.id.event_item_img);
        }
    }


    /**
     * OnBindViewHolder will render created view holder on screen
     * @param holder ViewHolder created for each position
     * @param position position needs to show
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Event event = eventList.get(position);
        holder.title.setText(event.getTitle());
        String[] locations = event.getAddress().split(",");
        holder.location.setText(locations[1] + ", " + locations[2]);
        holder.description.setText(event.getDescription());
        holder.time.setText(String.valueOf(event.getTime()));
    }


    /**
     * By calling this method, each ViewHolder will be initiated and passed to
     * OnBindViewHolder for rendering
     * @param parent parent view
     * @param viewType we might have multiple view types
     * @return ViewHolder created
     */
    public EventListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.event_list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }




}
