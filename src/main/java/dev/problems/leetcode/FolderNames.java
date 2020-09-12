package dev.problems.leetcode;

import java.util.*;

//https://leetcode.com/problems/making-file-names-unique/
public class FolderNames {

    public static void main(String[] args) {

        FolderNames folderNames = new FolderNames();
//        String[] givenNames = new String[]{"kaido", "kaido(1)", "kaido", "kaido(1)", "kaido(2)"};
//        String[] givenNames = new String[]{"pes","fifa","gta","pes(2019)"};
//        String[] givenNames = new String[]{"gta","gta(1)","gta","avalon"};
//        String[] givenNames = new String[]{"wano","wano","wano","wano"};
        String[] givenNames = new String[]{"kaido","kaido(1)","kaido","kaido(1)"};


        String[] result = folderNames.getFolderNames(givenNames);
        System.out.println(Arrays.toString(result));
    }

    public String[] getFolderNames(String[] names) {
        LinkedHashMap<String, Integer> givenNames = new LinkedHashMap<>();
        for (String folderName : names) {
            String folderNameWithSuffix = folderName;

            if (givenNames.containsKey(folderNameWithSuffix)) {
                int previousSuffix = givenNames.get(folderNameWithSuffix);
                folderNameWithSuffix = folderName + "(" + ++previousSuffix + ")";
                while (givenNames.containsKey(folderNameWithSuffix)) {
                    folderNameWithSuffix = folderName + "(" + ++previousSuffix + ")";
                }


                givenNames.put(folderName, previousSuffix);
            }
            givenNames.put(folderNameWithSuffix, 0);
        }

        return givenNames.keySet().toArray(new String[givenNames.size()]);
    }

//    private void addToHashMap(String folderName, HashSet<String> givenNames, int suffix, String folderNameWithSuffix) {
//        if (/*!givenNames.contains(folderName) && */!givenNames.contains(folderNameWithSuffix)) {
//
//            givenNames.add(folderNameWithSuffix);
//        } else {
//            folderNameWithSuffix = folderName + "(" + suffix + ")";
//            suffix++;
//            addToHashMap(folderName, givenNames, suffix, folderNameWithSuffix);
//
//        }
//    }
}
