package ru.sbt.patterns2.behavioral;


public class IteratorApp {
    public static void main(String[] args) {
        MyCollection c = new MyCollection();

        Iterator it = c.getIterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

interface Iterator {
    Object next();

    boolean hasNext();
}

interface Container {
    Iterator getIterator();
}

class MyCollection implements Container {
    private static final String[] collect = {"Картофель", "Свекла", "Капуста", "Лук", "Томат", "Мясо"};

    @Override
    public Iterator getIterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator {
        int index = 0;

        @Override
        public Object next() {
            return collect[index++];
        }

        @Override
        public boolean hasNext() {
            if (index < collect.length) {
                return true;
            }
            return false;
        }
    }
}

