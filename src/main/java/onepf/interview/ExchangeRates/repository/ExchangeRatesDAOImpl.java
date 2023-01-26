package onepf.interview.ExchangeRates.repository;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import onepf.interview.ExchangeRates.entity.ExchangeRate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Repository
public class ExchangeRatesDAOImpl implements ExchangeRatesDAO {
    private EntityManager entityManager;

    @Autowired
    public ExchangeRatesDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    };

    /**
     * Public method returning List of Exchange rate entities fromDB
     * @return List of Exchange rate entities
     */
    @Override
    public List<ExchangeRate> listAll() {
        log.info("method in: ExchangeRatesDAO.listAll()");
        // gets current session
        Session currentHibernateSession = entityManager.unwrap(Session.class);

        //creates SQL query
        Query<ExchangeRate> query = currentHibernateSession.createQuery("from ExchangeRate", ExchangeRate.class);
        log.debug("method in: ExchangeRatesDAO.listAll() - QUERY:" + query.getQueryString());
        //executes SQL query and creates list
        List<ExchangeRate> exchangeRates = query.getResultList();
        log.debug("method in: ExchangeRatesDAO.listAll() - RESULT" + exchangeRates);

        return exchangeRates;
    }

    /**
     * Public method deleting all existing data in DB in table exchange_rate and inserting new data to DB
     * @param newExchangeRateList list of exchange rate entities to be inserted to DB
     */
    @Override
    public void ReloadAllDataInDB(List<ExchangeRate> newExchangeRateList) {
        log.info("method in: ExchangeRatesDAO.ReloadAllDataInDB()");
        deleteAll();
        log.debug("method in: ExchangeRatesDAO.ReloadAllDataInDB() - all data deleted");
        InsertAllFromList(newExchangeRateList);
        log.debug("method in: ExchangeRatesDAO.ReloadAllDataInDB() - new data inserted:" + newExchangeRateList);
    }

    /**
     * private method deleting all data from DB in table exchange_rate
     */
    private void deleteAll(){
        // Gets current session
        log.info("method in: ExchangeRatesDAO.deleteAll()");
        Session currentHibernateSession = entityManager.unwrap(Session.class);

        //creates SQL query
        Query<ExchangeRate> query = currentHibernateSession.createQuery("delete from ExchangeRate");
        log.debug("method in: ExchangeRatesDAO.deleteAll() - QUERY: " + query.getQueryString());
        //executes SQL query
        query.executeUpdate();
    }

    /**
     * private method inserting list of exchange rate entities to db in the table exchange_rate
     * @param exchangeRateList list of exchange rate entities
     */
    @Transactional
    private void InsertAllFromList(List<ExchangeRate> exchangeRateList){
        log.info("method in: ExchangeRatesDAO.InsertAllFromList()");
        log.debug("method in: ExchangeRatesDAO.InsertAllFromList() data in: " + exchangeRateList);
        exchangeRateList.forEach((n) -> save(n));
    }

    /**
     * private method inserting exchange rate entity to db in the table exchange_rate
     * @param exchangeRate instance of ExchangeRate class
     */
    private void save(ExchangeRate exchangeRate){
        log.debug("method in: ExchangeRatesDAO.save() data in: " + exchangeRate);
        // gets current session
        Session currentHibernateSession = entityManager.unwrap(Session.class);
        currentHibernateSession.save(exchangeRate);
        log.debug("method in: ExchangeRatesDAO.save() data saved");
    }
}
