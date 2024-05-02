import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static List<Long> nums;
    public static void main(String[] args) throws FileNotFoundException {
        nums=new ArrayList<>();
        Scanner s = new Scanner(System.in);
        System.out.print("Введите путь до файла: ");
        String path = s.nextLine();
        s.close();
        File file = new File(path);
        Scanner scan = new Scanner(file);
      String line = scan.nextLine();
      scan.close();
      String[] lnum = line.split(" ");
      for (int i = 0; i< lnum.length; i++){
          nums.add(Long.parseLong(lnum[i]));
      }
        System.out.println(_max());
        System.out.println(_min());
        System.out.println(_sum());
        System.out.println(_mult());

    }
    public static long _max(){
       List<Long> copy = nums;
       Collections.sort(copy);
       return copy.getLast();
    }
    public static long _min(){
        List<Long> copy = nums;
        Collections.sort(copy);
        return copy.getFirst();
    }
    public static long _sum(){
        long ans=0;
        for (int i =0; i< nums.size(); i++){
            ans+= nums.get(i);
        }
        return ans;
    }
    public static BigInteger _mult(){
        BigInteger ans = new BigInteger("1");
        for (int i = 0; i< nums.size(); i++){
            ans = ans.multiply(BigInteger.valueOf(nums.get(i)));
        }
        return ans;
    }
}

