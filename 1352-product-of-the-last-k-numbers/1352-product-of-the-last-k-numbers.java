import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
    private List<Integer> prefix;

    public ProductOfNumbers() {
        prefix = new ArrayList<>();
        prefix.add(1); // Sentinel value to simplify division
    }
    
    public void add(int num) {
        if (num == 0) {
            prefix.clear();
            prefix.add(1);
        } else {
            int lastProduct = prefix.get(prefix.size() - 1);
            prefix.add(lastProduct * num);
        }
    }
    
    public int getProduct(int k) {
        int n = prefix.size();
        if (k >= n) {
            return 0; // A zero was added within the last k elements
        }
        return prefix.get(n - 1) / prefix.get(n - 1 - k);
    }
}