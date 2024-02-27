# Dates and Times in Java
Java provides classes for working with dates and times in the `java.time` package which you will need to import.

## Date and Time classes
The 3 main classes for working with dates & times in Java 8 are:

Class|Functionality
:--|:--
`LocalDate`|Date only, no time
`LocalTime`|Time only, no date
`LocalDateTime`|Date and Time but no timezone

According to *Oracle recommends avoiding time zones unless you really need them*. If you do really need them the `ZonedDateTime` class handles them.

### `.now()` method
Each of the above classes has a method called `.now()` which returns the current local date/time.


```Java
import java.time.*; // lazily import everything

System.out.println(LocalDate.now()); // outputs date only
System.out.println(LocalTime.now()); // outputs time only
System.out.println(LocalDateTime.now()); // outputs both
```

    2022-01-10
    11:36:59.225
    2022-01-10T11:36:59.226





    null



## Creating Date and Time objects
You cannot instantiate Date and Time objects the way you would for many other classes (i.e. using a constructor like `new LocalDate()` or `new LocalTime()`). Instead you will use each classes respective `.of()` method as follows:
<br>`LocalDate myDate = LocalDate.of(int year, [int month OR Month month], int dayOfMonth);`
<br>`LocalTime myTime = LocalTime.of(int hour, int minutes, int seconds [optional], int nanoseconds [optional]);`
<br>`LocalDateTime myDateTime = LocalDateTime.of(int year, int month/Month month, int dayOfMonth, int hour, int minute, int seconds [optional], int nanoseconds [optional]);`

In the case of *LocalDateTime* you can also pass *LocalDate* and *LocalTime* objects rather than the separate components:
<br>`LocalDateTime myDateTime = LocalDateTime.of(LocalDate date, LocalTime time);`



```Java
import java.time.*;

LocalDate ld = LocalDate.of(2022, Month.JANUARY, 10);
LocalTime lt = LocalTime.of(11, 47, 05);
LocalDateTime ldt = LocalDateTime.of(ld, lt);

System.out.println(ldt.getDayOfWeek());
System.out.println(ldt.getMonth());
System.out.println(ldt.getYear());
System.out.println(ldt.getDayOfYear());
```

    MONDAY
    JANUARY
    2022
    10





    null



## Adjusting Dates and Times
Date and Time objects are immutable like Strings, which means that if we want to change them we need to re-assign the outcome of an operation to a reference variable. There are several methods available for adjusting dates/times:


```Java
import java.time.*;

LocalDate ld = LocalDate.now();
System.out.println(ld);

ld = ld.plusDays(31); // add 31 days
System.out.println(ld);

ld = ld.plusWeeks(2); // add 2 weeks
System.out.println(ld);

ld = ld.plusMonths(3); // add 3 months
System.out.println(ld);

ld = ld.plusYears(4); // add 4 years
System.out.println(ld);

System.out.println(); // empty line

LocalTime lt = LocalTime.now();
System.out.println(lt);

lt = lt.minusHours(2); // reduce by 2 hrs
System.out.println(lt);

lt = lt.minusMinutes(24); // reduce by 24 mins
System.out.println(lt);

lt = lt.minusSeconds(120); // reduce by 120 secs
System.out.println(lt);
```

    2022-01-10
    2022-02-10
    2022-02-24
    2022-05-24
    2026-05-24
    
    13:29:23.239
    11:29:23.239
    11:05:23.239
    11:03:23.239





    null



## The Old Way
Prior to Java 8 date/time objects were instantiated like any other object using the `Date` and `Calendar` classes in the `java.util` package:

Action|Old Way|New Way
:--|:--|:--
import|`import java.util.*;`|`import java.time.*;`
Create time object with current time (no date)|NA|`LocalTime ltime = LocalTime.now();`
Create date object with current date (no time)|NA|`LocalDate ldate = LocalDate.now();`
Create date object with current date and time|`Date d = new Date();`|`LocalDateTime ldt = LocalDateTime.now();`
Create date object with specified date and time|`Calendar c = new GregorianCalendar(2022, Calendar.JANUARY, 10);`|`LocalDate ld = LocalDate.of(2022, Month.JANUARY, 10);`

