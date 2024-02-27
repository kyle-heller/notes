# Creating a hierarchy of classes

## Polymorphism
Polymorphism in the context of Python classes & objects is __a subclass' ability to modify the behaviour of its superclass__. In the following example we can see that the `sing()` method, which is defined in `PolyClass1` and thus invokes class1's `my_song()` method, is automatically adjusted when invoked by `poly_obj2` to call `PolyClass2`'s `my_song()` method and change the song from *La La La* to *Fa Fa Fa*.


```python
class PolyClass1:
    def my_song(self):
        print("La La La")
        
    def sing(self):
        self.my_song()
        
class PolyClass2(PolyClass1):
    def my_song(self):
        print("Fa Fa Fa")
        
poly_obj1 = PolyClass1()
poly_obj2 = PolyClass2()

poly_obj1.sing()
poly_obj2.sing()
```

    La La La
    Fa Fa Fa


## How to use polymorphism when building a hierarchy of classes
The benefit of polymorphism manifests when creating a single method which is inherited and adjusted by subclasses. In the example below the `PlayMusic` class holds the actual `play()` funtion but doesn't have the specifics of *how* each instrument is played. The subclasses (`Guitar` and `Bass`) implement their specific concrete methods of play (plucking & strumming) and apply those to the shared `play()` function.


```python
import time

class PlayMusic:
    def play_instrument(self, method, play):
        if play:
            print((method+" ")*3)
        else:
            print("Stopped", method)

    def play(self, method):
        self.play_instrument(method, True)
        time.sleep(0.25)
        self.play_instrument(method, False)

class Guitar(PlayMusic):
    method="Strum"
    def strum_strings(self):
        self.play(self.method)


class Bass(PlayMusic):
    method="Pluck"
    def pluck_strings(self):
        self.play(self.method)
        
band_member1 = Guitar()
band_member2 = Bass()

band_member1.strum_strings()
band_member2.pluck_strings()
```

    Strum Strum Strum 
    Stopped Strum
    Pluck Pluck Pluck 
    Stopped Pluck


## Using composition to achieve the same effect
Composition is the process of composing an object using other different objects. It can be said that:
- __inheritance__ extends a class' capabilities by adding new components and modifying existing ones
- __composition__ uses a class as a container which holds and makes use of other classes and each object implements a part of the overall behaviour


```python
import time

class PlayGuitar:
    method="Strum"
    string_num=6
    def perform(self, play):
        print(f"{self.method}ming {self.string_num} strings:",play)


class PlayBass:
    method="Pluck"
    string_num=4
    def perform(self, play):
        print(f"{self.method}ing {self.string_num} strings:",play)
        
class BandPlay:
    def __init__(self, instrument):
        self.instrument = instrument
        
    def play(self):
        self.instrument.perform(True)
        time.sleep(0.25)
        self.instrument.perform(False)
        
        
guitarist = BandPlay(PlayGuitar())
bassist = BandPlay(PlayBass())

guitarist.play()
bassist.play()
```

    Strumming 6 strings: True
    Strumming 6 strings: False
    Plucking 4 strings: True
    Plucking 4 strings: False



```python

```
