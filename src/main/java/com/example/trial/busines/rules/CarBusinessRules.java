package com.example.trial.busines.rules;

import com.example.trial.dataAccess.CarRepository;
import com.example.trial.exception.NumberException;
import com.example.trial.exception.UnLogicException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class CarBusinessRules {
    private final CarRepository carRepository;

    public void dailyPriceIsGreaterThan(Integer dailyPrice) {
        if (carRepository.countCarByDailyPriceIsGreaterThan(dailyPrice) > 100) {
            throw new NumberException("Daily price should not be big of daily price.");
        }
    }

    public void dailyPriceInvalid(Integer dailyPrice) {
        if (dailyPrice <= 0) {
            throw new UnLogicException("Daily price is unlogicxx");
        }
    }

    public void plateInvalid(String plateName) {
        if (plateName.length() > 20) {
            throw new UnLogicException("Daily price is unlogic");
        }
    }
}
