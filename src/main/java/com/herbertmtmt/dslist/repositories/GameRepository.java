package com.herbertmtmt.dslist.repositories;

import com.herbertmtmt.dslist.entities.Game;
import com.herbertmtmt.dslist.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository  extends JpaRepository<Game, Long> { // tipo da entidade e o tipo do id da entidade

    // usa nativeQuery pq está sendo usado sql puro, n jpql, uma linguagem de consulta da jpa
    @Query(nativeQuery = true, value = """
		SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
		tb_game.short_description AS shortDescription, tb_belonging.position
		FROM tb_game
		INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
		WHERE tb_belonging.list_id = :listId
		ORDER BY tb_belonging.position
			""")
    List<GameMinProjection> searchByList(Long listId); // interface == projection

}
