# The `time` module
Python's `time` module is similar to the `datetime` module except it provides time-related functions. 

## The `sleep()` function
The `sleep` function suspends program execution for the given number of seconds (it accepts int or float numbers only).


```python
import time

class Developer:
    def power_nap(self, seconds):
        print(f"I'm gonna take a {seconds} second break from coding.")
        time.sleep(seconds)
        print("Ok, I'm back.")
        
jimbo = Developer()
jimbo.power_nap(5)
```

    I'm gonna take a 5 second break from coding.
    Ok, I'm back.


## The `ctime()` function
The `ctime()` function converts a time (expressed as the number of seconds passed since Jan 1st 1970, aka the *Unix epoch*) to a string. If you don't pass any arguments the function will return the current time.


```python
import time

stamp = time.time()
time.ctime(stamp)
```




    'Mon May 10 16:00:10 2021'



## The `struct_time` class and  `gmtime()` & `localtime()` functions
Some of the functions in the `time` module require knowledge of the *struct_time* class, lets take a look at that class:

`time.struct_time:
    tm_year # specifies the year
    tm_mon # specifies the month (1 to 12)
    tm_mday # specifies the day of the month (1 to 31)
    tm_hour # specifies the hour (0 to 23)
    tm_min # specifies the minute (0 to 59)
    tm_sec # specifies the second (0 to 59)
    tm_wday # specifies the weekday (0 to 6)
    tm_yday # specifies the year day (1 to 366);
    tm_isdst # specifies whether daylight saving time applies (1=yes, 0=no)
    tm_zone # specifies the timezone name (value in an abbreviated format)
    tm_gmtoff # specifies the offset east of UTC (value in seconds)`
    
The `struct_time` class also allows access to values using indexes i.e. index `0` returns the value in `tm_year`, `1` the value in `tm_mon` etc. The exceptions are `tm_zone` and `tm_gmtoff` which cannot be accessed using indexes.


```python
import time

tstamp = time.time()
print(time.gmtime(tstamp))
print(time.localtime(tstamp))
```

    time.struct_time(tm_year=2021, tm_mon=5, tm_mday=10, tm_hour=15, tm_min=10, tm_sec=32, tm_wday=0, tm_yday=130, tm_isdst=0)
    time.struct_time(tm_year=2021, tm_mon=5, tm_mday=10, tm_hour=16, tm_min=10, tm_sec=32, tm_wday=0, tm_yday=130, tm_isdst=0)


## The `asctime()` and `mktime()` functions
The `time` module has finctions that expect a *struct_time* object or a tuple that stores values according to the indexes presented when discussing the *struct_time* class.

- `asctime()` converts a struct_time object (or tuple) to a string.
- `mktime()` converts a struct_time object (or tuple) to a the number of seconds since the Unix epoch.


```python
import time

timestamp = time.time()
st = time.gmtime(timestamp)

print(time.asctime(st))
print(time.mktime((2019,11,4,14,53,0,0,308,0)))
```

    Mon May 10 15:15:56 2021
    1572875580.0


## The `strftime()` function
The `strftime` function in the `time` module differs slightly from the function of the same name available in the `datetime` module in that, in addition to the format argument it can also take (optionally) a tuple or struct_time object. If you don't pass either, formatting will be done using the current local time.


```python
import time

timestamp = time.time()
st = time.gmtime(timestamp)

print(time.strftime("%Y/%m/%d %H:%M:%S", st))
print(time.strftime("%Y/%m/%d %H:%M:%S"))
```

    2021/05/10 16:44:37
    2021/05/10 17:44:37



```python

```
