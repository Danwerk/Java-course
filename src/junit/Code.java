package junit;

import java.util.Arrays;

public class Code {
    public static void main(String[] args) {
        int[] array = {100, 0, 3, 100, 0, 4, 562, 4};
//        System.out.println(mode("abbcccddddf"));
//        System.out.println(getCharacterCount("abcccd", 'c'));
//        System.out.println(longestStreak(null));
        System.out.println(removeDuplicates(array));
        System.out.println(copyOfArray(array));
    }

    public static boolean isSpecial(int candidate) {

        return candidate % 11 < 4;
    }

    public static int longestStreak(String inputString) {
        if (inputString == "" || inputString == null) {
            return 0;
        }
        String lastChar = null;
        int globalStreak = 0;
        int streak = 0;
        for (String currentChar : inputString.split("")) {
            if (currentChar.equals(lastChar)){
                streak++;
            }

            else {
                streak = 1;
            }

            if (streak > globalStreak) {
                globalStreak = streak;
            }

            lastChar = currentChar;
        }
        return globalStreak;
    }

    public static Character mode(String inputString) {
        if (inputString == null || inputString == "") {
            return null;
        }
        Character mode = null;
        int globalCount = 0;
        for (char i : inputString.toCharArray()) {
            int count = 0;
            for (char j : inputString.toCharArray()) {
                if (j == i) {
                    count++;
                }
            }
            if (count > globalCount) {
                globalCount = count;
                mode = i;
            }
        }
        return mode;
    }



    public static int getCharacterCount(String allCharacters, char targetCharacter) {
        if (allCharacters == "") {
            return 0;
        }
        int count = 0;
        for (char i : allCharacters.toCharArray()) {
            if (i == targetCharacter) {
                count += 1;
            }
        }
        return count;
    }



    public static int[] removeDuplicates(int[] integers) {
        boolean wasZero = false;
        int i = 0;
        int arrayLength = countUniqueElementsInArray(integers);
        int[] newArray = new int[arrayLength];


        for (int integer : integers) {
            if (integer == 0 && !wasZero) {  //This is important part to check whether the zero fits in array
                newArray[i] = integer;       //by default the elements of an array are zeros
                wasZero = true;
                i++;
                continue;
            }
            if (arrayContainsValue(newArray, integer)) {
                continue;
            }

            else {
                newArray[i] = integer;
                i++;
            }
        }
    return newArray;
    }



    public static int countUniqueElementsInArray(int[] integers) {  //auxiliary function for removeDuplicates
        int counter = 1;
        int[] arrayCopy = copyOfArray(integers);
        Arrays.sort(arrayCopy);

        for (int i = 1; i < arrayCopy.length; i++) {
            if (arrayCopy[i] != arrayCopy[i - 1]) {
                counter++;
            }
        }
        return counter;
    }



    public static boolean arrayContainsValue(int[] integers, int searchedValue) {  //auxiliary function for removeDuplicates
        boolean found = false;
        for(int x : integers){
            if(x == searchedValue){
                found = true;
                break;
            }
        }
    return found;
    }



    public static int[] copyOfArray(int[] integers) {   //auxiliary function for removeDuplicates
        int[] newArray = new int[integers.length];
        for (int i = 0; i < integers.length; i++) {
            newArray[i] = integers[i];
        }
        return newArray;
    }



    public static int sumIgnoringDuplicates(int[] integers) {
        int result = 0;
        int[] newArray = removeDuplicates(integers);
        for (int i : newArray) {
            result += i;

        }
        return result;
    }
}
