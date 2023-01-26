package onepf.interview.ExchangeRates.service;

import lombok.extern.slf4j.Slf4j;
import onepf.interview.ExchangeRates.repository.ExchangeRatesDAO;
import onepf.interview.ExchangeRates.entity.ExchangeRate;
import onepf.interview.ExchangeRates.externaldataprocessing.ExternalDataProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ExchangeRateServiceImpl implements ExchangeRateService {

    // Fields
    private ExchangeRatesDAO exchangeRatesDAO;
    private ExternalDataProcessing externalDataProcessing;

    @Autowired
    public ExchangeRateServiceImpl(ExchangeRatesDAO exchangeRateDAO, ExternalDataProcessing theExternalDataProcessing){
        externalDataProcessing = theExternalDataProcessing;
        exchangeRatesDAO = exchangeRateDAO;
    }


    // Methods

    /**
     * public service method returning list of exchange rate instances received from DB table exchange_rate
     * @return List of Exchange Rates entities
     */
    @Override
    @Transactional
    public List<ExchangeRate> listAllFromDB() {
        log.info("method in: ExchangeRateService.listAllFromDB()");
        return exchangeRatesDAO.listAll();
    }

    @Override
    @Transactional
    /**
     * public service method returning list of exchange rate instances received from external API
     * @return List of Exchange Rates entities
     */
    public List<ExchangeRate> listAllFromExtURL() {
        log.info("method in: ExchangeRateService.listAllFromExtURL()");
        List<ExchangeRate> listOfExRatesFromExtURL = externalDataProcessing.getExchangeRateListFromExtApi();
        // saving new external data to DB
        exchangeRatesDAO.ReloadAllDataInDB(listOfExRatesFromExtURL);

        // returning external data to RestController
        return listOfExRatesFromExtURL;
    }
}
