/*LRU缓存是最近最少使用
查询功能：找到该数，将原位置的数删除，将该数添到链表后面
添加功能：情况1 本来链表中还存有该数，删除原来的数，直接在后面插入新的
         情况2 链表中没有该数。此时看缓存，如果缓存未满，插到后面；如果缓存满了，先将链头的数删除，再添加新数到链尾
*/

class LRUCache {
    int cap;
    Map<Integer,Integer> map = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.cap = capacity;
    }
    
    public int get(int key) {
        if(map.keySet().contains(key)){
            int val = map.get(key);
            map.remove(key);
            map.put(key,val);
            return val;

        }
        return -1;

    }
    
    public void put(int key, int value) {
        if(map.keySet().contains(key)){
            map.remove(key);
        }else if(map.size() == cap){
            Iterator<Map.Entry<Integer,Integer>> iterator = map.entrySet().iterator();//迭代器
            iterator.next();//迭代器一开始必须用next；相当于指针
            iterator.remove();//next指针指向第一个，删除第一个
        }
        map.put(key,value);

    }
}