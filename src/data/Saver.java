package data;

import model.Livre;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Saver implements ISaver{
    @Override
    public void save(Livre l) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("livre.bin"))){
            oos.writeObject(l);
        }
    }
}
