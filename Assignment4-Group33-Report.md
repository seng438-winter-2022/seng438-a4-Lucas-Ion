**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group \#:33       |   |
|-----------------|---|
| Student Names:  |   |
| Lucas Ion                |   |
| Hao Nguyen                |   |
| Alden Lien                |   |
|Nguyen Gia Hy Huynh                |   |

# Introduction

The purpose of this lab was two-fold. The first goal of this lab was to gain a deeper understanding of mutation based testing using Pitest. The second goal of the lab was to gain a deeper understanding of GUI based testing using SeleniumIDE and understanding its benefits over other GUI based testing technologies such as SikuliX.

Throughout the lab we were required to engage in theoretical and hands on work, with the ultimate goal to gain a deeper understanding on how to effectively test code and software systems.


# Analysis of 10 Mutants of the Range class 

## Mutant #1

- **Method test**: public static KeyedValues getCumulativePercentages(KeyedValues data)
- **Mutant produce**: Negated double local variable number 2
- **Test class**: getCumulativePercentagesTest.java
- **How it was killed or not**: The mutant initially survived because the local variable **total** equals to 0 initially. Therefore, negation of a zero will not affect one-value KeyedValues. So what method test2() does was sending a KeyedValues with length of 2, although the mutant survived for the first iteration, the second iteration would definitely kills it since now **total** does not evaluate to 0 any more. This results in the **mutant being killed**.


## Mutant #2

- **Method test**: public static Range expand(Range range,
                               double lowerMargin, double upperMargin)
- **Mutant produce**: Negated double local variable number 7
- **Test class**: expandTest.java
- **How it was killed or not**: The mutant initially survived because there is no test case that was created to cover the situation when **lower** is larger than **upper**. So what method upperGreaterEqualtoLower() does was pass a negative margin for both lower bound and upper bound. This helped the program get into the condition and kills the mutant by failing the scenerio that the negation creates. This results in the **mutant being killed**.

## Mutant #3

- **Method test**: public boolean intersects(double b0, double b1)
- **Mutant produce**: changed conditional boundary
- **Test class**: RangeTest.java
- **How it was killed or not**: The changed condition boundary of `<` is `<=`. Thus, in the previous assignment we did not aim to cover the case where `b0 <= this.upper` which initially made this mutant survive the test cases. Knowing that, we created a test case that contains b0 that equals to the upperbound which makes the mutant fail if we assert the answer to be false. This solves the problem because in the case `b0 <= this.upper`, the mutant is always true. This results in the **mutant being killed**. 

## Mutant #4

- **Method test**: public boolean intersects(double b0, double b1)
- **Mutant produce**: changed conditional boundary
- **Test class**: RangeTest.java
- **How it was killed or not**: The changed condition boundary of `>=` is `>`. Thus, in previous assignment we did not aim to cover the case where `b1 > b0` which initially made this mutant survive from the test cases. Knowing that, we created a test case that has `b1 == b0` which makes the mutant fail if we assert the answer to be true. This solves the problem because in the case `b1 == b0`, the mutant is always false. This results in the **mutant being killed**. 


## Mutant #5

- **Method test**: public boolean intersects(double b0, double b1)
- **Mutant produce**: Incremented (a++) double local variable number 1
- **Test class**: RangeTest.java
- **How it was killed or not**: The mutant will make line 161 become `return (b0++ < this.upper && b1 > b0)`. Initially the mutant survives from the change because there were no test cases that make the increment of b0 become false because for the second condition `b1 > b0`. Knowing that, we created the test case that initially sends in b0 and b1 that equals to each other but are still larger than the lower-bound so that the program can jump into the `else statement`. This approach will fail the mutant if we assert the answer to be true as it always results false. **Therefore the mutant is killed**

## Mutant #6

- **Method test**: public boolean intersects(double b0, double b1)
- **Mutant produce**: Incremented (a++) double field upper
- **Test class**: RangeTest.java
- **How it was killed or not**: Initially the mutant survives because there was no test cases that makes the change post-increment of field upper be the failed cause of the following test cases. We resolve the problem by reusing the method that was implemented for mutant #5. By using the solution that killed Mutant #5 we are also able to **kill Mutant #6**. 

## Mutant #7 

- **Method test**: public boolean intersects(double b0, double b1)
- **Mutant produce**: Incremented (++a) double local variable number 1
- **Test class**: RangeTest.java
- **How it was killed or not**: The mutant will make line 161 become `return (++b0 < this.upper && b1 > b0)`. Difference from #5 is that the increment happens directly to the first comparision `++b0 < this.upper`. However, the approach is similar to #5 so reusing is the best approach in this case, resulting in the **mutant being killed**.


