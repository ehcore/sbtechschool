import java.util.*;

public class Solution2045 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        List<String> list = new ArrayList<>();

        int first = 0;
        int end = 0;

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (ch == ',' || ch == '.' || ch == '!' || ch == '?' || ch == ' ') {
                end = i;
                String subLine = line.substring(first, end + 1);
                if (!subLine.equals(" ")) list.add(subLine.trim());
                first = i + 1;
            }
        }

        String subLine = line.substring(first, line.length());
        if (!subLine.equals(" ")) list.add(subLine.trim());

        for (int i = 0; i < list.size(); i++) {
            char ch = list.get(i).charAt(0);
            if ((ch == ',' || ch == '.' || ch == '!' || ch == '?') & i > 0) {
                String previous = list.get(i - 1);
                String current = list.get(i);
                list.set(i - 1, previous.trim() + ch);
                list.set(i, current.substring(1, current.length()));
            }
        }

        List<String> finalList = new ArrayList<>();
        for (String str : list) {
            if (!str.equals("")) finalList.add(str.trim());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < finalList.size() - 1; i++) {
            sb.append(finalList.get(i)).append(" ");
        }
        sb.append(finalList.get(finalList.size() - 1));
        System.out.println(sb.toString());
    }
}
