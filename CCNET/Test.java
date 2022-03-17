package CCNET;

import CCNET.CCNET_MESSAGE;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        // Обработка объекта в массив
//        getCCN();
        // Обработка массива в объект
        setCCN();

    }
    public static void getCCN(){
        Scanner in = new Scanner(System.in);
        byte SYNC = in.nextByte();
        byte ADR = in.nextByte();
        byte LNG = in.nextByte();
        byte DATA = in.nextByte();
        CCNET_MESSAGE ccnet_message = new CCNET_MESSAGE();
        try {
            ccnet_message.getMessage(SYNC,ADR,LNG,DATA);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void setCCN() {
        CCNET_MESSAGE ccnet_message = new CCNET_MESSAGE();
        try {
            byte[] bytes = {2, 3, 6, 51};
            ccnet_message.setMessage(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
