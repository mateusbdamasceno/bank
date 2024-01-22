package com.project.servicce;

import com.project.beans.Transaction;
import com.project.repository.TransactionRepository;
import com.project.services.TransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;
import java.math.BigDecimal;
import java.util.Date;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceImpTest {
    @Mock
    private TransactionRepository repository;

    @Mock
    private TransactionService service;

    @Test
    public void testSaveCorrect() throws Exception {
        service.makeTransfer(populaTransaction());
        verify(service).makeTransfer(populaTransaction());
    }

    @Test
    public void testVerifyCorrect()  {
        service.verify(2, populaTransaction().getValueTransfer());
        verify(service).verify(2, populaTransaction().getValueTransfer());
    }

    public Transaction populaTransaction(){
        Transaction transaction = new Transaction();
        transaction.setId(2);
        transaction.setSourceAccount("1212");
        transaction.setTargetAccount("1212");
        transaction.setValueTransfer(new BigDecimal("1000"));
        transaction.setRate(new BigDecimal("25"));
        transaction.setSchedulingDate(new Date());
        transaction.setTransferDate(new Date());

        return transaction;
    }
}
