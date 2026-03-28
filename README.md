# Vityarthi_Project
## Student Expense Tracker
A Java-based console application designed for students to track their daily spending, manage categories, and maintain financial records through persistent file storage.

---

### Overview
The **Student Expense Tracker** is a streamlined tool that helps students monitor their finances by recording expenditures across various categories like Food, Travel, and Books. It focuses on core financial literacy by providing automated totals, category-wise summaries, and local data persistence.

---

### Features

#### **Transaction Management**
* **Add Expense**: Record new spending with specific amounts, categories, and dates.
* **View All Expenses**: Display a formatted table of all recorded transactions with serial numbers.
* **Auto-Save**: Every new entry is automatically synchronized to a local text file for data safety.

#### **Financial Analytics**
* **Total Expenditure**: Instantly calculate the sum of all recorded expenses.
* **Category-wise Summary**: View a breakdown of spending grouped by category using `HashMap` logic.
* **Data Persistence**: Automatically loads previous records from `expenses.txt` upon startup.

#### **Technical Highlights**
* **Encapsulation**: Uses private fields and public getters/setters in the `Expense` model to ensure data integrity.
* **Error Handling**: Robust validation for file operations and numeric input.
* **File I/O**: Implements `BufferedReader` and `BufferedWriter` for CSV-style data storage.

---

### Technologies & Tools Used
* **Programming Language**: Java 8+
* **IDE**: Visual Studio Code / IntelliJ IDEA
* **Architecture**: Object-Oriented Programming (Model-Logic-View)
* **Data Storage**: Flat-file system (`expenses.txt`)
* **Libraries**: Java Standard Library (`java.util`, `java.io`)

---

### Installation & Setup for VS Code

#### **Prerequisites**
* Java JDK 11 or higher
* Visual Studio Code
* Extension: **Extension Pack for Java**



---

### Screenshots
<img width="1167" height="911" alt="image" src="https://github.com/user-attachments/assets/54bc207f-57cb-45fb-84e7-199c74420937" />
<img width="1166" height="941" alt="image" src="https://github.com/user-attachments/assets/cf635a8e-d29b-4115-b4de-ad4626b2a900" />
<img width="1180" height="934" alt="image" src="https://github.com/user-attachments/assets/498dd2d8-d286-4d61-8e1d-9df386ff6b73" />
<img width="1167" height="940" alt="image" src="https://github.com/user-attachments/assets/1967f6a4-574d-4f4d-af8b-ebc949607a7a" />
<img width="1165" height="897" alt="image" src="https://github.com/user-attachments/assets/19caf27d-df45-47fe-8be3-1bb67d2c4aaa" />


