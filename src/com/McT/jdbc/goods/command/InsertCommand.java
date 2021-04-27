package com.McT.jdbc.goods.command;

import com.McT.jdbc.goods.common.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertCommand implements Command{
    @Override
    public void excute() {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入商品编号：");
        int id = in.nextInt();
        System.out.println("请输入商品名称：");
        String name = in.next();
        System.out.println("请输入商品价格：");
        Float price = in.nextFloat();
        System.out.println("请输入商品描述：");
        String desp = in.next();

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DbUtils.getConnection();
            String sql = "insert into goods(id,name,price,desp) values(?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.setString(2,name);
            pstmt.setFloat(3,price);
            pstmt.setString(4,desp);
            int cnt = pstmt.executeUpdate();
            System.out.println("cnt:"+cnt);
            System.out.println("新商品已加入");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DbUtils.closeConnection(null, pstmt, conn);
        }

    }
}
