package ru.curs.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.curs.celesta.Celesta;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class DatabasePostProcessingService {
    private final Celesta celesta;

    public DatabasePostProcessingService(@Autowired Celesta celesta) {
        this.celesta = celesta;
    }

    @PostConstruct
    void postProcess() {
        try (Connection connection = celesta.getConnectionPool().get();
             Statement statement = connection.createStatement();
        ) {
            //statement.execute( WHATEVER SQL YOU WANT);
        } catch (SQLException e) {
            IllegalStateException error = new IllegalStateException("Database error");
            error.initCause(e);
            throw error;
        }
    }
}
