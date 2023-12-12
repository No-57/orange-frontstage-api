package com.orange.main.boards.service.impl;

import com.orange.main.boards.bo.Board;
import com.orange.main.boards.repo.BoardsRepository;
import com.orange.main.boards.service.BoardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardssServiceImpl implements BoardsService {

    @Autowired
    private BoardsRepository boardsRepository;

    @Override
    public List<Board> getBoardsByCodeAndLimit(String code, int limit) {
        return boardsRepository.findByCode(code, PageRequest.of(0, limit));
    }

}
