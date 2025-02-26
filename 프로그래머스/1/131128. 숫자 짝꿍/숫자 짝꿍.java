import java.util.*;
import java.io.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        int[] arrX = new int[10];
        int[] arrY = new int[10];
        
        
        for(char s : X.toCharArray()){
            arrX[s - '0']++;
        }
        
        for(char s : Y.toCharArray()){
            arrY[s - '0']++;
        }
        
        for(int i = 9; i>=0; i--){
            while(arrX[i] >0 && arrY[i] >0){
                sb.append(i);
                
                arrX[i]--;
                arrY[i]--;
            }
        }
        
        if(sb.toString().equals("")) return "-1";
        if(sb.toString().startsWith("0")) return "0";
        
        return sb.toString();
        
    }
}