## Mutant #8

- **Method test**: public boolean intersects(double b0, double b1)
- **Mutant produce**: Incremented (++a) double field upper
- **Test class**: RangeTest.java
- **How it was killed or not**: The mutant will make line 161 become `return (b0 < ++this.upper && b1 > b0)`. The difference from #6 is that the increment happens directly to the first comparision `b0 < ++this.upper`. However, the approach is similar to #6 so reusing is the best approach in this case, resulting in the **mutant being killed**.


## Mutant #9 

- **Method test**: public boolean intersects(double b0, double b1)
- **Mutant produce**: Incremented (a++) double local variable number 3
- **Test class**: RangeTest.java
- **How it was killed or not**: This mutant is considered as an equivalent mutant. This results in a syntactical change, while the semantics stay the same. The mutant makes line 161 become `return (b0 < this.upper++ && b1 > b0++);`. As you can see, the post-increment in b0 at the end would not persist when the function returns. This is because the change is considered as a local change therefore, it will not exist anymore when test case returns.  **This results in the mutant surviving**


## Mutant #10

- **Method test**: public boolean intersects(double b0, double b1)
- **Mutant produce**: Incremented (++a) double local variable number 3
- **Test class**: RangeTest.java
- **How it was killed or not**: This mutant is considered as an equivalent mutant. Because the pre-increment in b1 will not change the logic of the condition. The increment will only make b1 become larger which is imposible to obtain a result that is similar to the orignal. **This results in the mutant surviving**

# Report all the statistics and the mutation score for each test class

The relevant stats can be found here:

New Updated Stats with 10%+ increase: https://github.com/seng438-winter-2022/seng438-a4-Lucas-Ion/tree/main/New-Increase-Coverage
Old Original Stats: https://github.com/seng438-winter-2022/seng438-a4-Lucas-Ion/tree/main/Old-Mutation-Coverage

# Analysis drawn on the effectiveness of each of the test classes

# A discussion on the effect of equivalent mutants on mutation score accuracy

At their core, equivalent mutants are mutants that have the exact same behaviour as their original program. This means that their nature is to mask within the program and to act in such as way that yields the same behaviour as the original source code that is being tested.

Let's take an example:

Say our original program source code has a for-loop such as:

```
int x = 0; 

for(int i = 0 i < 10; i++){

x++;

}
```

As can seen above this original for-loop is operating on the loop terminating condition of: `i < 10`

Now here is an example of a mutated example of above code that could be generated by a mutation testing software such as Pitest:

```
int x = 0; 

for(int i = 0 i != 10; i++){

x++;

}
```

Although the above code can appear very similar to the original code, there is one key difference. In the second mutated code snipet the loop terminating condition is changed from `i < 10` to `i !=10`. This change, although subtle can have serious ramifactions. This mutated code behaves exactly the same the original source code. This would be an example of an equivalent muation. Now there are two effects that equivalent mutants can have on the code testing process:

`1`

Firstly in the example above, this equivalent mutant "hides itself" by not changing the behaviour of the original code. This means that when an Test Suite is designed, and it cannot detect a specific error in the code. If an equivalent mutant is created that new mutant will also fail to be indentified by the test, causing it to pass. This can be problematic as this kind of mutation can make it hard to pinpoint what exactly is causing faliure in the orginal code.

`2`

The second and equally problamatic issues, is that if an equivalent mutation is created by Pitest or whichever mutation software is being used, this means that if one mutation is killed by the Test Suite, N*equivalent mutations will also be killed by the test suite. This means that although the total mutation coverage score will increase as a result of: `mutations killed/total mutations,` this could be an aritifically high number. This inflated number could give the developer a false sense of security that their code is robust, where as in reality any large gaps in the code could be overlooked simply because it so happened that the mutants did not cover them. 

Therefore the main takeaway is that although mutation score accuracy can be a good litmus test to give a rough feel for the robustness of the code, it should not be used to determine whether code is ready and well tested enough to be pushed to production level.

Now in order to identify equivalent mutants we looked through the Pitest report to identify mutants that were not killed. Typically when a mutant resulted from changing the conditional values and surviving, we knew that it was an equivalent mutant. Moreover, upon closer inspection of the Pitest report when values were changed such as local variables or constants, and they surived the test typically these were equivalent mutants. Therefore, overall, identifying equivalent mutants was a combination of reading the Pitest report as well and the documentation, and inspecting our own code.


# A discussion of what could have been done to improve the mutation score of the test suites

# Design strategy

