Feature: Employee Details Info

Scenario: Get Employee Details base on ID

Given Employee Details API is up and running
When hit url with quary parameter as "/1"
Then API returns the response with status code as 200
And all the Employee details will be return for employee "Tiger Nixon"