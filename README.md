# Tutorial

## Prerequisite
- Java 21
- Maven 3.9.x
- Docker (Step 3)

## Subject
You want to create an API to get information on talents for each specialization available in retail WoW.
As they can change with each patch, with talents being updated, added or removed, you want this API to do all sorts of things.

Here are the defined requirements:
1. Classes:
    1. A class must have:
        1. a name
        2. a description
        3. a list of talents
        4. a list of spells
        5. a list of specializations
    2. You can:
        1. get all classes
        2. get one class
        3. patch one
        4. create a new one
        5. delete one
2. Specialization:
    1. A spec must have:
        1. a name
        2. a description
        3. a list of talents
        4. a list of spells
    2. You can:
        1. get all classes
        2. get one class
        3. patch one
        4. create a new one
        5. delete one
3. Talents:
    1. A talent must have
        1. an ID
        2. a name
        3. a description
        4. the damage provided
        5. the healing provided
        6. the shielding provided
        7. a cooldown
        8. if they provide a spell
        9. if it's a class talent or a spec talent
        10. their children's ID
    2. Same as for classes and specs:
        1. you can get all
        2. get one
        3. patch one
        4. create a new one
        5. delete one
    3. You must be able to filter talents based on:
        1. if they have children or not
        2. if they provide a spell or not
        3. if it's a class talent or a spec talent
4. Spells:
    1. A spell must have:
        1. a name
        2. a description
        3. the damage provided
        4. the healing provided
        5. the shielding provided
        6. a cooldown
        7. if they are activated or deactivated by default (meaning it is dependent on a talent being activated)
        8. if they are a passive or not
    2. Same as the others you get the gist
5. The talent tree:
    1. Construct the two talent trees, one for the class and one for the spec
    2. No UI is required, only that a talent tree leads to parent(s) talents and their children.
    3. Don't do the talent switches like there is in retail, it adds unneeded complexity.
    4. The goal is to work on recursion and dependencies
    5. The route must be:
        1. Get both talent trees for a given class using this pattern: `/{class_name}`
        2. Get only the class tree or talent tree

Filter methods must be implemented using query parameters (ex: `?type=SPECIALIZATION`)
To go further, you can implement the talent switch logic, add the multiplier on specific spells,use [generics](https://www.baeldung.com/java-generics) for class specific implementations and use an abstract class to simplify class and specs

## Step 1
- Clone the project: `git clone https://github.com/maxenceng/tutorial-baps.git`
- Create a new branch from master
- Find the branch with all the unit tests (clue: there is a `git branch` command)
- Merge the branch onto yours (find out how, don't merge on master)
- These tests will be on your business domain, make sure they are all OK
- All these tests are unit tests, meaning they test a single class
- Each time a test is green, add your changes and commit
- When you're done, push and call me, we'll create your first merge request
- DO NOT USE SPRING

### Links
[Git](https://git-scm.com/docs/gittutorial)

[If you fuck up with Git, this will save you, keep this](https://ohshitgit.com/)

[Baeldung - JUnit](https://www.baeldung.com/junit)

[Baeldung - Mockito](https://www.baeldung.com/mockito-series)

## Step 2
- Go to branch `spring`
- look at the commit, there are commands to look at the history, your IDE is your friend, find out how it can help you
- Rebase your changes from step 1 that are now on `master` onto this branch, you might have conflicts, use your IDE interactive interface to resolve them if needed
- Create your data in your application for now, it will be removed in step 3
- There are integration tests, their goal is to test a behavior, do the same thing as you did with tests for step 1
- Hide protected attributes like IDs from the returned objects by creating new classes called DTOs
- Create a new merge request once you're done

### Links
[Baeldung - Spring](https://www.baeldung.com/spring-tutorial)

[Baledung - Integration testing](https://www.baeldung.com/integration-testing-in-spring)

[Baeldung - DTO Pattern](https://www.baeldung.com/java-dto-pattern)

### Step 3
- Go to branch `sql`
- Same as for step 2, rebase your changes from `master` onto this branch
- Create your schemas for Liquibase, find out why it's useful. Only use SQL
- Start with the tables, don't forget the primary and foreign keys
- Add your `INSERT` files in separated scripts
- Connect your database with your application using JPA (it's an ORM to facilitate queries)
- Instead of having your data created in step 2, your domain should now use the data in the database

### Links
[Baeldung - Liquibase](https://www.baeldung.com/liquibase-refactor-schema-of-java-app)

[Baeldung - JPA & Hibernate](https://www.baeldung.com/learn-jpa-hibernate)