## Converting to `long`
*LocalDate* has a method for converting into `long` (this is based on the *[UNIX epoch](https://duckduckgo.com/l/?uddg=https%3A%2F%2Fwww.howtogeek.com%2F759337%2Fwhat-is-the-unix-epoch-and-how-does-unix-time-work%2F&notrut=duckduck_in)*):


```Java
import java.time.*;

LocalDate ld = LocalDate.now();
System.out.println("LocalDate is: " + ld);

long ldLong = ld.toEpochDay();
System.out.println("LocalDate long is: " + ldLong);

```

    LocalDate is: 2022-01-10
    LocalDate long is: 19002





    null



## Period class
The `Period` class allows you to create an object representing a particular period of time and also has method of manipulating the period.

__NOTE__: `Period` does NOT allow chaining.


```Java
import java.time.*;

Period annual = Period.ofYears(1); // every year
Period monthly = Period.ofMonths(1); // every month
Period quarterly = Period.ofMonths(3); // every 3 months
Period biAnnual = Period.ofMonths(6); // every 6 months
Period everySecondDay = Period.ofDays(2); // every second day
Period everyYearAndHalf = Period.of(1, 6, 0); // every year and 6 months
Period nowTilChristmas = Period.between(LocalDate.now(), LocalDate.of(2022, 12, 25));
```




    null



## Duration class
The `Duration` class is for smaller units of time:


```Java
import java.time.*;

Duration hours = Duration.ofHours(2);
Duration minutes = Duration.ofMinutes(30);
Duration seconds = Duration.ofSeconds(15);
Duration nanoSeconds = Duration.ofNanos(100);
```




    null



## DateTimeFormatter
The `DateTimeFormatter` class allows you to format any type of date or time object:


```Java
import java.time.*;
import java.time.format.*;

LocalTime lt = LocalTime.now();
LocalDate ld = LocalDate.now();
LocalDateTime ldt = LocalDateTime.now();

DateTimeFormatter shortFormatDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
DateTimeFormatter longFormatDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
DateTimeFormatter custFormatDate = DateTimeFormatter.ofPattern("MM|DD|YY");

DateTimeFormatter medFormatTime = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
DateTimeFormatter custFormatTime = DateTimeFormatter.ofPattern("hh~mm~ss");

System.out.println(ld.format(shortFormatDate)); // short format date
System.out.println(ldt.format(longFormatDate)); // long format date
System.out.println(ldt.format(custFormatDate)); // long format date
System.out.println(lt.format(medFormatTime)); // short format time
System.out.println(lt.format(custFormatTime)); // short format time


```

    1/10/22
    January 10, 2022
    01|10|22
    2:20:47 PM
    02~20~47





    null



## ZonedDateTime
ZonedDateTime is an immutable date-time object which includes a time-zone. The class includes methods which allow you to convert objects from one timezone to another.


```Java
import java.time.*;

ZoneId CET = ZoneId.of("Europe/Paris");
ZoneId BST = ZoneId.of("Europe/London");

ZonedDateTime zdtHere = ZonedDateTime.now();
System.out.println(zdtHere);
ZonedDateTime zdtSweden = zdtHere.toOffsetDateTime().atZoneSameInstant(CET);
System.out.println(zdtSweden);
```

    2022-01-11T15:18:18.369Z[Europe/Dublin]
    2022-01-11T16:18:18.369+01:00[Europe/Paris]





    null



## Method Chart
Below is a chart of some useful date/time methods:

Method|Use|Example
:--|:--|:--
`.now()`|Creates an instance using system clock|`LocalDate myDate = LocalDate.now();`
`.of()`|Creates an instance using the given arguments|`LocalTime lunch = LocalTime.of(13,0);`
`.get()`|Returns part of current state of object|`myDate.get(ChronoField.DAY_OF_WEEK);`
`.with()`|Returns copy of object with one element changed|`myDate.withMonth(12);`
`.plus()`|Returns copy of object with amount added|`myDate.plusDays(14);`
`.minus()`|Returns copy of object with amount deducted|`myDate.minusYears(2);`
`.to()`|Converts object to different type|`LocalDate.now().toSecondOfDay();`
`.at()`|Combines object with another, return LocalDateTime object|`myDate.at(LocalTime.now());`
`.until()`|Calculates amount of time from object until another date|`LocalDate.of(1915,8,12).until(LocalDate.now(), ChronoUnit.YEARS);`
`.isBefore()`|Compares object to argument, returns boolean|`myDate.isBefore(LocalDate.of(1915,8,12));`
`.isAfter()`|Compares object to argument, returns boolean|`myDate.isAfter(LocalDate.of(1915,8,12));`
`.isLeapYear()`|Checks if object is leap year, returns boolean|`myDate.isLeapYear();`


```Java
import java.time.*;
import java.time.temporal.*;

LocalDateTime today = LocalDateTime.now();
System.out.println(today);

System.out.println("\nToday is day " + today.get(ChronoField.DAY_OF_WEEK) + " of the week.");

LocalDateTime nextOct = today.withMonth(10);
System.out.println("\n" + nextOct);

LocalDateTime tomorrow = today.plusDays(1);
System.out.println("\nTomorrow is: " + tomorrow);

LocalDateTime lastYear = today.minusYears(1);
System.out.println("\nThis time last year was " + lastYear);

int secondOfDay = LocalTime.now().toSecondOfDay();
System.out.println("\nRight now is second " + secondOfDay + " of the day.");

System.out.println("\nThis time 4 years ago was " + LocalDate.of(2018, 1, 11).atTime(LocalTime.now()));

System.out.println("\nAugust 12th 1915 was " + LocalDate.of(1915,8,12).until(LocalDate.now(), ChronoUnit.YEARS) + " years ago.");

System.out.println("\nToday is before August 12th 1915? " + LocalDate.now().isBefore(LocalDate.parse("1915-08-12")));

System.out.println("\nToday is after August 12th 1915? " + LocalDate.now().isAfter(LocalDate.of(1915, 8, 12)));

System.out.println("\n1915 was a leap year? " + LocalDate.of(1915, 8, 12).isLeapYear());
```

    2022-01-11T16:14:08.496
    
    Today is day 2 of the week.
    
    2022-10-11T16:14:08.496
    
    Tomorrow is: 2022-01-12T16:14:08.496
    
    This time last year was 2021-01-11T16:14:08.496
    
    Right now is second 58448 of the day.
    
    This time 4 years ago was 2018-01-11T16:14:08.497
    
    August 12th 1915 was 106 years ago.
    
    Today is before August 12th 1915? false
    
    Today is after August 12th 1915? true
    
    1915 was a leap year? false





    null



## Instant
The `Instant` class stores an instant in time and is useful for timestamps. The instant is stored as seconds (`long`) and nanoseconds (`int`) in UTC. Can be paired with `isBefore` and `isAfter` methods to great effect.


```Java
import java.time.*;

Instant now = Instant.now();
System.out.println(now);
Instant noNow = Instant.now();
System.out.println(noNow);

System.out.println(now.isAfter(noNow));
```

    2022-01-11T16:19:25.057Z
    2022-01-11T16:19:25.058Z
    false





    null



## TemporalUnit and ChronoUnit
`TemporalUnit` is an interface which represents a unit of time. It's implemented by the *enum* `ChronoUnit` class.


```Java
import java.time.*;
import static java.time.temporal.ChronoUnit.*;
import static java.time.temporal.TemporalAdjusters.*;

LocalDate today = LocalDate.now();
LocalDate newYearsEve = today.withMonth(12).with(lastDayOfMonth());
long daysTil = DAYS.between(today, newYearsEve);
System.out.println("There are " + daysTil + " days until New Years Eve.");
```

    There are 354 days until New Years Eve.





    null



## Populating  dates in a more readable manner
One of the goals of the updated Date/Time API in Java 8 was to allow for more readable creation of date objects. To that end you can chain methods to create dates in a way that makes the intention more readable to others:


```Java
import java.time.*;

// Shorter but Not readable
LocalDate popsBirthday = LocalDate.of(1915, 8, 12);

// more readable
LocalDate popsBDay = Year.of(1915).atMonth(8).atDay(12);
ZonedDateTime flightLandsLocal = LocalDate.of(2022, 1, 16).atTime(15, 45).atZone(ZoneId.of("Europe/Paris"));
```




    null


