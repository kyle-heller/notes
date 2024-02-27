# The `calendar` module
The Python standard library provides a module named `calendar` which offers calendar-related functions.

## How days are represented
Similar to the `date` and `time` modules, the `calendar` module represents the days of the week as integers.

Day of the week|Integer value|Constant
:--|:--|:--
Monday|0|calendar.MONDAY
Tuesday|1|calendar.TUESDAY
Wednesday|2|calendar.WEDNESDAY
Thursday|3|calendar.THURSDAY
Friday|4|calendar.FRIDAY
Saturday|5|calendar.SATURDAY
Sunday|6|calendar.SUNDAY

## The `calendar` function
The `calendar` function from within the `calendar` module allows you to display the calendar for the whole year. It functions similar to the `cal` command in Unix but requires you to specify the year.

You can change the default formatting using the following parameters:
- `w`: date column width (default=2)
- `l`: number of lines per week (default=1)
- `c`: number of spaces between month columns (default=6)
- `m`: number of colums (default=3)


```python
import calendar

print(calendar.calendar(2021))
```

                                      2021
    
          January                   February                   March
    Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su
                 1  2  3       1  2  3  4  5  6  7       1  2  3  4  5  6  7
     4  5  6  7  8  9 10       8  9 10 11 12 13 14       8  9 10 11 12 13 14
    11 12 13 14 15 16 17      15 16 17 18 19 20 21      15 16 17 18 19 20 21
    18 19 20 21 22 23 24      22 23 24 25 26 27 28      22 23 24 25 26 27 28
    25 26 27 28 29 30 31                                29 30 31
    
           April                      May                       June
    Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su
              1  2  3  4                      1  2          1  2  3  4  5  6
     5  6  7  8  9 10 11       3  4  5  6  7  8  9       7  8  9 10 11 12 13
    12 13 14 15 16 17 18      10 11 12 13 14 15 16      14 15 16 17 18 19 20
    19 20 21 22 23 24 25      17 18 19 20 21 22 23      21 22 23 24 25 26 27
    26 27 28 29 30            24 25 26 27 28 29 30      28 29 30
                              31
    
            July                     August                  September
    Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su
              1  2  3  4                         1             1  2  3  4  5
     5  6  7  8  9 10 11       2  3  4  5  6  7  8       6  7  8  9 10 11 12
    12 13 14 15 16 17 18       9 10 11 12 13 14 15      13 14 15 16 17 18 19
    19 20 21 22 23 24 25      16 17 18 19 20 21 22      20 21 22 23 24 25 26
    26 27 28 29 30 31         23 24 25 26 27 28 29      27 28 29 30
                              30 31
    
          October                   November                  December
    Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su
                 1  2  3       1  2  3  4  5  6  7             1  2  3  4  5
     4  5  6  7  8  9 10       8  9 10 11 12 13 14       6  7  8  9 10 11 12
    11 12 13 14 15 16 17      15 16 17 18 19 20 21      13 14 15 16 17 18 19
    18 19 20 21 22 23 24      22 23 24 25 26 27 28      20 21 22 23 24 25 26
    25 26 27 28 29 30 31      29 30                     27 28 29 30 31
    


## The `prcal` function
The `prcal` function is very similar to `calendar` (and takes the same arguments) except it doesn't require you to use the `print` function to display it.


