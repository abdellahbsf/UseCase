# flicker
# Binary Instrumenter for Collecting Application Data

The binary instrumenter, represented by the `minerva-agent-1.0.jar`, is a Java-based agent designed to instrument the byte code of Java monolithic applications. This instrumentation enables the collection of runtime traces when these applications run.

## Prerequisites

- Your application must be installed and running on a server or Liberty.
- The static analysis step should have been executed beforehand.

## Procedure

1. Verify that you have a directory containing three JSON files generated by the static analysis.

2. Configure the application server by adding the following argument to its Java virtual machine (JVM):

   ```bash
   -javaagent:./instrumenter/minerva-agent-1.0.jar=<agent-config-path>
   ```
- <agent-config-path> is the fully qualified path of the directory containing the three JSON files created by the code analyzer.
  
### Note:

- If your application is installed and running on WebSphere Application Server, use the administrative console to specify the JVM argument.
- If your application is on Liberty, create or update a jvm.options file to specify the JVM argument.

Start the application server and your application with the -javaagent JVM argument enabled.

# Recording Business Use Cases Interactively

When both the use case recorder and the application server are running on the same machine, execute the following command in your terminal:

```bash
cd UseCase
javac usecase_w.java
java usecase
```

## Terminal

By initiating this action, you will launch a terminal on your device, allowing you to commence the recording of usage scenarios. Simply follow the prompts provided. Upon completion of the recording process, a confirmation message will be displayed, signifying the successful execution of the command. Consequently, a JSON file will be appended to your current directory.

<img width="560" alt="50" src="https://github.com/abdellahbsf/flicker/assets/56552282/89b65bf8-4352-4e35-9d1b-c3f9e9190623">
