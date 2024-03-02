# Test Driven Development

Test Driven Development is the practice of writing a test for a piece of required functionality, before writing any implementation code. This test should fail when first run, and then, you write the code to get it to pass. It doesn’t have to be the most perfect code, just so long as the test passes. Once it does, you can then safely refactor your code.

## TDD Workflow

1. Read & understand the requirement for one method only.
2. Write one test for that method; run the tests to see it fail.
3. Write the method to fulfill the requirement.
4. Run the tests again. If they don't all pass, redo steps 1-3.
5. When your first test is passing, write the additional tests.
6. Run all of the tests. If any do not pass, redo steps 3-5.
7. Optional: Refactor your code and/or tests, keeping all tests passing.

## Benefits

1. Acceptance Criteria
   When writing some new code, you usually have a list of features that are required, or acceptance criteria that needs to be met. You can use either of these as a means to know what you need to test and then, once you’ve got that list in the form of test code, you can rest safely in the knowledge that you haven’t missed any work.

2. Focus
   You’re more productive while coding, and TDD helps keep that productivity high by narrowing your focus. You’ll write one failing test, and focus solely on that to get it passing. It forces you to think about smaller chunks of functionality at a time rather than the application as a whole, and you can then incrementally build on a passing test, rather than trying to tackle the bigger picture from the get-go, which will probably result in more bugs, and therefore a longer development time.

3. Interfaces
   Because you’re writing a test for a single piece of functionality, writing a test first means you have to think about the public interface that other code in your application needs to integrate with. You don’t think about the private methods or inner workings of what you’re about to work on. From the perspective of the test, you’re only writing method calls to test the public methods. This means that code will read well and make more sense.

4. Tidier Code
   Continuing on from the point above, your tests are only interfacing with public methods, so you have a much better idea of what can be made private, meaning you don’t accidentally expose methods that don’t need to be public. If you weren’t TDD’ing, and you made a method public, you’d then possibly have to support that in the future, meaning you’ve created extra work for yourself over a method that was only intended to be used internally in a class.

5. Dependencies
   Will your new code have any dependencies? When writing your tests, you’ll be able to mock these out without really worrying about what they are doing behind the scenes, which lets you focus on the logic within the class you’re writing. An additional benefit is that the dependencies you mock would potentially be faster when running the tests, and not bring additional dependencies to your test suite, in the form of filesystems, networks, databases etc.

6. Safer Refactoring
   Once you’ve got a test passing, it’s then safe to refactor it, secure in the knowledge that the test cases will have your back. If you’re having to work with legacy code, or code that someone else has written, and no tests have been written, you can still practice TDD. You needn’t have authored the original code in order for you to TDD. Rather than thinking you can only TDD code that you have written, think of it more as you can only TDD any code you are about to write. So if you inherit someone else’s untested code, before you start work, write a test that covers as much as you can. That puts you in a better position to refactor, or even to add new functionality to that code, whilst being confident that you won’t break anything.

7. Fewer Bugs
   TDD results in more tests, which can often result in longer test run times. However, with better code coverage, you save time down the line that would be spent fixing bugs that have popped up and need time to figure out. This is not to say that you might be able to think of every test case, but if a bug does come up, you can still write a test first before attempting to fix the problem, to ensure that the bug won’t come up again. This also helps define what the bug actually is, as you always need reproducible steps.

8. Increasing Returns
   The cost to TDD is higher at first, when compared to not writing any tests, though projects that don’t have tests written first usually end up costing more. This stems from them not having decent test code coverage, or any at all, making them more susceptible to bugs and issues, which means more time is spent in the long run fixing those. More time equals more money, which makes the project more expensive overall. Not only does TDD save time on fixing bugs, it also means that the cost to change functionality is less, because the tests act as a safety net that ensure your changes won’t break existing functionality.

