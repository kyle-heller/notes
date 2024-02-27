# Software Development Models
The following page discusses some common software development models.

## Application Development Lifecycle (ADLC)
ADLC covers the entire life of a product/system from initiation to end-of-life and is divided into stages/phases. Each stage has clearly definined activities, the output from which feeds into later phases.
1. Initiation
2. System Concept
3. Planning
4. Analysis
5. Design
6. Development
7. Validation
8. Deployment
9. Production
10. End of Life

### Start-up Phases
ADLC start-up phases are a subset of the overall ADLC representing the initial conception & design of the product/system. All start-up phases require stakeholder buy-in in order to proceed. Start-up phases product *Artifacts* which are input to later phases. SDLC (see below) phases can access all *artifacts* from the start-up phases.
1. Initiation
    - Identify a need or opportunity
    - Driven by sponsor (often a product manager)
2. System Concept
    - Define scope
    - Feasability Studies including ROI, Cost/Benefit, Risk Mgmt
    - Competitor surveys & reports    
3. Planning
    - Determine resources needed
    - Timeline
    - Cost projection

### Software Development Lifecycle (SDLC)
The SDLC is a subset of the steps from the ADLC. Different software models implement these tasks different (e.g. the *waterfall model* and *agile* development process).
1. Analysis (OUTPUT: *requirements document*)
    - In-depth research & analysis
    - Transform high-level Statement of Work (SOW) into a detailed architectural & functional __requirements document__
2. Design (OUTPUT: *system design*)
    - Transforms *requirements doc* into detailed __system design__
    - Architectural design
    - Software design
    - Database design
    - UI mock-ups
    - Selection of tools
    - Quality Assurance (QA) planning
3. Development (OUTPUT: *working application ready for validation*)
    - Use *system design* to implement the software
    - Writing code
    - Code reviews
    - Database creation
    - Writing test cases
    - Setting up test environment
4. Validation (OUTPUT: *test analysis report*)
    - QA testing
    - User Acceptance Testing
    - Validate that SW meets requirements
    - Identify bugs/defects
5. Deployment
    - Additional User Acceptance Testing (UAT)
    - Procurement of any hardware & software required to deploy
    - Operator, Administrator, and User training
    - Set-up helpdesk/support process

#### 1. Anaysis
This is the most critical phase for the success of the project.
- Understand the problem/goal
- Define project goals
- Build use cases
- Identify key players (stakeholders, dev team-leaders)
- Determine what needs to be implemented
- Identify features & functionality
- Identify customer expectations
- Create requirements document

#### 2. Design
This phase handles the translation of requirements into specific plans for how to implement them.
- Describe system in detail
- High level designs
- Detailed designs
- Quality Assurance planning
- Create prototypes, wireframes, and database models

#### 3. Development
This phase is responsible for the actual coding of the product/system based on information from the analysis & design phases.
- Setup development, build, and integration environments
- Write source code
- Write unit tests (small self contained tests for a specific module)
- Integration tests (brining together the small, separately developed modules and testing their combined functionality)
- Source code is archived and controlled in a Software Configuration Mgmt system

#### 4. Validation
This phase handles the testing & evaluation of the ouput from the previous phase to determine if it satisifies requirements.
- Execute test cases
- Functional and system requirement
- Report bugs & defects
- Perform User Acceptance Testing
- Critical bug fixes
- Create test analysis report

#### 5. Deployment
This phase handles the deployment of the tested product/system into the customer's production environment.
- Additional UAT
- Creation of supporting documentation (e.g. manuals)
- User Training
- Support Training
- Procurement of any needed resources (hardware, software)

### SDLC Umbrella Tasks
*Umbrella Tasks* are tasks which take place during the SDLC but are not restricted to any particular phase and can span multiple (or all) phases. These include:
- __Project Management__
    - Timeline tracking
    - Budget
    - Release mgmt
    - Coordination with external depts
- __Documentation__
    - Prepare & produce documents related to the project
    - User documentation
    - Marketing documentation
    - Technical documentation
- __Measurement & metrics__
- __Software Configuration Mgmt__
    - Version Control
    - Build mgmt
    - Controlled change process
- __Reusability Mgmt__
    - Identify re-usable Software elements
    - Reduce cost & effort
- __Risk Management__
    - Identify, measure, asses, and mitigate/manage risks
- __Change Mgmt__
- __Quality Assurance__
    - Functional requirements specification & compliance
    - Non-functional requirements such as robustness, performance, and maintainability
    - Promote best practices
- __Training__

### SDLC Iterations
The ADLC includes at least one (but possibly many more) SDLC. Often starting from a *Minimum Viable Product (MVP)* which represents the minimum requirements for a functional version of the product/system and then going through iterations to add extra features beyong the minimum requirements or to address bugs discovered during production use.

### SDLC Cost of Change
The cost of finding and fixing a defect in the requirements increases exponentially as the project progresses. This is because as the project proceeds more and more documentation, code, and test cases are being created and a change to the requirements means each of these needed to be updated, validated, and accepted again. This can of course result in:
- Delays
- Increase budgetary requirements

### Operation and Maintenance Phase
The *operation and maintenance* phase starts after the initial SDLC when the product/system is deployed to the production environment. This is the longest & most expensive phase of the ADLC as an application can stay in this phase for many years.
1. Operation
    - In production and in use
    - Administration & Cost of operation
2. Maintenance
    - Evaluation & assessment
    - Multiple SDLCs
        - Adaptive changes
        - Perfective changes
        - Corrective changes
        - Preventative changes

