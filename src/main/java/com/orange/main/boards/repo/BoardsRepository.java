package com.orange.main.boards.repo;

import com.orange.main.boards.bo.Board;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardsRepository extends JpaRepository<Board, Long> {

    List<Board> findByCode(String code, Pageable pageable);
}
