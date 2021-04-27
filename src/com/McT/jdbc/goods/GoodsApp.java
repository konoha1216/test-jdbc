package com.McT.jdbc.goods;

import com.McT.jdbc.goods.command.*;

import java.util.Scanner;

public class GoodsApp {
    public static void main(String[] args) {
        System.out.println("1-查询价格在多少之间的商品");
        System.out.println("2-新增商品");
        System.out.println("3-修改商品价格");
        System.out.println("4-删除某个商品");
        Scanner in = new Scanner(System.in);
        Integer cmd = in.nextInt();
        Command command = null;
        switch (cmd){
            case 1:
                command = new PstmtQueryPriceCommand();
                command.excute();
                break;
            case 2:
                command = new InsertCommand();
                command.excute();
                break;
            case 3:
                command = new UpdateCommand();
                command.excute();
                break;
            case 4:
                command = new DeleteCommand();
                command.excute();
        }
    }
}
