package com.eib.projetop2web.mvc.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ICommandController {
	void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
