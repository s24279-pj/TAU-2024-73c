import asyncio

class InsufficientFundsError(Exception):
    pass

class Account:
    def __init__(self, account_number: str, owner: str, initial_balance: float):
        self.account_number = account_number
        self.owner = owner
        self.balance = initial_balance

    def deposit(self, amount: float):
        """Dodaj środki do konta."""
        self.balance += amount

    def withdraw(self, amount: float):
        """Wypłać środki z konta, jeśli saldo jest wystarczające."""
        if amount > self.balance:
            raise InsufficientFundsError("Niewystarczające środki na koncie.")
        self.balance -= amount

    async def transfer(self, to_account: 'Account', amount: float):
        """Transferuj środki asynchronicznie do innego konta."""
        if amount > self.balance:
            raise InsufficientFundsError("Niewystarczające środki na koncie.")
        await asyncio.sleep(0.1)  # symulacja operacji asynchronicznej
        self.balance -= amount
        to_account.deposit(amount)

class Bank:
    def __init__(self):
        self.accounts = {}

    def create_account(self, account_number: str, owner: str, initial_balance: float) -> Account:
        """Tworzenie nowego konta."""
        if account_number in self.accounts:
            raise ValueError("Konto o tym numerze już istnieje.")
        account = Account(account_number, owner, initial_balance)
        self.accounts[account_number] = account
        return account

    def get_account(self, account_number: str) -> Account:
        """Zwróć konto na podstawie numeru."""
        if account_number not in self.accounts:
            raise ValueError("Konto o tym numerze nie istnieje.")
        return self.accounts[account_number]

    async def process_transaction(self, transaction_func):
        """Przetwarzanie transakcji - metoda asynchroniczna."""
        await transaction_func()
