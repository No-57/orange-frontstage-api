package com.orange.main.Theme.repo;

import com.orange.main.Theme.bo.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ThemeRepository extends JpaRepository<Theme, Long> {

    List<Theme> findByTypeAndDisable(String type, boolean disable);
}
