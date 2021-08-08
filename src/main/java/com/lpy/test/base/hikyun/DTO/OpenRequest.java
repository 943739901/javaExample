package com.lpy.test.base.hikyun.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class OpenRequest {

    private ArrayList<String> monitorCodes;

    private Long projectId;
}
