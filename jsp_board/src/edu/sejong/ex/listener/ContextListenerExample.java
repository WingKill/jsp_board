package edu.sejong.ex.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListenerExample implements ServletContextListener{
	public ContextListenerExample() {
		System.out.println("ContextListener 생성자 호출");
	}
	
	@Override
	public void contextInitialized(ServletContextEvent args0) {
		System.out.println("웹 어플리케이션이 초기화할 때 호출됩니다.");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent args0) {
		System.out.println("웹 어플리케이션이 종료할 때 호출됩니다.");
	}
}
