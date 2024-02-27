# Datetime


```python
import datetime
```


```python
mytime = datetime.time(15,18)
```


```python
mytime.minute
```




    18




```python
mytime.hour
```




    15




```python
print(mytime)
```

    15:18:00



```python
today = datetime.date.today()
```


```python
print(today)
```

    2021-02-06



```python
today.ctime()
```




    'Sat Feb  6 00:00:00 2021'




```python
from datetime import datetime, date
```


```python
date1 = date(2021,4,2)
date2 = date(2021,5,2)
```


```python
date_diff = date1 - date2
```


```python
print(date_diff)
```

    -30 days, 0:00:00



```python
datetime1 = datetime(2021,2,4,15,0)
datetime2 = datetime(2021,2,8,12,34)
```


```python
date_diff = datetime1 - datetime2#
```


```python
print(date_diff)
```

    -4 days, 2:26:00



```python
date_diff.total_seconds()
```




    -336840.0




```python

```
