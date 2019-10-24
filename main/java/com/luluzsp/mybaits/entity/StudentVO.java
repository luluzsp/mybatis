package com.luluzsp.mybaits.entity;

import lombok.Data;

import java.util.List;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/10/24 9:03
 * @description：Student查詢類
 * @modified By：
 * @version:
 */
@Data
public class StudentVO {

    private Student student;
    private List<Integer> ids;


}
