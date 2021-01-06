package easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PowerfulIntegers {

    public static void main(String[] args) {
        System.out.println(Math.log10(3));
    }

    public List<Integer> powerfulIntegers(int x, int y, int bound) {

        int p =   (x==1)  ? 1:(int)Math.ceil(Math.log10(bound)/Math.log10(x));
        int q =   (y==1)  ? 1:(int)Math.ceil(Math.log10(bound)/Math.log10(y));

        int r =   (int)Math.max(p,q);


        HashSet<Integer> uu  = new HashSet<>();

        for(int i = 0 ; i<=r ; i++){

            for(int j = 0 ; j<=r ; j++){

                if((int)Math.pow(x,i) + (int)Math.pow(y,j) <= bound ){

                    uu.add((int)Math.pow(x,i) + (int)Math.pow(y,j));
                }
            }
        }


        return new ArrayList<Integer>(uu);
    }
}

