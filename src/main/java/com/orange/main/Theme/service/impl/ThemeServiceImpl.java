package com.orange.main.Theme.service.impl;

import com.orange.main.Theme.bo.Theme;
import com.orange.main.Theme.repo.ThemeRepository;
import com.orange.main.Theme.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeServiceImpl implements ThemeService {

    @Autowired
    private ThemeRepository themeRepository;

    @Override
    public List<Theme> getThemeByType(String type) {
        // find active theme by type
        return themeRepository.findByTypeAndDisable(type,false);
    }

}
