
/**
 * 
Cryptographic hash functions are mathematical operations run on digital data; by comparing the computed hash (i.e., the output produced by executing a hashing algorithm) to a known and expected hash value, a person can determine the data's integrity. For example, computing the hash of a downloaded file and comparing the result to a previously published hash result can show whether the download has been modified or tampered with. In addition, cryptographic hash functions are extremely collision-resistant; in other words, it should be extremely difficult to produce the same hash output from two different input values using a cryptographic hash function.

Secure Hash Algorithm 2 (SHA-2) is a set of cryptographic hash functions designed by the National Security Agency (NSA). It consists of six identical hashing algorithms (i.e., SHA-256, SHA-512, SHA-224, SHA-384, SHA-512/224, SHA-512/256) with a variable digest size. SHA-256 is a -bit ( byte) hashing algorithm which can calculate a hash code for an input of up to  bits. It undergoes  rounds of hashing and calculates a hash code that is a -digit hexadecimal number.

Given a string, , print its SHA-256 hash value.

Input Format

A single alphanumeric string denoting .

Constraints

String  consists of English alphabetic letters (i.e.,  and/or decimal digits (i.e.,  through ) only.
Output Format

Print the SHA-256 encryption value of  on a new line.

Sample Input 0

HelloWorld
Sample Output 0

872e4e50ce9990d8b041330c47c9ddd11bec6b503ae9386a99da8584e9bb12c4
Sample Input 1

Javarmi123
Sample Output 1

f1d5f8d75bb55c777207c251d07d9091dc10fe7d6682db869106aacb4b7df678
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.security.MessageDigest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {

    public static void main(String[] args) {
        try {
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
            String inputLine = bufReader.readLine();
            String regexPattern = "^[a-zA-Z0-9]{6,20}$";
            Pattern allowedPattern = Pattern.compile(regexPattern);
            Matcher matcher = allowedPattern.matcher(inputLine);
            if (matcher.matches()) {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                md.update(inputLine.getBytes());
                byte[] digestData = md.digest();
                StringBuffer sb = new StringBuffer();
                for (byte b : digestData) {
                    sb.append(String.format("%02x", b & 0xff));
                }
                String hashedString = sb.toString();
                System.out.println(hashedString);
            } else {
                System.out.println("Wrong input. Doesn't match the pattern");
                return;
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }


    }
}
