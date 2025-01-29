import pytest
import asyncio
from unittest import mock
from bank_system import Account, Bank, InsufficientFundsError

@pytest.fixture
def bank():
    return Bank()

@pytest.fixture
def account1(bank):
    return bank.create_account("12345", "Jan Kowalski", 1000.0)

@pytest.fixture
def account2(bank):
    return bank.create_account("67890", "Anna Nowak", 500.0)

def test_deposit(account1):
    account1.deposit(500)
    assert account1.balance == 1500.0

def test_withdraw(account1):
    account1.withdraw(300)
    assert account1.balance == 700.0

def test_withdraw_insufficient_funds(account1):
    with pytest.raises(InsufficientFundsError):
        account1.withdraw(2000)

@pytest.mark.asyncio
async def test_transfer(account1, account2):
    await account1.transfer(account2, 300)
    assert account1.balance == 700.0
    assert account2.balance == 800.0

@pytest.mark.asyncio
async def test_transfer_insufficient_funds(account1, account2):
    with pytest.raises(InsufficientFundsError):
        await account1.transfer(account2, 2000)

def test_create_account(bank):
    account = bank.create_account("11223", "Marek Zielinski", 100.0)
    assert account.account_number == "11223"
    assert account.owner == "Marek Zielinski"
    assert account.balance == 100.0

def test_get_account(bank, account1):
    retrieved_account = bank.get_account("12345")
    assert retrieved_account == account1

def test_get_account_non_existent(bank):
    with pytest.raises(ValueError):
        bank.get_account("99999")

@pytest.mark.asyncio
async def test_process_transaction(bank, account1, account2):
    async def mock_transaction(arg):
        await account1.transfer(account2, 100)

    with mock.patch.object(bank, 'process_transaction', new=mock_transaction):
        await bank.process_transaction(mock_transaction)
    
    assert account1.balance == 900.0
    assert account2.balance == 600.0

def test_external_authorization(bank, account1, account2):
    with mock.patch('bank_system.Account.transfer', new_callable=mock.AsyncMock) as mock_transfer:
        account1.deposit(500)
        account1.withdraw(200)
        account1.transfer(account2, 200)

        mock_transfer.assert_called_once()
