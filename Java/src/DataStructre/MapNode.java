package DataStructre;

public class MapNode<K,V> {
    int hash;
    K key;
    V value;
    MapNode next;

    public MapNode (int hash, K key, V value, MapNode next){
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
