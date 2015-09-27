package comapps.com.decimaltoroman;

/**
 * Created by me on 7/28/2015.
 */
public class RomanConvert {

    static String IntegerToRomanNumeral(int input)
    {


        String stringRoman = "";

        while (input >= 1000) {
            stringRoman += "M";
            input -= 1000;
        } while (input >= 900) {
        stringRoman += "CM";
        input -= 900;
    } while (input >= 500) {
        stringRoman += "D";
        input -= 500;
    } while (input >= 400) {
        stringRoman += "CD";
        input -= 400;
    } while (input >= 100) {
        stringRoman += "C";
        input -= 100;
    } while (input >= 90) {
        stringRoman += "XC";
        input -= 90;
    } while (input >= 50) {
        stringRoman += "L";
        input -= 50;
    } while (input >= 40) {
        stringRoman += "XL";
        input -= 40;
    } while (input >= 10) {
        stringRoman += "X";
        input -= 10;
    } while (input >= 9) {
        stringRoman += "IX";
        input -= 9;
    } while (input >= 5) {
        stringRoman += "V";
        input -= 5;
    } while (input >= 4) {
        stringRoman += "IV";
        input -= 4;
    } while (input >= 1) {
        stringRoman += "I";
        input -= 1;
    }

        return stringRoman;
    }
}
