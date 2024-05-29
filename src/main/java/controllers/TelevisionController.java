package controllers;

import exceptions.RecordNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {
    private ArrayList<String> televisions = new ArrayList<>();

    @GetMapping()
    public ResponseEntity<ArrayList<String>> etTelevisions() {
        if(televisions.isEmpty())
            return ResponseEntity.noContent().build();

        else return  ResponseEntity.ok(televisions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getTelevisionById(@PathVariable int id) {
        if(televisions.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(televisions.get(id));
    }

    @PostMapping()
    public ResponseEntity<String> createTelevision(@RequestBody String television) {
        televisions.add(television);
        return ResponseEntity.created(null).body("television");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTelevision(@PathVariable int id, @RequestBody String television) {
        try {
            if (id >= 0 && id < televisions.size()) {
                televisions.set(id, television);
                return ResponseEntity.ok(television);
            } else {
                throw new RecordNotFoundException("Television not found");
            }
        } catch (RecordNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTelevision(@PathVariable int id) {
        try {
            if (id >= 0 && id < televisions.size()) {
                televisions.remove(id);
                return ResponseEntity.ok("Television deleted");
            } else {
                throw new RecordNotFoundException("Television not found");
            }
        } catch (RecordNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
