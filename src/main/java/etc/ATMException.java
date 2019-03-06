package etc;

import java.util.Map;

public class ATMException extends RuntimeException {
    private Map<Banknote, Long> StorageNominal;

    public ATMException(String message, Map<Banknote, Long> storageNominal) {
        super(message);
        StorageNominal = storageNominal;
    }

    public Map<Banknote, Long> getStorageNominal() {
        return StorageNominal;
    }
}
