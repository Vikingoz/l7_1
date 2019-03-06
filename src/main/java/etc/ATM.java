package etc;

import java.util.*;
import java.util.stream.Collectors;

public class ATM {
    private Map<Banknote, Long> storage;

    public ATM() {
        storage = new TreeMap<>(new BanknoteComparator());
    }

    /*Добавление банкноты*/
    public void AddBanknote (final Banknote banknote, final long value) {
        storage.merge(banknote, value, (k, v) -> Long.sum(v, k) );
    }

    /*Выдача суммы*/
    public Map<Banknote, Long> IssuanceOfBanknotes(final long value) throws ATMException{
        /**Подсчет общей суммы**/
        if (value > RemainingBalance()) {
            throw new ATMException("Too big sum.", storage);
        }
        /**Попоробуем  рассчитать**/
        List<Map.Entry<Banknote, Long>> entryList = storage.entrySet().stream().collect(Collectors.toList());

        for(int i = 0; i < entryList.size(); i++) {
            long val = value;
            Map<Banknote, Long> issurance = new TreeMap<Banknote, Long>(new BanknoteComparator());
            for (int j = i; j < entryList.size(); j++) {

                final long valOfBanknotes = val / entryList.get(j).getKey().getDenomination();
                final long numOfBanknotes = valOfBanknotes > entryList.get(j).getValue() ? entryList.get(j).getValue() : valOfBanknotes;
                issurance.merge(entryList.get(j).getKey(), numOfBanknotes, (k, v) -> Long.sum(v, numOfBanknotes));

                val -= numOfBanknotes * entryList.get(j).getKey().getDenomination();

                if (val == 0) {

                    for(Map.Entry<Banknote, Long> entry: issurance.entrySet()) {
                        storage.merge(entry.getKey(), entry.getValue(), (k, v) -> k - v);
                    }
                    return issurance;
                }
            }
        }
        throw new ATMException("We cant give a sum, sorry.", storage);
    }

    /*Выдача суммы остатка*/
    public long RemainingBalance() {
        long sum = 0;
        for (Map.Entry<Banknote, Long> entry : storage.entrySet()) {
            sum += entry.getKey().getDenomination() * entry.getValue();
        }
        return sum;
    }
    /*Выдача остатка*/
    public Map<Banknote, Long> RemainingBanknotes() {
        return storage;
    }
}
