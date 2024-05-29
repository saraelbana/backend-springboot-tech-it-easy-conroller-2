package controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {
    private ArrayList<String> televisions = new ArrayList<>();

    @GetMapping()
    public ResponseEntity<ArrayList<String>> etTelevisions() {
        return  ResponseEntity.ok(televisions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getTelevisionById(@PathVariable int id) {
        return ResponseEntity.ok(televisions.get(id));
    }

    @PostMapping()
    public ResponseEntity<String> createTelevision(@RequestBody String television) {
        televisions.add(television);
        return ResponseEntity.ok(television);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTelevision(@PathVariable int id, @RequestBody String television) {
        televisions.set(id, television);
        return ResponseEntity.ok(television);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTelevision(@PathVariable int id) {
        String television = televisions.get(id);
        televisions.remove(id);
        return ResponseEntity.ok(television);
    }
}
