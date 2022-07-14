package jdbc;

import java.sql.Connection;

public interface Connector {
    Connection getConnection();
}
