package com.orange.main.Theme.controller;

import com.orange.main.BaseController;
import com.orange.main.Theme.bo.Theme;
import com.orange.main.Theme.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class ThemeController extends BaseController{

    @Autowired
    private ThemeService themeService;

    @GetMapping("/themes")
    public Object getBoardsByCodeAndLimit(@RequestParam String type) {
        List<Theme> themeList = themeService.getThemeByType(type);
        return transResponseObj(themeList);
    }

}