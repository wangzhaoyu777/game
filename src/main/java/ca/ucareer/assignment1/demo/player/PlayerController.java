package ca.ucareer.assignment1.demo.player;


import ca.ucareer.assignment1.demo.core.CoreResponseBody;
import ca.ucareer.assignment1.demo.game.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlayerController {

    @Autowired //auto init class(bean) rather than : new Service()
    private PlayerService playerService;

    @PostMapping("/player")
    // Annotation for mapping HTTP {CODE: POST} requests onto specific
    // handler method;
    public ResponseEntity<CoreResponseBody> addOne(@RequestBody Player player){
        // @RequestBody Annotation indicating a
        // method parameter should be bound to the body of the web request.
        Player addedOne = this.playerService.addOne(player);//pass value to addedOne
        CoreResponseBody response = new CoreResponseBody(addedOne,null, "");

        return ResponseEntity.ok(response);//return ??
    }

    @DeleteMapping("/player/{id}")
    public ResponseEntity<CoreResponseBody> deleteOneById (@PathVariable Long id){

        CoreResponseBody response;
        try{
            this.playerService.deleteById(id);
            response = new CoreResponseBody(true,null , "deleted successfully");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response = new CoreResponseBody(null, e, "deleted failed");
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/player")
    public ResponseEntity<CoreResponseBody> getAll (){

        List<Player> results = this.playerService.getAll();
        CoreResponseBody response = new CoreResponseBody(results,null, "");

        return ResponseEntity.ok(response);
    }

    public ResponseEntity<CoreResponseBody> getOneById (@PathVariable Long id){

        Player result = this.playerService.getOneById(id);
        CoreResponseBody response = new CoreResponseBody(result,null, "");

        return ResponseEntity.ok(response);
    }


}
