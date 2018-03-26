package datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RansomNote {

    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;

    public RansomNote(String magazine, String note) {
        magazineMap = new HashMap<>();
        noteMap = new HashMap<>();
        String[] strArr1 = magazine.split(" ");
        String[] strArr2 = note.split(" ");
        for (int i = 0; i < strArr1.length; i++) {
            if (!magazineMap.containsKey(strArr1[i])) {
                magazineMap.put(strArr1[i], 1);
            } else {
                int newVal = magazineMap.get(strArr1[i]) + 1;
                magazineMap.put(strArr1[i], newVal);
            }
        }

        for (int i = 0; i < strArr2.length; i++) {
            if (magazineMap.containsKey(strArr2[i]) && magazineMap.get(strArr2[i]) > 0) {
                int newVal = magazineMap.get(strArr2[i]) - 1;
                magazineMap.put(strArr2[i], newVal);
            } else {
                noteMap.put(strArr2[i], 1);
                break;
            }
        }
    }

    public boolean solve() {
        if (noteMap.size() > 0) return false;
        else return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // Eat whitespace to beginning of next line
        scanner.nextLine();

        RansomNote s = new RansomNote(scanner.nextLine(), scanner.nextLine());
        scanner.close();

        boolean answer = s.solve();
        if (answer)
            System.out.println("Yes");
        else System.out.println("No");

    }
}
