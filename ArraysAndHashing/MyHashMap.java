import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyHashMap {

  private static final int SIZE_DEFAULT = 1000;
  private List<Entry>[] buckets;

  public static class Entry {

    public int key;
    public int value;

    public Entry(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  public MyHashMap() {
    buckets = new List[SIZE_DEFAULT];
    for (int i = 0; i < SIZE_DEFAULT; i++) {
      buckets[i] = new ArrayList<>();
    }
  }

  private int hash(int key) {
    return key % SIZE_DEFAULT;
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
    while (iterator.hasNext()) {
      Entry entry = iterator.next();
      if (entry.key == key) {
        iterator.remove();
        return;
      }
    }
  }
}
