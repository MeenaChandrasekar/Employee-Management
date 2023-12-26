package com.employwise1.employeemanagement1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    private static final Logger logger = LoggerFactory.getLogger(CustomErrorController.class);

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        // Get the exception
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            logger.error("Error with status code: {}", statusCode);

            // Add information to the model for the error page
            model.addAttribute("statusCode", statusCode);
            model.addAttribute("errorMessage", getErrorMessage(statusCode));
        }

        // Provide a custom error page (e.g., error.html)
        return "error";
    }

    private String getErrorMessage(int statusCode) {
        // You can customize error messages based on status codes
        switch (statusCode) {
            case 404:
                return "The resource you are looking for was not found.";
            case 500:
                return "An internal server error occurred.";
            // Add more cases as needed
            default:
                return "Something went wrong.";
        }
    }
}
