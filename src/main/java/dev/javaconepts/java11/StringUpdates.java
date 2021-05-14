package dev.javaconepts.java11;

public class StringUpdates {
    public static void main(String[] args) {
        String str;
//        System.out.println(str.isBlank());
//        str = "I\nam\nthe\ncreator\nof\nmy destiny";
//        System.out.println(str);
//        System.out.println(str.lines().collect(Collectors.toList()));
        str = "unicodeBlankSpaceTest";
        char unicodeBlankSpace = '\u2000';
        str = unicodeBlankSpace + str + unicodeBlankSpace;
        System.out.println(str);
        System.out.println(str.trim()); // trim can't remove these unicode blank spaces
        System.out.println(str.strip());
        System.out.println(str.stripTrailing());
        System.out.println(str.stripLeading());
        System.out.println(str.repeat(5));
    }
}
