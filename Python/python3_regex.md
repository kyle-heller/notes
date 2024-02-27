# `re` and Regular Expressions
`re` is a built-in Python module for working with regular expressions


```python
import re
```


```python
text = 'I am the very model of a modern major general'
```


```python
pattern = 'model'
```


```python
match = re.search(pattern,text)
```


```python
match.span()
```




    (14, 19)




```python
multi_match = re.findall("mod",text)
```


```python
multi_match
```




    ['mod', 'mod']




```python
for matches in re.finditer("mod",text):
    print(matches.span())
```

    (14, 17)
    (25, 28)


## Regex patterns

|Character|Desc|Example pattern|Example match|
|:--|:--|:--|:--|
|`\d`|Digits|`test_\d\d\d`|'test_123'|
|`\w`|Alphanumeric|`\w\w\w`|'xy4'|
|`\s`|Whitespace|`\s\w\s\w\s\w`|' a b 4'|
|`\D`|Non-digits|`\D\D\s\D`|'QR S'|
|`\W`|Non-alphanumeric|`\W\W\W`|';-)'|
|`\S`|Non-whitespace|`\S\S\S`|'Foo'|


```python
sentence = 'the haunted phone number is 451-666-6665'
```


```python
phone_pattern = re.search(r'\d\d\d-\d\d\d-\d\d\d\d',sentence)
```


```python
phone_pattern
```




    <re.Match object; span=(28, 40), match='451-666-6665'>




```python
phone_pattern.group()
```




    '451-666-6665'



## Regex Pattern Quantifiers

|Character|Desc|Example pattern|Example match|
|:--|:--|:--|:--|
|`+`|One of more|`test_\d+`|'test_123'|
|`{x}`|Exactly x times|`\w{3}`|'xy4'|
|`{x,y}`|Between x and y times|`\d\s{4,7}\d`|'0    8'|
|`{x,}`|x or more times|`\D{3,}`|'QRST'|
|`*`|zero or more times|`ABC*`|'ABB'|
|`?`|once or none|`t?e?st`|'est'|


```python
shorter_ph_pattern = re.search(r'\d{3}-\d{3}-\d{4}',sentence)
```


```python
shorter_ph_pattern
```




    <re.Match object; span=(28, 40), match='451-666-6665'>




```python
grouped_ph_pattern = re.compile(r'(\d{3})-(\d{3})-(\d{4})')
```


```python
new_result = re.search(grouped_ph_pattern, sentence)
```


```python
new_result.group(1)
```




    '451'



### OR
The pipe `|` can be used to search for multiple patterns.


```python
new_sentence = 'I like cats and dogs and snakes and rabbits. I do not like spiders.'
```


```python
re.search(r'dogs|giraffes',new_sentence)
```




    <re.Match object; span=(16, 20), match='dogs'>



### Wildcard
A period `.` can be used to signify any character.


```python
at_sentence = 'Batman and Catwoman were having tea with Gnatman.'
```


```python
re.findall(r'.at',at_sentence)
```




    ['Bat', 'Cat', 'nat']



### Starts with and Ends with
The carat symbol `^` can be used to denote the start of a start of a target. The dollar symbol `$` can be used to denote the end of a pattern.


```python
another_sentence = '1 is the loneliest number that you\'ll ever do'
re.search(r'^1', another_sentence)
```




    <re.Match object; span=(0, 1), match='1'>




```python
another_sentence2 = '2 can be as bad as 1 it\'s the loneliest number since the number 1'
re.search(r'1$',another_sentence2)
```




    <re.Match object; span=(64, 65), match='1'>



### Exclude
Square brackets `[]` can be used to exclude items from a pattern.


```python
new_phrase = 'There are 39 steps'
```


```python
re.findall(f'[^\d]+',new_phrase)
```




    ['There are ', ' steps']




```python
transformative_phrase = 'bah-weep grana-weep ninnibong! bah-weep grana-weep ninnibong?'
```


```python
re.findall(r'[^! ?]+', transformative_phrase) # exclude exclamations, question marks, and spaces
```




    ['bah-weep', 'grana-weep', 'ninnibong', 'bah-weep', 'grana-weep', 'ninnibong']




```python

```
