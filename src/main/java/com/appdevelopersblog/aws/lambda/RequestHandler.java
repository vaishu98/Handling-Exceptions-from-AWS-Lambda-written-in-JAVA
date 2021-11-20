package com.appdevelopersblog.aws.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.appdevelopersblog.aws.lambda.request.Request;
import com.appdevelopersblog.aws.lambda.model.Student;
import com.appdevelopersblog.aws.lambda.exceptions.MyException;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public class RequestHandler extends SpringBootRequestHandler<String,Object> {
    public Object handleRequest(Request request, Context context){
        Student student = null;
        switch (request.getHttpMethod()) {
            case "POST" :
                student = request.getStudent();
                if (student.getAge()<10){
                    throw new MyException("Bad Request, High school student cannot have age less than 10 years");
                }
                //Logic to save the student details into repository
                return student;
            case "default" :
                break;
        }
        return null;
    }
}
