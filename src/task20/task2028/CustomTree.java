package task20.task2028;


import java.io.Serializable;

import java.util.*;

/*

Построй дерево(1)

*/



public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    List<Entry<String>> list = new LinkedList<>();

    int listSize = 0;

    Entry<String> root;


    public CustomTree() {

        root = new Entry<>("0");

        root.parent = root;

        this.list.add(root);

    }


    static class Entry<T> implements Serializable {

        String elementName;

        boolean availableToAddLeftChildren, availableToAddRightChildren;

        Entry<T> parent, leftChild, rightChild;


        public Entry(String elementName) {

            this.elementName = elementName;

            availableToAddLeftChildren = true;

            availableToAddRightChildren = true;

        }

        public boolean isAvailableToAddChildren() {

            return availableToAddLeftChildren | availableToAddRightChildren;

        }


        @Override

        public String toString() {

            return "" + elementName;

        }



/*

@Override

public String toString() {

return "Entry{" +

"elementName='" + elementName + '\'' +

", leftChild=" + leftChild +

", rightChild=" + rightChild +

'}';

}

*/

    }


    public boolean add(String s) {

        Entry<String> entry = new Entry<>(s);


        for (int i = 0; i < list.size(); i++) {

            Entry<String> cureEntry = list.get(i);


            if (cureEntry.isAvailableToAddChildren()) {

                if (cureEntry.availableToAddLeftChildren) {

                    cureEntry.leftChild = entry;

                    cureEntry.availableToAddLeftChildren = false;

                    entry.parent = cureEntry;

                    list.add(entry);

                    listSize++;

                    return true;

                } else if (cureEntry.availableToAddRightChildren) {

                    cureEntry.rightChild = entry;

                    cureEntry.availableToAddRightChildren = false;

                    entry.parent = cureEntry;

                    list.add(entry);

                    listSize++;

                    return true;

                }

            }

        }

        return false;

    }


    public int size() {

        return list.size() - 1;

    }


    public String getParent(String s) {

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).elementName.equals(s))

                return list.get(i).parent.toString();

        }

        return null;

    }



    // =======================================================



    public String get(int index) {

        return list.get(index).toString();

    }



    public String set(int index, String element) {

        throw new UnsupportedOperationException();

    }



    public String remove(int index) {

        throw new UnsupportedOperationException();

    }



    public List<String> subList(int fromIndex, int toIndex) {

        throw new UnsupportedOperationException();

    }



    protected void removeRange(int fromIndex, int toIndex) {

        throw new UnsupportedOperationException();

    }



    public boolean addAll(int index, Collection<? extends String> c) {

        throw new UnsupportedOperationException();

    }

}

