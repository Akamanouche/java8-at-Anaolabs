package org.anaolabs.java8.streams.newuse.grouping;

import org.anaolabs.java8.utils.ReadWriteFile;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author t328469
 */
public class CatSubcatGroupingTest {

    ReadWriteFile dataLoader = new ReadWriteFile();

    List<String> data;
    List<CatSubcatData> dataAsObj;

    @Before
    public void setup() throws IOException {

        // Load data from file
        data = dataLoader.readSmallFile("src/test/resources/data/grouping/CatSubcat-relations.data");
        dataAsObj = data.stream()
            .map(line -> new CatSubcatData(line))
            .collect(Collectors.toList());
    }

    @Test
    public void testBasic_JustGroupingAndPrint() {
        Map<String, List<CatSubcatData>> dataGrouped = dataAsObj.stream()
            .collect(Collectors.groupingBy(CatSubcatData::getCategory));

        dataGrouped.entrySet()
            .stream()
            .forEach(e -> System.out.println(String.format("category: '%s' ==> number of subcat(s): %d", e.getKey(), e.getValue().size())));
    }

    @Test
    public void testTransform_ToList() {
        Map<String, List<CatSubcatData>> dataGrouped = dataAsObj.stream()
            .collect(Collectors.groupingBy(CatSubcatData::getCategory));

        Map<String, List<String>> newData = dataGrouped
            .entrySet()
            .stream()
            .collect(Collectors.toMap(
                e -> e.getKey(),
                e -> e.getValue()
                    .stream()
                    .map(csd -> csd.getSubCategory())
                    .collect(Collectors.toList())));

    }

}