9. Living Documentation
   Tests can serve as documentation to a developer. If you’re unsure of how a class or library works, go and have a read through the tests. With TDD, tests usually get written for different scenarios, one of which is probably how you want to use the class. So you can see the expected inputs a method requires and what you can expect as outcome, all based on the assertions made in the test.

## Types of Testing

In software development, there are various types of tests that can be performed to ensure that the code is working as expected. One of these types is unit testing.

1. Unit tests are automated tests that are designed to test individual units or components of a software application in isolation from the rest of the system. These units can be functions, classes, or modules. The purpose of unit testing is to ensure that each unit of code performs as expected and to catch errors or bugs early in the development process.

Other types of tests include:

2. Integration testing: Integration testing is the process of testing how different components of a software application work together. The purpose of integration testing is to ensure that the software works as a whole, and that different components can communicate with each other without any issues.

3. System testing: System testing is a type of testing that tests the entire system as a whole. It is performed after integration testing and is designed to test the entire system in a real-world environment.

4. Acceptance testing: Acceptance testing is performed to ensure that the software application meets the requirements and expectations of the end-users. It is usually the final step in the testing process before the software is released to production.

5. Performance testing: Performance testing is performed to measure how well the software application performs under different conditions, such as under high load or with limited resources.

In summary, unit tests are specific to testing individual units or components of a software application, while other types of tests focus on testing the application as a whole or under different conditions. All of these types of tests are important in ensuring that software applications are reliable, performant, and meet the needs of end-users.

## Potential Pitfalls

1. Overusing test doubles.
   When you have too many dependencies your tests are starting to be hard maintanable cause you need to change your tests on every change in your test doubles interface. Some people don't know it's not because TDD is bad but because your design it's bad:)

2. Thinking about unit tests in terms of classes/interfaces etc and testing private API.
   I think the better way to thinking about unit tests (especially when you have some new functionality to write) is to think about behaviour I believe that it should be also a result of good design. For example I'm not a fan of testing private classes, overriding some public functions used in other public functions in tests etc... Your tests will be hard maintanable and your code will become hard to refactor.

## What Should Be Tested?

In general, you probably have 4 different types of methods:

1.  Command - Changes the observable state, but does not return a value.

2.  Query - Returns a result, but does not change the observable state.

3.  Script - Only calls other methods, usually without returning anything.

4.  Looping Script - Only calls other methods, usually without returning
    anything, and stops when certain conditions are met.

**Let's take a look at methods that should always be tested:**

1.  Public Command or Public Query Methods should always be tested, because
    they are the public interface. Command Methods should test the method's action
    or side effect. Query Methods should test the method's return value.

2.  Command or Query Methods that are inside a public script or looping script
    method should be tested. For the games that we are making, script and looping
    script methods are just a convenient way to call the methods needed to play a
    full game. Since these methods are required to play the game, they should be
    tested and made public (even if you previously made them private). Pretend
    that someone will be using your class to make their own game with customized
    text. Any method that they would need in their game should be part of the
    public interface and have test coverage.

3.  Any method that sends a command message to another class should always test
    that those messages were sent.
4.  A Looping Script Method should test the behavior of the method. For
    example, that it stops when certain conditions are met.

**Here is a summary of what should be tested**

1.  Command Method -> Test the change in the observable state

2.  Query Method -> Test the return value

3.  Method with Outgoing Command -> Test that a message is sent

4.  Looping Script Method -> Test the behavior of the method

**There are a handful of methods that you do not need to test:**

1.  You do not have to test #initialize if it is only creating instance
    variables. However, if you call methods inside the initialize method, you
    might need to test #initialize and/or the inside methods. In addition, you
    will need to stub any inside methods because they will be called when you
    create an instance of the class.

2.  You do not have to test methods that only contain 'puts' or 'gets'
    because they are well-tested in the standard Ruby library.
3.  Private methods do not need to be tested because they should have test
    coverage in public methods. However, as previously discussed, you may have
    some private methods that are called inside a script or looping script method;
    these methods should be tested publicly.
