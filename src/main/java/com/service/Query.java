package main.java.com.service;

import java.sql.Connection;
import java.util.Vector;

import main.java.Setting;

public abstract class Query {
    protected static Connection conn = Setting.conMySql();

    public abstract Vector<Vector<String>> query();
}
