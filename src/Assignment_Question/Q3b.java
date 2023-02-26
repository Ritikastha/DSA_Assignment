package Assignment_Question;

//    Question 3b)
//    you are provided certain string and pattern, return true if pattern entirely matches the string otherwise return false.
//    Note: if pattern contains char @ it matches entire sequence of characters and # matches any single character within string.
//    Input: String a=“tt”, pattern =”@”
//    Output: true
//    Input: String a=“ta”, pattern =”t”
//    Output: false
//    Input: String a=“ta”, pattern =”t#”
//    Output: true

public class Q3b {
    public static boolean P_Matche(String input, String pattern) {
        int input_Index = 0;
        int pattern_Index = 0;
        int inputLength = input.length();
        int patternLgt = pattern.length();
        while (input_Index < inputLength && pattern_Index < patternLgt) {
            char currentChar = pattern.charAt(pattern_Index);
            if (currentChar == '@') {
                pattern_Index++;
                if (pattern_Index == patternLgt) {
                    return true; //  the '@' character is at the end of the pattern, it corresponds to the rest of the input.
                }
                char nextChar = pattern.charAt(pattern_Index);
                while (input_Index < inputLength && input.charAt(input_Index) != nextChar) {
                    input_Index++;
                }
                if (input_Index == inputLength) {
                    return false; // Can't find the next character after '@' in the input
                }
            } else if (currentChar == '#') {
                input_Index++;
                pattern_Index++;
            } else if (input.charAt(input_Index) == currentChar) {
                input_Index++;
                pattern_Index++;
            } else {
                return false; // The corresponding character and current characater doesn't match  in the input
            }
        }
        return (input_Index == inputLength && pattern_Index == patternLgt);
    }

    public static void main(String[] args) {
        String input = "tt";
        String pattern = "@";
        boolean isMatch = P_Matche(input, pattern);
        System.out.println(isMatch);

        String input2 = "ta";
        String pattern2 = "t";
        boolean isMatch2 = P_Matche(input2, pattern2);
        System.out.println(isMatch2);

        String input3 = "ta";
        String pattern3 = "t#";
        boolean isMatch3 = P_Matche(input3, pattern3);
        System.out.println(isMatch3);
    }
}
