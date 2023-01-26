package onepf.interview.ExchangeRates.controller;

import lombok.extern.slf4j.Slf4j;
import onepf.interview.ExchangeRates.entity.ExchangeRate;
import onepf.interview.ExchangeRates.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
@CrossOrigin()
public class ExRatesRestAPIController {
    private ExchangeRateService exchangeRateService;

    @Autowired
    public ExRatesRestAPIController(ExchangeRateService exRaDAO){
        exchangeRateService = exRaDAO;
    }

    /**
     * http://localhost:8080/api/list
     * GET REST API returning List of entites ExchangeRate form DB or external source, by parameter usedb. Default value set to True.
     * @param usedb string param with default setting True. If "false" API will get data from external URL and save them to DB
     * @return List of ExchangeRate entites
     */
    @GetMapping("/list")
    public List<ExchangeRate> list(@RequestParam(value = "usedb", defaultValue = "true") String usedb){
        log.info("method in: ExRatesRestAPIController.list() GET http://localhost:8080/api/list?" + usedb);
        List<ExchangeRate> listOfEntities;
        if(usedb.equals("false")){
            log.info("method in: ExRatesRestAPIController.list() getting data from external URL");
            listOfEntities = exchangeRateService.listAllFromExtURL();
            log.info("method in: ExRatesRestAPIController.list() data from external URL: " + listOfEntities);
            return listOfEntities;
        } else {
            log.info("method in: ExRatesRestAPIController.list() getting data from DB");
            listOfEntities = exchangeRateService.listAllFromDB();
            log.info("method in: ExRatesRestAPIController.list() data from DB: " + listOfEntities);
            return listOfEntities;
        }

    }
}
