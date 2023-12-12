package com.orange.main.boards.service;

import com.orange.main.boards.bo.Board;

import java.util.List;
public interface BoardsService {

    List<Board> getBoardsByCodeAndLimit(String code, int limit);
}
