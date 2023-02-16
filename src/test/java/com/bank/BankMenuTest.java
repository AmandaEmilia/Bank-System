package com.bank;

import com.bank.service.BankService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.Scanner;

import static TestUtil.TestUtil.getBankAccount;

import static org.junit.jupiter.api.Assertions.*;

class BankMenuTest {

    @Test
    void shouldDeposit(){
        BankService bankServiceMock = Mockito.mock(BankService.class);
        BankAccount bankAccount = getBankAccount();
        Scanner scMock = Mockito.mock(Scanner.class);

        BankMenu bankMenu = new BankMenu(bankServiceMock,bankAccount, scMock);

        Mockito.when(scMock.next()).thenReturn("b", "e");

        Mockito.when(scMock.nextDouble()).thenReturn(100d);

        bankMenu.menu();

        Mockito.verify(bankServiceMock,Mockito.times(1)).deposit(bankAccount,100d);


    }

    @Test
    void shouldWithdraw(){
        BankService bankServiceMock = Mockito.mock(BankService.class);
        BankAccount bankAccount = getBankAccount();
        Scanner scMock = Mockito.mock(Scanner.class);

        BankMenu bankMenu = new BankMenu(bankServiceMock, bankAccount,scMock);

        Mockito.when(scMock.next()).thenReturn("c", "e");

        Mockito.when(scMock.nextDouble()).thenReturn(100d);

        bankMenu.menu();

        Mockito.verify(bankServiceMock, Mockito.times(1)).withdraw(bankAccount, 100d);

    }
 // steg 1
    @Test
    void shouldThrowException(){
        BankService bankServiceMock = Mockito.mock(BankService.class);
        BankAccount bankAccount = getBankAccount();
        Scanner scMock = Mockito.mock(Scanner.class);

        BankMenu bankMenu = new BankMenu(bankServiceMock, bankAccount,scMock);

        Mockito.when(scMock.next()).thenReturn("c", "e");

        Mockito.when(scMock.nextDouble()).thenReturn(100d);

        Mockito.doThrow(RuntimeException.class).when(bankServiceMock).withdraw(ArgumentMatchers.any(), ArgumentMatchers.anyDouble());

        bankMenu.menu();

    }

    //steg 2 fixa kod i bankMenu

}