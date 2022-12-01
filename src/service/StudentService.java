package service;

import data.Student;
import data.User;
import util.ReaderFromTxt;
import util.WriterToTxt;

public class StudentService implements DataService {
   
    @Override
    public void create(User user) {
        if (user instanceof Student){
            WriterToTxt.writeUser(user);
        }
        else System.out.println("Ошибка!");
    }

    
    @Override
    public User read(String fileName) {
        return ReaderFromTxt.readUser(fileName);
    }
}
