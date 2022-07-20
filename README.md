# Springboot Etag Filter
* To make the browser understand if we provide the same content again the browser will send same respone. To stop same response from server and refresh the page with same content we can use `etag` with bean:
  ```
  @Bean
    ShallowEtagHeaderFilter shallowEtagHeaderFilter(){
        return new ShallowEtagHeaderFilter();
    }
  ```
* Open browser and hit below url and check in network by inspecting the page.
    > http://localhost:8080/hello/rajeev
  
* When we check on `ResponseHeaders` we will see there `ETag` with value which is hash value.
  
* When we refresh the page it will send the Etag hash value again so browser will no it is the same request.
* Also in the General tab at first request the `status code` is 200 but if we refresh the page the `status code` is 304.
* In `Request Headers` we can see the `If-None-Match` value whose value is equal to `Etag` value
* If the request value is different it will again has status code 200 because the request data is different.
* From postman we can check this by passing `If-None-Match` in headers with etag value got in response header. At first it will give status code as 200 and if we send same request data it will give 304 not modified and there is no response from server.
* We can customize etag value by passing value to etag in response entity.
* For specific endpoint to apply etag we have to use `FilterRegistrationBean`.