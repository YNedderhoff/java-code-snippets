package xyz.nedderhoff.javacodesnippets.springapi.transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Repository
public class TransactionalRepositoryImpl implements TransactionalRepository {
    private static final Logger logger = LoggerFactory.getLogger(TransactionalRepository.class);

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public TransactionalRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    @Transactional
    public List<TransactionalEntity> store(List<TransactionalEntity> entities) {
        String insertSql = "insert into entities "
                + "      ( "
                + "         firstName, "
                + "         lastName "
                + "    ) "
                + "  values" + "      ("
                + "          :firstName, "
                + "          :lastName "
                + "    ) ";


        TransactionSynchronizationManager.registerSynchronization(
                new TransactionSynchronization()
                {
                    @Override
                    public void beforeCommit(boolean readOnly) {
                        logger.info("Before commit, readOnly {}", readOnly);
                    }

                    @Override
                    public void beforeCompletion() {
                        logger.info("Before completion");
                    }

                    @Override
                    public void afterCompletion(int status) {
                        logger.info("After completion status {}", status);
                    }

                    @Override
                    public void afterCommit() {
                        logger.info("Post commit");
                    }
                }

        );

        List<MapSqlParameterSource> batchOfInserts = new ArrayList<>();
        for (TransactionalEntity entity : entities) {
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("firstName", entity.getFirstName());
            params.addValue("lastName", entity.getLastName());
            batchOfInserts.add(params);
        }

        int[] insertCounts = new int[0];

        if (batchOfInserts.size() > 0) {
            insertCounts = namedParameterJdbcTemplate.batchUpdate(insertSql, batchOfInserts.toArray(new MapSqlParameterSource[0]));
        }

        System.out.println(Arrays.toString(insertCounts));

        return entities;
    }
}
