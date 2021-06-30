package br.com.meli.bootcampspringcodigomorse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CodigoMorseService {
    private final Map<Character, String> simbolos = new HashMap<>();

    @Autowired
    public CodigoMorseService() {
        simbolos.put('A', ".-");
        simbolos.put('B', "-...");
        simbolos.put('C', "-.-.");
        simbolos.put('D', "-..");
        simbolos.put('E', ".");
        simbolos.put('F', "..-.");
        simbolos.put('G', "--.");
        simbolos.put('H', "....");
        simbolos.put('I', "..");
        simbolos.put('J', ".---");
        simbolos.put('K', "-.-");
        simbolos.put('L', ".-..");
        simbolos.put('M', "--");
        simbolos.put('N', "-.");
        simbolos.put('O', "---");
        simbolos.put('P', ".--.");
        simbolos.put('Q', "--.-");
        simbolos.put('R', ".-.");
        simbolos.put('S', "...");
        simbolos.put('T', "-");
        simbolos.put('U', "..-");
        simbolos.put('V', "...-");
        simbolos.put('W', ".--");
        simbolos.put('X', "-..-");
        simbolos.put('Y', "-.--");
        simbolos.put('Z', "--..");
        simbolos.put('0', "-----");
        simbolos.put('1', ".---");
        simbolos.put('2', "..---");
        simbolos.put('3', "...--");
        simbolos.put('4', "....-");
        simbolos.put('5', ".....");
        simbolos.put('6', "-....");
        simbolos.put('7', "--...");
        simbolos.put('8', "---..");
        simbolos.put('9', "----.");
        simbolos.put(' ', "   ");
    }

    public String toMorse(String normal) {
        StringBuilder textMorse = new StringBuilder();

        for (char character : normal.toUpperCase().toCharArray()) {
            if (textMorse.length() > 0)
                textMorse.append(" ");

            textMorse.append(getCharacterMorse(character));
        }

        return textMorse.toString();
    }

    public String toNormal(String morse) {
        StringBuilder textNormal = new StringBuilder();
        String[] morseWords = morse.split("\\Q   \\E");
        for (String morseWord : morseWords) {
            if (textNormal.length() > 0)
                textNormal.append(" ");

            String[] morseLetters = morseWord.trim().split(" ");
            for (String morseLetter : morseLetters)
                textNormal.append(getCharacterNormal(morseLetter));
        }

        return textNormal.toString();
    }

    private String getCharacterMorse(char normal) {
        return simbolos.get(normal);
    }

    private String getCharacterNormal(String morse) {
        String result = null;

        for (Map.Entry<Character, String> item : simbolos.entrySet()) {
            if (item.getValue().equalsIgnoreCase(morse))
                result = item.getKey().toString();
        }

        return result;
    }
}
