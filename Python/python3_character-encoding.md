# Strings and Characters
While not strictly a Python topic it's worth covering some basics about how data is recognised by computers.

## ASCII (American Standard Code for Information Interchange)
ASCII is one of the most widely used/recognised character encodings. It includes 256 different characters and each character takes up 8 bits. The first 128 characters are the standard Latin alphabet. Some examples of ASCII below:


|Char|Code|
|---|---|
|(space)|32|
|!|33|
|"|34|
|#|35|
|$|36|
|A|65|
|Z|90|
|a|97|
|z|122|

## I18N (Internationalization)
A `code point` is a number which makes a character. In the ASCII examples above the 32 code point represents a space. The Latin alphabet occupies the first 128 code points of ASCII and the remaining 128 code points are used differently for different languages using a `code page`. A code page is a "standard" for using the remaining 128 code points from ASCII for different languages. For example one code page will assign those 128 code points for Cyrillic, another will assign those code points to Slavic etc.

## Unicode
Unicode assigns unique characters to more than a million code points. The first 128 Unicode code points are identical to ASCII and the first 256 Unicode code points are identical to `ISO/IEC 8859-1` (a code page for Western European languages).

### UCS-4 (Universal Character Set 4)
UCS-4 is an implementation of Unicode which uses 32 bits (four bytes) to store each character.

### UTF-8 (Unicode Transformation Format-8)
UTF-8 is an implementation of Unicode that only uses as many bits for each code point as needed. For example:
 - All Latin characters occupy 8 bits
 - non-Latin characters occupy 16 bits
 - CJK (China, Japan, Korea) ideographs occupy 24 bits

## Additional info:
 - A `BOM` (byte order mark) is special combination of bits anouncing the encoding used by a files content.
 - Python 3 fully supports Unicode and UTF-8, meaning you can use Unicode/UTF-8 characters to name variables etc


```python

```
