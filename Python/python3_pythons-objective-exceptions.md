# The objective nature of Python's exceptions
The objective nature of Python's exceptions makes them very flexible, however, before diving into that lets cover a few additional syntactival and semantic aspects of `Try-Except`.

## `else`
The `else` keyword can also be used with `try-except`. In this usecase the `else` signifies *if there are no exceptions thrown*. So, if your `try` block executes without exception, the `else` branch will be executed also.


```python
def division_func(n):
    try:
        n = 1 / n
    except ZeroDivisionError:
        print("Uh oh, looks like you tried to divide by zero.")
        return
    else:
        print("Wahoo, that workd. Here's your result:")
        return n
    
print(division_func(1))
print(division_func(0))
```

    Wahoo, that workd. Here's your result:
    1.0
    Uh oh, looks like you tried to divide by zero.
    None


## `finally`
The `finally` keyword can be used in combination with `else` or independently and is always executed regardless of whether the `try` or `except` block was executed.


```python
def concat_func(n):
    try:
        n = "Bla bla " + n
    except TypeError:
        print("Nuh uh. Looks like you're trying to mix strings and integers there, hoss.")
    else:
        print("Success!")
    finally:
        print(f"Here you go: {n}")
        return "DONE"
        
print(concat_func(3))
print(concat_func("bla"))
```

    Nuh uh. Looks like you're trying to mix strings and integers there, hoss.
    Here you go: 3
    DONE
    Success!
    Here you go: Bla bla bla
    DONE


## `as`
Not only are exceptions classes but when an exception is raised an object of that class is instantiated. You can grab the instance for further evaluation by using the `as` keyword.


```python
try:
    n = 1 / 0
except Exception as e:
    print(e)
    print(e.__str__())

```

    division by zero
    division by zero


## Exception classes
Here's a nice function from [edube](https://edube.org/) showing the various exception classes:


