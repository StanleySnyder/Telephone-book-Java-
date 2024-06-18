import java.util.*;

class PhoneBook {
    private HashMap<String, List<Integer>> phoneBook = new HashMap<>();

    public void add(String name, Integer phoneNum) {
        // Проверяем, есть ли уже такое имя в телефонной книге
        if (phoneBook.containsKey(name)) {
            // Если есть, добавляем новый номер телефона к существующему списку
            phoneBook.get(name).add(phoneNum);
        } else {
            // Иначе создаем новую запись с одним номером телефона
            List<Integer> phones = new ArrayList<>();
            phones.add(phoneNum);
            phoneBook.put(name, phones);
        }
    }

    public List<Integer> find(String name) {
        // Ищем номера телефонов по имени
        return phoneBook.getOrDefault(name, new ArrayList<>());
    }

    public void showPhoneBook() {
        // Сначала сортируем записи по убыванию числа телефонов
        List<Map.Entry<String, List<Integer>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

        // Выводим отсортированные записи
        for (Map.Entry<String, List<Integer>> entry : sortedEntries) {
            System.out.println(entry.getKey() + " - " + entry.getValue().size() + " phone(s): " + entry.getValue());
        }
    }
}

public class PhoneBookDemo {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        // Добавляем записи в телефонную книгу
        phoneBook.add("Alice", 123456);
        phoneBook.add("Alice", 789012);
        phoneBook.add("Bob", 789012);

        // Выводим результаты
        System.out.println("Phone book entries:");
        phoneBook.showPhoneBook();
    }
}
