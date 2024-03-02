# RSpec Basics

## RSpec Testing

RSpec is a testing framework for the Ruby programming language. It provides a domain-specific language (DSL) for writing tests, and it is designed to be human-readable and easy to understand. RSpec uses a behavior-driven development (BDD) approach, which focuses on describing the behavior of the system under test.

## What To Test

Certainly! I'll provide examples and explanations for each of the four types of methods mentioned in your question: command, query, script, and looping script.

1. Command:
   A command is a method that changes the observable state but does not return a value. It is often used to perform actions or modify data without producing any specific output. Here's an example:

```ruby
class ShoppingCart
  def add_item(item)
    # Code to add the item to the shopping cart
    # ...
  end
end
```

In this example, the `add_item` method is a command because it modifies the state of the `ShoppingCart` object by adding an item to it. The method doesn't return anything; its purpose is solely to perform the action of adding an item.

When testing a command method, you would typically verify that the expected changes have occurred in the system. For instance, you could check if the item was successfully added to the shopping cart or if the appropriate changes were made to the underlying data.

2. Query:
   A query is a method that returns a result without changing the observable state. It is used to retrieve information or perform calculations based on the existing data. Here's an example:

```ruby
class Calculator
  def add(a, b)
    a + b
  end
end
```

In this example, the `add` method is a query because it takes two arguments, performs the addition operation, and returns the result. It doesn't modify any state; its purpose is solely to provide a value based on the inputs.

When testing a query method, you would typically verify that the returned value is correct based on the inputs or conditions specified. For instance, you could test if the `add` method returns the expected sum when provided with different combinations of numbers.

3. Script:
   A script is a method that only calls other methods, usually without returning anything. It orchestrates the execution of multiple methods to achieve a specific goal. Here's an example:

```ruby
class OrderProcessor
  def process_order(order)
    validate_order(order)
    apply_discounts(order)
    send_confirmation_email(order)
  end

  def validate_order(order)
    # Code to validate the order
    # ...
  end

  def apply_discounts(order)
    # Code to apply discounts to the order
    # ...
  end

  def send_confirmation_email(order)
    # Code to send a confirmation email to the customer
    # ...
  end
end
```

In this example, the `process_order` method is a script because it calls other methods (`validate_order`, `apply_discounts`, and `send_confirmation_email`) to perform various tasks related to order processing. It doesn't return anything; its purpose is to coordinate the execution flow.

When testing a script method, you would typically focus on the interactions between the called methods. You can verify that the expected methods are called with the correct arguments and that they are invoked in the desired order.

4. Looping Script:
   A looping script is a method that only calls other methods, usually without returning anything, and stops when certain conditions are met. It iterates over a collection or performs a repetitive task until a specific criterion is fulfilled. Here's an example:

```ruby
class DataProcessor
  def process_data(data)
    data.each do |item|
      process_item(item)
    end
  end

  def process_item(item)
    # Code to process an individual item
    # ...
  end
end
```

In this example, the process_data method is a looping script because it iterates over the data collection and calls the process_item method for each item. The iteration stops naturally when all items have been processed. The method doesn't return anything; its purpose is to iterate and execute the required task for each item.

When testing a looping script method, you would typically ensure that the underlying task is performed correctly for each item in the collection. You can verify that the process_item method is called the expected number of times and that it behaves as desired for different inputs.

By understanding these four types of methods and their purposes, you can structure your tests to cover the specific behaviors and expectations associated with each type, leading to comprehensive test coverage for your Ruby code.

### Key Elements of RSpec Testing

1. **Describe Blocks**: The `describe` block is used to define a group of related tests. It is typically used to describe the behavior of a class or method. For example:

```ruby
describe MyClass do
  # tests go here
end
```

2. **Context Blocks**: The `context` block is used to define a specific context in which tests should be run. It is typically used to describe different scenarios or edge cases. For example:

```ruby
describe MyClass do
  context "when given invalid input" do
    # tests go here
  end

  context "when given valid input" do
    # tests go here
  end
end
```

3. **It Blocks**: The `it` block is used to define a specific test case. It should describe the expected behavior of the system under test. For example:

```ruby
describe MyClass do
  it "returns the correct result" do
    # test code goes here
  end
end
```

4. **Expectations**: Expectations are used to specify the expected behavior of the system under test. They typically take the form of assertions, such as `expect(result).to eq(expected_result)`. There are many different types of expectations, including:

- `expect(value).to be_truthy`: Tests that a value is truthy (i.e., not `false` or `nil`).
- `expect(value).to be_falsy`: Tests that a value is falsy (i.e., `false` or `nil`).
- `expect(value).to be_nil`: Tests that a value is `nil`.
- `expect(value).to eq(expected_value)`: Tests that a value is equal to the expected value.

