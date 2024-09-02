package data;

public class Person {
    private String fname;
    private String fname_latin;
    private String lname;
    private String lname_latin;
    private String birthdate;
    private String firstSocials;
    private String secondSocials;
    private String firstLink;
    private String secondLink;

    public Person(String fname, String fname_latin, String lname, String lname_latin, String birthdate, String firstSocials, String firstLink, String secondSocials, String secondLink) {
        this.fname = fname;
        this.fname_latin = fname_latin;
        this.lname = lname;
        this.lname_latin = lname_latin;
        this.birthdate = birthdate;
        this.firstSocials = firstSocials;
        this.firstLink = firstLink;
        this.secondSocials = secondSocials;
        this.secondLink = secondLink;
    }

    public String getFirstName() {
        return fname;
    }

    public String getFirstNameLatin() {
        return fname_latin;
    }

    public String getLastName() {
        return lname;
    }

    public String getLastNameLatin() {
        return lname_latin;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getFirstSocials() {
        return firstSocials;
    }

    public String getFirstLink() {
        return firstLink;
    }

    public String getSecondSocials() {
        return secondSocials;
    }

    public String getSecondLink() {
        return secondLink;
    }
}