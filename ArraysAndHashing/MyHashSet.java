import java.util.ArrayList;
import java.util.List;

public class MyHashSet {
  private static final int SIZE = 10000;
  private List<Integer>[] buckets;

  public MyHashSet() {
    buckets = new List[SIZE];
    for (int i = 0; i < SIZE; i++) {
      buckets[i] = new ArrayList<>();
    }
  }

  private int hash(int key) {
    return key % SIZE;
  }

  public void add(int key) {
    int bucketIndex = hash(key);
    List<Integer> bucket = buckets[bucketIndex];
    if (!bucket.contains(key)) {
      bucket.add(key);
    }
  }

  public void remove(int key) {
    int bucketIndex = hash(key);
    List<Integer> bucket = buckets[bucketIndex];
    if (bucket.contains(key)) {
      bucket.remove(Integer.valueOf(key));
    }
  }

  public boolean contains(int key) {
    int bucketIndex = hash(key);
    List<Integer> bucket = buckets[bucketIndex];
    return bucket.contains(key);
  }
}