```python
def print_exception_tree(thisclass, nest = 0):
    if nest > 1:
        print("   |" * (nest - 1), end="")
    if nest > 0:
        print("   +---", end="")

    print(thisclass.__name__)

    for subclass in thisclass.__subclasses__():
        print_exception_tree(subclass, nest + 1)


print_exception_tree(BaseException)

```

    BaseException
       +---Exception
       |   +---TypeError
       |   |   +---MultipartConversionError
       |   |   +---FloatOperation
       |   +---StopAsyncIteration
       |   +---StopIteration
       |   +---ImportError
       |   |   +---ModuleNotFoundError
       |   |   +---ZipImportError
       |   +---OSError
       |   |   +---ConnectionError
       |   |   |   +---BrokenPipeError
       |   |   |   +---ConnectionAbortedError
       |   |   |   +---ConnectionRefusedError
       |   |   |   +---ConnectionResetError
       |   |   |   |   +---RemoteDisconnected
       |   |   +---BlockingIOError
       |   |   +---ChildProcessError
       |   |   +---FileExistsError
       |   |   +---FileNotFoundError
       |   |   +---IsADirectoryError
       |   |   +---NotADirectoryError
       |   |   +---InterruptedError
       |   |   |   +---InterruptedSystemCall
       |   |   +---PermissionError
       |   |   +---ProcessLookupError
       |   |   +---TimeoutError
       |   |   +---UnsupportedOperation
       |   |   +---ItimerError
       |   |   +---Error
       |   |   |   +---SameFileError
       |   |   +---SpecialFileError
       |   |   +---ExecError
       |   |   +---ReadError
       |   |   +---herror
       |   |   +---gaierror
       |   |   +---timeout
       |   |   +---SSLError
       |   |   |   +---SSLCertVerificationError
       |   |   |   +---SSLZeroReturnError
       |   |   |   +---SSLWantReadError
       |   |   |   +---SSLWantWriteError
       |   |   |   +---SSLSyscallError
       |   |   |   +---SSLEOFError
       |   |   +---URLError
       |   |   |   +---HTTPError
       |   |   |   +---ContentTooShortError
       |   +---EOFError
       |   |   +---IncompleteReadError
       |   +---RuntimeError
       |   |   +---RecursionError
       |   |   +---NotImplementedError
       |   |   |   +---StdinNotImplementedError
       |   |   |   +---ZMQVersionError
       |   |   +---_DeadlockError
       |   |   +---BrokenBarrierError
       |   |   +---BrokenExecutor
       |   |   +---SendfileNotAvailableError
       |   +---NameError
       |   |   +---UnboundLocalError
       |   +---AttributeError
       |   |   +---FrozenInstanceError
       |   +---SyntaxError
       |   |   +---IndentationError
       |   |   |   +---TabError
       |   +---LookupError
       |   |   +---IndexError
       |   |   +---KeyError
       |   |   |   +---UnknownBackend
       |   |   |   +---NoSuchKernel
       |   |   +---CodecRegistryError
       |   +---ValueError
       |   |   +---UnicodeError
       |   |   |   +---UnicodeEncodeError
       |   |   |   +---UnicodeDecodeError
       |   |   |   +---UnicodeTranslateError
       |   |   +---UnsupportedOperation
       |   |   +---JSONDecodeError
       |   |   +---Error
       |   |   +---ClassNotFound
       |   |   +---SSLCertVerificationError
       |   |   +---ClipboardEmpty
       |   |   +---MessageDefect
       |   |   |   +---NoBoundaryInMultipartDefect
       |   |   |   +---StartBoundaryNotFoundDefect
       |   |   |   +---CloseBoundaryNotFoundDefect
       |   |   |   +---FirstHeaderLineIsContinuationDefect
       |   |   |   +---MisplacedEnvelopeHeaderDefect
       |   |   |   +---MissingHeaderBodySeparatorDefect
       |   |   |   +---MultipartInvariantViolationDefect
       |   |   |   +---InvalidMultipartContentTransferEncodingDefect
       |   |   |   +---UndecodableBytesDefect
       |   |   |   +---InvalidBase64PaddingDefect
       |   |   |   +---InvalidBase64CharactersDefect
       |   |   |   +---InvalidBase64LengthDefect
       |   |   |   +---HeaderDefect
       |   |   |   |   +---InvalidHeaderDefect
       |   |   |   |   +---HeaderMissingRequiredValue
       |   |   |   |   +---NonPrintableDefect
       |   |   |   |   +---ObsoleteHeaderDefect
       |   |   |   |   +---NonASCIILocalPartDefect
       |   |   +---IllegalMonthError
       |   |   +---IllegalWeekdayError
       |   |   +---MacroToEdit
       |   |   +---JSONDecodeError
       |   |   +---ParserError
       |   +---AssertionError
       |   +---ArithmeticError
       |   |   +---FloatingPointError
       |   |   +---OverflowError
       |   |   +---ZeroDivisionError
       |   |   |   +---DivisionByZero
       |   |   |   +---DivisionUndefined
       |   |   +---DecimalException
       |   |   |   +---Clamped
       |   |   |   +---InvalidOperation
       |   |   |   |   +---ConversionSyntax
       |   |   |   |   +---DivisionImpossible
       |   |   |   |   +---DivisionUndefined
       |   |   |   |   +---InvalidContext
       |   |   |   +---DivisionByZero
       |   |   |   +---Inexact
       |   |   |   |   +---Overflow
       |   |   |   |   +---Underflow
       |   |   |   +---Rounded
       |   |   |   |   +---Overflow
       |   |   |   |   +---Underflow
       |   |   |   +---Subnormal
       |   |   |   |   +---Underflow
       |   |   |   +---FloatOperation
       |   +---SystemError
       |   |   +---CodecRegistryError
       |   +---ReferenceError
       |   +---MemoryError
       |   +---BufferError
       |   +---Warning
       |   |   +---UserWarning
       |   |   |   +---GetPassWarning
       |   |   |   +---FormatterWarning
       |   |   +---DeprecationWarning
       |   |   |   +---ProvisionalWarning
       |   |   +---PendingDeprecationWarning
       |   |   +---SyntaxWarning
       |   |   +---RuntimeWarning
       |   |   |   +---UnknownTimezoneWarning
       |   |   +---FutureWarning
       |   |   |   +---ProvisionalCompleterWarning
       |   |   +---ImportWarning
       |   |   +---UnicodeWarning
       |   |   +---BytesWarning
       |   |   +---ResourceWarning
       |   |   +---DeprecatedTzFormatWarning
       |   +---Error
       |   +---_OptionError
       |   +---error
       |   +---Verbose
       |   +---_Error
       |   +---SubprocessError
       |   |   +---CalledProcessError
       |   |   +---TimeoutExpired
       |   +---Error
       |   +---TokenError
       |   +---StopTokenizing
       |   +---error
       |   +---LZMAError
       |   +---RegistryError
       |   +---_GiveupOnFastCopy
       |   +---ClassFoundException
       |   +---EndOfBlock
       |   +---TraitError
       |   +---ArgumentError
       |   +---ArgumentTypeError
       |   +---ConfigError
       |   |   +---ConfigLoaderError
       |   |   |   +---ArgumentError
       |   |   +---ConfigFileNotFound
       |   +---ConfigurableError
       |   |   +---MultipleInstanceError
       |   +---ApplicationError
       |   +---ErrorDuringImport
       |   +---BdbQuit
       |   +---Restart
       |   +---ExceptionPexpect
       |   |   +---EOF
       |   |   +---TIMEOUT
       |   +---error
       |   +---error
       |   +---PtyProcessError
       |   +---FindCmdError
       |   +---HomeDirError
       |   +---ProfileDirError
       |   +---IPythonCoreError
       |   |   +---TryNext
       |   |   +---UsageError
       |   |   +---StdinNotImplementedError
       |   +---InputRejected
       |   +---GetoptError
       |   +---Incomplete
       |   +---OptionError
       |   +---ErrorToken
       |   +---PickleError
       |   |   +---PicklingError
       |   |   +---UnpicklingError
       |   +---_Stop
       |   +---PrefilterError
       |   +---AliasError
       |   |   +---InvalidAliasError
       |   +---Error
       |   |   +---InterfaceError
       |   |   +---DatabaseError
       |   |   |   +---InternalError
       |   |   |   +---OperationalError
       |   |   |   +---ProgrammingError
       |   |   |   +---IntegrityError
       |   |   |   +---DataError
       |   |   |   +---NotSupportedError
       |   +---Warning
       |   +---SpaceInInput
       |   +---Error
       |   |   +---CancelledError
       |   |   +---TimeoutError
       |   |   +---InvalidStateError
       |   +---_GiveupOnSendfile
       |   +---TimeoutError
       |   +---InvalidStateError
       |   +---LimitOverrunError
       |   +---QueueEmpty
       |   +---QueueFull
       |   +---DOMException
       |   |   +---IndexSizeErr
       |   |   +---DomstringSizeErr
       |   |   +---HierarchyRequestErr
       |   |   +---WrongDocumentErr
       |   |   +---InvalidCharacterErr
       |   |   +---NoDataAllowedErr
       |   |   +---NoModificationAllowedErr
       |   |   +---NotFoundErr
       |   |   +---NotSupportedErr
       |   |   +---InuseAttributeErr
       |   |   +---InvalidStateErr
       |   |   +---SyntaxErr
       |   |   +---InvalidModificationErr
       |   |   +---NamespaceErr
       |   |   +---InvalidAccessErr
       |   |   +---ValidationErr
       |   +---ValidationError
       |   +---EditReadOnlyBuffer
       |   +---_Retry
       |   +---InvalidLayoutError
       |   +---HeightIsUnknownError
       |   +---Empty
       |   +---Full
       |   +---ParserSyntaxError
       |   +---InternalParseError
       |   +---_PositionUpdatingFinished
       |   +---ArgumentError
       |   +---SimpleGetItemNotFound
       |   +---UncaughtAttributeError
       |   +---ParamIssue
       |   +---_JediError
       |   |   +---InternalError
       |   |   +---WrongVersion
       |   |   +---RefactoringError
       |   +---OnErrorLeaf
       |   +---InvalidPythonEnvironment
       |   +---MessageError
       |   |   +---MessageParseError
       |   |   |   +---HeaderParseError
       |   |   |   +---BoundaryError
       |   |   +---MultipartConversionError
       |   |   +---CharsetError
       |   +---Error
       |   +---HTTPException
       |   |   +---NotConnected
       |   |   +---InvalidURL
       |   |   +---UnknownProtocol
       |   |   +---UnknownTransferEncoding
       |   |   +---UnimplementedFileMode
       |   |   +---IncompleteRead
       |   |   +---ImproperConnectionState
       |   |   |   +---CannotSendRequest
       |   |   |   +---CannotSendHeader
       |   |   |   +---ResponseNotReady
       |   |   +---BadStatusLine
       |   |   |   +---RemoteDisconnected
       |   |   +---LineTooLong
       |   +---InteractivelyDefined
       |   +---KillEmbedded
       |   +---ZMQBaseError
       |   |   +---ZMQError
       |   |   |   +---ContextTerminated
       |   |   |   +---Again
       |   |   |   +---InterruptedSystemCall
       |   |   +---ZMQBindError
       |   |   +---NotDone
       |   +---NoIPAddresses
       |   +---InvalidPortNumber
       |   +---DuplicateKernelError
       |   +---TimeoutError
       |   +---error
       |   +---ReturnValueIgnoredError
       |   +---KeyReuseError
       |   +---UnknownKeyError
       |   +---LeakedCallbackError
       |   +---BadYieldError
       |   +---ReturnValueIgnoredError
       |   +---Return
       |   +---QueueEmpty
       |   +---QueueFull
       +---GeneratorExit
       +---SystemExit
       +---KeyboardInterrupt
       +---CancelledError


