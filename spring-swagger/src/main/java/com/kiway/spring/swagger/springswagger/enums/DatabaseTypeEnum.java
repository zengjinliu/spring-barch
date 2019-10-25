package com.kiway.spring.swagger.springswagger.enums;

import lombok.Data;
import lombok.Getter;

/**
 * @author LiuZj
 * @date 2019/9/24 15:33
 */
@Getter
public enum  DatabaseTypeEnum {

    PRIMARY("1"),
    USER("2");

    private String code;

    DatabaseTypeEnum(String code) {
        this.code = code;
    }
    public static DatabaseTypeEnum getDatabaseTypeEnum(String code) {
        for (DatabaseTypeEnum databaseTypeEnum : DatabaseTypeEnum.values()) {
            if (databaseTypeEnum.getCode().equals(code)) {
                return databaseTypeEnum;
            }
        }
        return null;
    }


}
