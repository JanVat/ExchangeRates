package onepf.interview.ExchangeRates.service;

import onepf.interview.ExchangeRates.entity.ExchangeRate;

import java.util.List;

public interface ExchangeRateService {
    // methods
    List<ExchangeRate> listAllFromDB();
    List<ExchangeRate> listAllFromExtURL();
}
