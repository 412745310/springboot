package com.chelsea.sprintboot_mybatis.init;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 * 初始化100万条数据
 * 
 * @author shevchenko
 *
 */
public class InitData {
    
    public static void main(String[] args) {
        final String driver = "com.mysql.jdbc.Driver";
        final String url = "jdbc:mysql://47.107.247.223:8066/testdb";
        final String user = "user";
        final String password = "user";
        Connection conn = null;
        PreparedStatement pst =  null;
        long beginTime = 0;
        long endTime = 0;
        int count = 1;
        try {
            Class.forName(driver);//指定连接类型
            conn = DriverManager.getConnection(url, user, password);
            if(conn != null) {
                System.out.println("获取连接成功");
                beginTime = new Date().getTime();//开始计时
                String sqlPrefix = "insert into ec_ll_allocate_detail (id, groupName, opertime) values ";
                // 保存sql后缀
                StringBuffer suffix = new StringBuffer();
                // 设置事务为非自动提交
                conn.setAutoCommit(false);
                // 比起st，pst会更好些
                pst = (PreparedStatement) conn.prepareStatement("");//准备执行语句
                // 外层循环，总提交事务次数
                for (int i = 1; i <= 100; i++) {
                    suffix = new StringBuffer();
                    // 第j次提交步长
                    for (int j = 1; j <= 100000; j++) {
                        String s = String.format("%07d", count);
                        // 构建SQL后缀
                        suffix.append("('"+ s +"','aaaa_" + s+"', now()"+"),");
                        count ++;
                    }
                    // 构建完整SQL
                    String sql = sqlPrefix + suffix.substring(0, suffix.length() - 1);
                    // 添加执行SQL
                    pst.addBatch(sql);
                    // 执行操作
                    pst.executeBatch();
                    // 提交事务
                    conn.commit();
                    // 清空上一次添加的数据
                    suffix = new StringBuffer();
                }
                endTime = new Date().getTime();//开始计时
            }else {
                System.out.println("数据库连接失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("com.mysql.jdbc.Driver驱动类没有找到");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库地址错误");
        }finally {//释放资源
            System.out.println("插入成功，所有时间："+ (endTime-beginTime));
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }

}
