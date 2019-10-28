package mybaties;

import org.apache.ibatis.jdbc.SQL;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-10-25
 */
public class SQLBuilder {

    /**
     * INSERT INTO verify_ocr_info
     *  (verify,name,number,start_date,end_date,creat_time,status)
     * VALUES (?,?,?,?,?,?,?)
     * @param args
     */
    public static void main(String[] args) {
        String verify_ocr_info = new SQL()
                .INSERT_INTO("verify_ocr_info")
                .INTO_COLUMNS("verify,name,number,start_date,end_date,creat_time,status")
                .INTO_VALUES("?,?,?,?,?,?,?").toString();
        System.out.println(verify_ocr_info);
    }
}
