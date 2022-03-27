class Bank {
    private long[] balance;
    public Bank(long[] balance) {
        this.balance = balance;
    }

    private boolean checkAccount(int account) {
        return 0 <= account && account < balance.length;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        account1--; account2--;
        if (!checkAccount(account1) || !checkAccount(account2)) return false;
        if (balance[account1] < money) return false;
        balance[account1] -= money;
        balance[account2] += money;
        return true;
    }
    
    public boolean deposit(int account, long money) {
        account--;
        if (!checkAccount(account)) return false;
        balance[account] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        account--;
        if (!checkAccount(account)) return false;
        if (balance[account] < money) return false;
        balance[account] -= money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */