package com.exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.mapper.FilmMapper;
import com.exam.pojo.Film;
import com.exam.service.FilmService;

/**
 * 电影业务处理接口实现类
 * @author yufeng.liu
 *
 */
@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmMapper filmMapper;

    /**
     * 添加电影
     */
    @Override
    public boolean addFilm(Film film) {
        int result = this.filmMapper.insert(film);
        if (result > 0) {
            return true;
        }
        return false;
    }

}
