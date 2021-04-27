package com.McT.jdbc.goods.command;

import java.sql.*;
import java.util.Scanner;

public class QueryPriceCommand implements Command{
    @Override
    public void excute() {
        System.out.println("请输入价格：");
        Scanner in = new Scanner(System.in);
        Double price = in.nextDouble();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        //1. 加载并注册JDBC驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2. 创建数据库连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/goods?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true", "root", "123456789");
            //3. 创建Statement对象
            stmt = conn.createStatement();
            //结果集
            System.out.println("select * from goods where price<" + price);
            rs = stmt.executeQuery("select * from goods where price<" + price);
            //4. 遍历查询结果
            //rs.next()返回布尔值，代表是否存在下一条记录
            //如果有，返回true,同时结果集提取下一条记录
            //如果没有，返回false，循环就会停止
            while (rs.next()) {
                Integer id = rs.getInt(1);//JDBC中字段索引从1开始，而非0
                String name = rs.getString("name");
                Float qprice = rs.getFloat("price");
                String desp = rs.getString("desp");
                System.out.println(id + "-" + name + "-" + qprice + "-" + desp);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            //5. 关闭连接,释放资源
            try {
                if(rs != null){
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if(stmt != null){
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if(conn != null && !conn.isClosed() ) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
