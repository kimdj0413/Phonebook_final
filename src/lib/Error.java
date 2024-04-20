package lib;

import java.util.Arrays;
import java.util.Scanner;

class NumberException extends Exception {
    public NumberException(String msg) {
        super(msg);
    }
}

class RelationException extends Exception {
    public RelationException(String msg) {
        super(msg);
    }
}

public class Error {
    private String tempNum;
    private String tempClass;
    private Scanner scan;

    public String NumberException(String tempNum, Scanner scan) {
        this.tempNum = tempNum;
        this.scan = scan;
        while (true) {
            try {
                System.out.print("번호를 입력하세요 : ");
                tempNum = scan.nextLine();
                if (tempNum.startsWith("010") == false) {
                    throw new NumberException("010으로 시작하세요!");
                }
                break;
            } catch (NumberException e) {
                System.out.println(e.getMessage());
            }
        }
        return tempNum;
    }

    public String RelationException(String tempClass, Scanner scan) {
        this.tempClass = tempClass;
        this.scan = scan;
        while (true) {
            try {
                System.out.print("관계를 입력하세요 : ");
                tempClass = scan.nextLine();
                if (!Arrays.asList("가족", "친구", "회사", "기타").contains(tempClass)) {
                    throw new RelationException("가족, 친구, 회사, 기타 중 하나를 입력하세요!");
                }
                break;
            } catch (RelationException e) {
                System.out.println(e.getMessage());
            }
        }
        return tempClass;
    }
}