package com.zl.lombok;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2018-12-20
 */
@Setter
@Getter


public class LomBokTestEntiy {

    public LomBokTestEntiy() {

    }

    public void fileExc() {
        try {

            InputStream inputStream = new FileInputStream("D://test.txt");
        } catch ( Exception e ) {
            e.printStackTrace();
        }

    }

    @NonNull
    private String id;
    @NonNull
    private String name;
    private String age;

}
