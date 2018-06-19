/**
 * Created by m.krivoshea on 5/11/2018.
 */

public class Contact
{
    public String name;
    public String phone;
    public String email;

    public Contact()
    {
        name = "";
        phone = "";
        email = "";
    }

    public Contact(String nameInput, String phoneInput, String emailInput)
    {
        String name = nameInput;
        String phone = phoneInput;
        String email = emailInput;
    }

    public String getName ()
    {
        return name;
    }

    public String getPhone ()
    {
        return phone;
    }

    public String getEmail ()
    {
        return email;
    }
}
