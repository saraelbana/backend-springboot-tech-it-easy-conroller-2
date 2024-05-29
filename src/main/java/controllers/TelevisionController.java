package controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    @GetMapping()
    public String<> getTelevisions() {
        ArrayList<String> televisions = new ArrayList<>();
        return "Listing televisions";
    }

    }

}
