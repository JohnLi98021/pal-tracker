package io.pivotal.pal.tracker;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    List<TimeEntry> list = new ArrayList<>();

    private Long createId() {
        return (long) (list.size() + 1);
    }

    public TimeEntry create(TimeEntry timeEntry) {
        Long id = createId();
        timeEntry.setId(id);
        list.add(timeEntry);
        return timeEntry;
    }

    public List<TimeEntry> list() {
        return list;
    }

    public TimeEntry find(long timeEntryId) {

        for(TimeEntry timeEntry : list) {
            if(timeEntry.getId() == timeEntryId)
                return timeEntry;
        }

        return null;
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        TimeEntry target = find(id);

        target.setProjectId(timeEntry.getProjectId());
        target .setUserId(timeEntry.getUserId());
        target.setDate(timeEntry.getDate());
        target.setHours(timeEntry.getHours());

        return target;
    }


    public void delete(long id) {

        TimeEntry target;
        while ((target = find(id)) != null) {
            list.remove(target);
        }

    }
}