## The `args` property
Python's `BaseException` class (the topmost in the exception class hierarchy) introduces a property named `args`. `args` is a tuple designed to hold all arguments passed to the class constructor (it's empty if the constructor has been invoked without arguments).


```python
def print_args(args):
    if len(args) == 0:
        print("No arguments were passed")
    elif len(args) == 1:
        print(args[0])
    else:
        print(str(args))
        
try:
    raise Exception
except Exception as e:
    print_args(e.args)
try:
    raise Exception("my","arguments")
except Exception as e:
    print_args(e.args)
```

    No arguments were passed
    ('my', 'arguments')


## Defining your own exceptions
If needed you can create your own exceptions derived from Python's (e.g. an even more specific one derived from one of the more concrete exceptions or derived from one of the more abstract such as `Exception` if you're looking to create your own independent family of exceptions).

Lets say we've created a maths game where users are not permitted to divide by 2 and we want an exception specifically for that case.


```python
import random

class DivByTwoError(ZeroDivisionError):
    message="You're not allowed do that."


def play_the_game(state):
    while state:
        userchoice = int(input("Please choose a number to divide by? "))
        if userchoice == 2:
            try:
                raise DivByTwoError
            except DivByTwoError as e:
                print(e.message)
                
        else:
            print(random.randint(1,100) / userchoice)
            state = False
            
play_the_game(True)
```

    Please choose a number to divide by? 2
    You're not allowed do that.
    Please choose a number to divide by? 1
    92.0


