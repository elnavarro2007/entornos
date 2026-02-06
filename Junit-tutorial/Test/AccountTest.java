import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    @Test
    @DisplayName("Debe mostrar la cuenta con las props correctas")
    void TestConstructor() {

        String custname = "Hector";
        double balance = 0.0;

        Account account = new Account("Hector");

        Assertions.assertAll(
                () -> Assertions.assertArrayEquals(custname.toCharArray(), account.getCustomerName().toCharArray()),
                () -> Assertions.assertEquals(balance, account.getBalance())
        );
    }

    @Test
    @DisplayName("Deberia lanzar la excepcion")
    void textNokConstructor() {
        Exception excepcion = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Account account = new Account(null);
        });
        String expectedMessage = "El nombre no puede ser nulo";
        String actualMessage = excepcion.getMessage();
        Assertions.assertTrue(excepcion.getMessage().contains("El nombre no puede ser nulo"));
    }


    @Test
    @DisplayName("Credito correcto")
    void testcredit() {
        double credit = 10.00;
        Account account = new Account("hector");
        account.Credit(1.00);

        Assertions.assertEquals(1.00, account.getBalance());
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () ->

                account.Credit((-1.00))

        );
    }

    @Test
    void testDebit() {
        String custName = "Joe Brown";
        double credit = 10.00;
        double debit = 5.00;
        Account account = new Account(custName);
        account.Credit(credit);
        account.Debit(debit);
        Assertions.assertEquals(credit - debit, account.Balance);
    }

    @Test
    public void Test_Credit_Negative() {
        String custName = "Joe Brown";
        double credit = -100.00;
        Account account = new Account(custName);
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
        {
            account.Credit(credit);
        });
        String expectedMessage = "La cantidad debe ser mayor que cero";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void Test_Debit_Negative() {
        String custName = "Joe Brown";
        double debit = -100.00;
        Account account = new Account(custName);
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
        {
            account.Debit(debit);
        });
        String expectedMessage = "La cantidad debe ser mayor que cero";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void Test_Debit_InsufficientBalance() {
        String custName = "Joe Brown";
        double credit = 10.00;
        double debit = 50.00;
        Account account = new Account(custName);
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.Credit(credit);
            account.Debit(debit);
        });
        String expectedMessage = "Saldo insuficiente";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));

    }
    @Test
    void testTiempoEjecucion() {
        assertTimeout(Duration.ofMillis(100), () -> {
// Código que debería ejecutarse en menos de 100ms
            Account a = new Account("Pablo");
            ArrayList<Account> accounts = new ArrayList<>();
            for(int i = 0; i<100;i++){
                accounts.add(new Account("a"));
            }
            /*Thread.sleep(50);*/
        });
    }
}




