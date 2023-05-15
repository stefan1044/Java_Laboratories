package lab11;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController

public class PlayerController {

    private static List<String> players = Arrays.asList("P1", "p2", "p3");

    @GetMapping("/players")
    public List<String> ReadPlayers(){
        return PlayerController.players;
    }
}