The first step of our strategy was to analyse the mutant log where the mutants survived our test cases. In this phase, we tried to skim through the log to detect the largest red areas which represents the high distribution of survived mutants. We tried to note down as much as we could, and sort out which area we should improve first based on the familarity of each member in our group.

The second step was to classify the types of mutants that existed in one distribution. By doing this, we can avoid most of the equivalent mutants so that we don't waste too much time on implementing very different test cases. This step was also important because priortizating the important test cases helped remove the following mutants that survived previously. 

The third step was to implement our new test cases. We made use of the JUnit Testing Software and Pitest to test out if the current approach will cover the mutants. For example, we changed the source code so that it matches with the mutant description. In order to know that it matches, we ran the coverage tool; if the coverage passes for the current test cases, it means that our test cases has failed in covering the mutant. The goal is to implement a test case that would pass the coverage for the source code but would fail for the mutant. We always made sure that we changed to the original version of the source code when running the Pitest. While implementing and running test cases, we made sure to keep track of the percentage of coverage so no contamination happened during the process. By that we mean, the process could generate more mutants if we are not careful enough. 

The final step was to gather up test cases from members of the team, and measure the coverage if it had passed the 10% increase requirement from the documentation. If it does not pass, we repeated the process. Once the goal was reached, we tried to clean up the code base by removing unneccessary test cases that does not improve the final coverage. 


# Why do we need mutation testing? Advantages and disadvantages of mutation testing

## **Pros**

The first benefit to mutation testing is that is can provide a much better calculation of the accuary and completness of your code compared to regular code coverage testing with EclEmma. Let's take an example

`Source Code`

```
public int calculateSum(int x, int y){

    return (x+y);

}
```

`Test - assertion`
```
assertTrue(3, object.calculateSum(3,0));
```

In the above example the test for the resulting code would provide 100% statement coverage as all lines would be hit every time the test is run through JUnit. Although initally this may seem good, what would happen if the mutation suite changed the source code to this:

`Mutatated Source Code`

```
public int calculateSum(int x, int y){

    return (x-y);

}
```

This mutated source code would still cause the original test assertion to pass! This is a problem, because although the coverage may be 100%, the mutation coverage would be 0%. This means that the test suite is not nearly as robust as we initally belived. 

This demonstrates that Mutation testing can be a great first step into developing much more robust code and equally robust test cases.

**Another benefit** that stems from mutation testing is that if a program naturally has low program coverage. Developing tests that can increase mutation coverage will result in a natural increase in code coverage as well. This means that mutation coverage is a great starting point for increasing the robustness of code testing as it bypasses the initial stage of code coverage orientated development.

**One other benefit** Is that mutation testing can increase the identification of loop holes in test data. This means that not only does mutation  testing increase the strength of logic implemented in tests, it also increases the quality of data that is passed into tests. Since this data can also have a profound effect on the amount of mutants that are killed.

## **Cons**

**The first major con** is that implementing tests that will kill mutations can sometimes be an incredibly difficult process. The first issue is firstly identify wheter or not a mutant is a `stubborn mutant,` a mutant that cannot be changed. Although sometimes this may be initially obvious, oftentimes that requires deep analyis through pseudocode, diagraming and testing to identify whether or not a mutant can actually be killed. This means that even before tests can be written to kill the mutant, we need to actually decide wheter or not it is even possible!

**This leads naturally to second con,** that being that mutation can be very costly and time consuming for companies to implement. Mutation testing can be a long drawn out process, with the identifying, designing, and iterations of tests taking a significang amount of time and money (for companies) to implement. Therefore although it can be beneficial to implement mutation tests, it can also add uneeded complications as companies need to do a calculus on what the `cost vs. benefit,` of implementing mutation testing is. 

**Another con** is that mutation testing takes a long time to run. Especially on prodcution level code with a large amount of dependecies, mutation testing can create an uneeded load on production level machines. This leads to an increase in network and electircity costs for companies once again contributing to increase in time needed for mutation testing, making it unwelcome in certain situations.



# Explain your SELENUIM test case design process

Our testing process has `4` phases;

`1 - Identify the goal of testing:`

In this phase of testing we aimed to brainstorm and plan what exactly we aimed to test for our respective website. This means that in the planning phase we aimed to develop pseudo assertions (i.e assertions that we were prepared to engage in when we tested). By laying out our goals and thoroughly preparing before we began the testing process we could establish a flow to our test pattern and use SeleniumIDE in a smooth and consistent manner.

`2 - Familiarize ourselves with the website`

