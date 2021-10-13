Feature: Create Jira Issue

Scenario: Create Issue in Jira

Given Create Session API is up and running with username as "srabaniadhikary@yahoo.in" & password as "Oxford@456"
And hit Create Session API url with base path as "/session"
When Create Issue API is up and running
And I pass Payload details to create issue
And hit Create Issue API url with base path as "/issue/"
Then New issue will be created with url "http://localhost:8086/rest/api/2/issue/"
And API returns the response with status code display as 201