## Sequential vs Iterative approach to Software Development
## Sequential
The sequential approach provides an easy to understand project structure with easily defined milestones but is somewhat rigid compared to the iterative approach.

__Pros__
- Easy to understand, linear structure
- Understandable milestones

__Cons__
- Requirements must be defined up-front
- Doesn't easily adapt to changes in requirements
- Potentially a longer wait for customer to receive project output
- Can give a false sense of progress since testing & validation happens towards the end of the project

#### Common sequential approaches
1. Waterfall
2. V-Model
3. Sashimi

### The Waterfall Model
The *waterfall* method rigidly follows the SDLC phases by:
- Gating control moving to the next phase
- Prevent revisiting completed phases
- Delivering "businesss value" at the end of the project

This makes it easy to understand & control but inflexible when dealing with shifting requirements.

__A good fit when__:
- Requirements are well understood
- Technology used is well understood
- Product definition is *clear* and *stable*

The name derives from the waterfall like structure of each phase falling off into the next:
<br>`|Phase 1|`
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`|Phase 2|`
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`|Phase 3|`

### Sashimi Model
The *Sashimi* model is very similar to *Waterfall* but with overlapping phases that allows for some feedback from the next phase into the prior phase.
- Allows iteration between adjourning phases
- Encourages continuity between phases
- Helps find defects early

__A good fit for:__
- Medium-size projects
- With effective communication between project roles

The name derives from the fact that the phases overlap like the cuts of fish on a plate of sashimi:
<br>`|phase 1|`
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`|phase 2|`
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`|phase 3|`

### V-Model
The V-Model method also follows the SDLC phases but puts an emphasis on verification & validation.
- Each development phase is paired with a test & integration phase
- Test & integration is planned in parallel with corresponding project definition phase
- Ensures tests will exist to validate every deliverable
- Once a phase is complete, you can't revisit it
- Reflects management view of project
- Inflexible to changing requirements

__A good fit for__:
- Systems requiring high-reliability

The name derives from the V shape of the model outlining timeline compared to level of abstraction:
<br>`|Planning|` &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`|Operation/Maintenance|`
<br>&nbsp;&nbsp;&nbsp;`|Requirements|`&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`|User Acceptance Testing|`
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`|High-level design|`&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`|Integration tests|`
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`|Detail design|`&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`|Unit tests|`
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`|Coding|`
<br>*X-Axis* (left/right)= time, *Y-Axis*(up-down)=level of abstraction

## Iterative
The *iterative* (also sometimes *adaptive*) method is a combination of iterative and incremental methods where multiple SDLC iterations feed into future iterations. The initial iteration is a minimal version which is then added to by each future iteration. As each iteration is completed & tested, the output is demonstrated to the customer/stakeholders for feedback which influences future iterations.
- Multiple SDLC iterations
- Lessons from one iteration feed into another
- Redesign and implentation at each iteration
- Customer feedback after each iteration
- Implements highest priority requirements first
- Adapts to changing requirements

__Cons__:
- Requires engineers skilled in planning & design
- Requires early definition of complete system

__Common iterative approaches__:
- RAD: Rapid Application Prototype
- RUP: Rational Unified Process
- Spiral
- Agile

__A good fit when__:
- You have lots of risk & complexity
- There are evolving requirements
- New tech is involved
- You have marketing schedule demands

### Agile Software Models
Agile models are a group of iterative methods which are lightweight and incremental with a focus on:
- Individuals and interactions over processes & tools
- Working software over comprehensive documentation
- Customer collaboration over contract negotiation
- Responding to change over following a plan

__Pros__:
- Adapt to changing requirements
- Respond to unpredictability
- Deployment possible at end of any iteration

#### Common practices
The following are some common practices among the various Agile methods:
- Test Driven Development (TDD): a test scenario is defined first and then the minimum implementation that will pass the test. Once passed the code is refactored.
- User Stories: take the form of `as <role>, I want <feature> so that <reason>` to flesh out the what a user needs and why.

#### Agile models
The two most comm agile models are...

__XP (eXtreme Programming)__:
- Views project from developer perspective
- Uses TDD to focus on implementation of system rather than management of project
- Coding standards put in place so all developers are working to the same spec
- Pair programming is often used where two devs work together to code taking turns coding vs acting as a soundboard/guide
- Uses continuous integration where the system is built & integrated every time a task is completed

__SCRUM__:
- Uses *sprints* which are timed iterations (usually weeks) of a complete SDLC
- Sprints include:
    - Planning
    - Design
    - Development
    - Testing
    - Delivery
- After each sprint feedback is obtained which can be incorporated into future sprints
- SCRUM contains 3 roles:
    - Product owner - represents customers & stakeholders, captures & prioritizes requirements
    - Self-directed team - responsible for delivering potentially shippable software at the end of each sprint
    - SCRUM master - owns the SCRUM process and ensures it is followed, responsible for working with team and removing impediments
- Each sprint has 5 meetings (or *ceremonies*):
    - Backlog: review & priorize backlog items, create user stories
    - Planning: user stories for the sprint are chosen and broken down into tasks
    - Daily scrum: daily meeting where team members check-in, stating what was done yesterday, what will be done today, and any impediments
    - Sprint review: the potentially shippable software from the sprint is demonstrated to customers/stakeholders
    - Sprint retrospective: team reviews the last sprint reflecting on what went well and what didn't & how to improve going forward


```Java

```
