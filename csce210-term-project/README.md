# **How Java Programs Are Compiled and Run (and What Maven Does)**

Before working on assignments in this course, it’s important to understand what actually happens when a Java program runs.

### **1. Java Source Code (`.java` files)**

When you write Java code, you create human-readable files ending in:

```
.java
```

These cannot run directly.

### **2. Compilation: Converting `.java` → `.class`**

Java programs must be **compiled** before they run.

The Java compiler (`javac`) translates your source files into **bytecode** files ending in:

```
.class
```

Bytecode is a machine-independent format understood by the Java Virtual Machine.

### **3. Running Java Programs**

Once compiled, the **Java Virtual Machine (JVM)** executes the bytecode:

```
java ClassName
```

Larger projects often contain dozens of classes and external libraries, so compiling and running everything manually is difficult.

### **4. What Maven Does for You**

Maven is a build automation tool.
In this course, we use the **Maven Wrapper**, which means:

✔ You do **not** install Maven
✔ The project builds in the same way on macOS, Windows, and Linux
✔ You use simple commands such as `mvnw test` or `mvnw package`

Maven automatically:

* Compiles your Java source files
* Runs your unit tests
* Downloads and manages libraries (“dependencies”)
* Packages your project (including the ZIP file you submit to Canvas)

You won’t run `javac` or `java` manually — Maven handles everything for you using the project’s `pom.xml`.

---

# CSCE 210 — Project Instructions

This project uses the **Maven Wrapper**, which means **you do NOT need to install Maven** on your computer.
You will run all Maven commands using the scripts included in the project.

Use the commands below depending on your operating system.

---

## 🖥️ Operating System Notes

### **macOS & Linux users**

Run commands with:

```
./mvnw
```

(Notice the `./` at the beginning.)

### **Windows users**

Run commands with:

```
mvnw.cmd
```

(NO `./` at the beginning.)

---

# ✔ 1. Compile the Project

**macOS/Linux:**

```
./mvnw clean compile
```

**Windows:**

```
mvnw.cmd clean compile
```

---

# ✔ 2. Run the Tests

**macOS/Linux:**

```
./mvnw test
```

**Windows:**

```
mvnw.cmd test
```

---

# ✔ 3. Run the Program (if your project has a main class)

Replace `your.package.Main` with the actual fully qualified class name.

**macOS/Linux:**

```
./mvnw exec:java -Dexec.mainClass="your.package.Main"
```

**Windows:**

```
mvnw.cmd exec:java -Dexec.mainClass="your.package.Main"
```

---

# ✔ 4. Build the ZIP File for Submission

The project is configured to produce a ZIP file when you run `package`.

**macOS/Linux:**

```
./mvnw clean package
```

If your project does not compile or unit tests fail, you need to run the following command to
create the package.

```
./mvnw clean package -Dmaven.compiler.failOnError=false -Dmaven.test.skip=true
```

**Windows:**

```
mvnw.cmd clean package
```

If your project does not compile or unit tests fail, you need to run the following command to
create the package.

```
mvnw.cmd clean package -Dmaven.compiler.failOnError=false -Dmaven.test.skip=true
```

When it finishes, look in the:

```
target/
```

folder for a file ending in `.zip`.
**Upload that ZIP file to Canvas.**

---

# ✔ 5. Show the Dependency Tree (optional)

Useful when checking for library conflicts.

**macOS/Linux:**

```
./mvnw dependency:tree
```

**Windows:**

```
mvnw.cmd dependency:tree
```

---

# 📁 6. Project Structure Explained

Your project follows the standard Maven directory layout:

```
project/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── (your Java source files)
│   │
│   └── test/
│       └── java/
│           └── (your JUnit test files)
│
├── pom.xml        (Maven configuration file)
├── mvnw           (Maven Wrapper for macOS/Linux)
├── mvnw.cmd       (Maven Wrapper for Windows)
└── .mvn/          (Maven Wrapper support files)
```

---

## **Where to write your code**

This project will be used for **all programming assignments** in the course.

You will **not** create a new project for each assignment.
Instead, you will add new code to this project under **different package names**.

### **Starter Package Provided**

The ZIP file you download contains this example in both source trees:

```
src/main/java/edu/noctrl/sp26/example/App.java
src/test/java/edu/noctrl/sp26/example/AppTest.java
```

Use this as a reference for the correct directory and package layout.

### **Package Naming for Assignments**

For each assignment, **I will tell you the exact package name to use**.

All packages in this course will **begin with**:

```
edu.noctrl.sp26
```

You will add the assignment’s package under:

* **Source code:**
  `src/main/java/`
* **Unit tests:**
  `src/test/java/`

The directory must match the package name exactly.

Example assignment package:

```
edu.noctrl.sp26.project1
```

Directory structure:

```
src/main/java/edu/noctrl/sp26/project1/
src/test/java/edu/noctrl/sp26/project1/
```

Place all `.java` files for the assignment in the correct directories.

---

# ☕ 7. Note About Java 8

This course uses **Java 8 (JDK 1.8)** for all programming assignments.

### ✔ Why Java 8?

* It avoids exposing you to advanced Java features before you are ready.
* It supports the core concepts we focus on in Data Structures.
* It provides a consistent, stable environment across macOS, Windows, and Linux.

# ⚙️ 8. Misc Settings and Troubleshooting

This section contains various settings that may be needed.

### IntelliJ Freezes after macOS Sleeps

* IntelliJ > Help > Edit Custom VM Options
* Add the following line to the idea.vmoptions file
```
-Dsun.java2d.metal=false
```

