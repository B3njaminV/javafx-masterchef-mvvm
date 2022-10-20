package data;

import model.Livre;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ISaver {

    public void save(Livre l) throws IOException;
}
