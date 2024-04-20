package lib;

import java.util.Scanner;

public class Menu {
    private String dummy;
    private String tempName;
    private Scanner scan;

    public void thisIs(String dummy, String tempName, Scanner scan) {
        this.dummy = dummy;
        this.scan = scan;
        this.tempName = tempName;
    }

    public void Main() {
        System.out.println("\n**************************************************");
        System.out.println("                  전화번호부");
        System.out.println("**************************************************");
        System.out.println("1.조회     2.수정     3.추가     4.삭제     5.종료");
        System.out.print("메뉴를 입력 하세요 : ");
    }

    public String Edit(String dummy, Scanner scan, String tempName) {
        thisIs(dummy, tempName, scan);

        dummy = scan.nextLine();
        System.out.print("수정할 연락처 이름을 입력하세요 : ");
        tempName = scan.nextLine();
        return tempName;
    }

    public String Delete(String dummy, Scanner scan, String tempName) {
        thisIs(dummy, tempName, scan);

        dummy = scan.nextLine();
        System.out.print("삭제할 연락처 이름을 입력하세요 : ");
        tempName = scan.nextLine();

        return tempName;
    }
}