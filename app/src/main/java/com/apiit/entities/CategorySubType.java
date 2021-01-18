package com.apiit.entities;



public class CategorySubType {
    private Integer Id;

    private String subTypeName;

//    @ManyToOne
//    @JoinColumn (name="categorytype_id")
//    private CategoryType categoryTypeObj;
//    @OneToMany(mappedBy = "categorySubTypeobj")
//    private List<Product>productList;

    public CategorySubType() {
    }

    @Override
    public String toString() {
        return subTypeName;
    }

//    public CategoryType getCategoryTypeObj() {
//        return categoryTypeObj;
//    }
//
//    public void setCategoryTypeObj(CategoryType categoryTypeObj) {
//        this.categoryTypeObj = categoryTypeObj;
//    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getSubTypeName() {
        return subTypeName;
    }

    public void setSubTypeName(String subTypeName) {
        this.subTypeName = subTypeName;
    }
}