5. **Matchers**: Matchers are used to define custom expectations. They provide a way to test for specific conditions or behaviors that are not covered by the built-in expectations. For example:

```ruby
RSpec::Matchers.define :be_within_epsilon do |expected|
  match do |actual|
    (actual - expected).abs < 0.01
  end
end

describe MyClass do
  it "returns a value within epsilon" do
    result = MyClass.do_something
    expect(result).to be_within_epsilon(0.5)
  end
end
```

6. **Before and After Hooks**: RSpec provides before and after hooks that allow you to run setup and teardown code before and after each test. These hooks are defined using the `before` and `after` methods, and they can be scoped to specific describe or context blocks. For example:

```ruby
describe MyClass do
  before(:each) do
    # setup code goes here
  end

  after(:each) do
    # teardown code goes here
  end

  it "does something" do
    # test code goes here
  end
end
```

7. **Shared examples** Shared examples are a feature of the RSpec testing framework that allow you to define a set of tests that can be reused across multiple describe blocks. This can be useful when you want to test the same behavior in multiple contexts or for multiple objects.

To define a shared example, you use the `shared_examples` method to create a named block of code that contains one or more `it` blocks. For example:

```ruby
RSpec.shared_examples "a calculator" do
  it "adds two numbers" do
    calculator = Calculator.new
    result = calculator.add(2, 3)
    expect(result).to eq(5)
  end

  it "subtracts two numbers" do
    calculator = Calculator.new
    result = calculator.subtract(5, 3)
    expect(result).to eq(2)
  end
end
```

In this example, we define a shared example called "a calculator" that contains two `it` blocks for testing the `add` and `subtract` methods of a `Calculator` object.

To include the shared example in a describe block, you use the `include_examples` method and provide the name of the shared example as an argument. For example:

```ruby
describe Calculator do
  include_examples "a calculator"
end
```

This will include the shared example in the `Calculator` describe block, allowing you to run the same tests for the `add` and `subtract` methods of the `Calculator` object.

Shared examples can also take arguments, allowing you to customize the behavior of the tests for different contexts. For example, you could define a shared example for testing a `Stack` object that takes a parameter for the maximum size of the stack, allowing you to test different scenarios where the stack is full or not.

Mocks, doubles, and stubs are all features of the RSpec testing framework that allow you to isolate and test specific parts of your application.

8. **Mocks**: Mocks are objects that simulate the behavior of real objects. They are used to test interactions between objects in your application. In RSpec, you can create a mock object using the `double` method. For example:

```ruby
user = double("user")
expect(user).to receive(:save)
```

In this example, we create a mock user object and then set an expectation that the `save` method will be called on it.

9. **Doubles**: Doubles are objects that behave like the real objects they represent, but they don't have any actual behavior or state. They are used to isolate and test specific parts of your application. In RSpec, you can create a double object using the `double` method. For example:

```ruby
user = double("user", name: "John", email: "john@example.com")
expect(user.name).to eq("John")
```

In this example, we create a double user object with two properties, `name` and `email`, and then test that the `name` property is set correctly.

10. **Stubs**: Stubs are objects that provide pre-defined responses to method calls. They are used to control the behavior of objects in your application during testing. In RSpec, you can create a stub object using the `allow` method. For example:

```ruby
user = double("user")
allow(user).to receive(:name).and_return("John")
expect(user.name).to eq("John")
```

In this example, we create a stub user object that returns the value "John" when the `name` method is called on it. Then we test that the value returned by the `name` method is correct.

Overall, mocks, doubles, and stubs are all powerful tools for testing complex applications with multiple interacting parts. They allow you to isolate and test specific parts of your application, and to control the behavior of objects during testing to ensure that your tests are accurate and reliable.

Sure! Here's an overview of the topics and some example code to illustrate how to use them in practice:

## Setting up RSpec in a Ruby project

RSpec is a testing framework for Ruby, used to write automated tests. To set up RSpec in a Ruby project, you need to add the `rspec` gem to your project's `Gemfile` and run the `bundle install` command to install it. Then, you need to run the `rspec --init` command to generate the `spec` directory and the `spec_helper.rb` file, which will contain the configuration for your RSpec tests.

```ruby
# Gemfile
group :development, :test do
  gem 'rspec'
end
```

```bash
$ bundle install
$ rspec --init
```

## Writing and running tests with RSpec

To write and run tests with RSpec, you need to create a new file in the `spec` directory with the `.spec.rb` extension. In this file, you will write one or more test cases using RSpec's syntax, which consists of `describe` and `it` blocks.

```ruby
# spec/example_spec.rb
describe 'Example' do
  it 'returns true' do
    expect(true).to eq(true)
  end
end
```

