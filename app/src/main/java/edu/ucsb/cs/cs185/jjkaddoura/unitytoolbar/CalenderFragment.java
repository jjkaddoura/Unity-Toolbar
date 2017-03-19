package edu.ucsb.cs.cs185.jjkaddoura.unitytoolbar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CalendarView;
import android.widget.ListView;

import java.util.Calendar;

public class CalenderFragment extends Fragment {
    public dateAdapter adapt;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_calender, container, false);
        CalendarView calender = (CalendarView) v.findViewById(R.id.Calender);
        calender.setDate(Calendar.getInstance().getTimeInMillis());
        ListView listings = (ListView)v.findViewById(R.id.EventList);
        adapt = new dateAdapter(getActivity().getApplicationContext());
        listings.setAdapter(adapt);
        listings.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Bundle args = new Bundle();
                args.putBoolean("NewEvent", false);
                args.putInt("position", position);
                event_editor edit = new event_editor();
                edit.setArguments(args);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.place_here,edit);
                ft.commit();
            }
        });
        calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                Bundle args = new Bundle();
                args.putBoolean("NewEvent", true);
                args.putInt("month", month);
                args.putInt("day", dayOfMonth);
                args.putInt("year", year);
                event_editor edit = new event_editor();
                edit.setArguments(args);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.place_here,edit);
                ft.commit();
            }
        });
        if(adapt.getCount() == 0) {
            adapt.addItem(new simpleDateClass("Meet with 185 Group", 3, 17,2017));
            adapt.addItem(new simpleDateClass("Disneyland trip", 3, 24, 2017));
            adapt.addItem(new simpleDateClass("Hector's Birthday", 3,25,2017));
            adapt.addItem(new simpleDateClass("Start of Spring Quarter", 4, 3, 2017));
            adapt.addItem(new simpleDateClass("Steven's Cocktail Party", 4, 18, 2017));
        }
        return v;
    }

}