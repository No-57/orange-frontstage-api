package com.orange.main.boards.controller;

import com.orange.main.BaseController;
import com.orange.main.boards.bo.Board;
import com.orange.main.boards.service.BoardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class BoardsController  extends BaseController{

    @Autowired
    private BoardsService boardsService;


    @GetMapping("/boards")
    public Object getBoardsByCodeAndLimit(@RequestParam String code, @RequestParam int limit) {
        List<Board> boardList = boardsService.getBoardsByCodeAndLimit(code, limit);
        return transResponseObj(boardList);
    }

}
