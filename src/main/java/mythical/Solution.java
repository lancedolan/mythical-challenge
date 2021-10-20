package mythical;
/*
 * Click `Run` to execute the snippet below!
 */

import java.util.*;

/*
 * Write a function to return an excel spreadsheet column given an integer
 * Spreadsheet columns go A-Z, then AA, AB, AC, ..., AZ, BA, BB, ...,
 *
 * To run the code at any time, please hit the run button located in the top left corner.
 *
 */

public class Solution {
    public static void main(String[] args) {
        try {
            System.out.println("column heading for 1: " + convertIntegerToColumnName( 1 ) );
            System.out.println("column heading for 2: " + convertIntegerToColumnName( 2 ) );
            System.out.println("column heading for 16: " + convertIntegerToColumnName( 16 ) );
            System.out.println("column heading for 81: " + convertIntegerToColumnName( 81 ) );
            System.out.println("column heading for 107: " + convertIntegerToColumnName( 107 ) );
            System.out.println("column heading for 585: " + convertIntegerToColumnName( 585 ) );
            System.out.println("column heading for 676: " + convertIntegerToColumnName( 676 ) );
            System.out.println("column heading for 677: " + convertIntegerToColumnName( 677 ) );
            System.out.println("column heading for 701: " + convertIntegerToColumnName( 701 ) );
            System.out.println("column heading for 702: " + convertIntegerToColumnName( 702 ) );
            System.out.println("column heading for 703: " + convertIntegerToColumnName( 703 ) );
            System.out.println("column heading for 704: " + convertIntegerToColumnName( 704 ) );
            System.out.println("column heading for 17603: " + convertIntegerToColumnName( 17603 ) );
        } catch (Exception e) {
            System.out.println("Exception while running tests");
            e.printStackTrace();
        }



        //column heading for 1: A
        //column heading for 2: B
        //column heading for 16: P
        //column heading for 81: CC
        //column heading for 107: DC
        //column heading for 585: VM
        //column heading for 676: YZ
        //column heading for 677: ZA
        //column heading for 701: ZY
        //column heading for 702: ZZ
        //column heading for 703: AAA
        //column heading for 704: AAB
        //column heading for 17603: ZAA
    }

    // Lance's scratch notes...
    //  1  2   3    4
    //  1 26  676  17576 sub
    //  1 27  703  18279 div

    public static String convertIntegerToColumnName(int number) {

        /**
         * Numeric representation of the eventual lexicographic base 26 string.
         * EG. [1,1,1] represents "AAA" and [26,26,1] represents ZZA
         */
        List<Integer> numericRepresentation = new ArrayList<>();

        // get all initial As in place while also learning character depth to work backward from
        for(int i = 0; i < Integer.MAX_VALUE; i++) {
            final int base = (int) Math.pow(26, i);
            if (number-base < 0) {
                break;
            }
            numericRepresentation.add(1);
            number -= base;
        }

        // Populate numericRepresentation; Determine largest possible number at each base, beginning with largest.
        // Note: Our lexicographic representation orders by smallest numbers to the right.
        for(int i = numericRepresentation.size()-1; i > -1; i--) {
            final int base = (int) Math.pow(26, i);
            if (number >= base) {
                final int numberLettersThatFit = (int) Math.floor((double) number / base);
                final int representationIndex = numericRepresentation.size() - 1 - i;
                final int existingVal = numericRepresentation.get(representationIndex);
                numericRepresentation.set(representationIndex, existingVal + numberLettersThatFit);
                number -= numberLettersThatFit * base;
            }
        }

        return toLexicographic(numericRepresentation);
    }

    private static String toLexicographic(List<Integer> numbers) {
        String returnString = "";
        for (Integer number : numbers) {
            if (number>0) {
                returnString += getLetter(number-1);
            }
        }
        return returnString;
    }

    private static String getLetter(int letterAsInt) {
        String[] alphabet = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
        return alphabet[letterAsInt];
    }



}