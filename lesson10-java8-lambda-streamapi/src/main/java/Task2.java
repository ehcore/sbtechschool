import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Выведите на экран список различных слов файла, отсортированный по возрастанию их длины
 * (компаратор сначала по длине слова, потом по тексту).
 * Задание(№2) из ДЗ к уроку по коллекциям
 * upd: переписать часть функционала на stream api
 */

public class Task2 {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(new File("input.txt")).useDelimiter("[^а-яА-Яa-zA-Z0-9-]");
        Set<String> set = new HashSet<>();

        while (scanner.hasNext()){
            String line = scanner.next();
            if(!line.equals("")){
                set.add(line);
            }
        }

        List<Word> list = new ArrayList<>();

        for (String str : set){
            Word word = new Word(str);
            list.add(word);
        }

        list.stream()
                .sorted(new Word().new FullComparator())
                .forEach(System.out::println);

    }
}


class Word{

    String word;
    Integer length;

    Word(){}

    Word(String word){
        this.word = word;
        this.length = word.length();
    }

    class LengthComparator implements Comparator<Word>{
        @Override
        public int compare(Word o1, Word o2) {
            return o1.length.compareTo(o2.length);
        }
    }

    class TextComparator implements Comparator<Word>{
        @Override
        public int compare(Word o1, Word o2) {
            return o1.word.toLowerCase().compareTo(o2.word.toLowerCase());
        }
    }

    class FullComparator implements Comparator<Word>{
        @Override
        public int compare(Word o1, Word o2) {
            int comp = o1.length - o2.length;
            if(comp == 0) comp = o1.word.toLowerCase().compareTo(o2.word.toLowerCase());
            return comp;
        }
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                ", length=" + length +
                '}';
    }
}