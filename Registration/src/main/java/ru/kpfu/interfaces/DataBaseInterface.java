package ru.kpfu.interfaces;

import java.io.IOException;

/**
 * Created by Admin on 21.09.2016.
 */
public interface DataBaseInterface {
    public void Writer(String[] message) throws IOException;
    public boolean Reader(String login) throws IOException;
}
