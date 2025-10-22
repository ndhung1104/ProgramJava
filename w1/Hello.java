package p1;
import java.util.*;
import math.*; // math.Adder

public class Hello // neu co lop public thi ten file phai = ten class public, phan biet hoa thuong, 1 file co toi da 1 lop public
{
    public static void main(String[] args)
    {
        System.out.println("Hello, today: ");
        Adder adder = new Adder();
        System.out.println("2 + 3 = " + adder.add(2, 3));
    }
}