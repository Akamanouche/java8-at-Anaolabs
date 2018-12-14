package org.anaolabs.java8.streams.newuse.map;

/**
 *
 * @author t328469
 */
public class SubCategeory {

    private final String CAT_SEPARATOR = "\\|\\|";

    String category;

    String name;

    Integer ranking;

    public SubCategeory(String line) {

        String[] token = line.split(CAT_SEPARATOR);
        setCategory(token[0]);
        setName(token[1]);
        setRanking(Integer.valueOf(token[2]));
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

}
