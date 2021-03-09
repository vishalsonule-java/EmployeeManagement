package com.mb.EmpMangApp.model;

import java.util.Date;

import lombok.Data;

@Data
public class ErrorInfo {

	private Integer code;
	private String msg;
	private Date date;
}
