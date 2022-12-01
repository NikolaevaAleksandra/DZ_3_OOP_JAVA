package service;

import data.StudentsGroup;
import util.ReaderFromTxt;
import util.WriterToTxt;

public class StudentsGroupService implements DataGroupService {
    // Сохранение всей группы в файл
    @Override
    public void create(StudentsGroup studentsGroup) {
        WriterToTxt.writeGroup(studentsGroup,"group.txt");
    }

    // Чтение из файла в объект студенческой группы
    @Override
    public StudentsGroup read(String fileName) {
        return ReaderFromTxt.readGroup("group.txt");
    }
}