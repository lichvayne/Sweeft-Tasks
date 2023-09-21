import java.util.HashMap;
import java.util.Map;

public class Main {
  static class MyDataStructure{
    private Set<E> set; 
    private List<E> list;
    public MyDataStructure() { 
      set = new HashSet<>(); 
      list = new ArrayList<>(); 
    }
    public void add(E element) { 
      if (!set.contains(element)) { 
        set.add(element); 
        list.add(element); 
      }
    }
    public boolean delete(E element) { 
      if (set.contains(element)) { 
        set.remove(element); 
        list.set(list.indexOf(element), null);
        return true;
        } 
        return false;
        
    }
  }

    public static void main(String[] args) {
      Main main = new Main();
      System.out.println("1. Non repeatable integer - "+main.singleNumber(new int[]{2,2,4,1,4,5,1}));
      System.out.println("2. Min Coin Quantity - " +main.minSplit(100));
      System.out.println("3. First positive integer which isn't in array - " +main.notContains(new int[]{1,2,3,4,7,6}));
      System.out.println("5. Variants - " + main.countVariants(4));
      System.out.println("4. Binary addition - " + main.binaryAdd("1011","111"));
      MyDataStructure<Integer> myDataStructure = new MyDataStructure<>();
      dataStructure.add(1); 
      dataStructure.add(2); 
      dataStructure.add(3);
      System.out.println("6. O(1) Data Structure Delete Result - "+myDataStructure.delete(3));
    }

public int singleNumber(int[] nums) {
    Map<Integer, Integer> elementCount = new HashMap<>();
    for (int num : nums) {
        elementCount.put(num, elementCount.getOrDefault(num, 0) + 1);
    }
    for (int num : nums) {
        if (elementCount.get(num) == 1) {
            return num;
        }
    }
    return -1;
}

public int minSplit(int amount){
    int[] coins ={50,20,10,5,1};
    int coinCounter = 0;
    
    for(int coin: coins){
        coinCounter+=amount/coin;
        amount = amount%coin ;
        if (amount==0) return coinCounter;
    }
    return coinCounter;
}

public int notContains(int[] array){
    Map<Integer,Integer> map = new HashMap<>();
    int max = array[0];
    for(int i = 0;i<array.length;i++){
        if(!map.containsKey(array[i])){
            map.put(array[i],array[i]);
        }
        if(array[i] >max ){ 
            max = array[i]; 
        }
    }
    for(int i = 1;i<=max;i++){ 
        if(!map.containsKey(i)){ 
            return i; 
        } 
    }
    if(max < 0){ 
        return 1; 
    } 
    return max+1;
}

public int countVariants(int stearsCount){
    if (stearsCount <= 1) return 1;
    return countVariants(stearsCount -1) +countVariants(stearsCount -2);
}

public String binaryAdd(String a, String b){
    StringBuilder result = new StringBuilder(); 
    int count = 0; 
    int i = a.length() - 1; 
    int j = b.length() - 1;
    
    while (i >= 0 || j >= 0 || count != 0){ 
        int sum = count; 
        if (i >= 0) { 
            sum += a.charAt(i--) - '0'; 
        } 
        if (j >= 0) { 
            sum += b.charAt(j--) - '0'; 
        } 
        result.insert(0, sum % 2); 
        count = sum / 2; 
    }
    return result.toString();
}

}