To run the tests, you need to execute the `rspec` command followed by the name of the file or directory containing your test files.

```bash
$ rspec spec/example_spec.rb
```

## Organizing tests with describe and context blocks

RSpec provides `describe` and `context` blocks to organize your tests into groups. You can use these blocks to group related tests together and give them a descriptive name.

```ruby
# spec/calculator_spec.rb
describe Calculator do
  context 'when adding numbers' do
    it 'returns the sum of two numbers' do
      calculator = Calculator.new
      expect(calculator.add(2, 3)).to eq(5)
    end
  end

  context 'when dividing numbers' do
    it 'returns the quotient of two numbers' do
      calculator = Calculator.new
      expect(calculator.divide(10, 2)).to eq(5)
    end

    it 'raises an error when dividing by zero' do
      calculator = Calculator.new
      expect{ calculator.divide(10, 0) }.to raise_error(ZeroDivisionError)
    end
  end
end
```

## Using expectations to make assertions

RSpec uses expectations to make assertions about your code's behavior. You can use the `expect` method to create an expectation and then chain it with a matcher to specify what you're expecting.

```ruby
# spec/example_spec.rb
describe 'Example' do
  it 'returns true' do
    expect(true).to eq(true)
  end

  it 'returns a string' do
    expect('hello').to be_a(String)
  end

  it 'returns a number greater than 5' do
    expect(7).to be > 5
  end
end
```

## Using built-in and custom matchers

Matchers are the heart of RSpec. Matchers help us write expectations that make our tests easy to read and easy to understand. They define what we're looking for in our tests, and how we want to look for it.

RSpec comes with a lot of built-in matchers, such as `eq`, `be`, `include`, `match`, `raise_error`, and many more. These matchers provide a great way to test our code quickly and easily. We can also create our custom matchers to encapsulate our specific domain or application requirements.

Here's an example of using a built-in matcher:

```ruby
describe "My awesome class" do
  it "should return true when the method is called with true" do
    my_object = MyAwesomeClass.new
    expect(my_object.my_method(true)).to be true
  end
end
```

Here's an example of creating a custom matcher:

```ruby
RSpec::Matchers.define :be_a_multiple_of do |expected|
  match do |actual|
    actual % expected == 0
  end
end

describe "My awesome class" do
  it "should be a multiple of 3" do
    my_object = MyAwesomeClass.new
    expect(my_object.my_method).to be_a_multiple_of(3)
  end
end
```

In the above example, we define a custom matcher `be_a_multiple_of` that matches when the actual value is a multiple of the expected value. We can then use this custom matcher in our tests to make our expectations more readable and reusable.

We can also use built-in and custom matchers with modifiers such as `not_to` and `to_not`, to express the opposite expectation. For example:

```ruby
describe "My awesome class" do
  it "should not be empty" do
    my_object = MyAwesomeClass.new
    expect(my_object.my_method).not_to be_empty
  end
end
```

In the above example, we use the `not_to` modifier with the `be_empty` built-in matcher to ensure that our method doesn't return an empty value.

## Using shared examples to reuse tests:

Shared examples in RSpec allow you to define examples in a shared context and reuse them across multiple tests. This can be useful when you have multiple tests that share the same setup or expectations. You can define a shared example using the `shared_examples` method, and then include it in your tests using the `include_examples` method. Here's an example:

```ruby
RSpec.shared_examples "a collection" do
  it "is empty when first created" do
    expect(subject.length).to eq(0)
  end
end

RSpec.describe Array do
  include_examples "a collection"
end

RSpec.describe Hash do
  include_examples "a collection"
end
```

In this example, we define a shared example called "a collection" that checks if a collection is empty when first created. We then include this shared example in our tests for both the `Array` and `Hash` classes using the `include_examples` method.

## Using mocks, doubles, and stubs to isolate and test specific parts of the application:

In RSpec, you can use mocks, doubles, and stubs to isolate and test specific parts of your application. These tools allow you to simulate the behavior of objects and methods in your application, so you can test your code in isolation from the rest of your application. Here's an example:

```ruby
RSpec.describe Order do
  let(:customer) { double("customer", name: "John") }
  let(:product) { double("product", name: "Book", price: 10.0) }

  it "adds the product to the order" do
    order = Order.new(customer)
    expect(order.add_product(product)).to eq([product])
  end

  it "calculates the total price of the order" do
    order = Order.new(customer)
    order.add_product(product)
    expect(order.total_price).to eq(10.0)
  end
end
```

In this example, we define a test for an `Order` class that takes a `customer` and allows products to be added to the order. We use doubles to simulate the behavior of a `customer` and `product` object. We then write tests to verify that the product is added to the order and that the total price of the order is correctly calculated.
