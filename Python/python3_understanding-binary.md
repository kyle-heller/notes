# Understanding Binary Numbers
The following info is derived from [this excellent explainer](http://www.steves-internet-guide.com/binary-numbers-explained/).

## Decimals aka Base-10
Before tackling binary it's helpful to first remind ourselves of how the decimal system works. Decimal uses `10` as the base and the numbers range from `0` to `9`. Let's take the number `129` (*one-hundred-and-twenty-nine*) as an example:

Hundres|Tens|Ones
:--|:--|:--
`1`|`2`|`9`

We've divided the number across columns representing each unit type the number represents:
- `1` hundreds
- `2` tens
- `9` ones

We could also represent the units with exponents/powers:

$10^2$|$10^1$|$10^0$
:--|:--|:--
`1`|`2`|`9`

If we need to cover larger numbers then we simply add further columns each of which represents a higher exponent of 10:

$10^4$|$10^3$|$10^2$|$10^1$|$10^0$
:--|:--|:--|:--|:--
ten-thousands|thousands|Hundreds|Tens|Ones
`10,000`|`1000`|`100`|`10`|`1`


## Binary numbers
The binary system is base-2 and has only two values: `0` and `1`. So, using the same column method as we did above for decimals, we just need to replace `10` as the base for exponentiation with `2`:

Fours|Twos|Ones
:--|:--|:--
$2^2$|$2^1$|$2^0$

As the size of a binary number increases we simply need to increase our columns to the left with further exponents of 2:

Thirty-Twos|Sixteens|Eights|Fours|Twos|Ones
:--|:--|:--|:--|:--|:--
$2^5$|$2^4$|$2^3$|$2^2$|$2^1$|$2^0$

## Let's convert some binary to decimal

Take `110100`:

Thirty-Twos|Sixteens|Eights|Fours|Twos|Ones
:--|:--|:--|:--|:--|:--
`1`|`1`|`0`|`1`|`0`|`0`

In other words:
- `1` thirty-twos
- `1` sixteens
- `0` eights
- `1` fours
- `0` twos
- `0` ones

So, `32`+`16`+`4` = `52`

## What about converting from decimal to binary?
The method we're going to use here is to find the largest power of two we can subtract from the number in question, then repeat for the remainder until we reach `0`.

One-Hundred-Twenty-Eights|Sixty-Fours|Thirty-Twos|Sixteens|Eights|Fours|Twos|Ones
:--|:--|:--|:--|:--|:--|:--|:--
$2^7$|$2^6$|$2^5$|$2^4$|$2^3$|$2^2$|$2^1$|$2^0$


Let's convert the number `48`:
- The largest power we can deduct is `32`:
    <br>`48-32=16`
- The largest power we can deduct from the remainder of `16` is `16`:
    <br>`16-16=0`
- So, we have 1x`32` and 1x`16`

Thirty-Twos|Sixteens|Eights|Fours|Twos|Ones
:--|:--|:--|:--|:--|:--
`1`|`1`|`0`|`0`|`0`|`0`

## Binary, bits, and bytes
In computers and coding 8-bit numbers are common. An 8-bit number is known as an __octet__ and also more commonly as a __byte__.

An 8-bit binary number can represent a maximum of `255` which in binary is `11111111`:

One-Hundred-Twenty-Eights|Sixty-Fours|Thirty-Twos|Sixteens|Eights|Fours|Twos|Ones
:--|:--|:--|:--|:--|:--|:--|:--
`1`|`1`|`1`|`1`|`1`|`1`|`1`|`1`


```python

```
