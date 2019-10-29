package mybaties.enums;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-10-29
 */

/**
 * 这个用默认的EnumTypeHandler 是取的下标值，不是id值
 */
public enum Sex {
    MALE(1, "男"),
    FEMALE(2, "女");
    private int id;
    private String name;

    public static Sex getSex(int id) {
        for (Sex sex : Sex.values()) {
            if (sex.getId() == id) {
                return sex;
            }
        }
        return Sex.MALE;
    }

    Sex(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
