import ATM.ATM;
import etc.Event;
import interfaces.Departmant;
import interfaces.Subordinate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ATMDepartmant implements Departmant {

    Map<Event, List<Subordinate>>  subordinates = new HashMap<>();

    @Override
    public void addSubordinate(Subordinate subordinate, Event event) {

        List<Subordinate> eventSubordinates = subordinates.get(event);

        if(eventSubordinates != null) {
            eventSubordinates.add(subordinate);
        } else {
            eventSubordinates = new ArrayList<Subordinate>();
            eventSubordinates.add(subordinate);
            subordinates.put(event, eventSubordinates);
        }
    }

    @Override
    public void notifySubordinate(Event event) {


        for(Subordinate subordinate :
                subordinates.get(event))
        {
            subordinate.doJob();
        }
    }

    @Override
    public long getReports(Event event) {

        long balance = 0;

        for(Subordinate subordinate :
                subordinates.get(event)) {

            balance += subordinate.getReport();

        }
        return balance;
    }

}
