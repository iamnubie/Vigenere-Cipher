package model;

public class VigenereModel {
    private String keyword;

    public void setKeyword(String keyword) {
        this.keyword = keyword.toUpperCase();
    }

    private String generateKey(String text, String key) {
        StringBuilder newKey = new StringBuilder();
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                newKey.append(key.charAt(j));
                j = (j + 1) % key.length();
            } else {
                newKey.append(c);
            }
        }
        return newKey.toString();
    }

    public String encrypt(String text) {
        StringBuilder result = new StringBuilder();
        String key = generateKey(text, this.keyword);
        for (int i = 0; i < text.length(); i++) {
            char p = text.charAt(i);
            char k = key.charAt(i);
            if (Character.isUpperCase(p)) {
                result.append((char) ((p + k - 2 * 'A') % 26 + 'A'));
            } else if (Character.isLowerCase(p)) {
                result.append((char) ((p + Character.toLowerCase(k) - 2 * 'a') % 26 + 'a'));
            } else {
                result.append(p);
            }
        }
        return result.toString();
    }

    public String decrypt(String text) {
        StringBuilder result = new StringBuilder();
        String key = generateKey(text, this.keyword);
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            char k = key.charAt(i);
            if (Character.isUpperCase(c)) {
                result.append((char) ((c - k + 26) % 26 + 'A'));
            } else if (Character.isLowerCase(c)) {
                result.append((char) ((c - Character.toLowerCase(k) + 26) % 26 + 'a'));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}