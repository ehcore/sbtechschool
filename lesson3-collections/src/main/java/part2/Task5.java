package part2;


import java.io.*;
import java.util.*;

/**
 * Реализуйте свой Iterator для обхода списка в обратном порядке.
 *
 */

public class Task5 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("input.txt")).useDelimiter("[^а-яА-Яa-zA-Z0-9-]");
        List<String> list = new ArrayList<>();

        while(scanner.hasNext()){
            String line = scanner.next();
            if(!line.equals("")){
                list.add(line);
            }
        }

        ConcreteContainer c = new ConcreteContainer(list);
        Iterator it = c.getIterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}


interface Iterator{
    boolean hasNext();
    Object next();
}

interface Container{
    Iterator getIterator();
}

class ConcreteContainer implements Container{
    List<String> list;

    ConcreteContainer(List list){
        this.list = list;
    }

    @Override
    public Iterator getIterator() {
        return new IteratorContainer();
    }

    private class IteratorContainer implements Iterator{
        int index = list.size()-1;

        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public Object next() {
            return list.get(index--);
        }
    }
}