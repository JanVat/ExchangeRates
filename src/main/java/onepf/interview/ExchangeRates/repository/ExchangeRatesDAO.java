package onepf.interview.ExchangeRates.repository;

import onepf.interview.ExchangeRates.entity.ExchangeRate;

import java.util.List;

public interface ExchangeRatesDAO {
    List<ExchangeRate> listAll();
    void ReloadAllDataInDB(List<ExchangeRate> newExchangeRateList);
}
