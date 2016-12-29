package com.exam.event.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextStartedEvent;

import com.exam.event.AfterInsertFilmEvent;
import com.exam.event.BeforeInsertFilmEvent;

/**
 * 事件监听机制
 * @author yufeng.liu
 *
 */
public class EventListener implements ApplicationListener<ApplicationEvent> {

    /**
     * 根据事件类型进行处理
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {

        if (event instanceof ContextClosedEvent) {
            System.out.println("Context Stop");
        } else if (event instanceof ContextStartedEvent) {
            System.out.println("Context Start");
        } else if (event instanceof BeforeInsertFilmEvent) {
            System.out.println("Before Insert Film Data");
        } else if (event instanceof AfterInsertFilmEvent) {
            System.out.println("After Insert Film Data");
        }
    }

}
