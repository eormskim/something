package com.example.something.board.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/board")
public class BoardController {

    @GetMapping("/list.wep")
    public String list() {
        return "board/list";
    }

    @GetMapping("/edit.wep")
    public String edit() {
        return "board/edit";
    }

    @GetMapping("/detail.wep/{boardId}")
    public String detail(Model model, @PathVariable Long boardId) {
        try {
            model.addText(String.valueOf(boardId));
        }catch (Exception e){
            e.printStackTrace();
        }
        return "board/detail";
    }

    @GetMapping("/chart.wep")
    public String chart() {
        return "board/chart";
    }

}