Or lets imagine we've created a bunch of musical instrument classes and want specific errors to handle issues we might run into.


```python
class StringError(Exception): # base string error derived from Exception class
    def __init__(self, message, instrument):
        Exception.__init__(self, message)
        self.instrument = instrument
        
class BrokenString(StringError): # more specific error based on StringError
    def __init__(self, message, instrument, string):
        StringError.__init__(self, message, instrument)
        self.string = string
        self.message = f"string {self.string} on {self.instrument} is broken"
        
class DetunedString(StringError): # another specific error based on StringError
    def __init__(self, message, instrument, string, target_note, actual_note):
        StringError.__init__(self, message, instrument)
        self.string = string
        self.target_note = target_note
        self.actual_note = actual_note
        self.message = f"string {self.string} on {self.instrument} is tuned to {self.actual_note} when it should be {self.target_note}"
        
def play_music(instruments):
    for instrument in instruments:
        if instrument["status"] == "playing":
            print(f"{instrument['name']} is {instrument['status']}")
        elif instrument["status"] == "brokenstring":
            try:
                raise BrokenString(instrument["status"],instrument["name"],instrument["problem_string"])
            except BrokenString as e:
                print(e.message)
        elif instrument["status"] == "detuned":
            try:
                raise DetunedString(instrument["status"], 
                                    instrument["name"], 
                                    instrument["problem_string"], 
                                    instrument["target_note"], 
                                    instrument["actual_note"])
            except DetunedString as e:
                print(e.message)

lead_guitar = {
    "name": "lead guitar",
    "status":"playing",
    "problem_string": None
         }
bass = {
    "name": "bass",
    "status": "brokenstring",
    "problem_string": 4
}

rhythm_guitar = {
    "name": "rhythm guitar",
    "status": "detuned",
    "problem_string": 6,
    "target_note": "E",
    "actual_note": "D"
}

play_music([lead_guitar,bass,rhythm_guitar])
```

    lead guitar is playing
    string 4 on bass is broken
    string 6 on rhythm guitar is tuned to D when it should be E



```python

```
