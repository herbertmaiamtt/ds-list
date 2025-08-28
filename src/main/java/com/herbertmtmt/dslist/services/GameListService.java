// necessário registrar a classe como um componente do sistema,
// diferentemente de repository, onde o uso da JPA já garante isso.
package com.herbertmtmt.dslist.services;

// import org.springframework.stereotype.Component;
import com.herbertmtmt.dslist.dto.GameDTO;
import com.herbertmtmt.dslist.dto.GameListDTO;
import com.herbertmtmt.dslist.dto.GameMinDTO;
import com.herbertmtmt.dslist.entities.Game;
import com.herbertmtmt.dslist.entities.GameList;
import com.herbertmtmt.dslist.repositories.GameListRepository;
import com.herbertmtmt.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service // @Component
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();

        return result.stream().map(x -> new GameListDTO(x)).toList();
    }

}
