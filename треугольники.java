public class StringLengthArray {

   private String[] data;
   private int size;


   public StringLengthArray(int capacity) {
       data = new String[capacity];
       size = 0;
   }

   public void add(String s) {
       if (size == data.length) {
           throw new RuntimeException("Array is full");
       }

       data[size] = s;
       int i = size;

       while (i > 0 && data[i - 1].length() > s.length()) {
           data[i] = data[i - 1];
           i--;
       }

       data[i] = s;
       size++;
   }

   public String getMax() {
       if (size == 0) {
           throw new RuntimeException("Array is empty");
       }
       return data[size - 1];
   }

   public double getAverageLength() {
       if (size == 0) {
           return 0;
       }

       int sum = 0;
       for (int i = 0; i < size; i++) {
           sum += data[i].length();
       }

       return (double) sum / size;
   }

   public static void main(String[] args) {
       StringLengthArray arr = new StringLengthArray(10);

       arr.add("hi");
       arr.add("hello");
       arr.add("a");
       arr.add("Java");
       arr.add("programming");

       System.out.println("Max length string: " + arr.getMax());
       System.out.println("Average length: " + arr.getAverageLength());
   }
}