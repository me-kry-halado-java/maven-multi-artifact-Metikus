package hu.meiit.haladojava.calculator;

import java.util.Scanner;

public class ReaderWriter {

    public String readFromConsole() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public void writeItDown(String s) {
        System.out.print(s);
    }
}