```python
import calendar

calendar.prcal(2020)
```

                                      2020
    
          January                   February                   March
    Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su
           1  2  3  4  5                      1  2                         1
     6  7  8  9 10 11 12       3  4  5  6  7  8  9       2  3  4  5  6  7  8
    13 14 15 16 17 18 19      10 11 12 13 14 15 16       9 10 11 12 13 14 15
    20 21 22 23 24 25 26      17 18 19 20 21 22 23      16 17 18 19 20 21 22
    27 28 29 30 31            24 25 26 27 28 29         23 24 25 26 27 28 29
                                                        30 31
    
           April                      May                       June
    Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su
           1  2  3  4  5                   1  2  3       1  2  3  4  5  6  7
     6  7  8  9 10 11 12       4  5  6  7  8  9 10       8  9 10 11 12 13 14
    13 14 15 16 17 18 19      11 12 13 14 15 16 17      15 16 17 18 19 20 21
    20 21 22 23 24 25 26      18 19 20 21 22 23 24      22 23 24 25 26 27 28
    27 28 29 30               25 26 27 28 29 30 31      29 30
    
            July                     August                  September
    Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su
           1  2  3  4  5                      1  2          1  2  3  4  5  6
     6  7  8  9 10 11 12       3  4  5  6  7  8  9       7  8  9 10 11 12 13
    13 14 15 16 17 18 19      10 11 12 13 14 15 16      14 15 16 17 18 19 20
    20 21 22 23 24 25 26      17 18 19 20 21 22 23      21 22 23 24 25 26 27
    27 28 29 30 31            24 25 26 27 28 29 30      28 29 30
                              31
    
          October                   November                  December
    Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su
              1  2  3  4                         1          1  2  3  4  5  6
     5  6  7  8  9 10 11       2  3  4  5  6  7  8       7  8  9 10 11 12 13
    12 13 14 15 16 17 18       9 10 11 12 13 14 15      14 15 16 17 18 19 20
    19 20 21 22 23 24 25      16 17 18 19 20 21 22      21 22 23 24 25 26 27
    26 27 28 29 30 31         23 24 25 26 27 28 29      28 29 30 31
                              30


## The `month` function
Allows you to display the calendar for a specific month. It takes a year and month number e.g. `calendar.month(2020, 12)`.

You can change the default formatting using the following parameters:
- `w`: date column width (default=2)
- `l`: number of lines per week (default=1)

__NOTE__: similar to `calendar` the `month` function has a print-less version called `prmonth`.


```python
import calendar

print(calendar.month(2021,5))
calendar.prmonth(2021,5)
```

          May 2021
    Mo Tu We Th Fr Sa Su
                    1  2
     3  4  5  6  7  8  9
    10 11 12 13 14 15 16
    17 18 19 20 21 22 23
    24 25 26 27 28 29 30
    31
    
          May 2021
    Mo Tu We Th Fr Sa Su
                    1  2
     3  4  5  6  7  8  9
    10 11 12 13 14 15 16
    17 18 19 20 21 22 23
    24 25 26 27 28 29 30
    31


## The `setfirstweekday()` function
As mentioned previously the default first day of the week in the `calendar` module is Monday. However, you can change this using the `setfirstweekday` function. It requires an integer argument expressing the desired day of the week.


```python
import calendar

calendar.setfirstweekday(calendar.TUESDAY)
calendar.prmonth(2021,3)
calendar.setfirstweekday(calendar.THURSDAY)
calendar.prmonth(2021,3)
```

         March 2021
    Tu We Th Fr Sa Su Mo
                       1
     2  3  4  5  6  7  8
     9 10 11 12 13 14 15
    16 17 18 19 20 21 22
    23 24 25 26 27 28 29
    30 31
         March 2021
    Th Fr Sa Su Mo Tu We
                 1  2  3
     4  5  6  7  8  9 10
    11 12 13 14 15 16 17
    18 19 20 21 22 23 24
    25 26 27 28 29 30 31


## The `weekday()` function
Returns the day of the week as an integer value for the given year, month, and day.


```python
import calendar

print(calendar.weekday(2020, 12, 24)) # prints 3, which is Thursday
```

    3


## The `weekheader()` function
Used to adjust the header containing the weekdays in the calendar output.


```python
import calendar

print(calendar.weekheader(2))
```

    Th Fr Sa Su Mo Tu We


## The `isleap()` and `leapdays()` functions
These functions allow you to check whether a given year is a leap year. `isleap` returns `True` if the year passed to it is a leap year. `leapdays` returns the number of leap years in a given range of years.


```python
import calendar

print(calendar.isleap(2021))
print(calendar.leapdays(2000,2021))
```

    False
    6


