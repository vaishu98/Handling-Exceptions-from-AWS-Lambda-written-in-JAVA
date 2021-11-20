package com.appdevelopersblog.aws.lambda;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.amazonaws.services.lambda.runtime.Context;
import com.appdevelopersblog.aws.lambda.Request.Request;
import com.appdevelopersblog.aws.lambda.model.Student;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

import javax.security.auth.callback.Callback;

public class RequestHandler extends SpringBootRequestHandler<String,Object> {
    public Object handleRequest(Request request, Context context, Callback callback){
        AmazonDynamoDB adb = AmazonDynamoDBClientBuilder.defaultClient();
        DynamoDBMapper mapper = new DynamoDBMapper(adb);
        Student student = null;
        switch (request.getHttpMethod()) {
            case "GET" :
                student = mapper.load(Student.class,request.getId());
                if (student == null) {
                    throw new ResourceNotFoundException("Resource Not Found "+request.getId());
                }
                return student;
            case "POST" :
                student = request.getStudent();
                mapper.save(student);
                return student;
            case "default" :
                break;
        }
        return null;
    }
}
