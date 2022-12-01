package data;

import java.util.Comparator;

public class StreamComparator implements Comparator<StudentsGroup>{
    // Сравнение 2-х групп по количеству членов в них
    @Override
    public int compare(StudentsGroup aGroup, StudentsGroup bGroup) {
        return Integer.compare(aGroup.getSizeOfGroup(),bGroup.getSizeOfGroup());
    }
}
