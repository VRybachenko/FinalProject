##  FinalProject

### Education project on base this shop: http://magento.mainacad.com

#### In this project were using next languages, technologies and pattern:
1. TestNG
2. Allure (for reporting)
3. Selenium
4. Cucumber
5. PageObject pattern
6. Java 8
7. Gherkin

#### Features:
- It possible to run tests from command line
- It possible to run tests in multithreading mode
- Test results possible to be present in Allure report
- After every fail steps in Allure report will present screenshot with last fail step

##### Running Tests From Command Line:
```bash
mvn clean test
```
##### Running Tests From Command Line in multithreading mode:
```bash
mvn clean test -Dthreads=2 (count of the threads, "2 threads" -Dthreads=2 for example) 
```
##### Test results in Allure report:
```bash
mvn allure:serve
```
##### Annotations in tests:
###### 1.You can mute tests via next annotation:
```bash
@Muted
```