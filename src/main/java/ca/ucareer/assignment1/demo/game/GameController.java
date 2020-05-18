package ca.ucareer.assignment1.demo.game;


import ca.ucareer.assignment1.demo.core.CoreResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //this class is a controller
@RequestMapping("/api")
// mapping web requests onto methods in request-handling
// classes with flexible method signatures.
public class GameController {

    @Autowired //auto init class(bean) rather than : new Service()
    private GameService gameService;

    @PostMapping("/game")
    // Annotation for mapping HTTP {CODE: POST} requests onto specific
    // handler method;
    public ResponseEntity<CoreResponseBody> addOne(@RequestBody Game game){
        // @RequestBody Annotation indicating a
        // method parameter should be bound to the body of the web request.
        Game addedOne = this.gameService.addOne(game);//pass value to addedOne
        CoreResponseBody response = new CoreResponseBody(addedOne,null, "");

        return ResponseEntity.ok(response);//return ??
    }

    @DeleteMapping("/game/{id}")
    public ResponseEntity<CoreResponseBody> deleteOneById (@PathVariable Long id){

        CoreResponseBody response;
        try{
            this.gameService.deleteById(id);
            response = new CoreResponseBody(true,null , "deleted successfully");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response = new CoreResponseBody(null, e, "deleted failed");
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/game")
    public ResponseEntity<CoreResponseBody> getAll (){

        List<Game> results = this.gameService.getAll();
        CoreResponseBody response = new CoreResponseBody(results,null, "");

        return ResponseEntity.ok(response);
    }

    public ResponseEntity<CoreResponseBody> getOneById (@PathVariable Long id){
        //                                          PathVariable =》｛id｝

        Game result = this.gameService.getOneById(id);
        CoreResponseBody response = new CoreResponseBody(result,null, "");

        return ResponseEntity.ok(response);
    }
}
