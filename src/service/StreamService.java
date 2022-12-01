package service;

import data.StudentsGroup;
import data.StudentsGroupsStream;
import data.StreamComparator;

import java.util.List;

public class StreamService extends StudentsGroupsStream{
    public StreamService(){
        super();
    }
    public StreamService(List<StudentsGroup> groupList){
        super(groupList);
    }
    public void mySort() {  
        this.studentsGroups.sort(new StreamComparator());
    }
}
