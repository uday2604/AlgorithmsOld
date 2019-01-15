package amazon;

import java.util.HashMap;

/**
 * Created by uthota on 8/11/16.
 */

// Egg and Add are Isomorphic
// Dog and  Pad are Isomorphic
// FOO and BAR are not Isomorphic

public class IsomorphicStrings {


    public boolean isomorphicStrings(String inputString1, String inputString2) {

        if(inputString1==null || inputString2==null || inputString1.length()!=inputString2.length())
            return false;

        HashMap<Character, Character> characterStoreHashMap = new HashMap<>();
        for(int i=0;i<inputString1.length();i++) {

            Character characterInFirstString = inputString1.charAt(i);
            Character characterInSecondString = inputString2.charAt(i);

            if(characterStoreHashMap.containsKey(characterInFirstString)) {

                Character getValue = characterStoreHashMap.get(characterInFirstString);
                if(getValue!=characterInSecondString)
                    return false;

            }

            else {

               // This is for test case "ab" and "aa"
                if(characterStoreHashMap.containsValue(characterInSecondString)) //if c2 is already being mapped
                    return false;

                characterStoreHashMap.put(characterInFirstString, characterInSecondString);
            }



        }
        return true;


    }

    // Program Creek Method
    public boolean isIsomorphic(String s, String t) {
        if(s==null||t==null)
            return false;

        if(s.length()!=t.length())
            return false;

        HashMap<Character, Character> map = new HashMap<Character, Character>();


        for(int i=0; i<s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(map.containsKey(c1)){
                if(map.get(c1)!=c2)// if not consistent with previous ones
                    return false;
            }else{
                if(map.containsValue(c2)) //if c2 is already being mapped
                    return false;
                map.put(c1, c2);
            }
        }

        return true;
    }

    public static void main(String[] args) {

        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        boolean isIsomorphic = isomorphicStrings.isomorphicStrings("ab", "aa");

        System.out.println("Both string are isomorphic: "+isIsomorphic);
    }


}
