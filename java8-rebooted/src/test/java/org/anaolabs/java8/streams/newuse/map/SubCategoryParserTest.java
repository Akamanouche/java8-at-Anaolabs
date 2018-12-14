package org.anaolabs.java8.streams.newuse.map;

import org.anaolabs.java8.utils.ReadWriteFile;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

/**
 * Ici on teste :
 * - le "map" de Stream : Stream<String> ==> Stream<Object>
 * - le "sort" sur Object
 * 
 * @author t328469
 */
public class SubCategoryParserTest {

    ReadWriteFile dataLoader = new ReadWriteFile();

    List<String> data;

    @Before
    public void setup() throws IOException {

        // Mock data
        data = dataLoader.readSmallFile("src/test/resources/data/categoriesSubCategories.data");
    }

    @Test
    public void testDisplayAllSubCategories() throws Exception {

        // Display Streams
        data.stream()
            .map(line -> new SubCategeory(line))
            .forEach(sc ->
                {
                    System.out.println(String.format("\tCategory: %s || SubCategory: '%s' || rank: %d", sc.getCategory(), sc.getName(), sc.getRanking()));
                });
    }

    @Test
    public void testFilterSubCategories() throws Exception {

        // Display Streams
        data.stream()
            .map(line -> new SubCategeory(line))
            .filter(sc -> sc.getCategory().equals("Airport"))
            .forEach(sc ->
                {
                    System.out.println(String.format("\tCategory: %s || SubCategory: '%s' || rank: %d", sc.getCategory(), sc.getName(), sc.getRanking()));
                });
    }

    @Test
    public void testFilterAndOrderSubCategories() throws Exception {

        // Display Streams
        data.stream()
            .map(line -> new SubCategeory(line))
            .filter(sc -> sc.getCategory().equals("Airport"))
            .sorted(Comparator.comparing(SubCategeory::getRanking))
            .forEach(sc ->
                {
                    System.out.println(String.format("\tCategory: %s || SubCategory: '%s' || rank: %d", sc.getCategory(), sc.getName(), sc.getRanking()));
                });
    }

}
