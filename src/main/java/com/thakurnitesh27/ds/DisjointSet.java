package com.thakurnitesh27.ds;


import java.util.*;

/**
 * This is an implementation for disjoint set data structure. It uses hashing to maintain the uniqueness of the items passed.
 * Equality and hashing performance depends upon the item(of type V) being used.
 * It maintains rank in each representative to find the smaller list and then update the new representative into
 * each item which has older representative. Rank of non representative items doesn't matter.
 * @param <V>
 */

public class DisjointSet<V> {

    // private Item[] items;
    //private Item[] parent;
    // private static final int DEFAULT_SIZE = 10;
    private HashMap<V, Item<V>> uniqueItems;
    private int index = 0;
    private final Random secureRandom;


//    public DisjointSet(T[] items) {
//        this.items = items;
//        parent = new Item[items.length];
//        uniqueItems = new HashSet<T>(items.length);
//        secureRandom = new Random();
//    }

    public DisjointSet() {
        //  items = new Item[DEFAULT_SIZE];
        // parent = new Item[DEFAULT_SIZE];
        uniqueItems = new HashMap<>();
        secureRandom = new Random();
    }


    public Boolean makeSet(V value) {
        if (!uniqueItems.keySet().contains(value)) {
            addItem(value);
            return true;
        }
        //item already a set in current disjoint instance.
        return false;
    }

    private void addItem(V value) {
        Item newItem = createNewItem(value);
        uniqueItems.put(value, newItem);
        //  items[index] = newItem;
        //  parent[index] = newItem;
    }

    private Item createNewItem(V value) {
        return new Item<V>(value);
    }

    public int find(V value) {

        Item itemToFind = uniqueItems.get(value);
        if (Objects.nonNull(itemToFind)) {

            return itemToFind.getRepresentative().getKey();
        }
        return Integer.MIN_VALUE;
    }

    public void union(V value1, V value2) {

        int key1 = find(value1);
        int key2 = find(value2);
        if (key1 != key2 && key1 != Integer.MIN_VALUE && key2 != Integer.MIN_VALUE) {
            Item itemList1 = uniqueItems.get(value1);
            Item itemList2 = uniqueItems.get(value2);
            int rank1 = itemList1.getRepresentative().getRank();
            int rank2 = itemList2.getRepresentative().getRank();
            if (rank2 > rank1) {

                Item newRep = itemList2.getRepresentative();
                Item nextItem = itemList1;
                //do {
                nextItem.setRepresentative(newRep);
                // uniqueItems.remove(nextItem.value);
                nextItem = nextItem.next;

                // }
                // while (nextItem.next != null);
                uniqueItems.values().forEach(item->{
                    if(item.getRepresentative().equals(itemList1)){
                        item.setRepresentative(newRep);
                        //item.setNewRank(1);
                    }
                });

                int newRank = rank1 + rank2;
                newRep.setNewRank(newRank);

            } else {

                Item newRep = itemList1.getRepresentative();
                Item nextItem = itemList2;
                //  do {
                nextItem.setRepresentative(newRep);
                // uniqueItems.remove(nextItem.value);
                nextItem = nextItem.next;

                // }
                //  while (nextItem!= null);
                uniqueItems.values().
                        forEach(item->{
                    if(item.getRepresentative().equals(itemList2)){
                        item.setRepresentative(newRep);
                        //item.setNewRank(1);
                    }
                });

                int newRank = rank1 + rank2;
                newRep.setNewRank(newRank);

            }
        }
    }

    public Collection<List<V>> collectDisjointSets() {
        Map<Item, List<V>> representatives = new HashMap<>();
        for (V value : uniqueItems.keySet()) {
            Item currentItem = uniqueItems.get(value);
            Item rep = currentItem.getRepresentative();
            if (representatives.containsKey(rep)) {
                List list = representatives.get(rep);
                list.add(currentItem.value);
            }
            else {
                List list=new ArrayList<>();
                list.add(rep.getValue());
                representatives.put(rep,list);
            }
        }
        return representatives.values();

    }

    protected class Item<V> {
        private final V value;
        private int key;
        private Item representative;
        private Item next;
        private Item prev;
        private int rank;

        Item(V item) {
            this.value = item;
            this.key = secureRandom.nextInt();
            representative = this;
            next = null;
            prev = null;
            rank = 1;
        }

        public V getValue() {
            return value;
        }

        public int getKey() {
            return key;
        }


        public Item getRepresentative() {
            return representative;
        }

        public void setRepresentative(Item representative) {
            this.representative = representative;
        }

        public Item getNext() {
            return next;
        }

        public void setNext(Item next) {
            this.representative.incrementRank();
            this.next = next;
        }

        public Item getPrev() {
            return prev;
        }

        public void setPrev(Item prev) {
            this.prev = prev;
        }

        public int getRank() {
            return rank;
        }

        public void incrementRank() {
            if (this.equals(representative))
                this.rank++;
            else {
                this.representative.incrementRank();
            }
        }

        public void setNewRank(int rank) {
            if (this.equals(representative)) {
                this.rank = rank;
            }
        }

        @Override
        public int hashCode() {
            return value.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Item) {
                Item newItem = ((Item<V>) obj);
                return value.equals(newItem.value);
            }
            return false;
        }
    }
}
