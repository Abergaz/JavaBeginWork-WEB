package ru.javabegin.training.spring.aop.transactions;

import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Component
public class CheckTransaction {

	public void checkTransactionActive() {

		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());

	}

}
