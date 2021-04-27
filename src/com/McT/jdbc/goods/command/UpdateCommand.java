package com.McT.jdbc.goods.command;

import com.McT.jdbc.goods.common.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateCommand implements Command{
    @Override
    public void excute() {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入待修改商品编号：");
        int id = in.nextInt();
        System.out.println("请输入修改后的价格：");
        float price = in.nextFloat();

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DbUtils.getConnection();
            String sql = "update goods set price = ? where id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setFloat(1,price);
            pstmt.setInt(2,id);

            int cnt = pstmt.executeUpdate();
            if (cnt==1){
                System.out.println("商品"+id+"价格修改完毕");
            } else {
                System.out.println("未找到id为"+id+"的商品");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DbUtils.closeConnection(null, pstmt, conn);
        }
    }
}
