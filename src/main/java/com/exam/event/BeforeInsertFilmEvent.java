package com.exam.event;

import org.springframework.context.ApplicationEvent;

/**
 * 插入电影前的事件
 * @author yufeng.liu
 *
 */
public class BeforeInsertFilmEvent extends ApplicationEvent{

    
    private static final long serialVersionUID = 1L;

    public BeforeInsertFilmEvent(Object source) {
        super(source);
    }

    

}
