package edu.ucsb.cs.cs185.jjkaddoura.unitytoolbar;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class event_editor extends Fragment {
    public int pos;
    public int day;
    public int month;
    public int year;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle args = getArguments();
        View v = inflater.inflate(R.layout.fragment_event_editor, container, false);
        if(!args.getBoolean("NewEvent")){
            Button edit = (Button) v.findViewById(R.id.saveButton);
            edit.setText("Edit");
            Button delete = (Button) v.findViewById(R.id.cancelButton);
            delete.setText("Delete");
            pos = args.getInt("position");
            simpleDateClass current = dateAdapter.events.get(pos);
            final EditText description = (EditText) v.findViewById(R.id.DescriptionEdit);
            description.setText(current.desc);
            final DatePicker picker = (DatePicker) v.findViewById(R.id.datepicker);
            picker.updateDate(current.year, current.month - 1, current.day);
            edit.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    simpleDateClass holder = dateAdapter.events.get(pos);
                    if (holder.year == picker.getYear() && holder.day == picker.getDayOfMonth() && holder.month == picker.getMonth() + 1) {
                        dateAdapter.events.get(pos).desc = description.getText().toString();
                    }
                    else{
                        dateAdapter.events.remove(pos);
                        dateAdapter.add(new simpleDateClass(description.getText().toString(),
                                picker.getMonth()+1, picker.getDayOfMonth(), picker.getYear()));
                    }
                    CalenderFragment calender = new CalenderFragment();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.place_here, calender);
                    ft.commit();
                }
            });
            delete.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    dateAdapter.events.remove(pos);
                    CalenderFragment calender = new CalenderFragment();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.place_here, calender);
                    ft.commit();
                }
            });
        }
        else{
            Button save = (Button) v.findViewById(R.id.saveButton);
            Button cancel = (Button) v.findViewById(R.id.cancelButton);
            day = args.getInt("day");
            month = args.getInt("month");
            year = args.getInt("year");
            final EditText description = (EditText) v.findViewById(R.id.DescriptionEdit);
            final DatePicker picker = (DatePicker) v.findViewById(R.id.datepicker);
            picker.updateDate(year, month, day);
            save.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    dateAdapter.add(new simpleDateClass(description.getText().toString(),
                            picker.getMonth()+1, picker.getDayOfMonth(), picker.getYear()));
                    CalenderFragment calender = new CalenderFragment();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.place_here, calender);
                    ft.commit();
                }
            });
            cancel.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    CalenderFragment calender = new CalenderFragment();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.place_here, calender);
                    ft.commit();
                }
            });
        }

        return v;
    }
}
