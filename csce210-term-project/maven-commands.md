# **Maven Command Summary**

Use **`./mvnw`** on **macOS/Linux**
Use **`mvnw.cmd`** on **Windows**

This document lists all common Maven Wrapper commands you will need for the course.

---

# ✔ **Compile the Project**

**macOS/Linux:**

```
./mvnw compile
```

**Windows:**

```
mvnw.cmd compile
```

---

# ✔ **Clean + Compile**

**macOS/Linux:**

```
./mvnw clean compile
```

**Windows:**

```
mvnw.cmd clean compile
```

---

# ✔ **Run Tests**

**macOS/Linux:**

```
./mvnw test
```

**Windows:**

```
mvnw.cmd test
```

---

# ✔ **Run Your Java Program**

Replace `your.package.Main` with your actual main class.

**macOS/Linux:**

```
./mvnw exec:java -Dexec.mainClass="your.package.Main"
```

**Windows:**

```
mvnw.cmd exec:java -Dexec.mainClass="your.package.Main"
```

---

# ✔ **Build the ZIP File (for submission)**

**macOS/Linux:**

```
./mvnw clean package
```

**Windows:**

```
mvnw.cmd clean package
```

---

# ✔ **Show the Dependency Tree**

**macOS/Linux:**

```
./mvnw dependency:tree
```

**Windows:**

```
mvnw.cmd dependency:tree
```

---

# ✔ **Skip Tests (not recommended unless instructed)**

**macOS/Linux:**

```
./mvnw -DskipTests package
```

**Windows:**

```
mvnw.cmd -DskipTests package
```

---

# ✔ **Force Re-download of Dependencies**

Run both commands:

**macOS/Linux:**

```
./mvnw dependency:purge-local-repository
./mvnw clean install
```

**Windows:**

```
mvnw.cmd dependency:purge-local-repository
mvnw.cmd clean install
```

---

# ⚠ **If Compilation Fails or Tests Fail**

If your project does *not compile* or your tests fail, but you still need to submit your work, you can still generate a ZIP file.

**macOS/Linux:**

```
./mvnw clean package -Dmaven.compiler.failOnError=false -Dmaven.test.skip=true
```

**Windows:**

```
mvnw.cmd clean package -Dmaven.compiler.failOnError=false -Dmaven.test.skip=true
```

This will:

* **skip tests**,
* **ignore compile errors**,
* still generate the ZIP file in `target/`.

Use only when necessary.