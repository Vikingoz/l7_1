import etc.ATM;
import etc.Banknote;

import java.util.Map;


public class Test {



    public static void main(String[] args){

        ATM atm = new ATM();
        System.out.println(atm.RemainingBalance());
        atm.AddBanknote(Banknote.FIVE_HUNDRED, 2);
        System.out.println(atm.RemainingBalance());
        atm.AddBanknote(Banknote.TEN, 2);
        System.out.println(atm.RemainingBalance());
        atm.AddBanknote(Banknote.FIVE_HUNDRED, 1);
        atm.AddBanknote(Banknote.TWO_HUNDRED, 3);
        atm.AddBanknote(Banknote.FIVE_HUNDRED, 2);
        System.out.println(atm.RemainingBalance());
        atm.AddBanknote(Banknote.TWO_HUNDRED, 3);
        System.out.println("Banknotes in ATM");
        for(Map.Entry<Banknote, Long> entry : atm.RemainingBanknotes().entrySet())
        {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("issure Banknotes of 1700");
        for(Map.Entry<Banknote, Long> entry : atm.IssuanceOfBanknotes(1700).entrySet())
        {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("Banknotes in ATM");
        for(Map.Entry<Banknote, Long> entry : atm.RemainingBanknotes().entrySet())
        {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("issure Banknotes of 600");
        for(Map.Entry<Banknote, Long> entry : atm.IssuanceOfBanknotes(600).entrySet())
        {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("Banknotes in ATM");
        for(Map.Entry<Banknote, Long> entry : atm.RemainingBanknotes().entrySet())
        {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("(with error) issure Banknotes of 123");
        for(Map.Entry<Banknote, Long> entry : atm.IssuanceOfBanknotes(123).entrySet())
        {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

}

