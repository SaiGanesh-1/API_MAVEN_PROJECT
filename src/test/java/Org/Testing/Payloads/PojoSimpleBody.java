package Org.Testing.Payloads;

public class PojoSimpleBody {
    public static PojoBodyData GetBodyData()
    {
        PojoBodyData data =new PojoBodyData();
        data.setFirstName("Mashatm");
        data.setLastName("Sambad");
        data.setAge(24);
        data.setProfession("Student");
        data.setId(432);


        return data;
    }
}