In this phase of testing we explored the website we were going to test. This meant exploring how the website is layed out, and noticing any key details that we did not pick up on in the previous phase. This would also give us a "trial run" at creating the test cases on Selenium as we would also familiarize ourselves with the points in which we would add assertions in our scripts when we actually carried out our tests.

`3 - Carry out the SeleniumIDE testing`

In this phase of our test case design process we actually carry out our designed test case and `record` them in SeleniumIDE. This is the phases where we work through our pseudo test-scripts and actually carry them out live in SeleniumIDE. It is also in this phase were we implement our assertions by succesfully implementing our assertions in the code at specific points we layed out (i.e credit card information, location, search)

`4 Reflect on conducted test`

In this phase we posthumously reflected on the work we did. We firstly reflected on the testing script created by SeleniumIDE and confirmed that the assertions we created we succesully recorded in the script. We then reflected back on the video recording to ensure that the test case successfully captured what we wanted it to capture.

# Explain the use of assertions and checkpoints

For our Selenium Tests we utilized both assertions and checkpoints in our test case design process.

Assertions allowed us to verify how exactly we were carrying out our tests and to ensure that the output matched the pre-planed expected output. For our testing, assertions worked by grabbing the relevant text that needed to be grabbed in order to do an `assert text` assertion in SeleniumIDE.

For example, for the `BestBuy-InvalidLocationSearch(1),` we noticed in our test planning that the output of an invalid search produced the text output: ` Sorry, there are no locations near "Phoenix, AZ". Please modify your search and try again or browse our directory.`

Therefore when we were performing our tests in order to determine where the test was successful we wrote the command:


`Command={assert text} Target={css=.Locator-noResults} Value ={Phoenix, AZ". Please modify your search and try again or browse our directory.}`

This succesfully passed our test and completed our test case that was responsible for checking an invalid location.

This example above illustrates how we conducted our testing, we performed the same general practice for all 16 test cases that we wrote.


# How did you test each functionaity with different test data

In order to test the functionality for each test. We decided to double the amount of tests that we wrote. So for example in order to test the `Location Finder` feature of the BestBuy web page, we decided to create varying test data. One of the test data we provided was Toronto, a valid location that would also simultaneously determine a correct location. However another test value that we passed was a string of random numbers, an incorrect test value that produced a completely different output. Therefore by addying various test data to each function test we could observe different outputs and develop more robust tests.

# Discuss advantages and disadvantages of Selenium vs. Sikulix

## **Pros - Selenium**

**The first advantage** of Selenium is that it is much more lighweight and data conservative than SikuliX, meaning that it is less intensive on the system.

**Another benefit** is that Selenium is hyper-optimized for web browsing enviroments since that is the only capable enviroment is can operate on. This means Selenium can be well maintained and optimized for the testing on the web with little worry of crashes.

## **Cons - Selenium**

**The main disadvantage of Selenium** is that it can only work on web applications and not any other type of application such as mobile applications or desktop applications, this means that is cannot give a large variety to testing.

**Another disadvantage of Selenium** is that it cannot automate flash objects, meaning that its testing capability is once again limited.

## **Pros - SikuliX**

**The first advantage** of SikuliX is that it can automate both web and desktop applciations, and although it does not have native support for mobile applications, it can utilize emulators to also test for those. For example the Android Debugging Bridge (ADB) can be used to effectively link SikuliX to mobile applications.

**Another advantage** of SikuliX is that it is powered by OpenCV a powerful computer vision neural network. This means that SikuliX has the capability to implement operations such as click() and doubleClick()

## **Cons - SikuliX**

**The main disadvantage of SikuliX** is that it is required to store all the images that it collects as part of its testing process. This can result in a very bloated storage setup taking up a large amount of storage.

**Another disadvantage of SikuliX** is that it cannot read text effectively and requires quite a lot of workarounds to implement correctly, therefore making it very diffcult to integrate with ReCaptcha testing or any text based interaction that needs to be done.



# How the team work/effort was divided and managed

All team work was managed equally with everyone developing an equal number of test cases to increase mutation coverage, as well as everyone contributing equally to the development and undertaking of SeleniumIDE tests!


# Difficulties encountered, challenges overcome, and lessons learned

The first difficulty we encountered was understanding how to recognize the nomenclature that Pitest used and how to effectivley use it to identify mutants. Once we understood that, we were ready to test effectively.

The second difficulty was figuring out how to create assertions using SeleniumIDE, however once we figured out how to use the `select text` feature, we were able to easily select text from the BestBuy webpage and use it in our tests.

# Comments/feedback on the lab itself

We thoroughly enjoyed this lab as it allowed us to gain a deeper understanding of Mutation Testing as well as SeleniumIDE and GUI based testing!
