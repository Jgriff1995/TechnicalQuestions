# 📂 Interview Questions Repository

This repository is a collection of various interview questions, all implemented in **Java**. Each solution includes additional functionality to enhance understanding, such as **printing histograms** for problems like the Rainwater Trapping problem.

---

### 🔗 Navigation
- [📂 Interview Questions Repository](#-interview-questions-repository)
    - [🔗 Navigation](#-navigation)
  - [🚀 Features](#-features)
  - [🛠️ Usage](#️-usage)
  - [📂 Folder Structure](#-folder-structure)
  - [🤝 Contributions](#-contributions)
  - [☕ **runJava.sh** - Bash Script to Compile and Run Java Programs](#-runjavash---bash-script-to-compile-and-run-java-programs)
    - [**Usage**](#usage)
    - [**Requirements**](#requirements)
    - [**How to make the Script Global**](#how-to-make-the-script-global)
    - [**Notes**](#notes)
  - [🙏 Acknowledgments](#-acknowledgments)

---

## 🚀 Features

- **Java Implementation**: All solutions are written in Java, ensuring clarity and readability.
- **Enhanced Functionality**: Includes additional features like visual representations (e.g., histograms) to better understand the problem and solution.
- **Expected Output**: For each problem, the expected output is provided in `expectedOutput.txt` within the relevant folders. Cloning the repository and running the code without modifications will produce these results.

---

## 🛠️ Usage

1. **Clone the repository**:
   ```bash
   git clone https://github.com/jgriff1995/TechnicalQuestions.git
   ```

2. **Navigate to the specific problem folder**:
   ```bash
   cd TechnicalQuestions/problem_folder
   ```
3. **Run Java code**:
   ```bash
   javac insert_solution_name.java
   java insert_solution_name
   ``` 

4. **Compare the output with the provided expectedOutput.txt to verify correctness.**

## 📂 Folder Structure

```bash
TechnicalQuestions/
├── Rainwater/
│   ├── Solution.java
│   └── expectedOutput.txt
│   
├── Knapsack/
│   ├── Solution.java
│   └── expectedOutput.txt
└── ...
```
## 🤝 Contributions

Contributions are welcome! If you'd like to add more problems, improve existing solutions, or suggest enhancements, feel free to:

1. **Fork the repository**.

2. **Create a new branch** for your changes:
   ```bash
   git checkout -b feature/your-feature-name
   ```
3. **Commit your changes**:
   ```bash
   git commit -m "Add a commit message here"
   ```
4. **Push to the branch**:
   ```bash
   git push origin feature/your-feature-name
   ```
5. **Open a pull request**.


## ☕ **runJava.sh** - Bash Script to Compile and Run Java Programs

This script automates the process of compiling and running Java programs. It handles packages and works from any directory. By default, the script is stored in a `runJava.txt` file. Simply change the file extension from `.txt` to `.sh` to use it. The script can be run either globally or from the root folder.

---

### **Usage**
```bash
runJava <JavaFileName>
```

**Example**
```bash
runJava JumpGame
```

---

### **Requirements**

Java Development Kit (JDK): Ensure javac and java are installed and accessible in your PATH.

---

### **How to make the Script Global**
Move the script to a directory in your PATH, such as ~/bin or /usr/local/bin:

```bash
mv runJava.sh /usr/local/bin/runJava
Make the script executable:
```

```bash
chmod +x /usr/local/bin/runJava
Ensure the directory is in your PATH:
```

```bash
export PATH=$PATH:/usr/local/bin
```

---

### **Notes**

The script assumes the Java file is located in the current directory or its subdirectories.

If the Java file is part of a package, the script will create the necessary directory structure and run the program with the fully qualified class name.

---

## 🙏 Acknowledgments

- Thanks to the open-source community for inspiration and resources!
- Special thanks to [LeetCode](https://leetcode.com/) and [HackerRank](https://www.hackerrank.com/) for providing great problem sets.

---

[🔝 Back to Top](#-interview-questions-repository)