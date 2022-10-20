package data;

import model.Livre;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Loader implements ILoader{
    @Override
    public Livre load() throws IOException, ClassNotFoundException {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("livre.bin"))){
            return (Livre) ois.readObject();
        }
    }
}
