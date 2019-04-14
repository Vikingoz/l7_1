package interfaces;

import etc.Event;

public interface Departmant {

    void addSubordinate(Subordinate subordinate, Event event);

    void notifySubordinate(Event event);

    long getReports(Event event);

}