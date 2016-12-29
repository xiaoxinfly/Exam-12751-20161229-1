package com.exam.main;

import java.math.BigDecimal;
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.exam.pojo.Film;
import com.exam.service.FilmService;

/**
 * App是本次应用程序的封装类
 * 
 * @author yufeng.liu
 *
 */
public class App {

    private AbstractApplicationContext context;
    private FilmService filmService;
    private Scanner scanner;

    private String title;
    private String description;
    private Byte languageId;

    /**
     * 初始化，开启应用
     */
    public void start() {
        context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        context.start();
        filmService = context.getBean(FilmService.class);
        scanner = new Scanner(System.in);
    }

    /**
     * 关闭应用
     */
    public void close() {
        context.close();
        System.exit(1);
    }

    /**
     * 输入标题
     */
    private void inputTitle() {
        System.out.println("请输入电影名称[title]：");
        this.title = scanner.next();
    }

    /**
     * 输入描述
     */
    private void inputDescription() {
        System.out.println("请输入电影描述[description]：");
        this.description = scanner.next();
    }

    /**
     * 输入语言ID，如果输入的ID不是数字则，递归inputLanguageID()方法
     */
    private void inputLanguageID() {
        System.out.println("请输入语言ID[language_id]");
        try {
            String str = scanner.next();
            this.languageId = Byte.valueOf(str);
        } catch (NumberFormatException e) {
            System.out.println("格式错误，请输入数字");
            inputLanguageID();
        }
    }

    /**
     * 开始添加电影，根据本次练习要求，由于数据库表中有默认字段，自动添加RentalDuration、RentalRateReplacementCost
     * 添加成功后关闭context
     */
    private void startAddFilm() {
        Film film = new Film();
        film.setTitle(title);
        film.setDescription(description);
        film.setLanguageId(languageId);
        film.setRentalDuration(Byte.valueOf("3"));
        film.setRentalRate(BigDecimal.valueOf(4.99));
        film.setReplacementCost(BigDecimal.valueOf(19.99));
        if (!this.filmService.addFilm(film)) {
            System.out.println("添加电影失败，请重新输入");
            addFilm();
        }
    }

    /**
     * 添加电影
     */
    public void addFilm() {
        inputTitle();
        inputDescription();
        inputLanguageID();
        startAddFilm();
    }

}
