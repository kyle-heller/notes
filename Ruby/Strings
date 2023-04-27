“%” notation for ruby literals
Many examples you will come accross in Ruby involve an odd “%” notation when declaring literals. The syntax is basically a % symbol followed by a pair of any type of bracket or other non alphanumeric character, with some contents between the brackets. All five of the following examples;

```
=> %{Hello World}
=> %<Hello World>
=> %(Hello World)
=> %[Hello World]
=> %?Hello World?
```

Will evaluate to the string “Hello World”. While any non alphanumeric character can be used (such as the ? above) you gain more readability using brackets because you can see the opening and closing nature of each bracket. There is one other benefit of using brackets which we’ll come on to in a bit.

Why is this useful? Well, the most obvious benefit is when escaping characters within string literals. The following, for example, would fail due to a syntax error because the string is considered closed when the interpreter encounters the second quote mark;

```
=> puts "Mikey considers inappropriate use of "quotation marks" in sentences to be a crime against hunanity"
```

In order to get that working, you’d need to escape the quotes, like so;

```
=> puts "Mikey considers inappropriate use of \"quotation marks\" in sentences to be a crime against hunanity"
```

The following, however, would work without the need to escape the quotes;

```
=> puts %{Mikey considers inappropriate use of "quotation marks" in sentences to be a crime against hunanity}
```

And just to come back to the second benefit of using brackets instead of other symbols, the following example would fail because the ? inside the literal is not escaped;

```
=> %?Hello?World?      #This fails
=> %?Hello\?World?     #This is fine because the inner ? is escaped
```

However, when using brackets, as long as the internal brackets balance then ruby will escape them for you;

```
=> %<Hello < World>        #This will break because the internal brackets arent' balanced
=> %{Hello {there} World}  #This works just fine!
```

Decorating the %

The % can be decorated with various mneumonics which further assist ruby in evaluating the contents. The tradition with these mneumonics is that they are alphabetic characters, and that when capitalized these pneumonics allow interpolation to occur. For example, the letter q is used for string literals, and Q for string literals that allow interpolation, as seen in this example. If you attempt interpolation without using the correct mneumonic, your interpolation will be escaped;

```
=> num = 2
=> %q{1+1=#{num}}      #evaluates to "1+1=\#{num}"
=> %Q{1+1=#{num}}      #evaluates to "1+1=2"
```

The two i find myself using the most are q and w, which identify strings and arrays respectively as follows;

q string
Q interpolated string
w array of strings
W interpolated array of strings
Just to give one final example of that array notation in action, it’ll basically evaluate the contents to an array of strings using whitespace as a seperator like this;

```
=> %w{This is an array}     #evaluates to ["this", "is", "an", "array"]
```

I have seen and used this notation extensively in requiring libraries. For example, the following;

```
require "rubygems"
require "hpricot"
require "rails"
```

could be re-written more readably like this;

```
%w{rubygems hpricot rails}.each { |lib| require lib }
```
