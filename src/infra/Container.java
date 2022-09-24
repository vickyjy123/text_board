package infra;

import contriller.SystemController;

import java.util.Scanner;

public class Container {
    public static Scanner sc;
    public static SystemController systemcontroller;
    static {
        sc=new Scanner(System.in);
        systemcontroller = new SystemController();

    }
}
