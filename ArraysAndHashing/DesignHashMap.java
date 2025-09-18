import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DesignHashMap {
  private static final int DEFAULT_CAPACITY = 1000;
  private List<Entry>[] buckets;
  private static class Entry {
    private int key;
    private int value;

    public Entry(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  public DesignHashMap() {
    buckets = new List[DEFAULT_CAPACITY];
    for (int i = 0; i < DEFAULT_CAPACITY; i++) {
      buckets[i] = new ArrayList<>();
    }
  }

  private int hash(int key) {
    return key % DEFAULT_CAPACITY;
  }

  public void put(int key, int value) {
    int bucketIndex = hash(key);
    List<Entry> bucket = buckets[bucketIndex];

    for (Entry entry : bucket) {
      if (entry.key == key) {
        entry.value = value;
        return;
      }
    }
    bucket.add(new Entry(key, value));
  }

  public int get(int key) {
    int bucketIndex = hash(key);
    List<Entry> bucket = buckets[bucketIndex];
    for (Entry entry : bucket) {
      if (entry.key == key) {
        return entry.value;
      }
    }
    return -1;
  }

  public void remove(int key) {
    int bucketIndex = hash(key);
    List<Entry> bucket = buckets[bucketIndex];
    Iterator<Entry> iterator = bucket.iterator();
        while(iterator.hasNext()) {
            Entry entry = iterator.next();
            if (entry.key == key) {
                iterator.remove();
                return;
            }
        }
  }
}
