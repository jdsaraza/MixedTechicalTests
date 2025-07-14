public class Integer_To_Roman {
/*
Seven different symbols represent Roman numerals with the following values:
Symbol	Value
I	    1
V	    5
X	    10
L	    50
C	    100
D	    500
M	    1000
Roman numerals are formed by appending the conversions of decimal place values from highest to lowest.
Converting a decimal place value into a Roman numeral has the following rules:
If the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted from the input,
append that symbol to the result, subtract its value, and convert the remainder to a Roman numeral.
If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted from the following symbol,
for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX.
Only the following subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).
Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of 10.
You cannot append 5 (V), 50 (L), or 500 (D) multiple times. If you need to append a symbol 4 times
use the subtractive form.
Given an integer, convert it to a Roman numeral.

Example 1:
    Input: num = 3749
    Output: "MMMDCCXLIX"
    Explanation:
    3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)
     700 = DCC as 500 (D) + 100 (C) + 100 (C)
      40 = XL as 10 (X) less of 50 (L)
       9 = IX as 1 (I) less of 10 (X)
    Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places
Example 2:
    Input: num = 58
    Output: "LVIII"
    Explanation:
    50 = L
     8 = VIII
Example 3:
    Input: num = 1994
    Output: "MCMXCIV"
    Explanation:
    1000 = M
     900 = CM
      90 = XC
       4 = IV

Constraints:
1 <= num <= 3999
 */

    public static void main(String[] args) {

        int number = 3749;
        System.out.println("Roman Number from "+number+" is: "+intToRoman(number));
    }

    public static String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();

        if (num <1 || num > 3999) return "The num is not in the range";

        //thousand cases
        while (num > 999) {
            roman.append("M");
            num = num-1000;
        }


        //hundred cases
        if (num > 99) {
            int auxHundred = num/100;
            switch (auxHundred) {
                case 1 : roman.append("C"); break;
                case 2 : roman.append("CC"); break;
                case 3 : roman.append("CCC"); break;
                case 4 : roman.append("CD"); break;
                case 5 : roman.append("D"); break;
                case 6 : roman.append("DC"); break;
                case 7 : roman.append("DCC"); break;
                case 8 : roman.append("DCCC"); break;
                case 9 : roman.append("CM"); break;
            }
            num = num%100;//reduce to tens

        }

        //tens cases
        if(num > 9 ){
            int auxTen = num/10;
            switch (auxTen) {
                case 1 : roman.append("X"); break;
                case 2 : roman.append("XX"); break;
                case 3 : roman.append("XXX"); break;
                case 4 : roman.append("XL"); break;
                case 5 : roman.append("L"); break;
                case 6 : roman.append("LX"); break;
                case 7 : roman.append("LXX"); break;
                case 8 : roman.append("LXXX"); break;
                default : roman.append("XC"); break;
            }
            num = num%10;//reduce to units
        }

        //units cases
        switch (num){
            case 1 : roman.append("I"); break;
            case 2 : roman.append("II"); break;
            case 3 : roman.append("III"); break;
            case 4 : roman.append("IV"); break;
            case 5 : roman.append("V"); break;
            case 6 : roman.append("VI"); break;
            case 7 : roman.append("VII"); break;
            case 8 : roman.append("VIII"); break;
            default : roman.append("IX"); break;
        }
        return roman.toString();
    }
}
