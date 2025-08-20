package com.herbertmtmt.dslist.repositories;

import com.herbertmtmt.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository  extends JpaRepository<Game, Long> { // tipo da entidade e o tipo do id da entidade



}
