# allure-cucumber-testng

Android Automation test using appium with allure as reporting framewrok and cucumber as scenario framework.

Pre:
1. Run appium server
2. Have connected device

Run as maven

```mvn clean test```

To Generate report:

```mvn site```

# Run with Athena

Pre:
1. already have athena installed
2. Run athena appium

``` athena appium start --port=4444 --apks-dir=app/ --adb-port=5037```
3. run mvn from athena

```athena appium java <tests_dir> [<options>...] [<maven_args>...]```

example:
```athena appium java <tests_dir> clean install```
```athena appium java <tests_dir> site```



