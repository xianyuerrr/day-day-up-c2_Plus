class Bank:

    def __init__(self, balance: List[int]):
        self.lis = balance
        self.n = len(self.lis)
    
    def check(self, accountId):
        return 1 <= accountId <= self.n

    def transfer(self, account1: int, account2: int, money: int) -> bool:
        if not (self.check(account1) and self.check(account2)):
            return False
        if self.lis[account1-1] < money:
            return False
        self.lis[account1-1] -= money
        self.lis[account2-1] += money
        return True

    def deposit(self, account: int, money: int) -> bool:
        if not self.check(account):
            return False
        self.lis[account-1] += money
        return True


    def withdraw(self, account: int, money: int) -> bool:
        if not self.check(account):
            return False
        if self.lis[account-1] < money:
            return False
        self.lis[account-1] -= money
        return True


# Your Bank object will be instantiated and called as such:
# obj = Bank(balance)
# param_1 = obj.transfer(account1,account2,money)
# param_2 = obj.deposit(account,money)
# param_3 = obj.withdraw(account,money)