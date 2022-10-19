package Org.Testing.Payloads;

public class PojoSimpleUpdatedData {

    public static PojoBodyData GetUpdatedBodyData()
    {
        PojoBodyData data=new PojoBodyData();
        data.setFirstName("Rambala");
        data.setLastName("LGoswami");
        data.setAge(21);
        data.setProfession("Student");
        data.setId(2027);
        return data;
    }

}
