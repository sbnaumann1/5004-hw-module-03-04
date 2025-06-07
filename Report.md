# Report for Payroll Generator

This report helps you demonstrate your understanding of the concepts. You should write this report after you have completed the project. 

## Technical Questions

1. What does CSV stand for? 
   Comma Separated Values

2. Why would you declare `List<IEmployee>` instead of `ArrayList<HourlyEmployee>`?
    Using the abstractions of List and IEmployee allows you to put both Hourly and Salary employees in your list. It also leaves the option open to delay making the decision to use a particular implementation of the List interface until you know you might need it in the future. Plus you don't get any unnecessary overhead that comes from the arraylist implementation that you might not need.

3. When you have one class referencing another object, such as storing that object as one of the attributes of the first class - what type of relationship is that called (between has-a and is-a)?
    Storing the object as one of the attributes or fields sounds like a has-a relationship and is likely a composition if the class being stored cannot exist without the containing class.

4. Can you provide an example of a has-a relationship in your code (if one exists)?
    Yes! Employee has-a PayStub.

5. Can you provide an example of an is-a relationship in your code (if one exists)?
    Yep - HourlyEmployee is-a Employee. 

6. What is the difference between an interface and an abstract class?
    An interface only contains the method signatures for a particular abstraction of a set of classes that share a common contract (the contract being that they must all implement those methods). An abstract class is more defined, it has fields and often implementations of certain methods. Subclasses of abstract classes inherit all those fields and methods. 

7. What is the advantage of using an interface over an abstract class?
    An interface is better than an abstract class when you don't want to pass along a bunch of fields and defined methods. It is lighter weight than an Abstract Class and forces fewer inherited features on classes that implement it. 

8. Is the following code valid or not? `List<int> numbers = new ArrayList<int>();`, explain why or why not. If not, explain how you can fix it. 
    No it isn't valid, you need to use the Java wrapper class Integer. You cannot use primitive types with List implementations. 
    https://www.geeksforgeeks.org/initialize-an-arraylist-in-java/ 

9. Which class/method is described as the "driver" for your application? 
    The main method is the universal driver, but in my application PayrollGenerator that contains main is the driver that kicks off my program and starts feeding in data into the Builder.


10. How do you create a temporary folder for JUnit Testing?
    The @TempDir decorator can be used to create a temporary forlder for JUnit Testing that you then put data inside of. 


## Deeper Thinking 

Salary Inequality is a major issue in the United States. Even in STEM fields, women are often paid less for [entry level positions](https://www.gsb.stanford.edu/insights/whats-behind-pay-gap-stem-jobs). However, not paying equal salary can hurt representation in the field, and looking from a business perspective, can hurt the company's bottom line has diversity improves innovation and innovation drives profits. 

Having heard these facts, your employer would like data about their salaries to ensure that they are paying their employees fairly. While this is often done 'after pay' by employee surveys and feedback, they have the idea that maybe the payroll system can help them ensure that they are paying their employees fairly. They have given you free reign to explore this idea.

Think through the issue / making sure to cite any resources you use to help you better understand the topic. Then write a paragraph on what changes you would need to make to the system. For example, would there be any additional data points you would need to store in the employee file? Why? Consider what point in the payroll process you may want to look at the data, as different people could have different pretax benefits and highlight that. 

The answer to this is mostly open. We ask that you cite at least two sources to show your understanding of the issue. The TAs will also give feedback on your answer, though will be liberal in grading as long as you show a good faith effort to understand the issue and making an effort to think about how your design to could help meet your employer's goals of salary equity. 

In order to properly address this issue you would want to make a couple changes to your application structure. First you would want to add gender and race to the employee class so that you could then identify differences across sections of those categories in pay scale. You would want to study what types of pretax deductions are available to all groups and separate that from the raw pay rate differences. Pay rate may want to be tracked separately from netpay since reduced hours may be a result of discrimination and might compound the discrepency even more. This creates a sense of theoretical wage gap vs. experienced wage gap which might be interesting to compare.

HOWEVER, a major issue with that is that this data is sensitive and private. It may be illegal to associate these statistics inside the application to sex or gender for fear of misuse. To address that challenge, you will want to start by encrypting the names of employees and their ID numbers - perhaps by using a hashing algorithm. That way researchers can collect the data without associating it with individuals. You may want to take it one step further and simply aggregate into bins as data comes in. I.E. keep gender in a separate lookup table that can be pinged when a payroll goes out. So lookup Employee gender, and then add the pay for this pay period to the appropriate category bin, but never store the two types of data together. 

https://iwpr.org/national-gender-wage-gap-widens-significantly-in-2023-for-the-first-time-in-20-years/ 
https://medium.com/@sanaatrash09/5-backend-security-best-practices-every-developer-should-know-90469b9f131f 
https://tax.thomsonreuters.com/blog/protecting-tax-accounting-information-best-practices-for-it-professionals-in-data-security-and-confidentiality/ 