## Classes for creating calendars
The following are *some* of the classes provided by the `calendar` module.
- `calendar.Calendar`: provides methods to prepare calendar data for formatting
- `calendar.TextCalendar`: is used to create regular text calendars.
- `calendar.HTMLCalendar`: is used to create HTML calendars
- `calendar.LocalTextCalendar`: a subclass of the `calendar.TextCalendar` class. The constructor takes the *locale* parameter, which is used to return the appropriate months and weekday names.
- `calendar.LocalHTMLCalendar`: a subclass of the `calendar.HTMLCalendar` class. The constructor takes the *locale* parameter, which is used to return the appropriate months and weekday names.

## Creating a calendar object
The `Calendar` class constructor takes one optional parameter names `firstweekday` which is equal to 0 (Monday) by default and must be an integer between 0 and 6.

The example below additionally uses the `iterweekdays` method which returns an iterator for the weekday numbers.


```python
import calendar

c = calendar.Calendar(calendar.SUNDAY) # create calendar object with Sunday as the first day of the week

for weekday in c.iterweekdays(): # loop through iterator to print the weekday numbers
    print(weekday, end=" ")
```

    6 0 1 2 3 4 5 

## The `itermonthdates()` method
Another method provided by the `Calendar` class is `itermonthdates` which returns an iterator of all days from the specified month (the method requires a year and month). Each day is represented by a `datetime.date` object.

__NOTE__: in order to keep the weeks returned "complete" the iterator may include days from the prior and following months also (in our example below we see 5 days from April and 6 days from June).


```python
import calendar

c = calendar.Calendar()

for date in c.itermonthdates(2021,5):
    print(date, end=", ")
```

    2021-04-26, 2021-04-27, 2021-04-28, 2021-04-29, 2021-04-30, 2021-05-01, 2021-05-02, 2021-05-03, 2021-05-04, 2021-05-05, 2021-05-06, 2021-05-07, 2021-05-08, 2021-05-09, 2021-05-10, 2021-05-11, 2021-05-12, 2021-05-13, 2021-05-14, 2021-05-15, 2021-05-16, 2021-05-17, 2021-05-18, 2021-05-19, 2021-05-20, 2021-05-21, 2021-05-22, 2021-05-23, 2021-05-24, 2021-05-25, 2021-05-26, 2021-05-27, 2021-05-28, 2021-05-29, 2021-05-30, 2021-05-31, 2021-06-01, 2021-06-02, 2021-06-03, 2021-06-04, 2021-06-05, 2021-06-06, 

## Additional methods from the `Calendar` class
There are four additional methods similar to `itermonthdates` in the `Calendar` class.
- `itermonthdays`: returns an iterator of the days of the week represented by numbers.
- `itermonthdays2`: returns days in the form of tuples consisting of a day of the month number and a weekday number
- `itermonthdays3`: returns days in the form of tuples consisting of a year, a month, and a day of the month number.
- `itermonthdays4`: returns days in the form of tuples consisting of a year, a month, a day of the month number, and a day of the week number.


