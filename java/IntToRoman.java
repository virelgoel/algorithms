public class IntToRoman{
    public static String toRoman(int n){
        String roman = "";
        int quotient;
        int numbers[] = {1000,900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String symbols[] = {"M","CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        for(int i = 0; n > 0; i++){
            quotient = n / numbers[i];
            for(int j = 1; j <= quotient; j++){
                roman = roman + symbols[i];
            }
            n = n % numbers[i];
        }
        return roman;
    }
 
    public static void main(String args[]){
        System.out.println("12: "+ toRoman(12));
        System.out.println("999: "+ toRoman(999));
    }
}