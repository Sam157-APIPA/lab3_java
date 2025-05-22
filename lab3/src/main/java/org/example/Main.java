
package org.example;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/**
 * Класс Main выполняет бенчмарк сравнения производительности коллекций ArrayList и LinkedList.
 *
 * Выполняются следующие операции над каждой коллекцией:
 *
 *   add(int) — добавление элементов;   get(int) — случайный доступ к элементам;   remove(0) — удаление элементов из начала списка.
 * Результаты измеряются в наносекундах и выводятся в миллисекундах.
 *
 */
public class Main {
    /**
     * Точка входа в программу. Выполняет бенчмарк операций add, get и remove(0)
     * для ArrayList и LinkedList.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        int n = 100000; // количество операций
        Random rand = new Random(0);

        // Тест ArrayList
        List<Integer> arrayList = new ArrayList<>();
        System.out.println("Benchmarking ArrayList with " + n + " operations:");
        long start, duration;

        // add
        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            arrayList.add(i);
        }
        duration = System.nanoTime() - start;
        System.out.printf("%-12s | %-10s | %10d | %10.3f ms%n",
                "ArrayList", "add", n, duration / 1_000_000.0);

        // get
        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            arrayList.get(rand.nextInt(n));
        }
        duration = System.nanoTime() - start;
        System.out.printf("%-12s | %-10s | %10d | %10.3f ms%n",
                "ArrayList", "get", n, duration / 1_000_000.0);

        // remove(0)
        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            arrayList.remove(0);
        }
        duration = System.nanoTime() - start;
        System.out.printf("%-12s | %-10s | %10d | %10.3f ms%n",
                "ArrayList", "remove(0)", n, duration / 1_000_000.0);

        System.out.println();

        // Тест LinkedList
        List<Integer> linkedList = new LinkedList<>();
        System.out.println("Benchmarking LinkedList with " + n + " operations:");

        // add
        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkedList.add(i);
        }
        duration = System.nanoTime() - start;
        System.out.printf("%-12s | %-10s | %10d | %10.3f ms%n",
                "LinkedList", "add", n, duration / 1_000_000.0);

        // get
        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkedList.get(rand.nextInt(n));
        }
        duration = System.nanoTime() - start;
        System.out.printf("%-12s | %-10s | %10d | %10.3f ms%n",
                "LinkedList", "get", n, duration / 1_000_000.0);

        // remove(0)
        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkedList.remove(0);
        }
        duration = System.nanoTime() - start;
        System.out.printf("%-12s | %-10s | %10d | %10.3f ms%n",
                "LinkedList", "remove(0)", n, duration / 1_000_000.0);
    }
}
