___

<a href='https://www.udemy.com/user/joseportilla/'><img src='../Pierian_Data_Logo.png'/></a>
___
<center><em>Content Copyright by Pierian Data</em></center>

# Object Oriented Programming Challenge

For this challenge, create a bank account class that has two attributes:

* owner
* balance

and two methods:

* deposit
* withdraw

As an added requirement, withdrawals may not exceed the available balance.

Instantiate your class, make several deposits and withdrawals, and test to make sure the account can't be overdrawn.


```python
class Account:
    
    def __init__(self,owner,balance):
        self.owner = owner
        self.balance = balance
        
    def deposit(self, amount):
        self.balance += amount
        return f"Depost accepted. New balance: {self.balance}"
        
    def withdraw(self, amount):
        if self.balance >= amount:
            self.balance -= amount
            return f"Withdrawel accepted. Remaining balance: {self.balance}"
        else:
            return f"Insufficient funds in account: {self.balance}."
```


```python
# 1. Instantiate the class
acct1 = Account('Jose',100)
```


```python
# 2. Print the object
print(acct1)
```

    <__main__.Account object at 0x7f9304413d00>



```python
# 3. Show the account owner attribute
acct1.owner
```




    'Jose'




```python
# 4. Show the account balance attribute
acct1.balance
```




    100




```python
# 5. Make a series of deposits and withdrawals
acct1.deposit(50)
```




    'Depost accepted. New balance: 150'




```python
acct1.withdraw(75)
```




    'Withdrawel accepted. Remaining balance: 75'




```python
# 6. Make a withdrawal that exceeds the available balance
acct1.withdraw(500)
```




    'Insufficient funds in account: 75.'



## Good job!
