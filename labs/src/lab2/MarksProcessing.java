package lab2;

import java.util.Map;
import java.util.TreeMap;

public class MarksProcessing {

    static GenericList<MarkRecord> generateRandomMarkRecords(int nStudents, int nModules) {
        GenericList<MarkRecord> records = new GenericArrayList<>();
        for (int i = 0; i < nStudents; i++) {
            for (int j = 0; j < nModules; j++) {
                records.append(new MarkRecord(i, j, (int) (Math.random() * 100)));
            }
        }
        return records;
    }

    static double average(GenericList<Integer> data) {
        double average = 0;
        for (int values : data) {
            average += (double) values;
            System.out.println(values);
        }
        average = average / data.length();
        return average;
    }

    static void printStats(MarksData data) {
        for (Map.Entry<Integer, GenericList<Integer>> values : data.moduleMap.entrySet())
        {
            double average = average(values.getValue());
            System.out.println("Average of module " + values.getKey() + " is : " + average);
        }

        for (Map.Entry<Integer, GenericList<Integer>> values : data.studentMap.entrySet())
        {
            double average = average(values.getValue());
            System.out.println("Average of student " + values.getKey() + " is : " + average);
        }
    }

    //process a set of student marks for a set of modules
    public static void main(String[] args) {
        GenericList<MarkRecord> marks = generateRandomMarkRecords(5, 2);
        for (MarkRecord mark : marks) {
            System.out.println(mark);
        }
        MarksData processedMarks = new MarksData();
        for (MarkRecord mark: marks) {
            processedMarks.addRecord(mark);
        }
        System.out.println();
        System.out.println(processedMarks.moduleMap);
        System.out.println();
        System.out.println(processedMarks.studentMap);
        System.out.println();
        printStats(processedMarks);
    }
}
//////////////////////////////
record MarkRecord(int studentId, int modueleId, int mark) {
}
//////////////////////////////
class MarksData {
    Map<Integer, GenericList<Integer>> moduleMap = new TreeMap<>();
    Map<Integer, GenericList<Integer>> studentMap = new TreeMap<>();

    void addRecord(MarkRecord record){
        //add the record to the module marks
        GenericList<Integer> moduleMarks =
                moduleMap.computeIfAbsent(record.modueleId(), k -> new GenericArrayList<>());
        moduleMarks.append(record.mark());

        GenericList<Integer> studentMarks =
                studentMap.computeIfAbsent(record.studentId(), k -> new GenericArrayList<>());
        studentMarks.append(record.mark());
    }
}
//////////////////////////////
