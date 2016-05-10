package com.ksr.dao;

import java.sql.SQLException;

public class DAOException extends SQLException {
	
	
	public DAOException(String string) {
		super(string);
	}
    public DAOException(Throwable exception) {
        super(exception);
    }
}
