package org.example;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GenerateRandom {
    private static Set<String> generatedNames = new HashSet<>();
    private static Set<String> generatedEmails = new HashSet<>();

    public String name(){
        String name;
        do{
            name = generateRandomName();
        }while(generatedNames.contains(name));
        generatedNames.add(name);
        return name;
    }

    public String email(){
        String email;
        do{
            email = generateRandomEmail();

        }while (generatedEmails.contains(email));
        generatedEmails.add(email);

        return email;
    }

    public static String generateRandomName(){
        String caracteres = "abcdefghijklmnopqrstuvwxyz";
        int length = 10;
        Random random = new Random();
        StringBuilder randomName = new StringBuilder(length);

        for(int i = 0; i < length; i++){
            randomName.append(caracteres.charAt(random.nextInt(caracteres.length())));
        }
        return randomName.toString();
    }

    public static String generateRandomEmail(){
        String email = "@mymail.com";
        Random random = new Random();

        return generateRandomName() + email;
    }
}
