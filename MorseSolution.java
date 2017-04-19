/*

Requirement

Today's challenge is about English.
We want you to write a program that converts Morse code to English text and English text to Morse code. You can choose your favorite programming language to solve the challenge.


As a rule, for every Morse sentence, we should consider a space between morse letters, and three spaces between morse words (" " => "   ") (also two spaces in english are equivalent to six spaces in morse ).


If the morse code that is going to be translated is not valid or the spacing is not correct, you should ouput 'Invalid Morse Code Or Spacing'


INPUT
boolean     morseToEnglish
^^ true if the given input text is in morse and false if it is in english


string         textToTranslate
^^ a string containing the text we wish to translate


OUTPUT
string translatedText
^^ a string containing the input text, translated


EXAMPLE
Input
false,"The wizard quickly jinxed the gnomes before they vaporized."


Output
- .... .   .-- .. --.. .- .-. -..   --.- ..- .. -.-. -.- .-.. -.--   .--- .. -. -..- . -..   - .... .   --. -. --- -- . ...   -... . ..-. --- .-. .   - .... . -.--   ...- .- .--. --- .-. .. --.. . -.. .-.-.-


CONSTRAINTS
0 < nrCharacters <= 100 000
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MorseSolution {

    static char [] English = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };

    static String [] Morse = { ".-" , "-..." , "-.-." , "-.." , "." , "..-." , "--." , "...." , ".." , ".---" , "-.-" , ".-.." , "--" , "-." , "---" , ".--." , "--.-" ,  ".-." , "..." , "-" , "..-" , "...-" , ".--" , "-..-" , "-.--" , "--.." , "|" };
      

    public static void main(String[] args) throws Exception {
        BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = bufReader.readLine();
        String[] inputArray = inputLine.split(",");
        boolean m2E = new Boolean(inputArray[0]);
        String toconvertString = inputArray[1];
        if(toconvertString.length()>100000) {
            System.out.println("String too long");
            return;
            
        }
        StringBuffer sb = new StringBuffer();
        if (m2E) {
           
            String[] morseWords = toconvertString.split(" ");
            for (String word : morseWords) {
                String[] characters = word.split(" "); //split the morse text by space
                for (String character : characters) {
                    if (character.isEmpty()) {
                        sb.append(" ");
                        continue;
                    }
                    boolean englishCodeFound = false;
                    for (int i = 0; i < Morse.length; i++) {
                        if (character.equals(Morse[i])) {
                            sb.append(English[i]);
                            englishCodeFound = true;
                        }

                    }
                    if (!englishCodeFound) {
                        sb.append(character);
                    }
                }
            }
            
        } else {
            toconvertString = toconvertString.toLowerCase();
            for (int j = 0; j < toconvertString.length(); j++) {
                boolean morseCodeFound = false;
                System.out.println(Morse.length);
                for (int i = 0; i < English.length; i++) {
                    if (English[i] == toconvertString.charAt(j)) {
                        morseCodeFound = true;
                        System.out.println("*"+i+"*");
                        sb.append(Morse[i] + "");
                    }
                }
                if (!morseCodeFound) {
                    sb.append(toconvertString.charAt(j)+" ");
                }
                else {
                    sb.append(" ");
                }
            }
        }
        System.out.println(sb.toString());

    }


}
