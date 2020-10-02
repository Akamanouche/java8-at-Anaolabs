package org.anaolabs.java8.streams.newuse.grouping.afklm;

/**
 * Handles a relation Category/SubCategory as provided in {@link DataInFileEnum#CATEG_SUBCATEG_RELATIONS}
 *
 * @author t328469
 */
public class CatSubcatData {

    /* Categories and SubCategories Separator pattern */
    private static final String DATA_FILE_DELIMITER = "::";

    /* Fiels to map */
    private String category;
    private int categoryRanking;
    private String subCategory;
    private int subCategoryRanking;
    private boolean selfService;

    ///////////////////////////////////////////////////////////////////////////
    // Constructors
    ///////////////////////////////////////////////////////////////////////////

    public CatSubcatData(String line) {
        String[] token = line.split(DATA_FILE_DELIMITER);
        setCategory(token[0]);
        setCategoryRanking(Integer.parseInt(token[1]));
        setSubCategory(token[2]);
        setSubCategoryRanking(Integer.parseInt(token[3]));
        setSelfService(Boolean.parseBoolean(token[4]));
    }

    public CatSubcatData(String category, int categoryRanking, String subCategory, int subCategoryRanking, boolean selfService) {
        super();
        this.category = category;
        this.categoryRanking = categoryRanking;
        this.subCategory = subCategory;
        this.subCategoryRanking = subCategoryRanking;
        this.selfService = selfService;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Getters/Setters boilerplate
    ///////////////////////////////////////////////////////////////////////////

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the categoryRanking
     */
    public int getCategoryRanking() {
        return categoryRanking;
    }

    /**
     * @param categoryRanking the categoryRanking to set
     */
    public void setCategoryRanking(int categoryRanking) {
        this.categoryRanking = categoryRanking;
    }

    /**
     * @return the subCategory
     */
    public String getSubCategory() {
        return subCategory;
    }

    /**
     * @param subCategory the subCategory to set
     */
    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    /**
     * @return the subCategoryRanking
     */
    public int getSubCategoryRanking() {
        return subCategoryRanking;
    }

    /**
     * @param subCategoryRanking the subCategoryRanking to set
     */
    public void setSubCategoryRanking(int subCategoryRanking) {
        this.subCategoryRanking = subCategoryRanking;
    }

    /**
     * @return the selfService
     */
    public boolean isSelfService() {
        return selfService;
    }

    /**
     * @param selfService the selfService to set
     */
    public void setSelfService(boolean selfService) {
        this.selfService = selfService;
    }

}
