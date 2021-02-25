package xyz.nedderhoff.javacodesnippets.springapi.transactional;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface TransactionalRepository {

    @Transactional
    List<TransactionalEntity> store(List<TransactionalEntity> entities);
}
