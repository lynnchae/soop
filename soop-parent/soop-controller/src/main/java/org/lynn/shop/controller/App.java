package org.lynn.soop.controller;

import org.lynn.common.serverUtil.server.nettyServer.NettyServer;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {
    public static void main(String[] args) {

        try {
            System.setProperty("druid.mysql.usePingMethod","false");
            String location = "applicationContext.xml";
            String bean = Thread.currentThread().getContextClassLoader().getResource(location).toString();
            FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext(new String[]{bean});
            ctx.start();
            NettyServer netty = ctx.getBean(NettyServer.class);
            netty.start();


            System.out.println();
            System.out.println("======================================================");
            System.out.println("application started.");
            System.out.println("======================================================");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
