package yang;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] arr = str.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i < arr.length;i++)
        {
            if(!(arr[i]>='a' && arr[i] <= 'z') && !(arr[i]>='A' && arr[i] <= 'Z'))
            {
                continue;
            }
            if(!map.containsKey(arr[i]))
            {
                map.put(arr[i],1);
            }
            else
            {
                int t = map.get(arr[i])+1;
                if(t >= 3)
                {
                    System.out.println(arr[i]);
                    break;
                }
                map.put(arr[i],t);
            }
        }
    }

}
