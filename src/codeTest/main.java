package codeTest;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        
        List<Integer> diffchk = new ArrayList<Integer>();
        for(int a : arr) {
            diffchk.add(a);
        }
        
        System.out.println(diffchk.indexOf(3));
    }
}
