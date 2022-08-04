import java.util.Arrays;
import java.util.stream.IntStream;
import java.lang.reflect.Array;


public class ReplaceWithMax {
    public static void main(String[] args) {

        int [] inputArray = new int[]{16, 17, 6, 2, 5, 3};
        int[] ints = IntStream.range(0, inputArray.length)
                .map(x ->  Arrays.stream(Arrays.copyOfRange(inputArray, x+1, inputArray.length + 1)).max().getAsInt()).toArray();
        Array.set(ints, inputArray.length-1, -1);
        System.out.println(Arrays.toString(ints));

    }
}