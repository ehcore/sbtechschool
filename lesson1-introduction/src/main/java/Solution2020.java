import java.util.*;

public class Solution2020 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] numbers = new int[count];

        HashSet<Integer> hashSet = new HashSet<>();

        int currInt = 0;

        for (int i = 0; i < count; i++) {
            currInt = scanner.nextInt();
            numbers[i] = currInt;
            hashSet.add(currInt);
        }

        HashMap<Integer,Integer> map = new HashMap<>();

        for(Integer integer : hashSet){
            int counter = 0;
            for(int i = 0; i < numbers.length; i++){
                if(numbers[i] == integer){
                    counter ++;
                }
            }
            map.put(integer,counter);
        }

        int max = 0;

        for (HashMap.Entry<Integer,Integer> e : map.entrySet()){
            int curIntMap = e.getValue();
            max = Math.max(max,curIntMap);
        }

        for (HashMap.Entry<Integer,Integer> e : map.entrySet()){
            int curIntMap = e.getValue();
            if(curIntMap == max){
                System.out.println(e.getKey() + " " + max);
                break;
            }
        }

    }
}
