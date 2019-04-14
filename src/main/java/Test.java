import ATM.ATM;
import etc.Banknote;
import etc.BanknoteComparator;
import etc.Event;

import java.util.Map;
import java.util.TreeMap;


public class Test {



    public static void main(String[] args){

        //Пресеты для АТМ
        Map<Banknote, Long> preset2800 = new TreeMap<>(new BanknoteComparator());
        preset2800.put(Banknote.FIVE_HUNDRED, Long.valueOf("4"));
        preset2800.put(Banknote.TWO_HUNDRED, Long.valueOf("4"));

        Map<Banknote, Long> preset4000 = new TreeMap<>(new BanknoteComparator());
        preset4000.put(Banknote.HUNDRED, Long.valueOf("20"));
        preset4000.put(Banknote.TWO_THOUSAND, Long.valueOf("1"));

        Map<Banknote, Long> preset5000 = new TreeMap<>(new BanknoteComparator());
        preset5000.put(Banknote.TEN, Long.valueOf("100"));
        preset5000.put(Banknote.THOUSAND, Long.valueOf("4"));

        ATMDepartmant atmDepartmant = new ATMDepartmant();

        ATM atm2800 = new ATM(preset2800, atmDepartmant);
        ATM atm4000 = new ATM(preset4000, atmDepartmant);
        ATM atm5000 = new ATM(preset5000, atmDepartmant);

        System.out.println("Balance on all ATM = " + atmDepartmant.getReports(Event.ATM));

        System.out.println("try to issuance banknotes");

        atm2800.issuanceOfBanknotes(700);
        atm4000.issuanceOfBanknotes(1500);
        atm5000.issuanceOfBanknotes(300);

        System.out.println("Balance on all ATM = " + atmDepartmant.getReports(Event.ATM));

        atmDepartmant.notifySubordinate(Event.ATM);

        System.out.println("Balance on all ATM after RESET = " + atmDepartmant.getReports(Event.ATM));

        /*
        System.out.println("DFLT in ATM");
        for(Map.Entry<Banknote, Long> entry : atm.storageDefault.entrySet())
        {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        /*System.out.println("issure Banknotes of 600");
        for(Map.Entry<Banknote, Long> entry : atm.issuanceOfBanknotes(600).entrySet())
        {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("Banknotes in ATM");
        for(Map.Entry<Banknote, Long> entry : atm.remainingBanknotes().entrySet())
        {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("(with error) issure Banknotes of 123");
        for(Map.Entry<Banknote, Long> entry : atm.issuanceOfBanknotes(123).entrySet())
        {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }*/
    }

}

