```python
import pdb
```


```python
x = [1,2,3]
y = 2
z = 3


result_one = y + z
pdb.set_trace() """effectively pauses the script at this point and 
                    allows you to run ad hoc operations on the variables to troubleshoot"""
result_two = y + x
```

    --Return--
    None
    > [0;32m<ipython-input-6-8bf5d3b49e1d>[0m(7)[0;36m<module>[0;34m()[0m
    [0;32m      4 [0;31m[0;34m[0m[0m
    [0m[0;32m      5 [0;31m[0;34m[0m[0m
    [0m[0;32m      6 [0;31m[0mresult_one[0m [0;34m=[0m [0my[0m [0;34m+[0m [0mz[0m[0;34m[0m[0;34m[0m[0m
    [0m[0;32m----> 7 [0;31m[0mpdb[0m[0;34m.[0m[0mset_trace[0m[0;34m([0m[0;34m)[0m [0;31m# effectively pauses the script at this point and run ad hoc operations on the variables at that point to troubleshoot[0m[0;34m[0m[0;34m[0m[0m
    [0m[0;32m      8 [0;31m[0mresult_two[0m [0;34m=[0m [0my[0m [0;34m+[0m [0mx[0m[0;34m[0m[0;34m[0m[0m
    [0m
    ipdb> 
    ipdb> 
    ipdb> 
    ipdb> 
    ipdb> 
    ipdb> 
    ipdb> 
    ipdb> q



    ---------------------------------------------------------------------------

    BdbQuit                                   Traceback (most recent call last)

    <ipython-input-6-8bf5d3b49e1d> in <module>
          5 
          6 result_one = y + z
    ----> 7 pdb.set_trace() # effectively pauses the script at this point and run ad hoc operations on the variables at that point to troubleshoot
          8 result_two = y + x


    /usr/lib/python3.9/bdb.py in trace_dispatch(self, frame, event, arg)
         90             return self.dispatch_call(frame, arg)
         91         if event == 'return':
    ---> 92             return self.dispatch_return(frame, arg)
         93         if event == 'exception':
         94             return self.dispatch_exception(frame, arg)


    /usr/lib/python3.9/bdb.py in dispatch_return(self, frame, arg)
        152             finally:
        153                 self.frame_returning = None
    --> 154             if self.quitting: raise BdbQuit
        155             # The user issued a 'next' or 'until' command.
        156             if self.stopframe is frame and self.stoplineno != -1:


    BdbQuit: 



```python

```
