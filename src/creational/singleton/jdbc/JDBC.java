package creational.singleton.jdbc;

import creational.singleton.jdbc.eager.EagerJDBC;
import creational.singleton.jdbc.lazy.threadsafe.ThreadSafeJDBC;
import creational.singleton.jdbc.lazy.threadunsafe.ThreadUnsafeJDBC;

import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Mohit Chaudhari
 * <a href="https://www.linkedin.com/in/mohit-chaudhari-1018/">Linkedin - Mohit Chaudhari</a>
 * Created date: 17/11/24
 */
public class JDBC {

    public static void main(String[] args) {
        System.out.println();
        validateThreadSafeSingletonDesignPattern();
        System.out.println();
        validateThreadUnsafeSingletonDesignPattern();
        System.out.println();
        validateEagerSingletonDesignPattern();
    }

    private static void validateThreadSafeSingletonDesignPattern() {
        System.out.println("This is thread safe singleton design pattern validation");
        Set<Integer> instanceHashCodes = ConcurrentHashMap.newKeySet();

        CompletableFuture<?>[] futures = new CompletableFuture[1000];

        for (int i = 0; i < 1000; i++) {
            futures[i] = CompletableFuture.runAsync(() -> {
               ThreadSafeJDBC instance = ThreadSafeJDBC.getInstance();
               instanceHashCodes.add(instance.hashCode());
            });
        }

        CompletableFuture.allOf(futures).join();
        // Verify if only one unique instance was created
        if (instanceHashCodes.size() == 1) {
            System.out.println("Singleton verified! Only one instance was created.");
        } else {
            System.out.println("Singleton violated! Multiple instances were created.");
            System.out.println("Hash codes of instances: " + instanceHashCodes);
        }
    }

    private static void validateThreadUnsafeSingletonDesignPattern() {
        System.out.println("This is thread unsafe singleton design pattern validation");
        Set<Integer> instanceHashCodes = ConcurrentHashMap.newKeySet();

        CompletableFuture<?>[] futures = new CompletableFuture[1000];

        for (int i = 0; i < 1000; i++) {
            futures[i] = CompletableFuture.runAsync(() -> {
                ThreadUnsafeJDBC instance = ThreadUnsafeJDBC.getInstance();
                instanceHashCodes.add(instance.hashCode());
            });
        }

        CompletableFuture.allOf(futures).join();
        // Verify if only one unique instance was created
        if (instanceHashCodes.size() == 1) {
            System.out.println("Singleton verified! Only one instance was created.");
        } else {
            System.out.println("Singleton violated! Multiple instances were created.");
            System.out.println("Hash codes of instances: " + instanceHashCodes);
        }
    }

    private static void validateEagerSingletonDesignPattern() {
        System.out.println("This is eager initialization if singleton design pattern validation");
        Set<Integer> instanceHashCodes = ConcurrentHashMap.newKeySet();

        CompletableFuture<?>[] futures = new CompletableFuture[1000];

        for (int i = 0; i < 1000; i++) {
            futures[i] = CompletableFuture.runAsync(() -> {
                EagerJDBC instance = EagerJDBC.getInstance();
                instanceHashCodes.add(instance.hashCode());
            });
        }

        CompletableFuture.allOf(futures).join();
        // Verify if only one unique instance was created
        if (instanceHashCodes.size() == 1) {
            System.out.println("Singleton verified! Only one instance was created.");
        } else {
            System.out.println("Singleton violated! Multiple instances were created.");
            System.out.println("Hashcodes of instances: " + instanceHashCodes);
        }
    }
}
