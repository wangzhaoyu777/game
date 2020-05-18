package ca.ucareer.assignment1.demo.game;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GameService")
public class GameService {

    final GameRepository gameRepository;//?????


    @Autowired
    GameRepository repository;//????


    public GameService(GameRepository gameRepository) {
        //constructor
        this.gameRepository = gameRepository;
    }

    public Game addOne(Game game) {
        //add and save one entity
        return repository.save(game);
    }

//    public List<Game> addAll (){
//        //add and save all entity
//        return repository.saveAll();
//    }

    void deleteById(Long id) {
        this.gameRepository.deleteById(id);
    }

    public List<Game> getAll() {
        //Returns all instances of the type by List<>;
        return repository.findAll();
    }

    public Game getOneById(Long id) {
        //add and save one entity
        /**
         * Returns all instances of the type {@code T} with the given IDs.
         * <p>
         * If some or all ids are not found, no entities are returned for these IDs.
         * <p>
         * Note that the order of elements in the result is not guaranteed.
         *
         * @param ids must not be {@literal null} nor contain any {@literal null} values.
         * @return guaranteed to be not {@literal null}. The size can be equal or less than the number of given
         *         {@literal ids}.
         * @throws IllegalArgumentException in case the given {@link Iterable ids} or one of its items is {@literal null}.
         */
        // ?? don't understand, need explanation of orElse(null)
        return repository.findById(id).orElse(null);
    }

//    public Game update (Long id, Game game) {
//
//
//    }

    //controller annotation ?
    public long countNum() {
        //Returns the number of entities available.
        return repository.count();
    }


}
