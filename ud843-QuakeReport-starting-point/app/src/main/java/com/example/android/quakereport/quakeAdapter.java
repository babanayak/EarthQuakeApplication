package com.example.android.quakereport;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static android.support.v4.content.ContextCompat.getColor;
import static android.support.v4.content.ContextCompat.startActivities;

public class quakeAdapter extends ArrayAdapter<quake> {


    public quakeAdapter(@NonNull Context context, @NonNull List<quake> objects) {
        super(context, 0, objects);
    }
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.quakes, parent, false);
        }
        final quake my_quake = (quake) getItem(position);
        DecimalFormat df=new DecimalFormat("#.#");
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        miwokTextView.setText(String.valueOf(df.format(my_quake.getmagnitude())));
        String near=my_quake.getPlace();
        int j=near.indexOf("of");
        String near1=near.substring(0,j+2);
        String near2=near.substring(j+2);
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.ac);
        defaultTextView.setText(near1);
        TextView abcd=(TextView)listItemView.findViewById(R.id.af);
        abcd.setText(near2);
        Date dateobject=new Date(my_quake.getDate());
        TextView abc=(TextView)listItemView.findViewById(R.id.ad);
        abc.setText(formatDate(dateobject));
        TextView abd=(TextView)listItemView.findViewById(R.id.ae);
        abd.setText(formatTime(dateobject));

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) miwokTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(my_quake.getmagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        return listItemView;
    }
    private int getMagnitudeColor(double magnitude){
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch(magnitudeFloor) {

            case 0:

            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;

            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;

            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;

            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;

            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;

            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;

            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;

            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;

            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return getColor(getContext(), magnitudeColorResourceId);
    }
}
