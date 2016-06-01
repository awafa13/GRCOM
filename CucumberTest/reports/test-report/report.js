$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/cucumberfeatures/myfeatures.feature");
formatter.feature({
  "id": "proof-of-concept-that-my-framework-works",
  "description": "",
  "name": "Proof of concept that my framework works",
  "keyword": "Feature",
  "line": 1
});
formatter.scenario({
  "id": "proof-of-concept-that-my-framework-works;my-first-test",
  "description": "",
  "name": "My First Test",
  "keyword": "Scenario",
  "line": 3,
  "type": "scenario"
});
formatter.step({
  "name": "First Test Step",
  "keyword": "Given ",
  "line": 4
});
formatter.step({
  "name": "Second Test step",
  "keyword": "When ",
  "line": 5
});
formatter.step({
  "name": "Third Test Step",
  "keyword": "Then ",
  "line": 6
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "test.second_Test_step()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "test.third_Test_Step()"
});
formatter.result({
  "status": "skipped"
});
});