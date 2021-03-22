package de.maryfro.string_operations.service.operation;

import org.springframework.stereotype.Service;

@Service
public class LowerCaseSO implements IStringOperation {
    public LowerCaseSO() {
    }

    @Override
    public String operate(String input) {
        String res;
        res = input.toLowerCase();
        return res;
    }

    @Override
    public String getName() {
        return "lower_case";
    }
}
