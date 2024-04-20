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
        int keyTemp = 0;
        int menuNum = 0;
        String dummy = "";
        String tempName = "";
        String tempNum;
        String tempAdd;
        String tempRelation;
        String query;
        boolean go = true;

        HashMap<Integer, Info> hashMap = new HashMap<Integer, Info>();

        while (go) {
            try {
                menu.Main();
                menuNum = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\n1 ~ 5번 숫자를 입력해주세요!");
                scan.nextLine();
            }

            switch (menuNum) {
                case 1:
                    for (Integer key : hashMap.keySet()) {
                        System.out.println("이름 : " + hashMap.get(key).getName() + "\t번호 : "
                                + hashMap.get(key).getNumber() + "\t주소 : " + hashMap.get(key).getAddress() + "\t관계 : "
                                + hashMap.get(key).getRelation());
                    }
                    continue;
                case 2:
                    tempName = menu.Edit(dummy, scan, tempName);
                    keyTemp = edit.forEqual(tempName, keyTemp, hashMap);
                    edit.inputData(scan, hashMap, keyTemp);
                    continue;
                case 3:
                    dummy = scan.nextLine();
                    edit.inputData(scan, hashMap, keyCnt);
                    keyCnt++;
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
