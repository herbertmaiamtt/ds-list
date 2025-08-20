// necessário registrar a classe como um componente do sistema,
// diferentemente de repository, onde o uso da JPA já garante isso.
package com.herbertmtmt.dslist.services;

// import org.springframework.stereotype.Component;
import com.herbertmtmt.dslist.dto.GameMinDTO;
import com.herbertmtmt.dslist.entities.Game;
import com.herbertmtmt.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // @Component
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        // stream permite fazer operações com sequências de dados
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();

        return dto;
    }

}
