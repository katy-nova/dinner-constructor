package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishesByType;
    Random random = new Random();

    DinnerConstructor() {
        dishesByType = new HashMap<>();
    }

    void addDish(String category, String name) {
        if (dishesByType.containsKey(category)) {
            ArrayList<String> dishes = dishesByType.get(category);
            if (dishes.contains(name)) {
                System.out.println("Это блюдо уже есть в списке");
                return;
            }
            dishes.add(name);
        } else {
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(name);
            dishesByType.put(category, dishes);
        }
        System.out.println(dishesByType);
    }

    void selfAddDishes() { // метод автоматического заполнения таблицы для упрощения тестов
        ArrayList<String> dishes = new ArrayList<>();
        dishes.add("Вода");
        dishes.add("Сок");
        dishes.add("Вино");
        dishesByType.put("Напиток",dishes);
        dishes = new ArrayList<>();
        dishes.add("Картофельное пюре");
        dishes.add("Рис");
        dishes.add("Гречка");
        dishes.add("Макароны");
        dishesByType.put("Гарнир",dishes);
        dishes = new ArrayList<>();
        dishes.add("Стейк");
        dishes.add("Котлета");
        dishesByType.put("Мясо",dishes);
    }

    boolean checkType(String type) {
        return dishesByType.containsKey(type);
    }

    void generateCombo(int numberOfCombos, ArrayList<String> types) {
        // создаем список списков для нужного кол-ва комбо
        ArrayList<ArrayList<String>> combos = new ArrayList<>(numberOfCombos);
        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> combo = new ArrayList<>();
            // создаем список для комбо
            for (String type: types) {
                ArrayList<String> dishes = dishesByType.get(type); // достаем список блюд по типу
                int length = dishes.size();
                int index = random.nextInt(length); // генерируем рандом в зависимости от длины списка
                String dish = dishes.get(index); // достаем рандомное блюдо из списка
                while (true) {
                    if (combo.contains(dish)) { // чтобы не было 2 одинаковых блюд одного типа
                        index = random.nextInt(length);
                        dish = dishes.get(index);
                    } else {
                        break;
                    }
                }
                combo.add(dish); // добавляем блюдо в комбо
            }
            combos.add(combo); // добавляем комбо в список комбо
        }
        for (int i = 0; i < combos.size(); i++) {
            System.out.println("Комбо " + (i + 1));
            System.out.println(combos.get(i));
        }
    }

}
