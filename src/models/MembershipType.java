package models;

public class MembershipType {

    private Integer membershipTypeId;
    private String type;



    public Integer getMembershiptypeId() {
        return membershipTypeId;
    }
    public void setMembershipTypeId(Integer membershipTypeId) {
        this.membershipTypeId = membershipTypeId;
    }
    
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    } 
}
