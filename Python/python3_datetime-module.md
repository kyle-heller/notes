# The `datetime` module
Python's `datetime` module provides classes for working with date and time. Some examples for use are:
- __event loggin__: to trakc when exactly a particular error occurred.
- __tracking changes in a databse__: storing when a particular change was made.
- __data validation__: for example validating that a coupon is still valid
- __storing important information__: for example a bank storing when a transfer was made.

## Getting the current local dat and creating date objects
The `date` class from the `datetime` module allows the creation of dat objects which consist of the year, month, and day. These objects have method called `today` which returns the current local date. The date object returned by the `today` method has three read-only attributes: year, month, day.

When creating date objects keep the following restrictions in mind:

Parameter|Restriction
:--|:--
year|must be greater than or equal to 1 (MINYEAR constant) and less than or equal to 9999 (MAXYEAR constant).
month|must be greater than or equal to 1 and less than or equal to 12.
day|must be greater than or equal to 1 and less than or equal to the last day of the given month and year.


```python
from datetime import date

my_date = date(1984,2,21)
print(my_date)
```

    1984-02-21


## Creating a date object from a timestamp
The `date` class includes a method for creating a date object from a timestamp name `fromtimestamp()`.

NOTE: the result of the time function used in the example below may vary depending on the platform in use.


```python
from datetime import date
import time

timestamp = time.time() # create a timestamp to use
print("Timestamp:",timestamp)

d = date.fromtimestamp(timestamp)
print("Date:",d)
```

    Timestamp: 1620645328.4523773
    Date: 2021-05-10


## Creating a date object using the ISO format
A similar method to the above but for creating a date object using the ISO 8601 standard compliant format of __YYYY-MM-DD__ is `fromisoformat()`.


```python
from datetime import date

d = date.fromisoformat("1999-12-31")
print(d)
```

    1999-12-31


## The `replace()` method
Since the year, month, and day attributes are read-only, you can't directly change them. To do so you will need to use the `replace()` method.

__NOTE__: since the replace method returns a changed date object you must remember to assign it if you want to keep the change.


```python
d = d.replace(year=1997,month=3,day=23)
print(d)
```

    1997-03-23


## Working with days of the week
### The `weekday` method
Returns the day of the week as an integer value between 0 (Monday) and 6 (Sunday).

### The `isoweekday` method
Returns the day of the week as an ISO 85601 compliant integer value between 1 (Monday) and 7 (Sunday).


```python
from datetime import date

d = date(2018,5,26)
print(d.weekday())
print(d.isoweekday())
```

    5
    6


## Creating time objects using the datetime module
The `datetime` module provides a similar class to `date` but for creating time objects, it's the `time` class.

The time class constructor takes the following optional parameters:

Parameter|Restriction
:--|:--
hour|must be greater than or equal to 0 and less than or equal to 23
minute|must be greater than or equal to 0 and less than or equal to 59
second|must be greater than or equal to 0 and less than or equal to 59
microsecond|must be greater than or equal to 0 and less than or equal to 1,000,000
tzinfo|must be a `tzinfo` subclass or object or `None` (default)
fold|must 0 (default) or 1

- *tzinfo* is associated with timeszones
- *fold* is associated with wall times


```python
from datetime import time

t = time(13, 52, 20, 1)

print("Time:", t)
print("Hour:", t.hour)
print("Minute:", t.minute)
print("Second:", t.second)
print("Microsecond:", t.microsecond)
```

    Time: 13:52:20.000001
    Hour: 13
    Minute: 52
    Second: 20
    Microsecond: 1


## Creating `datetime` objects
In the `datetime` module, date and time can be represented as separate objects or as one. The class that combines date and time is called `datetime`.

Its constructor accepts the following parameters:

Parameter| Restrictions
:--|:--
year|must be >= 1 (MINYEAR constant) and <= 9999 (MAXYEAR constant)
month|must be >= 1 and <= 12
day|must be >= 1 and <= the last day of the given month & year
hour|must be >=0 and <=23
minute|must be >=0 and <=59
second|must be >=0 and <=59
microsecond|must be >=0 and <=1,000,000
tzinfo|must be a `tzinfo` subclass object or `None` (default)
fold|must be 0 (default) or 1


```python
from datetime import datetime

dtime = datetime(2019, 11, 4, 14, 53)

print("Datetime:", dtime)
print("Date:",dtime.date()) # date method returns date object with given year
print("Time:", dtime.time()) # time method returns time object with given hour and minute
```

    Datetime: 2019-11-04 14:53:00
    Date: 2019-11-04
    Time: 14:53:00


## Methods that return the current date and time
The datetime class has several methods that return the current date and time.
- `today()`: returns the current local date and time with the tzinfo attribute set to `None`
- `now()`: returns the current local date and time the same as today method, unless we pass options argument `tz` to it. The argument of this method must be an object of the `tzinfo` subclass.
- `utcnow()`: returns the current UTC date and time with the `tzinfo` attribute set to `None`


