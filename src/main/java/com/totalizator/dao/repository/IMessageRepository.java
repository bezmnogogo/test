package com.totalizator.dao.repository;

import com.totalizator.dao.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kasyanov on 6/14/2016.
 */
@Repository
public interface IMessageRepository extends JpaRepository<Message,Long> {
}
