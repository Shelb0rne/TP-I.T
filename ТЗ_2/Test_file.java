import org.junit.Test;
import java.io.IOException;
import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import static org.junit.Assert.*;

public class Check {

    @Test
    public void testTime() throws IOException {
        Main.nums = new ArrayList<>();
        int t1 = 1000;
        Random r = new Random();
        for (int i =0; i<t1; i++){
            Main.nums.add(r.nextLong(1,10000));
        }
        Instant start1 = Instant.now();
        long max1 = Main._max();
        long min1 = Main._min();
        long sum1 = Main._sum();
        BigInteger mult1 = Main._mult();
        Instant end1 = Instant.now();
        System.out.println("Время выполнения программы при нагрузке (1000 чисел): " + Duration.between(start1, end1).toMillis()+" мс");

        int t2 = 10000;
        for (int i =0; i<t2; i++){
            Main.nums.add(r.nextLong(1,10000));
        }
        Instant start2 = Instant.now();
       long max2 = Main._max();
       long min2 = Main._min();
       long sum2 = Main._sum();
       BigInteger mult2 = Main._mult();
        Instant end2 = Instant.now();
        System.out.println("Время выполнения программы при нагрузке (10000 чисел): " + Duration.between(start2, end2).toMillis()+ " мс");

        int t3 = 10000;
        for (int i =0; i<t3; i++){
            Main.nums.add(r.nextLong(1,10000));
        }
        Instant start3 = Instant.now();
        long max3 = Main._max();
        long min3 = Main._min();
        long sum3 = Main._sum();
        BigInteger mult3 = Main._mult();
        Instant end3 = Instant.now();
        System.out.println("Время выполнения программы при нагрузке (100000 чисел): " + Duration.between(start3, end3).toMillis()+ " мс");
    }
    @Test
    public void test_sum() {
        Main.nums = Arrays.asList(5L, 3L, 7L, 2L, 9L);
        assertEquals(26, Main._sum());
    }

    @Test
    public void test_mult() {
        Main.nums = Arrays.asList(5L, 3L, 7L, 2L, 9L);
        assertEquals(new BigInteger("1890"), Main._mult());
    }
    @Test
    public void testMemory(){
        Main.nums = Arrays.asList(5L, 3L, 7L, 2L, 9L);
        assertEquals(new BigInteger("1890"), Main._mult());
        assertEquals(26, Main._sum());
        assertEquals(2, Main._min());
        assertEquals(9, Main._max());
        long usedBytes = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("Использованная память: "+ usedBytes/1048576 + " мб");
    }
    @Test
    public void test_min() {
        Main.nums = Arrays.asList(5L, 3L, 7L, 2L, 9L);
        assertEquals(2, Main._min());

    }

    @Test
    public void test_max() {
        Main.nums = Arrays.asList(5L, 3L, 7L, 2L, 9L);
        assertEquals(9, Main._max());
    }
}
