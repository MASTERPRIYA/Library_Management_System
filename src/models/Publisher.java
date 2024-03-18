package models;

public class Publisher {
    private Integer publisherId;
    private User user;
    private String registrationNum;
    private String website;

// =====================================================================
    public Publisher(Integer publisherId, User user,String registrationNum,String website){
        this.publisherId=publisherId;
        this.user=user;
        this.registrationNum=registrationNum;
        this.website=website;
    }
    
    public Publisher(Integer publisherId){
        this.publisherId=publisherId;
    }
// =====================================================================

    public Integer getPublisherId() {
        return publisherId;
    }
    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }
    
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public String getRegistrationNum() {
        return registrationNum;
    }
    public void setRegistrationNum(String registrationNum) {
        this.registrationNum = registrationNum;
    }

    public String getWebsite(){
        return website;
    }
    public void setWebsite(String website){
        this.website = website;
    }
    
    
}
