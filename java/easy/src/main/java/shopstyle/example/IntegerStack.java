package shopstyle.example;

import java.util.Optional;

/**
 * An {@link Integer} implementation of {@link Stack}.
 *
 * <p>Instances of this class are not thread-safe.</p>
 */
final class IntegerStack implements Stack<Integer>{

    private static final int DEFAULT_SIZE = 10;

    private Integer[] array;

    /**
     * the amount of occupying elements in the array,
     * to make it "dynamic"
     */
    private int fillSize = 0;

    public IntegerStack(){
        array = new Integer[DEFAULT_SIZE];
    }

    public IntegerStack(int size){
        array = new Integer[size];
    }

    @Override
    public boolean isEmpty() {
        return fillSize == 0;
    }

    @Override
    public Optional<Integer> peek() {
        if (fillSize == 0){
            return Optional.empty();
        }else{
            return Optional.of(fillSize - 1);
        }
    }

    @Override
    public Optional<Integer> pop() {
        Optional<Integer> value = peek();  //let's reuse
        if (value.isPresent()){
            array[--fillSize] = null;
        }
        return value;
    }

    @Override
    public void push(Integer val) {
      if (fillSize == array.length){
          StringBuilder sb = new StringBuilder("Input value ").append(val).append(" exceeds maximum capacity of ")
                  .append(array.length);
          throw new IllegalArgumentException(sb.toString());
      }
      array[fillSize] = val;
      fillSize++;
    }
}
