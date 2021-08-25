**1- Purpose**

The purpose of this automation script is to automate all of the APIs so that we just need to execute the script for sanity,smoke and Regression testing or every time we get the new build changes from API level.
 
 **2- Scope**
 
 The script provides following features:
 

i- It has different reusable functions which can be accessed from any where of the script.

_Restassured framework follows BDD approach(Given,When,Then)_

There are different reusable functions of  **given** , **when** and **then** which are used on the basis of execution of an API.

`- given()`

Function with no parameter ,this function doesnot take any extra information with the Given statement

`- givenHeaders(Map<String, String> headers)`

Function with one parameter , this function takes header info with the Given statement.

`- givenHeaderPayload(Map<String, String> headers, String payload)`

Function with two parameters, this function takes header info and request payload of an API with the Given statement.

`- givenFormData(Map<String, String> formData)`

Function with one parameter , this function takes multipart form data key and value with the Given statement.

`- givenHeaderFormData(Map<String, String> headers, Map<String,String> formData)`

Function with two parameters , this function takes header info and multipart form data key and value with the Given statement

`- whenFunction(String requestType, String endPoint)`

Function with two parameters , this function takes info of the request type (Get,Post,Put,Delete etc) and the Url of an API with When statement. 

`- thenFunction(int statusCode)`

Function with one parameter , this function takes expected status code of an API with Then statement.

_**It has some other reusable functions which can be used on the basis of requirements.**_

`- printResponse()`

Print JSON response of an API on console.

`- getResponseString()`

Get response of API in string

`- getResponsePath(String key)`

Get path of the response.

`- getResponseLengthByKey(String Key)`

Get length of the response with respect to object of an array

e.g ReusableFunctions.getResponseLengthByKey("data.size()") --> It gives size of the data object.

`- thenObjectmatch (String path, String matchers)`

Checks at least one item which matches the parameter matcher.It can have more items (matching or not), in any order.The matcher is tried on each element until one of them matches, the rest of them is ignored.


`- compareFile(apiResponse,expectedJson,ignoreFields)`

Compare actual response with expected Json and ignore all of the dynamic values which are defined with ignoreFields parameters


ii-  It provides json comparison of static parameters of actual response from expected json file and ignore all of the dynaimc values which will be updating on every execution.
Its function takes three parameters
- Response Payload of an API
- Expected Json file
- list of the field which needs to be ignored
e.g reusableFunctions.compareFile(apiResponse,expectedJson,ignoreFields);

iii- It provides feature of reading path from request paylod and compare it with the path from response payload by usig "json.read" Syntax.
Its function takes two parameters
- Json object of Request payload 
- Json Path
e.g JsonPath.read(RequestPayload,"[0].firstName")



**3- Pre-requisite**

 - Jdk version >= 8

here is the link: 
https://www.oracle.com/java/technologies/javase-downloads.html

- Tool for dev : IntelliJ
- All the required dependencies along with version will be downloaded automatically through pom.xml file

