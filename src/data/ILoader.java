package data;

import model.Livre;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ILoader {

    public Livre load() throws IOException, ClassNotFoundException;
}
