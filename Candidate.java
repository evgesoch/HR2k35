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

	/**
     * Returns the id of a candidate.
     *
     * @return The id as an {@code int}
     */
    public int getId() {
        return id;
    }

	/**
     * Returns the name of a candidate.
     *
     * @return The name as a {@code String}
     */
    public String getName() {
        return name;
    }

	/**
     * Returns the e-mail of a candidate.
     *
     * @return The e-mail as a {@code String}
     */
    public String getEmail() {
        return email;
    }

	/**
     * Returns the telephone of a candidate.
     *
     * @return The telephone as a {@code String}
     */
    public String getPhone() {
        return phone;
    }

	/**
     * Returns the date of birth of a candidate.
     *
     * @return The date of birth as a {@code String}
     */
    public String getDob() {
        return dob;
    }

	/**
     * Returns the profession of a candidate.
     *
     * @return The profession as a {@code String}
     */
    public String getProfession() {
        return profession;
    }

	/**
     * Returns the city of a candidate.
     *
     * @return The city as a {@code String}
     */
    public String getCity() {
        return city;
    }

	/**
     * Sets the id of a candidate.
     */
    public void setId(int id) {
        this.id = id;
    }

	/**
     * Sets the name of a candidate.
     */
    public void setName(String name) {
        this.name = name;
    }

	/**
     * Sets the e-mail of a candidate.
     */
    public void setEmail(String email) {
        this.email = email;
    }

	/**
     * Sets the telephone of a candidate.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

	/**
     * Sets the date of birth of a candidate.
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

	/**
     * Sets the profession of a candidate.
     */
    public void setProfession(String profession) {
        this.profession = profession;
    }

	/**
     * Sets the city of a candidate.
     */
    public void setCity(String city) {
        this.city = city;
    }
}

