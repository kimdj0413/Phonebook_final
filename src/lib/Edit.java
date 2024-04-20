package lib;

import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import lib.Error;
import lib.Info;

public class Edit {
    Info info = new Info(null, null, null, null);
    Error error = new Error();

    private Scanner scan;
    private HashMap<Integer, Info> hashMap;

    private Integer keyTemp;
    private String tempName;
    private String tempNum;
    private String tempRelation;

    public void thisIs(HashMap<Integer, Info> hashMap, Integer keyTemp, String tempName) {
        this.hashMap = hashMap;
        this.keyTemp = keyTemp;
        this.tempName = tempName;
    }

    public Integer forEqual(String tempName, Integer keyTemp, HashMap<Integer, Info> hashMap) {
        thisIs(hashMap, keyTemp, tempName);

        for (Integer key : hashMap.keySet()) {
            if (hashMap.get(key).getName().equals(tempName)) {
                keyTemp = key;
            }
        }
        return keyTemp;
    }

    public void inputData(Scanner scan, HashMap<Integer, Info> hashMap, Integer keyTemp) {
        thisIs(hashMap, keyTemp, null);
        System.out.print("이름을 입력하세요 : ");
        String tempName = scan.nextLine();
        tempNum = error.NumberException(tempNum, scan);
        System.out.print("주소를 입력하세요 : ");
        String tempAdd = scan.nextLine();
        tempRelation = error.RelationException(tempRelation, scan);

        info = new Info(tempName, tempNum, tempAdd, tempRelation);
        hashMap.put(keyTemp, info);
    }

    public void Remove(HashMap<Integer, Info> hashMap, Integer keyTemp) {
        thisIs(hashMap, keyTemp, null);

        hashMap.remove(keyTemp);
    }
}
