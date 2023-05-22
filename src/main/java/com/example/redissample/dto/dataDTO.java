package com.example.redissample.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class dataDTO {
    private String id;
    @SerializedName("bodyDTO") // JSON 필드와 매핑
    private bodyDTO bodyData;
}
