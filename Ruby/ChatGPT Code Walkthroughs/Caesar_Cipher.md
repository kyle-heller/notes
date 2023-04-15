# Caesar Cipher Examples and Walkthroughs

## Example 1

```
# frozen_string_literal: true

class CaesarCipher
  def translate(message, shift, result = '')
    message.each_char do |char|
      base = char.ord < 91 ? 65 : 97
      # Modifies Lowercase & Uppercase
      if char.ord.between?(65, 90) || char.ord.between?(97, 122)
        rotation = (((char.ord - base) + shift) % 26) + base
        result += rotation.chr
      # Keeps spaces & punctuation
      else
        result += char
      end
    end
    result
  end
end
```

This code defines a class called CaesarCipher that has one instance method called translate. The method takes three arguments: message, shift, and result, which is set to an empty string by default.

The first line of the code (# frozen_string_literal: true) is a special directive for Ruby that prevents the use of undefined variables as string literals, which can help prevent errors.

The translate method takes in a message string, a shift integer, and a result string that is initially set to an empty string.

The message string is looped over one character at a time using each_char method.

The base variable is set to either 65 or 97, which correspond to the ASCII codes for 'A' and 'a' respectively. This is used later to determine if the character is uppercase or lowercase.

The if statement checks if the current character is a letter between 'A' and 'Z' or between 'a' and 'z'. If it is, the letter is rotated by the shift amount by subtracting the appropriate ASCII code (base), applying the shift using the modulo operator (%) which is needed to work with shifts greater than 26, adding the appropriate ASCII code back (base), and then converting it back to a character using chr method. The rotated character is then added to the result string.

If the current character is not a letter between 'A' and 'Z' or between 'a' and 'z', then it is not rotated and is simply added to the result string.

The result string is returned after all characters in message have been processed.

In summary, this code defines a CaesarCipher class with a translate method that takes in a message string and shifts each letter in the message by a certain amount, determined by the shift argument. The method ignores any characters that are not letters and preserves the case of the letters. Finally, the method returns the translated message as a string.

**Does the last code work for shifts greater than 26?**

Yes, this code works for shifts greater than 26.

The code handles shifts greater than 26 by taking the modulo of the shift factor with 26. This ensures that the shift factor remains within the range of 0 to 25.

The line rotation = (((char.ord - base) + shift) % 26) + base calculates the ASCII value of the shifted character. The char.ord - base expression calculates the index of the character within the range of alphabetic characters (0 to 25), and (char.ord - base + shift) % 26 applies the shift factor to the index and wraps around to the beginning of the alphabet if it goes beyond 'Z' (uppercase) or 'z' (lowercase). Finally, the + base expression converts the index back to the ASCII value of the shifted character.

Since the shift factor is taken modulo 26, it doesn't matter whether the shift factor is greater than 26 or not, as it will always be reduced to a value within the range of 0 to 25.

## Example 2

```
def caesar_cipher(text, shift)
  for i in 0...text.length do
    char_code = text[i].ord

    (a, z) = case char_code
             when 97..122 then [97, 122]   # a-z
             when 65..90  then [65, 90]    # A-Z
             else next
    end

    rotate = shift > 0 ? 26 : -26

    char_code += shift
    char_code -= rotate unless char_code.between?(a, z)

    text[i] = char_code.chr
  end
end

message = "Omae wa mou shindeiru. -NANI!?!!"

caesar_cipher(message, 21)

puts message
```

This code defines a method called caesar_cipher which takes two arguments, a string text and an integer shift.

1. The for loop iterates over each character in the text string using the range 0...text.length, where 0...text.length creates a range that goes from 0 up to, but not including, the length of the text string.

2. The char_code variable is assigned the integer value of the ASCII code of the current character in the text string using the ord method.

3. The case statement checks whether the char_code is between the ASCII codes of lowercase letters (97 for 'a' to 122 for 'z') or uppercase letters (65 for 'A' to 90 for 'Z'). If it is, then the a and z variables are assigned the appropriate ASCII codes for the corresponding range. If the char_code is not between 97 and 122 or between 65 and 90, then the next statement is used to skip to the next iteration of the loop.

4. The rotate variable is set to either 26 or -26 depending on whether shift is positive or negative. This will be used later to wrap around the alphabet when shifting a character by more than 26.

5. The char_code variable is then modified by adding shift. This will shift the character by the number of positions specified in the shift argument.

6. If the new char_code is not between the range defined by a and z, then the rotate value is subtracted from it to wrap around the alphabet.

7. Finally, the text[i] character is reassigned to the new character with the shifted ASCII code using the chr method.

8. After the loop has iterated over each character in the text string, the modified text string is implicitly returned by the method.

9. The message string is assigned a value of "Omae wa mou shindeiru. -NANI!?!!".

10. The caesar_cipher method is called on message with a shift value of 21, which will shift each letter in message by 21 positions.

11. The modified message string is printed to the console using the puts method, which outputs the string followed by a newline character.

**Does the last code work for shifts greater than 26?**

The last code will work for shifts greater than 26 but it will produce incorrect results.

When shift is greater than 26, the following line sets the rotate variable to 26:

bash
Copy code
rotate = shift > 0 ? 26 : -26
Then, the code subtracts rotate from char_code if char_code is not between a and z or A and Z. However, if shift is greater than 26, then the value of rotate will not be enough to wrap the character around the alphabet multiple times. For example, if shift is 30, then the character 'A' should be shifted to 'E', but the code will only wrap it around the alphabet once and produce the incorrect result of '['.

To handle shifts greater than 26 correctly, the rotate variable should be set to the remainder of shift divided by 26. This will ensure that the character is wrapped around the alphabet the correct number of times.

## Example 3

```
def caesar_cipher(string,shift_factor)

    # Split string into character array, get ascii value for each character
    # 65 - 90 for A-B
    # 97 - 122 for a-b
    asciis = string.split("").map { |e| e.ord }

    shifted = asciis.map do |ascii|
        # check if character is alphabetic, yes - do shift , no - no shift
        if ascii.between?(65,90)
            # logic for wrap around
            if shift_factor.positive?
                ascii + shift_factor > 90 ? (ascii + shift_factor) - 26 : ascii + shift_factor
            else
                ascii + shift_factor < 65 ? (ascii + shift_factor) + 26 : ascii + shift_factor
            end
        elsif ascii.between?(97,122)
            if shift_factor.positive?
                ascii + shift_factor > 122 ? (ascii + shift_factor) - 26 : ascii + shift_factor
            else
                ascii + shift_factor < 97 ? (ascii + shift_factor) + 26 : ascii + shift_factor
            end
        else
            ascii
        end
    end

    shifted_string = shifted.map! { |a| a.chr }.join
    p shifted_string
end

print "Enter the string to encode : "
string = gets.chomp

print "Enter the shift factor for the string : "
shift_factor = gets.chomp.to_i

caesar_cipher(string,shift_factor)
```

The caesar_cipher method takes two arguments, a string and a shift_factor. The shift_factor is the number of characters that each character in the string should be shifted by.

asciis = string.split("").map { |e| e.ord }
This line splits the string into an array of individual characters and then maps each character to its ASCII code using the ord method. The resulting asciis array contains the ASCII codes for each character in the string.

shifted = asciis.map do |ascii|
This line begins a new block that maps each ASCII code in the asciis array to a new ASCII code, based on the shift_factor.

if ascii.between?(65,90)
This line checks if the ASCII code belongs to the uppercase letters 'A' to 'Z'.

if shift_factor.positive?
This line checks if the shift_factor is positive. If it is, the ASCII code is shifted to the right (i.e. forward in the alphabet).

ascii + shift_factor > 90 ? (ascii + shift_factor) - 26 : ascii + shift_factor
This line calculates the new ASCII code for an uppercase letter that is being shifted to the right. If the new ASCII code is greater than 90 (the ASCII code for 'Z'), the formula (ascii + shift_factor) - 26 is used to wrap the letter around to the beginning of the alphabet. Otherwise, the formula ascii + shift_factor is used to shift the letter to the right without wrapping it around.

elsif ascii.between?(97,122)
This line checks if the ASCII code belongs to the lowercase letters 'a' to 'z'. If it does, the code block starting from line 4 is executed, but with the appropriate changes for lowercase letters.

else
This line checks if the ASCII code is not an uppercase or lowercase letter. If it is not, the original ASCII code is used without any shift.

shifted_string = shifted.map! { |a| a.chr }.join
This line maps each ASCII code in the shifted array to its corresponding character using the chr method, and then joins all the resulting characters together into a new string.

p shifted_string
This line prints the resulting shifted_string to the console.

The last three lines of the code prompt the user for input of the string and the shift_factor, and then call the caesar_cipher method with these inputs.

**Does the last code work for shifts greater than 26?**

Yes, the code works for shifts greater than 26.

The code handles shifts greater than 26 by wrapping around the alphabet if the shifted character goes beyond 'Z' (uppercase) or 'z' (lowercase) or goes below 'A' (uppercase) or 'a' (lowercase).

This is achieved by checking if the shift factor is positive or negative and applying appropriate logic to get the shifted ASCII value of the character. If the shifted ASCII value goes beyond the range of alphabetic characters, the code subtracts or adds 26 to wrap around to the beginning or end of the alphabet.

## Example 4

ALPHABETS = %w{abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ 0123456789}

```
def caesar(string, rotate)
  ALPHABETS.each do
    |alphabet|
    rotated_alphabet = alphabet[rotate % alphabet.length..] +
    alphabet[...rotate % alphabet.length]
    string.tr!(alphabet, rotated_alphabet)
  end
  puts string
ends
```

The tr! method is a built-in Ruby method that stands for "translate". It's called on a string and takes two arguments: the first argument specifies the characters to be replaced, and the second argument specifies the corresponding replacement characters.

This method performs a character-by-character translation of the string, replacing any characters that match the first argument with the corresponding character from the second argument. It returns a modified copy of the original string with all the replacements made.

The ! at the end of the method name indicates that it modifies the string in place, rather than returning a new copy of the string. This means that the original string is modified directly by the method, without creating a new string object. If no replacements are made, the method returns nil.

**Does the last code work for shifts greater than 26?**

Yes, the last code should work for shifts greater than 26.

The rotate % alphabet.length part of the code takes the remainder of rotate divided by the length of the alphabet, which ensures that the rotation amount is always within the length of the alphabet. This means that even for shift values greater than 26, the code will correctly perform the rotation and replace the characters in the input string.

For example, if rotate is 30, then rotate % alphabet.length would be 4, and the rotation would be performed by shifting the alphabet four positions to the left. The resulting rotated_alphabet would be "efghijklmnopqrstuvwxyzabcd XYZABCDEFGHIJKLMNOPQRSTUVW 6789012345", which correctly includes the original alphabets and numbers but with the characters shifted by 4 positions.
