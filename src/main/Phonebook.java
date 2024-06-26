package main;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import lib.Edit;
import lib.Menu;
import lib.Info;

public class Phonebook {
    public static void main(String[] args) throws Exception {
        Edit edit = new Edit();
        Menu menu = new Menu();
        Info info = new Info(null, null, null, null);
        Scanner scan = new Scanner(System.in);

        int keyCnt = 0;
        String keyTemp = "";
        int menuNum = 0;
        String dummy = "";
        String tempName = "";
        String tempNum;
        String tempAdd;
        String tempRelation;
        String query;
        boolean go = true;

        HashMap<String, Info> hashMap = new HashMap<String, Info>();

        while (go) {
            try {
                menu.Main();
                menuNum = scan.nextInt();
            } catch (InputMismatchException e) {
                scan.nextLine();
            }

            switch (menuNum) {
                case 1:                
                    dummy = scan.nextLine();
                    edit.inputData(scan, hashMap, keyTemp);
                    keyCnt++;
                    continue;
                case 2:
                    for (String key : hashMap.keySet()) {
                        System.out.println("회원정보 : 이름 = " + hashMap.get(key).getName() + ", 전화번호 : "
                                + hashMap.get(key).getNumber() + ", 주소 : " + hashMap.get(key).getAddress() + ", 관계 : "
                                + hashMap.get(key).getRelation());
                    }
                    continue;
                case 3:
                    edit.editData();
                    continue;
                case 4:
                    tempName = menu.Delete(dummy, scan, tempName);
                    keyTemp = edit.forEqual(tempName, keyTemp, hashMap);
                    edit.Remove(hashMap, keyTemp);
                    continue;
                case 5:
                    go = false;
            }
        }
    }
}