package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class TimeEntryController {


    TimeEntryRepository timeEntryRepository;


    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;

    }
    @PostMapping("/time-entries")
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntryToCreate) {
        TimeEntry createdEntry = timeEntryRepository.create(timeEntryToCreate);

        ResponseEntity<TimeEntry> responseEntity = new ResponseEntity<>(createdEntry, HttpStatus.CREATED);

        return responseEntity;
    }

    @GetMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable("id") long timeEntryId) {
        ResponseEntity<TimeEntry> responseEntity = null;

        TimeEntry timeEntry = timeEntryRepository.find(timeEntryId);

        if(timeEntry == null) {
            responseEntity = new ResponseEntity<>(new TimeEntry() , HttpStatus.NOT_FOUND);
        } else {
            responseEntity = new ResponseEntity<>(timeEntry, HttpStatus.OK);
        }

        return responseEntity;
    }

    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> list = timeEntryRepository.list();
        ResponseEntity<List<TimeEntry>> responseEntity = new ResponseEntity<>(list, HttpStatus.OK);

        return responseEntity;
    }

    @PutMapping("/time-entries/{id}")
    public ResponseEntity update(@PathVariable("id")  long timeEntryId, @RequestBody TimeEntry expected) {
        TimeEntry timeEntry = timeEntryRepository.find(timeEntryId);
        if(timeEntry == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        timeEntryRepository.update(timeEntryId, expected);
        timeEntry = timeEntryRepository.find(timeEntryId);
        ResponseEntity<TimeEntry> responseEntity = new ResponseEntity<>(timeEntry, HttpStatus.OK);

        return responseEntity;
    }
    @DeleteMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> delete(@PathVariable("id") long timeEntryId) {

        timeEntryRepository.delete(timeEntryId);
        TimeEntry timeEntry = timeEntryRepository.find(timeEntryId);

        if(timeEntry == null)
            return new ResponseEntity<>(timeEntry, HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(timeEntry, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
