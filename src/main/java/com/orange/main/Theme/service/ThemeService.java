package com.orange.main.Theme.service;

import com.orange.main.Theme.bo.Theme;

import java.util.List;

public interface ThemeService {

    List<Theme> getThemeByType(String type);
}
