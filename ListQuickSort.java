// Ben Fristad

import java.io.*;
import java.util.*;

public class ListQuickSort
{
    public static void main(String[] args) throws Exception
    {
        DLinkedList numberList = new DLinkedList();
        String fileName = args[0];
        fillDLinkedList(numberList, fileName);
        numberList.quickSort(numberList.getFirst(), numberList.getLast());
        numberList.printResults();
        
    }// end main
    
    public static DLinkedList fillDLinkedList(DLinkedList numberList, String fileName) throws Exception
    {
        File dataFile = openInputFile(fileName);
        Scanner fileScanner = new Scanner(dataFile);

        while(fileScanner.hasNextLine())
        {
            DNode newNode = new DNode(fileScanner.nextLine(), null, null);
            numberList.addLast(newNode);

        }// end while loop

        fileScanner.close();

        return numberList;

    }// end fillDLinkedList

    public static File openInputFile(String fileName)
    {
        if(fileName == null || fileName == "")
            throw new IllegalArgumentException("Invalid File Name");
        
        File inputFile = new File(fileName);

        if(!inputFile.exists())
            throw new RuntimeException("File does not exist");
        
            return inputFile;

    }// end openInputFile
    
}// end class

