package com.company.lesson10;

import java.util.HashMap;
import java.util.HashSet;

public class Phonebook {
    private HashMap<String, HashSet> data = new HashMap<>();

    public Phonebook() {}

    public void add(String family, String phoneNumber) {
        HashSet phoneNumbers = new HashSet();
        HashSet foundPhoneNumbers = data.get(family.toLowerCase());

        if (foundPhoneNumbers != null) {
            phoneNumbers = foundPhoneNumbers;
        }
        phoneNumbers.add(phoneNumber);

        data.put(family.toLowerCase(), phoneNumbers);
    }

    public String get(String family) {
        HashSet foundPhoneNumbers = data.get(family.toLowerCase());

        if (foundPhoneNumbers == null) {
            return "Phone number of " + family + " not found";
        }
        if (foundPhoneNumbers.size() == 1) {
            return "Phone number of " + family + " is: " + foundPhoneNumbers.toString();
        }
        return "Phone numbers of " + family + " are: " + foundPhoneNumbers.toString();
    }
}
