package com.McT.jdbc.goods.command;

import com.McT.jdbc.goods.common.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteCommand implements Command{
    @Override
    public void excute() {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入待删除商品编号：");
        int id = in.nextInt();

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DbUtils.getConnection();
            String sql = "delete from goods where id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);

            int cnt = pstmt.executeUpdate();
            if (cnt==1){
                System.out.println("商品"+id+"删除完毕");
            } else {
                System.out.println("未找到id为"+id+"的商品");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DbUtils.closeConnection(null, pstmt, conn);
        }
    }
}
