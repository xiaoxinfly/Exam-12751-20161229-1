package com.exam.event;

import org.springframework.context.ApplicationEvent;

/**
 * 插入电影后的事件
 * @author yufeng.liu
 *
 */
public class AfterInsertFilmEvent extends ApplicationEvent {
    
    private static final long serialVersionUID = 1L;

    public AfterInsertFilmEvent(Object source) {
        super(source);
    }

}
