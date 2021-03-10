package ie.gmit;

public class Employee {

    private String Title;
    private String Name;
    private String PPS_ID;
    private String Phone;
    private String Employement_Type;
    private int Age;

    public Employee(String Title, String Name, String PPS_ID, String Phone, String Employement_Type, int Age) {
        setTitle(Title);
        setName(Name);
        setPPS_ID(PPS_ID);
        setPhone(Phone);
        setEmployement_Type(Employement_Type);
        setAge(Age);
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        if ( title.equals("Mr") || title.equals("Mrs") || title.equals("Miss"))
            Title = title;
        else
            throw new IllegalArgumentException("Invalid employee title");
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        if (name.length() <= 5)
            throw new IllegalArgumentException("Employee name must contain atleast 5 characters");
        else if (name.length() >= 22)
            throw new IllegalArgumentException("Employee name must be less than 22 characters");
        else
            Name = name;
    }

    public String getPPS_ID() {
        return PPS_ID;
    }

    public void setPPS_ID(String PPS_ID) {
        if (PPS_ID.length() == 6)
            this.PPS_ID = PPS_ID;
        else
            throw new IllegalArgumentException("Employee PPS should be 6 characters");
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        if (phone.length() == 7)
            Phone = phone;
        else
            throw new IllegalArgumentException("Employee phone number should be 7 characters");
    }

    public String getEmployement_Type() {
        return Employement_Type;
    }

    public void setEmployement_Type(String employement_Type) {
        if (employement_Type.equals("Full-time") || employement_Type.equals("Part-time"))
            Employement_Type = employement_Type;
        else
            throw new IllegalArgumentException("Invalid employee employement type");
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        if (age > 18)
            Age = age;
        else
            throw new IllegalArgumentException("Age must be over 18");
    }
}
