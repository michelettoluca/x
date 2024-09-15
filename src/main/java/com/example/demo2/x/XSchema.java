package com.example.demo2.x;


public interface XSchema {
	XSchema nullable();

	XResult safeParse(Object obj);

	void parse(Object obj) throws XException;
}
