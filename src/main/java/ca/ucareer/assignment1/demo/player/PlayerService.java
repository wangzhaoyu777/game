package ca.ucareer.assignment1.demo.player;


import ca.ucareer.assignment1.demo.game.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PlayerService")
public class PlayerService {

    final PlayerRepository playerRepository;

    @Autowired
    PlayerRepository repository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player addOne(Player player) {
        //add and save one entity
        return repository.save(player);
    }

    void deleteById(Long id) {
        this.playerRepository.deleteById(id);
    }

    public List<Player> getAll() {
        //Returns all instances of the type by List<>;
        return repository.findAll();
    }

    public Player getOneById(Long id) {
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

    public long countNum() {
        //Returns the number of entities available.
        return repository.count();
    }



}
