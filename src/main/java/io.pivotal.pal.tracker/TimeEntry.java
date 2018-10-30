package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.Objects;

public class TimeEntry {

    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;

    public void setId(long id) {
        this.id = id;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public TimeEntry() {
    }

    public TimeEntry(long timeEntryId, long projectId, long userId, LocalDate parse, int i) {
        this.id = timeEntryId;
        this.projectId = projectId;
        this.userId = userId;
        this.date = parse;
        this.hours = i;
    }

    public TimeEntry(long l, long l1, LocalDate parse, int i) {

        this.projectId = l;
        this.userId = l1;
        this.date = parse;
        this.hours = i;
    }

    public long getId() {
        
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectId, userId, date, hours);
    }

    public boolean equals(Object obj) {

        if (!(obj instanceof TimeEntry)) { return false; }

        TimeEntry timeEntry = (TimeEntry) obj;

        if(this.projectId != timeEntry.getProjectId())
            return false;

        if(this.userId != timeEntry.getUserId())
            return false;

        if(!this.date.equals(timeEntry.getDate()))
            return false;

        if(this.hours != timeEntry.getHours())
            return false;

        return true;
    }


    @Override
    public String toString() {
        return "TimeEntry{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", userId=" + userId +
                ", date=" + date +
                ", hours=" + hours +
                '}';
    }
}
