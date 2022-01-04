import java.util.*;
import java.util.regex.Pattern;

public class PhoneBook {
    Map<String, String> mapPhone = new HashMap<>();

    public void addContact(String phone, String name) {

        String regexName = "^(([А-Я]{1}[а-я]{1,14}\\s[А-Я]{1}[а-я]{1,14})|([А-Я]{1}[а-я]{1,14}\\s[А-Я]{1}[а-я]{1,14}\\s[А-Я]{1}[а-я]{1,14})|([А-Я]{1}[а-я]{1,14})|([А-Я]{1}[а-я]{1,15}\\s[А-Я]{1}[а-я]{1,14}\\s[А-Я]{1}[а-я]{1,14}\\-[А-Я]{1}[а-я]{1,14}))$";
        String regexNumber = "^[0-9]{11}$";
        if (Pattern.compile(regexName).matcher(name).matches() && Pattern.compile(regexNumber).matcher(phone).matches()) {
            if (mapPhone.containsKey(phone)) {
                mapPhone.remove(phone);
            }
            mapPhone.put(phone, name);
            System.out.println("контакт сохранен");
        } else {
            System.out.println("имя или номер введен некорректно");
        }
    }

    public String getNameByPhone(String phone) {

        String nameByPhone = "";
        if (mapPhone.containsKey(phone)) {
            nameByPhone = mapPhone.get(phone) + " - " + phone;
            System.out.println(nameByPhone);
            return nameByPhone;
        } else {
            System.out.println("контакта с таким номером в списке нет");
            return nameByPhone;
        }
    }

    public Set<String> getPhonesByName(String name) {

        Set<String> setPhoneByName = new TreeSet<>();
        String stringKey = "";
        if (mapPhone.containsValue(name)) {
            for (Map.Entry<String, String> entry : mapPhone.entrySet()) { // Преобразует Map в Entry
                if (entry.getValue().equals(name)) { // Если данное имя имеется в Entry  !True!
                    stringKey = stringKey.concat(entry.getKey() + ",");
                }
            }
            String k = stringKey.substring(0, stringKey.lastIndexOf(","));
            setPhoneByName.add(name + " - " + k);
            for (String byName : setPhoneByName) {
                System.out.println(byName);
            }
            return setPhoneByName;
        } else {
            System.out.println("контакта с таким именим в списке нет");
            return setPhoneByName;
        }
    }

    public Object getAllContacts() {

        Set<String> phoneBookSet = new TreeSet<>();
        ArrayList<String> list = new ArrayList<>(mapPhone.values());
        Set<String> stringsOfKeys = new TreeSet<>(mapPhone.values());
        ArrayList<String> listValues = new ArrayList<>(stringsOfKeys);

        for (int i = 0; i < listValues.size(); i++) {
            int ch = 0; // счётчик
            String s = "";

            for (int j = 0; j < list.size(); j++) {
                boolean b = list.get(j).contains(listValues.get(i));
                if (b) {
                    ch++;
                }
            }
            if (ch > 0) {
                for (Map.Entry<String, String> entry : mapPhone.entrySet()) {
                    if (entry.getValue().equals(listValues.get(i))) {
                        s = s.concat(entry.getKey() + ",");
                    }
                }
                String k = s.substring(0, s.lastIndexOf(","));
                phoneBookSet.add(listValues.get(i) + " - " + k);
            } else {
                for (Map.Entry<String, String> entry : mapPhone.entrySet()) {
                    phoneBookSet.add(entry.getValue() + " - " + entry.getKey());
                }
            }
        }
        for (String printContacts : phoneBookSet) {
            System.out.println(printContacts);
        }
        return phoneBookSet;
    }
}