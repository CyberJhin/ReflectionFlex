package org.example;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    public static void main(String[] args) {
        List<Class<?>> classesToTest = new ArrayList<>();
        classesToTest.add(ClassToTest.class);

        for (Class<?> clazz : classesToTest) {
            runTests(clazz);
        }
    }

    private static void runTests(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MyTest.class)) {
                try {
                    Object instance = clazz.getDeclaredConstructor().newInstance();
                    // Вызываем метод и получаем результат
                    method.invoke(instance);
                    System.out.println("Тест '" + method.getName() + "' успешно завершен.");
                } catch (InvocationTargetException e) {
                    // Обработка исключения, возникшего при выполнении теста
                    Throwable cause = e.getCause();
                    if (cause instanceof TextComparisonException) {
                        System.out.println("Тест '" + method.getName() + "' завершился с ошибкой: " + cause.getMessage());
                    } else {
                        System.out.println("Тест '" + method.getName() + "' завершился с ошибкой: " + cause.getMessage());
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    // Обработка других исключений
                    e.printStackTrace();
                }
            }
        }
    }
}
