package com.exam.aop;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.exam.event.AfterInsertFilmEvent;
import com.exam.event.BeforeInsertFilmEvent;

/**
 * 电影相关事件处理
 * 实现ApplicationContextAware接口是为了得到ApplicationContext
 * @author yufeng.liu
 *
 */
public class FilmEventHandler implements ApplicationContextAware{
    
    private ApplicationContext context=null;
    
    /**
     * 在插入电影之前触发BeforeInsertFilmEvent事件
     */
    public void beforeInsert(){
        BeforeInsertFilmEvent beforeInsertFilmEvent = new BeforeInsertFilmEvent(context);
        context.publishEvent(beforeInsertFilmEvent);
    }
    
    /**
     * 在插入电影之后触发AfterInsertFilmEvent事件
     */
    public void afterInsert(){
        AfterInsertFilmEvent afterInsertFilmEvent = new AfterInsertFilmEvent(context);
        context.publishEvent(afterInsertFilmEvent);
    }

    /**
     * 接口方法，得到ApplicationContext
     */
    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }
}
