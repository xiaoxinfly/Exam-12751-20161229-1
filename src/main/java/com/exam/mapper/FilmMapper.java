package com.exam.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.exam.pojo.Film;
import com.exam.pojo.FilmExample;
/**
 * 利用MyBatis逆向工程自动生成的数据库映射类，同时还有FilmMapper.xml
 * 与FilmMapper.xml相对应
 * @author yufeng.liu
 *
 */
public interface FilmMapper {
    int countByExample(FilmExample example);

    int deleteByExample(FilmExample example);

    int deleteByPrimaryKey(Short filmId);

    int insert(Film record);

    int insertSelective(Film record);

    List<Film> selectByExampleWithBLOBs(FilmExample example);

    List<Film> selectByExample(FilmExample example);

    Film selectByPrimaryKey(Short filmId);

    int updateByExampleSelective(@Param("record") Film record, @Param("example") FilmExample example);

    int updateByExampleWithBLOBs(@Param("record") Film record, @Param("example") FilmExample example);

    int updateByExample(@Param("record") Film record, @Param("example") FilmExample example);

    int updateByPrimaryKeySelective(Film record);

    int updateByPrimaryKeyWithBLOBs(Film record);

    int updateByPrimaryKey(Film record);
    
}