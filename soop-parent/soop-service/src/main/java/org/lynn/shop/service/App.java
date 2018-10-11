package org.lynn.soop.service;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        try {
            String location = "applicationContext.xml";
            String bean = Thread.currentThread().getContextClassLoader().getResource(location).toString();

            FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext(new String[]{bean});
            ctx.start();
            System.out.println("service started.");
            System.in.read();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
