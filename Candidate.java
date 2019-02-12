public class Candidate {

    private int id;
    private String name;
    private String email;
    private String phone;
    private String dob;
    private String profession;
    private String city;

    /**
     * Overloaded constructor to put no data and use setters to insert is afterwards
     */
    public Candidate(){

    }

    /** Overloaded constructor to put all the data when creating the object
     * @param name
     * @param email
     * @param phone
     * @param dob             IMPORTANT: dob format: YYYY-MM-DD, for example 1992-02-23
     * @param profession
     * @param city
     */
    public Candidate(String name, String email, String phone, String dob, String profession, String city){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
        this.profession = profession;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getDob() {
        return dob;
    }

    public String getProfession() {
        return profession;
    }

    public String getCity() {
        return city;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

