package com.yaofei.springmvcmybatis.webapp.dto;

/**
 * Created by f_yao on 2017/2/14.
 */
public class TreeNode {
    private Long id;
    private Long pId;
    private String name;
    private Boolean checked;
    private Boolean open;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the pId
     */
    public Long getPId() {
        return pId;
    }

    /**
     * @param id the pId to set
     */
    public void setPId(Long id) {
        pId = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the checked
     */
    public Boolean isChecked() {
        return checked;
    }

    /**
     * @param checked the checked to set
     */
    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    /**
     * @return the open
     */
    public Boolean isOpen() {
        return open;
    }

    /**
     * @param open the open to set
     */
    public void setOpen(Boolean open) {
        this.open = open;
    }

    public TreeNode(Long id, Long pId, String name, Boolean checked, Boolean open) {
        super();
        this.id = id;
        this.pId = pId;
        this.name = name;
        this.checked = checked;
        this.open = open;
    }

    public TreeNode() {
        super();
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                ", pId=" + pId +
                ", name='" + name + '\'' +
                ", checked=" + checked +
                ", open=" + open +
                '}';
    }
}
