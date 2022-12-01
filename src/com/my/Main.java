package com.my;

import data.*;
import service.DataGroupService;
import service.StudentService;
import service.StudentsGroupService;
import service.StreamService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public class Main {


    public static void main(String[] args) {
        final boolean ASC = true;
        final boolean DESC = false;
        Logger logger = Logger.getAnonymousLogger();
        List<User> userList = new ArrayList<User>();
        StudentsGroup currentGroup = new StudentsGroup(userList);
        List<StudentsGroup> groupList = new ArrayList<StudentsGroup>();
      
        userList.add(new Teacher("Математика","Александр", "11.05.1974"));
        userList.add(new Student("012","Иван", "20.06.1984"));
        userList.add(new Student("013","Павел", "28.01.1985"));
        userList.add(new Student("014","Ирина", "05.08.1984"));
        userList.add(new Student("015","Сергей", "04.09.1983"));
        userList.add(new Student("016","Анна", "17.12.1984"));
        currentGroup.SetMembers(userList);
        groupList.add(new StudentsGroup(currentGroup));

        userList.clear();
        userList.add(new Teacher("Физика","Роман", "11.09.1972"));
        userList.add(new Student("102","Софья", "01.03.1984"));
        userList.add(new Student("103","Наталья", "30.07.1985"));
        userList.add(new Student("104","Петр", "02.06.1984"));
        userList.add(new Student("105","Татьяна", "04.05.1983"));
        userList.add(new Student("106","Андрей", "07.04.1983"));
        userList.add(new Student("107","Алексей", "08.03.1983"));
        currentGroup.SetMembers(userList);
        groupList.add(new StudentsGroup(currentGroup));

        userList.clear();
        userList.add(new Teacher("Химия","Елена", "05.11.1973"));
        userList.add(new Student("202","Дмитрий", "15.05.1984"));
        userList.add(new Student("203","Михаил", "16.06.1985"));
        userList.add(new Student("204","Сергей", "14.07.1984"));
        userList.add(new Student("205","Инна", "13.08.1983"));
        currentGroup.SetMembers(userList);
        groupList.add(new StudentsGroup(currentGroup));

        userList.clear();
        userList.add(new Teacher("Биология","Анастасия", "21.04.1982"));
        userList.add(new Student("302","Кирилл", "10.02.1984"));
        userList.add(new Student("303","Виталий", "20.11.1985"));
        userList.add(new Student("304","Ольга", "30.07.1984"));
        currentGroup.SetMembers(userList);
        groupList.add(new StudentsGroup(currentGroup));

        StreamService groupStream = new StreamService(groupList);

        while (groupStream.hasNext()) {
            for (User s : groupStream.next().getMembers()) {  // Красиво выводим в лог
                logger.info(s.toString());
            }
        }

        logger.info("Посмотрим на группы - выведем учителя и количество членов группы.");

        groupStream.ResetIndex();
        while (groupStream.hasNext()) {
            currentGroup = groupStream.next();
            logger.info("Учитель: " + currentGroup.getTeacher() +
                    " Количество членов группы: " + currentGroup.getSizeOfGroup().toString());
        }

        logger.info("Сортировка групп по количеству членов в них...");

        groupStream.mySort();

        logger.info("Посмотрим на группы после сортировки.");
        groupStream.ResetIndex();
        while (groupStream.hasNext()) {
            currentGroup = groupStream.next();
            logger.info("Учитель: " + currentGroup.getTeacher() +
                    " Количество членов группы: " + currentGroup.getSizeOfGroup().toString());
        }



        logger.info("Работа завершена.");
    }
}