```python
import calendar

c = calendar.Calendar()

print("Itermonthdays:")
for d in c.itermonthdays(2021, 5):
    print(d, end=", ")

print("\n\nItermonthdays2:")
for d in c.itermonthdays2(2021, 5):
    print(d, end=", ")

print("\n\nItermonthdays3:")    
for d in c.itermonthdays3(2021, 5):
    print(d, end=", ")
    
print("\n\nItermonthdays4")    
for d in c.itermonthdays4(2021, 5):
    print(d, end=", ")
```

    Itermonthdays:
    0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 0, 0, 0, 0, 0, 0, 
    
    Itermonthdays2:
    (0, 0), (0, 1), (0, 2), (0, 3), (0, 4), (1, 5), (2, 6), (3, 0), (4, 1), (5, 2), (6, 3), (7, 4), (8, 5), (9, 6), (10, 0), (11, 1), (12, 2), (13, 3), (14, 4), (15, 5), (16, 6), (17, 0), (18, 1), (19, 2), (20, 3), (21, 4), (22, 5), (23, 6), (24, 0), (25, 1), (26, 2), (27, 3), (28, 4), (29, 5), (30, 6), (31, 0), (0, 1), (0, 2), (0, 3), (0, 4), (0, 5), (0, 6), 
    
    Itermonthdays3:
    (2021, 4, 26), (2021, 4, 27), (2021, 4, 28), (2021, 4, 29), (2021, 4, 30), (2021, 5, 1), (2021, 5, 2), (2021, 5, 3), (2021, 5, 4), (2021, 5, 5), (2021, 5, 6), (2021, 5, 7), (2021, 5, 8), (2021, 5, 9), (2021, 5, 10), (2021, 5, 11), (2021, 5, 12), (2021, 5, 13), (2021, 5, 14), (2021, 5, 15), (2021, 5, 16), (2021, 5, 17), (2021, 5, 18), (2021, 5, 19), (2021, 5, 20), (2021, 5, 21), (2021, 5, 22), (2021, 5, 23), (2021, 5, 24), (2021, 5, 25), (2021, 5, 26), (2021, 5, 27), (2021, 5, 28), (2021, 5, 29), (2021, 5, 30), (2021, 5, 31), (2021, 6, 1), (2021, 6, 2), (2021, 6, 3), (2021, 6, 4), (2021, 6, 5), (2021, 6, 6), 
    
    Itermonthdays4
    (2021, 4, 26, 0), (2021, 4, 27, 1), (2021, 4, 28, 2), (2021, 4, 29, 3), (2021, 4, 30, 4), (2021, 5, 1, 5), (2021, 5, 2, 6), (2021, 5, 3, 0), (2021, 5, 4, 1), (2021, 5, 5, 2), (2021, 5, 6, 3), (2021, 5, 7, 4), (2021, 5, 8, 5), (2021, 5, 9, 6), (2021, 5, 10, 0), (2021, 5, 11, 1), (2021, 5, 12, 2), (2021, 5, 13, 3), (2021, 5, 14, 4), (2021, 5, 15, 5), (2021, 5, 16, 6), (2021, 5, 17, 0), (2021, 5, 18, 1), (2021, 5, 19, 2), (2021, 5, 20, 3), (2021, 5, 21, 4), (2021, 5, 22, 5), (2021, 5, 23, 6), (2021, 5, 24, 0), (2021, 5, 25, 1), (2021, 5, 26, 2), (2021, 5, 27, 3), (2021, 5, 28, 4), (2021, 5, 29, 5), (2021, 5, 30, 6), (2021, 5, 31, 0), (2021, 6, 1, 1), (2021, 6, 2, 2), (2021, 6, 3, 3), (2021, 6, 4, 4), (2021, 6, 5, 5), (2021, 6, 6, 6), 

## The `monthdays2calendar()` method
Another useful method in the `Calendar` class, this takes the year and month, then returns a list of weeks in a the specified month. Each week is a tuple consisting of month day numbers and weekday numbers.


```python
import calendar

c = calendar.Calendar()

for cinfo in c.monthdays2calendar(2021,5):
    print(cinfo)
```

    [(0, 0), (0, 1), (0, 2), (0, 3), (0, 4), (1, 5), (2, 6)]
    [(3, 0), (4, 1), (5, 2), (6, 3), (7, 4), (8, 5), (9, 6)]
    [(10, 0), (11, 1), (12, 2), (13, 3), (14, 4), (15, 5), (16, 6)]
    [(17, 0), (18, 1), (19, 2), (20, 3), (21, 4), (22, 5), (23, 6)]
    [(24, 0), (25, 1), (26, 2), (27, 3), (28, 4), (29, 5), (30, 6)]
    [(31, 0), (0, 1), (0, 2), (0, 3), (0, 4), (0, 5), (0, 6)]



```python

```
