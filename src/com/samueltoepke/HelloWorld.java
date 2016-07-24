/*
 * Copyright 2016 Samuel Lee Toepke
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 
package aws_lambda_test;

import com.amazonaws.services.lambda.runtime.Context; 
import com.amazonaws.services.lambda.runtime.LambdaLogger;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

/**
* HelloWorld class. To show workingness of an AWS Lambda function.
* @author  Samuel Lee Toepke
* @version 1.0
*/
public class HelloWorld {

    private static LambdaLogger logger;

   /**
    * HelloWorldHandler method.
	*   Lambda Function:     aws_lambda_test.HelloWorld::HelloWorldHandler
	* @param  input       Map of input, comes in as JSON.
	* @param  context     Lambda context.
	* @return String showing done.
	* @throws IOException In the case of an IO error.
	* @throws InterruptedException In the case of an interrupted error.
	*/
    public String HelloWorldHandler(Map<String,Object> input, Context context) throws IOException, InterruptedException {
		String method = "HelloWorld: ";
		String togo   = "Done.";
		logger        = context.getLogger();
				
		logger.log(method + "STARTING.");

		// 0. Print Event Input.
		logger.log(method + "0. Print Event Input.");
		printEvent(input);
		
		// 1. Print Invocation Time
		logger.log(method + "1. Invocation Time (UTC): " + getCurrentTimeStamp());
		
		logger.log(method + "ENDING.");        	
		
		return togo;
    }
	
   /**
    * printEvent. Prints out the information from the handler call.
	* @param event Event object.
	*/
	private void printEvent(Map<String,Object> event) {
		String method = "..printEvent: ";
		logger.log(method + "STARTING.");
		
		String account     = event.get("account").toString();
		String region      = event.get("region").toString();
		String detail      = event.get("detail").toString();
		String detail_type = event.get("detail-type").toString();
		String source      = event.get("source").toString();
		String time        = event.get("time").toString();
		String id          = event.get("id").toString();
		String resources   = event.get("resources").toString();

        logger.log(method + "account:     " + account);
		logger.log(method + "region:      " + region);
		logger.log(method + "detail_type: " + detail_type);
		logger.log(method + "source:      " + source);
		logger.log(method + "time:        " + time);
		logger.log(method + "id:          " + id);
		logger.log(method + "resources:   " + resources);
		
		logger.log(method + "ENDING.");
	}
	
   /**
    * getCurrentTimeStamp. Returns a String of the current time in UTC.
	* @return String of current time.
	*/
	public String getCurrentTimeStamp() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
	
		Date now       = new Date();
		String strDate = sdf.format(now);
    
		return strDate;
	}
	
}