```python
from datetime import datetime

print("Today:", datetime.today())
print("Now:", datetime.now())
print("UTC Now:", datetime.utcnow())
```

    Today: 2021-05-10 17:11:33.951767
    Now: 2021-05-10 17:11:33.952005
    UTC Now: 2021-05-10 16:11:33.952101


## Getting a timestamp
The `timestamp` method provided by the `datetime` class allows us to generate a timestamp based on a given date and time.

__NOTE__: the `timestamp` method returns a float value expressing the number of seconds elapsed between the *Unix epoch* and the provided date & time.


```python
from datetime import datetime

dt = datetime(2021,5,10,17,13)
print("Timestamp:", dt.timestamp())
```

    Timestamp: 1620663180.0


## Date and time formatting
All `datetime` module classes presented so far have a method called `strftime` that allows us to return the date & time in a specified format. `strftime` takes only one argument inthe form of a string specifying the format using *directives*.

A *directive* is a string consisting of the percent `%` character and a lowercase or uppercase letter. For example `%Y` means the year with the century as a decimal number such as *1991*.

Directive|Meaning|Example
:--|:--|:--
`%a`|Weekday as locale's abbreviated name|Sun, Mon, Tue...
`%A`|Weekday as locale's full name|Sunday, Monday...
`%w`|Weekday as a decimal number where 0 is Sunday and 6 is Saturday|0, 1, ..., 6
`%d`|Day of the month as a zero-padded decimal number| 01, 02, ..., 31
`%b`|Month as locale's abbreviated name|Jan, Feb, Mar...
`%B`|Month as locale's full name|January, February...
`%m`|Month as a zero-padded decimal|01, 02, ..., 12
`%y`|Year withou century as zero-padded decimal|01, 84, 98, 21
`%Y`|Year with century as decimal|1980, 2021
`%H`|Hour (24-hr format) as a zero-padded decimal|00, 13, 23
`%I`|Hour (12-hr format) as a zero-padded decimal|01, 3, 12
`%p`|Locale's equivalent of either AM or PM|AM, PM, am, pm
`%M`|Minute as a zero-padded decimal|00, 15, 35, 59
`%S`|Second as a zero-padded decimal|00, 15, 35, 59
`%f`|Microsecond as a decimal, zero-padded on left|000000, 000001, 999999
`%z`|UTX offset in the form `+HHMM[SS[.ffffff]]`|(empty), +0000,-0400
`%Z`|Time zone name (empty if object is naive)|(empty), UTC, GMT
`%j`|Day of the year as a zero-padded decimal|001, 039, 366
`%U`|Week number of the year (Sunday as first day of week) as zero-padded decimal|00, 03, 53
`%W`|Week number of the year (Monday as first day of week) as zero-padded decimal|00, 03, 53
`%c`|Locale's appropriate date and time representation|Tue Aug 16 21:30:00 1988
`%x`|Locale's appropriate date representation|08/16/88, 08/16/1988, 16.08.1988
`%X`|Locale's appropriate time representation|21:30:00
`%%`|A literal `%` character


```python
from datetime import date
from datetime import time

d = date(1991,2,8)
print(d.strftime("%Y/%m/%d"))

t = time(17,49)
print(t.strftime("%H:%M:%S"))
```

    1991/02/08
    17:49:00


## The `strptime()` method
The `strptime` method creates a `datetime` object from a string representing the date and time but requires that you specify the format in which the date & time is saved. If the format you specify doesn't match that of the given string, a `ValueError` will be raised.


```python
from datetime import datetime

print(datetime.strptime("2019/11/04 14:53:00", "%Y/%m/%d %H:%M:%S"))
```

    2019-11-04 14:53:00


## Date and time operations
There's a class called `timedelta` in the `datetime` module that allows you to perform calculations on date and time. To create a `timedelta` object, simply do a subtraction on the `date` or `datetime` objects.


```python
from datetime import date
from datetime import datetime

d1 = date(2020, 11, 4)
d2 = date(2019, 11, 4)

timed = d1 - d2
print(timed.days, timed.total_seconds())

dt1 = datetime(2020, 11, 4, 0, 0, 0)
dt2 = datetime(2019, 11, 4, 14, 53, 0)

print(dt1 - dt2)

delta2 = timed * 2
print(delta2)
```

    366 31622400.0
    365 days, 9:07:00
    732 days, 0:00:00


You can also create a `timedelta` using the `timedelta` class.


```python
from datetime import timedelta

delta = timedelta(weeks=3, days=4, hours=2)
print(delta)
print("Days:",delta.days)
print("Seconds:",delta.seconds)
print("Microseconds:",delta.microseconds)
```

    25 days, 2:00:00
    Days: 25
    Seconds: 7200
    Microseconds: 0



```python

```
